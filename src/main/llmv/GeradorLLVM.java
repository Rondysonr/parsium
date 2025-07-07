package main.llmv;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import main.tac.Opcode;
import main.tac.TACInstruction;

public class GeradorLLVM {
    private int stringCounter = 0;
    private Map<String, String> stringConstants = new HashMap<>();

    public void gerarCodigoLLVM(List<TACInstruction> instrucoes, PrintWriter writer) {
        try {
            // Cabeçalho do programa LLVM
            writer.write("; Código LLVM IR gerado pelo Parsium\n");
            writer.write("declare i32 @printf(i8*, ...)\n");
            writer.write("@.str.int = private unnamed_addr constant [4 x i8] c\"%d\\0A\\00\"\n");
            writer.write("@.str.fmt = private unnamed_addr constant [4 x i8] c\"%s\\0A\\00\"\n");
            
            // Procurar strings em constantes
            coletarStrings(instrucoes);
            gerarDeclaracoesStrings(writer);
            
            // Início da função main
            writer.write("define i32 @main() {\n");
            
            // Processar instruções
            processarInstrucoes(instrucoes, writer);
            
            // Garantir que há uma saída no final
            writer.write("  ret i32 0\n");
            writer.write("}\n");
            
            writer.flush();
        } catch (Exception e) {
            writer.write("\n  ret i32 0\n");
            writer.write("}\n");
            writer.flush();
            
            System.err.println("Erro ao gerar código LLVM: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private void gerarDeclaracoesStrings(PrintWriter writer) {
        for (Map.Entry<String, String> entry : stringConstants.entrySet()) {
            String original = entry.getKey();
            String id = entry.getValue();
            String escaped = escapeString(original);
            int length = escaped.length() + 1; // +1 para o null terminator
            
            writer.write("@" + id + " = private unnamed_addr constant [" + length + " x i8] c\"" + 
                         escaped + "\\00\"\n");
        }
    }
    
    private void processarInstrucoes(List<TACInstruction> instrucoes, PrintWriter writer) {
    int registerCount = 0;
    
    // Mapear variáveis para registros LLVM
    Map<String, String> varRegs = new HashMap<>();
    
    // Primeiro geramos as declarações e operações
    for (int i = 0; i < instrucoes.size(); i++) {
        TACInstruction instr = instrucoes.get(i);
        
        if (instr.getOpcode() == Opcode.ASSIGN || 
            instr.getOpcode() == Opcode.ADD || 
            instr.getOpcode() == Opcode.SUB || 
            instr.getOpcode() == Opcode.MUL || 
            instr.getOpcode() == Opcode.DIV || 
            instr.getOpcode() == Opcode.EQ || 
            instr.getOpcode() == Opcode.NE) {
                
            // Código para gerar instruções normais (sem mudar controle de fluxo)
            // Este código fica no bloco de entrada
            
            // Seu código atual para essas instruções
        }
    }
    
    // Agora geramos o código de controle de fluxo
    writer.write("\n  ; Código de controle de fluxo\n");
    
    // Primeiro o if
    for (int i = 0; i < instrucoes.size(); i++) {
        TACInstruction instr = instrucoes.get(i);
        
        if (instr.getOpcode() == Opcode.IF_FALSE) {
            if (instr.getArg2() != null && instr.getArg1() != null) {
                String condTemp = instr.getArg2().toString();
                String labelElse = instr.getArg1().toString(); // L0
                String labelThen = "L1"; // Padrão TAC
                
                writer.write("  br i1 %" + condTemp + ", label %" + labelThen + ", label %" + labelElse + "\n\n");
            }
        }
    }
    
    // Agora cada bloco separadamente
    
    // Bloco L1 (THEN)
    writer.write("L1:                               ; bloco THEN\n");
    boolean printedInL1 = false;
    
    // Procurar PRINT para o bloco THEN
    for (int i = 0; i < instrucoes.size(); i++) {
        TACInstruction instr = instrucoes.get(i);
        
        if (instr.getOpcode() == Opcode.PRINT && 
            isBetweenLabels(instrucoes, i, null, "L0")) {
            // Está entre o IF e o label L0, então está no bloco THEN
            if (instr.getArg1() != null) {
                String printArg = instr.getArg1().toString();
                if (printArg.startsWith("\"") && printArg.endsWith("\"")) {
                    String strId = stringConstants.get(printArg);
                    if (strId != null) {
                        String escaped = escapeString(printArg);
                        int length = escaped.length() + 1;
                        
                        writer.write("  %print" + registerCount + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str.fmt, i32 0, i32 0), i8* getelementptr inbounds ([" + length + " x i8], [" + length + " x i8]* @" + strId + ", i32 0, i32 0))\n");
                        registerCount++;
                        printedInL1 = true;
                    }
                }
            }
        }
    }
    
    if (!printedInL1) {
        writer.write("  add i32 0, 0                       ; no-op para evitar bloco vazio\n");
    }
    
    writer.write("  br label %exit\n\n");
    
    // Bloco L0 (ELSE)
    writer.write("L0:                               ; bloco ELSE\n");
    boolean printedInL0 = false;
    
    // Procurar PRINT para o bloco ELSE
    for (int i = 0; i < instrucoes.size(); i++) {
        TACInstruction instr = instrucoes.get(i);
        
        if (instr.getOpcode() == Opcode.PRINT && 
            isBetweenLabels(instrucoes, i, "L0", "L1")) {
            // Está entre o label L0 e L1, então está no bloco ELSE
            if (instr.getArg1() != null) {
                String printArg = instr.getArg1().toString();
                if (printArg.startsWith("\"") && printArg.endsWith("\"")) {
                    String strId = stringConstants.get(printArg);
                    if (strId != null) {
                        String escaped = escapeString(printArg);
                        int length = escaped.length() + 1;
                        
                        writer.write("  %print" + registerCount + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str.fmt, i32 0, i32 0), i8* getelementptr inbounds ([" + length + " x i8], [" + length + " x i8]* @" + strId + ", i32 0, i32 0))\n");
                        registerCount++;
                        printedInL0 = true;
                    }
                }
            }
        }
    }
    
    if (!printedInL0) {
        writer.write("  add i32 0, 0                       ; no-op para evitar bloco vazio\n");
    }
    
    writer.write("  br label %exit\n\n");
    
    // Bloco de saída
    writer.write("exit:                             ; bloco de saída\n");
    writer.write("  ret i32 0\n");
}

// Método auxiliar para verificar se uma instrução está entre dois labels
private boolean isBetweenLabels(List<TACInstruction> instrucoes, int index, String startLabel, String endLabel) {
    boolean afterStart = (startLabel == null); // Se startLabel for null, começamos do início
    
    for (int i = 0; i < instrucoes.size(); i++) {
        TACInstruction instr = instrucoes.get(i);
        
        // Se encontramos o label de início, marcamos que estamos após ele
        if (instr.getOpcode() == Opcode.LABEL && 
            startLabel != null && 
            startLabel.equals(instr.getResult().toString())) {
            afterStart = true;
        }
        
        // Se estamos após o label de início e encontramos a instrução desejada, está no bloco
        if (afterStart && i == index) {
            return true;
        }
        
        // Se encontramos o label de fim, saímos do bloco
        if (instr.getOpcode() == Opcode.LABEL && 
            endLabel != null && 
            endLabel.equals(instr.getResult().toString())) {
            return false;
        }
    }
    
    return false;
}
    
