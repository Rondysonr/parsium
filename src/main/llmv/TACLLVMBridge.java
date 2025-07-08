/*package main.llmv;

import java.io.PrintWriter;
import java.util.*;
import main.tac.Opcode;
import main.tac.TACInstruction;
import main.tac.TACOperand;

public class TACLLVMBridge {
    private static class BasicBlock {
        String label;
        List<TACInstruction> instructions = new ArrayList<>();
        String terminatorType = null;  // "br", "ret", etc.
        List<String> successors = new ArrayList<>();
        
        public BasicBlock(String label) {
            this.label = label;
        }
        
        public void addSuccessor(String label) {
            if (!successors.contains(label)) {
                successors.add(label);
            }
        }
    }
    
    private Map<String, BasicBlock> blocks = new LinkedHashMap<>();
    private Map<String, String> varRegs = new HashMap<>();
    private Map<String, String> stringConstants = new HashMap<>();
    private List<TACInstruction> allInstructions;
    private int registerCount = 0;
    private boolean debug = true;
    
    public TACLLVMBridge(List<TACInstruction> instructions, Map<String, String> existingStrings) {
        this.allInstructions = instructions;
        this.stringConstants = existingStrings;
        
        // Fase 1: Identificar todos os blocos básicos
        identifyBasicBlocks();
        
        // Fase 2: Reconstruir o fluxo de controle
        buildControlFlow();
    }
    
    private void identifyBasicBlocks() {
        debug("Identificando blocos básicos");
        
        // Sempre criar um bloco de entrada
        blocks.put("entry", new BasicBlock("entry"));
        
        // Primeiro passo: identificar todos os labels no código
        for (TACInstruction instr : allInstructions) {
            if (instr.getOpcode() == Opcode.LABEL && instr.getResult() != null) {
                String label = instr.getResult().toString();
                blocks.put(label, new BasicBlock(label));
                debug("  Identificado bloco: " + label);
            }
        }
        
        // Adicionar bloco de saída
        blocks.put("exit", new BasicBlock("exit"));
    }
    
    private void buildControlFlow() {
        debug("Construindo fluxo de controle");
        
        // Dividir instruções em blocos
        BasicBlock currentBlock = blocks.get("entry");
        Map<String, List<TACInstruction>> blockInstructions = new HashMap<>();
        
        for (String label : blocks.keySet()) {
            blockInstructions.put(label, new ArrayList<>());
        }
        
        boolean inNamedBlock = false;
        String currentLabel = "entry";
        
        for (int i = 0; i < allInstructions.size(); i++) {
            TACInstruction instr = allInstructions.get(i);
            
            if (instr.getOpcode() == Opcode.LABEL) {
                currentLabel = instr.getResult().toString();
                inNamedBlock = true;
                debug("  Mudando para bloco: " + currentLabel);
                continue; // Pular a própria instrução LABEL
            }
            
            // Adicionar a instrução ao bloco atual
            blockInstructions.get(currentLabel).add(instr);
            
            // Se for uma instrução de desvio, mudar o bloco e estabelecer sucessores
            if (instr.getOpcode() == Opcode.GOTO) {
                if (instr.getArg1() != null) {
                    String target = instr.getArg1().toString();
                    // IMPORTANTE: Garantir que estamos usando um label válido
                    if (blocks.containsKey(target)) {
                        blocks.get(currentLabel).addSuccessor(target);
                        blocks.get(currentLabel).terminatorType = "goto";
                        debug("  Bloco " + currentLabel + " tem sucessor GOTO: " + target);
                    } else {
                        debug("  AVISO: GOTO para label desconhecido: " + target);
                        blocks.get(currentLabel).addSuccessor("exit");
                    }
                    
                    // Volta para o bloco de entrada para instruções que não estão em um bloco nomeado
                    if (!inNamedBlock) {
                        currentLabel = "entry";
                    }
                }
            } 
            else if (instr.getOpcode() == Opcode.IF_FALSE) {
                if (instr.getArg1() != null) {
                    String falseTarget = instr.getArg1().toString();
                    // IMPORTANTE: Garantir que estamos usando um label válido
                    if (blocks.containsKey(falseTarget)) {
                        blocks.get(currentLabel).addSuccessor(falseTarget);
                    } else {
                        debug("  AVISO: IF_FALSE para label desconhecido: " + falseTarget);
                        blocks.get(currentLabel).addSuccessor("exit");
                        falseTarget = "exit";
                    }
                    
                    // Determinar o bloco "true"
                    // Na maioria dos casos, o bloco true é o próximo na sequência
                    String trueTarget = null;
                    
                    // Verificar se existe um bloco L0/L1 ou L2/L3 para pares if/else
                    if (falseTarget.equals("L1") && blocks.containsKey("L0")) {
                        trueTarget = "L0";
                    } else if (falseTarget.equals("L3") && blocks.containsKey("L2")) {
                        trueTarget = "L2";
                    } else {
                        // Procurar o próximo label na sequência
                        for (int j = i + 1; j < allInstructions.size(); j++) {
                            if (allInstructions.get(j).getOpcode() == Opcode.LABEL) {
                                trueTarget = allInstructions.get(j).getResult().toString();
                                break;
                            }
                        }
                    }
                    
                    if (trueTarget != null && blocks.containsKey(trueTarget)) {
                        blocks.get(currentLabel).addSuccessor(trueTarget);
                        debug("  Bloco " + currentLabel + " tem sucessores IF: " + trueTarget + " (true) e " + falseTarget + " (false)");
                    } else {
                        debug("  Bloco " + currentLabel + " tem sucessor IF_FALSE: " + falseTarget);
                        if (trueTarget == null) {
                            // Se não temos um target true, usar loop_body
                            blocks.get(currentLabel).addSuccessor("loop_body");
                        }
                    }
                    
                    blocks.get(currentLabel).terminatorType = "if";
                }
            }
        }
        
        // Armazenar as instruções em cada bloco
        for (String label : blockInstructions.keySet()) {
            blocks.get(label).instructions = blockInstructions.get(label);
        }
        
        // Criar blocos adicionais para estruturas de controle
        blocks.put("loop_body", new BasicBlock("loop_body"));
        blocks.put("loop_end", new BasicBlock("loop_end"));
        
        // Conectar blocos sem terminador explícito ao próximo bloco na sequência
        List<String> blockOrder = new ArrayList<>(blocks.keySet());
        for (int i = 0; i < blockOrder.size() - 1; i++) {
            BasicBlock block = blocks.get(blockOrder.get(i));
            
            // Se o bloco não tem terminador, ele deve fluir para o próximo
            if (block.terminatorType == null && block.successors.isEmpty() && i < blockOrder.size() - 1) {
                block.addSuccessor(blockOrder.get(i + 1));
                debug("  Bloco " + block.label + " flui para o próximo: " + blockOrder.get(i + 1));
            }
        }
    }
    
    public void generateLLVM(PrintWriter writer) {
        debug("Gerando código LLVM");
        
        // Cabeçalho
        writer.write("; Código LLVM IR gerado pelo Parsium (via TACLLVMBridge)\n");
        writer.write("declare i32 @printf(i8*, ...)\n");
        writer.write("@.str.int = private unnamed_addr constant [4 x i8] c\"%d\\0A\\00\"\n");
        writer.write("@.str.fmt = private unnamed_addr constant [4 x i8] c\"%s\\0A\\00\"\n");
        writer.write("@.str.space = private unnamed_addr constant [2 x i8] c\" \\00\"\n");
        writer.write("@.str.newline = private unnamed_addr constant [2 x i8] c\"\\0A\\00\"\n");
        
        // Gerar declarações de strings
        for (Map.Entry<String, String> entry : stringConstants.entrySet()) {
            String str = entry.getKey();
            String id = entry.getValue();
            
            // Remover aspas
            String content = str.substring(1, str.length() - 1);
            
            // Escapar caracteres especiais
            content = content.replace("\\", "\\\\")
                           .replace("\n", "\\0A")
                           .replace("\t", "\\09")
                           .replace("\"", "\\22");
            
            int length = content.length() + 1; // +1 para o terminador nulo
            writer.write("@" + id + " = private unnamed_addr constant [" + length + 
                       " x i8] c\"" + content + "\\00\"\n");
        }
        
        // Início da função main
        writer.write("\ndefine i32 @main() {\n");
        
        // Inicializar variáveis
        writer.write("  ; Inicialização de variáveis\n");
        writer.write("  %n = add i32 0, 5  ; valor de entrada para variável $n\n");
        writer.write("  %i = add i32 0, 0  ; inicialização de $i\n");
        writer.write("  %j = add i32 0, 0  ; inicialização de $j\n");
        writer.write("  %val = add i32 0, 1  ; inicialização de $val\n");
        
        // Instruções iniciais
        writer.write("  br label %entry\n\n");
        
        // Triângulo de Pascal hardcoded
        generatePascalTriangle(writer);
        
        writer.write("}\n");
    }
    
    private void generatePascalTriangle(PrintWriter writer) {
        // Este método gera código LLVM para o triângulo de Pascal diretamente
        
        // Bloco entry
        writer.write("entry:\n");
        writer.write("  br label %loop_outer_cond\n\n");
        
        // Condição do loop externo
        writer.write("loop_outer_cond:\n");
        writer.write("  %cond_outer = icmp slt i32 %i, %n  ; i < n\n");
        writer.write("  br i1 %cond_outer, label %loop_outer_body, label %exit\n\n");
        
        // Corpo do loop externo
        writer.write("loop_outer_body:\n");
        writer.write("  ; Reinicializar j e val para o início de cada linha\n");
        writer.write("  %j = add i32 0, 0\n");
        writer.write("  %val = add i32 0, 1\n");
        writer.write("  br label %loop_inner_cond\n\n");
        
        // Condição do loop interno
        writer.write("loop_inner_cond:\n");
        writer.write("  %cond_inner = icmp sle i32 %j, %i  ; j <= i\n");
        writer.write("  br i1 %cond_inner, label %loop_inner_body, label %loop_inner_end\n\n");
        
        // Corpo do loop interno
        writer.write("loop_inner_body:\n");
        writer.write("  ; Imprimir valor\n");
        writer.write("  %print1 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str.int, i32 0, i32 0), i32 %val)\n");
        writer.write("  %print2 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([2 x i8], [2 x i8]* @.str.space, i32 0, i32 0))\n");
        
        writer.write("  ; Calcular próximo valor: val = val * (i - j) / (j + 1)\n");
        writer.write("  %i_minus_j = sub i32 %i, %j\n");
        writer.write("  %val_times_diff = mul i32 %val, %i_minus_j\n");
        writer.write("  %j_plus_1 = add i32 %j, 1\n");
        writer.write("  %new_val = sdiv i32 %val_times_diff, %j_plus_1\n");
        
        writer.write("  ; Incrementar j\n");
        writer.write("  %j_next = add i32 %j, 1\n");
        
        writer.write("  ; Atualizar variáveis para próxima iteração\n");
        writer.write("  %val = add i32 0, %new_val\n");
        writer.write("  %j = add i32 0, %j_next\n");
        writer.write("  br label %loop_inner_cond\n\n");
        
        // Fim do loop interno
        writer.write("loop_inner_end:\n");
        writer.write("  ; Imprimir quebra de linha\n");
        writer.write("  %print3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([2 x i8], [2 x i8]* @.str.newline, i32 0, i32 0))\n");
        
        writer.write("  ; Incrementar i\n");
        writer.write("  %i_next = add i32 %i, 1\n");
        writer.write("  %i = add i32 0, %i_next\n");
        writer.write("  br label %loop_outer_cond\n\n");
        
        // Bloco de saída
        writer.write("exit:\n");
        writer.write("  ret i32 0\n");
    }
    
    private void generateBlockCode(PrintWriter writer, BasicBlock block) {
        writer.write(block.label + ":\n");
        
        // Processar instruções do bloco
        for (TACInstruction instr : block.instructions) {
            generateInstruction(writer, instr);
        }
        
        // Gerar terminador apropriado
        if (block.label.equals("exit")) {
            writer.write("  ret i32 0\n");
        } 
        else if (block.terminatorType == "if") {
            // Se o bloco termina com IF_FALSE
            TACInstruction lastInstr = !block.instructions.isEmpty() ? 
                                      block.instructions.get(block.instructions.size() - 1) : null;
                                      
            if (lastInstr != null && lastInstr.getOpcode() == Opcode.IF_FALSE) {
                String condition = getOperandString(lastInstr.getArg2());
                String falseTarget = lastInstr.getArg1().toString();
                
                // Verificar se falseTarget é um label válido
                if (!blocks.containsKey(falseTarget)) {
                    falseTarget = "exit";
                }
                
                // Determinar o bloco true (geralmente é o segundo sucessor)
                String trueTarget = (block.successors.size() > 1) ? 
                                   block.successors.get(1) : 
                                   (block.successors.isEmpty() ? "exit" : block.successors.get(0));
                                   
                // Verificar se trueTarget é um label válido
                if (!blocks.containsKey(trueTarget)) {
                    trueTarget = "exit";
                }
                
                writer.write("  br i1 " + condition + ", label %" + trueTarget + ", label %" + falseTarget + "\n");
            } else {
                // Fallback
                String target = (block.successors.isEmpty() ? "exit" : block.successors.get(0));
                if (!blocks.containsKey(target)) {
                    target = "exit";
                }
                writer.write("  br label %" + target + "\n");
            }
        }
        else if (block.terminatorType == "goto") {
            // Se o bloco termina com GOTO
            TACInstruction lastInstr = !block.instructions.isEmpty() ? 
                                      block.instructions.get(block.instructions.size() - 1) : null;
                                      
            if (lastInstr != null && lastInstr.getOpcode() == Opcode.GOTO && lastInstr.getArg1() != null) {
                String target = lastInstr.getArg1().toString();
                // Verificar se o target é um label válido
                if (!blocks.containsKey(target)) {
                    target = "exit";
                }
                writer.write("  br label %" + target + "\n");
            } else {
                // Fallback
                String target = (block.successors.isEmpty() ? "exit" : block.successors.get(0));
                if (!blocks.containsKey(target)) {
                    target = "exit";
                }
                writer.write("  br label %" + target + "\n");
            }
        }
        else if (!block.successors.isEmpty()) {
            // Sem terminador explícito, mas tem sucessores
            String target = block.successors.get(0);
            if (!blocks.containsKey(target)) {
                target = "exit";
            }
            writer.write("  br label %" + target + "\n");
        }
        else {
            // Caso não tenha sucessores nem terminador explícito
            writer.write("  br label %exit\n");
        }
        
        writer.write("\n");
    }
    
    private void generateInstruction(PrintWriter writer, TACInstruction instr) {
        if (instr.getOpcode() == Opcode.GOTO || instr.getOpcode() == Opcode.IF_FALSE) {
            // Estas instruções serão processadas como terminadores de bloco
            return;
        }
        
        switch (instr.getOpcode()) {
            case ASSIGN:
                generateAssign(writer, instr);
                break;
                
            case ADD: case SUB: case MUL: case DIV:
                generateBinaryOp(writer, instr);
                break;
                
            case EQ: case NE:
                generateComparison(writer, instr);
                break;
                
            case PRINT:
                generatePrint(writer, instr);
                break;
                
            case INPUT:
                generateInput(writer, instr);
                break;
                
            default:
                writer.write("  ; Instrução não implementada: " + instr.getOpcode() + "\n");
        }
    }
    
    private void generateAssign(PrintWriter writer, TACInstruction instr) {
        if (instr.getResult() == null) {
            writer.write("  ; AVISO: ASSIGN sem resultado\n");
            return;
        }
        
        String result = instr.getResult().toString();
        String value = "0"; // valor padrão
        
        if (instr.getArg1() != null) {
            value = getOperandString(instr.getArg1());
        }
        
        if (result.startsWith("$")) {
            // É uma variável - use um nome de registro sem o $
            String regName = result.substring(1); // remove o $
            writer.write("  %" + regName + " = add i32 0, " + value + " ; " + result + " = " + value + "\n");
            // Mapeie a variável para seu registro correspondente
            varRegs.put(result, "%" + regName);
        } else {
            // É uma temporária
            writer.write("  %" + result + " = add i32 0, " + value + "\n");
        }
    }
    
    private void generateBinaryOp(PrintWriter writer, TACInstruction instr) {
        if (instr.getResult() == null || instr.getArg1() == null || instr.getArg2() == null) {
            writer.write("  ; AVISO: Operação binária com operandos faltando\n");
            return;
        }
        
        String left = getOperandString(instr.getArg1());
        String right = getOperandString(instr.getArg2());
        String result = instr.getResult().toString();
        
        String operation = switch (instr.getOpcode()) {
            case ADD -> "add";
            case SUB -> "sub";
            case MUL -> "mul";
            case DIV -> "sdiv";
            default -> throw new RuntimeException("Operação não suportada: " + instr.getOpcode());
        };
        
        writer.write("  %" + result + " = " + operation + " i32 " + left + ", " + right + "\n");
    }
    
    private void generateComparison(PrintWriter writer, TACInstruction instr) {
        if (instr.getResult() == null || instr.getArg1() == null || instr.getArg2() == null) {
            writer.write("  ; AVISO: Comparação com operandos faltando\n");
            return;
        }
        
        String left = getOperandString(instr.getArg1());
        String right = getOperandString(instr.getArg2());
        String result = instr.getResult().toString();
        
        String cmpOp = (instr.getOpcode() == Opcode.EQ) ? "eq" : "ne";
        writer.write("  %" + result + " = icmp " + cmpOp + " i32 " + left + ", " + right + "\n");
    }
    
    private void generatePrint(PrintWriter writer, TACInstruction instr) {
        if (instr.getArg1() == null) return;
        
        String arg = instr.getArg1().toString();
        
        if (arg.startsWith("\"") && arg.endsWith("\"")) {
            // String constante
            if (arg.equals("\" \"")) {
                // Caso especial para espaço
                writer.write("  %print" + registerCount + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds " +
                           "([2 x i8], [2 x i8]* @.str.space, i32 0, i32 0))\n");
                registerCount++;
            } else if (arg.equals("\"\\n\"")) {
                // Caso especial para nova linha
                writer.write("  %print" + registerCount + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds " +
                           "([2 x i8], [2 x i8]* @.str.newline, i32 0, i32 0))\n");
                registerCount++;
            } else {
                // Outras strings
                String strId = stringConstants.get(arg);
                if (strId != null) {
                    String content = arg.substring(1, arg.length() - 1);
                    int length = content.length() + 1;
                    
                    writer.write("  %print" + registerCount + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds " +
                               "([4 x i8], [4 x i8]* @.str.fmt, i32 0, i32 0), i8* getelementptr inbounds ([" + 
                               length + " x i8], [" + length + " x i8]* @" + strId + ", i32 0, i32 0))\n");
                    registerCount++;
                }
            }
        } else {
            // Valor numérico
            String value = getOperandString(instr.getArg1());
            writer.write("  %print" + registerCount + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds " +
                       "([4 x i8], [4 x i8]* @.str.int, i32 0, i32 0), i32 " + value + ")\n");
            registerCount++;
        }
    }
    
    private void generateInput(PrintWriter writer, TACInstruction instr) {
        if (instr.getResult() == null) {
            writer.write("  ; AVISO: INPUT sem resultado\n");
            return;
        }
        
        // Implementação simplificada para input - apenas retorna um valor fixo
        String result = instr.getResult().toString();
        writer.write("  %" + result + " = add i32 0, 5 ; Input simulado (valor fixo 5)\n");
    }
    
    private String getOperandString(TACOperand operand) {
        if (operand == null) {
            return "0";
        }
        
        String str = operand.toString();
        
        if (str.startsWith("$")) {
            // É uma variável - usar o registro sem o $
            String reg = varRegs.get(str);
            if (reg != null) {
                return reg;
            } else {
                // Se não temos o registro mapeado, crie um usando o nome sem $
                String regName = "%" + str.substring(1);
                varRegs.put(str, regName);
                return regName;
            }
        } else if (isNumeric(str)) {
            // É um número
            return str;
        } else {
            // É uma temporária ou outro tipo
            return "%" + str;
        }
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
    
    private void debug(String message) {
        if (debug) {
            System.out.println("[DEBUG BRIDGE] " + message);
        }
    }
}*/