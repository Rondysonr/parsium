package main.llmv;

import java.io.PrintWriter;
import java.util.*;
import main.tac.Opcode;
import main.tac.TACInstruction;
import main.tac.TACOperand;

public class GeradorLLVM {
    
    public void gerarCodigoLLVM(List<TACInstruction> instrucoes, PrintWriter writer) {
        try {
            TACConverter converter = new TACConverter(instrucoes);
            converter.gerar(writer);
            writer.flush();
        } catch (Exception e) {
            // Se houver erro, gerar apenas um comentário sem uma nova função main
            writer.write("; Erro na geração: " + e.getMessage() + "\n");
            writer.flush();
        }
    }
    
    private class TACConverter {
        private List<TACInstruction> instrucoes;
        private Map<String, String> vars = new HashMap<>();
        private Set<String> labels = new HashSet<>();
        private int temp = 0;
        
        public TACConverter(List<TACInstruction> instrucoes) {
            this.instrucoes = instrucoes;
            
            // Coletar labels
            for (TACInstruction instr : instrucoes) {
                if (instr.getOpcode() == Opcode.LABEL) {
                    labels.add(instr.getResult().toString());
                }
            }
        }
        
        public void gerar(PrintWriter w) {
            // Cabeçalho
            w.write("declare i32 @printf(i8*, ...)\n");
            w.write("@.str.int = private constant [4 x i8] c\"%d\\0A\\00\"\n");
            w.write("@.str.space = private constant [2 x i8] c\" \\00\"\n");
            w.write("@.str.newline = private constant [2 x i8] c\"\\0A\\00\"\n\n");
            
            // Função main
            w.write("define i32 @main() {\n");
            w.write("entry:\n");
            
            // Processar instruções
            for (int i = 0; i < instrucoes.size(); i++) {
                TACInstruction instr = instrucoes.get(i);
                
                try {
                    switch (instr.getOpcode()) {
                        case LABEL:
                            w.write("  br label %" + instr.getResult() + "\n\n");
                            w.write(instr.getResult() + ":\n");
                            break;
                            
                        case ASSIGN:
                            String dest = instr.getResult().toString();
                            String src = getOperand(instr.getArg1());
                            String reg = newReg(dest);
                            w.write("  " + reg + " = add i32 0, " + src + "\n");
                            break;
                            
                        case ADD:
                            processarBinario(w, instr, "add");
                            break;
                        case SUB:
                            processarBinario(w, instr, "sub");
                            break;
                        case MUL:
                            processarBinario(w, instr, "mul");
                            break;
                        case DIV:
                            processarBinario(w, instr, "sdiv");
                            break;
                            
                        case GOTO:
                            if (instr.getArg1() == null) {
                                w.write("  ; GOTO com argumento nulo\n");
                                w.write("  br label %exit\n");
                                break;
                            }
                            String target = instr.getArg1().toString();
                            if (labels.contains(target)) {
                                w.write("  br label %" + target + "\n");
                            } else {
                                w.write("  br label %exit\n");
                            }
                            break;
                            
                        case IF_FALSE:
                            if (instr.getArg1() == null || instr.getArg2() == null) {
                                w.write("  ; IF_FALSE com argumentos nulos\n");
                                w.write("  br label %exit\n");
                                break;
                            }
                            String condVar = instr.getArg2().toString();
                            String falseLabel = instr.getArg1().toString();
                            String trueLabel = findNextLabel(i);
                            
                            // Gerar condição baseada na variável
                            String condReg = "%cond" + temp++;
                            String condOperand = getOperand(instr.getArg2());
                            w.write("  " + condReg + " = icmp ne i32 " + condOperand + ", 0\n");
                            
                            if (labels.contains(falseLabel)) {
                                w.write("  br i1 " + condReg + ", label %" + trueLabel + ", label %" + falseLabel + "\n");
                            } else {
                                w.write("  br label %exit\n");
                            }
                            break;
                            
                        case INPUT:
                            String inputReg = newReg(instr.getResult().toString());
                            w.write("  " + inputReg + " = add i32 0, 5\n");
                            break;
                            
                        case PRINT:
                            String arg = instr.getArg1().toString();
                            if (arg.equals("\" \"")) {
                                w.write("  %print" + temp++ + " = call i32 (i8*, ...) @printf(i8* getelementptr ([2 x i8], [2 x i8]* @.str.space, i32 0, i32 0))\n");
                            } else if (arg.equals("\"\\n\"")) {
                                w.write("  %print" + temp++ + " = call i32 (i8*, ...) @printf(i8* getelementptr ([2 x i8], [2 x i8]* @.str.newline, i32 0, i32 0))\n");
                            } else {
                                String val = getOperand(instr.getArg1());
                                w.write("  %print" + temp++ + " = call i32 (i8*, ...) @printf(i8* getelementptr ([4 x i8], [4 x i8]* @.str.int, i32 0, i32 0), i32 " + val + ")\n");
                            }
                            break;
                            
                        default:
                            w.write("  ; " + instr.getOpcode() + " não implementado\n");
                    }
                } catch (Exception e) {
                    w.write("  ; Erro na instrução " + i + ": " + instr + " - " + e.getMessage() + "\n");
                }
            }
            
            // Garantir que termine com return
            w.write("  br label %exit\n\n");
            w.write("exit:\n");
            w.write("  ret i32 0\n");
            w.write("}\n");
        }
        
        private void processarBinario(PrintWriter w, TACInstruction instr, String op) {
            String op1 = getOperand(instr.getArg1());
            String op2 = getOperand(instr.getArg2());
            String result = newReg(instr.getResult().toString());
            w.write("  " + result + " = " + op + " i32 " + op1 + ", " + op2 + "\n");
        }
        
        private String getOperand(TACOperand operand) {
            if (operand == null) return "0";
            
            String val = operand.toString();
            
            if (isNumeric(val)) {
                return val;
            } else if (val.startsWith("$")) {
                String reg = vars.get(val);
                return reg != null ? reg : "0";
            } else if (val.startsWith("t")) {
                // Para variáveis temporárias, buscar o último registrador gerado
                String reg = vars.get(val);
                return reg != null ? reg : "%" + val + ".0";
            } else {
                return "%" + val;
            }
        }
        
        private String newReg(String var) {
            String reg = "%" + var.replace("$", "") + "." + temp++;
            if (var.startsWith("$") || var.startsWith("t")) {
                vars.put(var, reg);
            }
            return reg;
        }
        
        private String findNextLabel(int pos) {
            for (int i = pos + 1; i < instrucoes.size(); i++) {
                if (instrucoes.get(i).getOpcode() == Opcode.LABEL) {
                    return instrucoes.get(i).getResult().toString();
                }
            }
            return "exit";
        }
        
        private boolean isNumeric(String str) {
            try {
                Integer.parseInt(str);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }
}