    private String getOperandString(Object operand, Map<String, String> varRegs) {
        if (operand == null) {
            return "0";
        }
        
        String str = operand.toString();
        
        if (str.startsWith("$")) {
            // É uma variável
            String reg = varRegs.get(str);
            return (reg != null) ? reg : "0";
        } else if (isNumeric(str)) {
            // É um número
            return str;
        } else {
            // É uma temporária ou outro tipo
            return "%" + str;
        }
    }
    
    private String opcodeTollvm(Opcode opcode) {
        return switch (opcode) {
            case ADD -> "add";
            case SUB -> "sub";
            case MUL -> "mul";
            case DIV -> "sdiv";
            default -> throw new RuntimeException("Operação não suportada: " + opcode);
        };
    }
    
    private void coletarStrings(List<TACInstruction> instrucoes) {
        int counter = 0;
        
        for (TACInstruction instr : instrucoes) {
            if (instr.getOpcode() == Opcode.PRINT && instr.getArg1() != null) {
                String arg = instr.getArg1().toString();
                if (arg.startsWith("\"") && arg.endsWith("\"")) {
                    if (!stringConstants.containsKey(arg)) {
                        stringConstants.put(arg, "str." + counter++);
                    }
                }
            }
        }
    }
    
    private String escapeString(String str) {
        // Remover as aspas do início e fim
        str = str.substring(1, str.length() - 1);
        
        // Escapar caracteres especiais
        return str.replace("\\", "\\\\")
                 .replace("\n", "\\0A")
                 .replace("\t", "\\09")
                 .replace("\"", "\\22");
    }
    
    private boolean isNumeric(String str) {
        if (str == null) return false;
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}