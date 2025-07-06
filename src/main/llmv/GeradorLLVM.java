package main.llmv;

import main.tac.TACInstruction;
import main.tac.Opcode;

import java.io.PrintWriter;
import java.util.List;

public class GeradorLLVM {

    public void gerarCodigoLLVM(List<TACInstruction> instrucoes, PrintWriter writer) {
        writer.println("; Código LLVM IR gerado pelo Parsium");
        writer.println("declare i32 @printf(i8*, ...)");
        writer.println("@.str = private unnamed_addr constant [4 x i8] c\"%d\\0A\\00\"");
        writer.println("define i32 @main() {");

        int tempCount = 0;

        for (TACInstruction instr : instrucoes) {
            String linha = "";

            Opcode opcode = instr.getOpcode();

            switch (opcode) {
                case ASSIGN:
                    linha = "%" + instr.getResult() + " = add i32 0, %" + instr.getArg1();
                    break;

                case ADD:
                    linha = "%" + instr.getResult() + " = add i32 %" + instr.getArg1() + ", %" + instr.getArg2();
                    break;

                case SUB:
                    linha = "%" + instr.getResult() + " = sub i32 %" + instr.getArg1() + ", %" + instr.getArg2();
                    break;

                case MUL:
                    linha = "%" + instr.getResult() + " = mul i32 %" + instr.getArg1() + ", %" + instr.getArg2();
                    break;

                case DIV:
                    linha = "%" + instr.getResult() + " = sdiv i32 %" + instr.getArg1() + ", %" + instr.getArg2();
                    break;

                case INPUT:
                    linha = "; INPUT não implementado";
                    break;

                case PRINT:
                    linha = "%" + tempCount + " = call i32 (i8*, ...) @printf(i8* getelementptr "
                         + "([4 x i8], [4 x i8]* @.str, i32 0, i32 0), i32 %" + instr.getArg1() + ")";
                    tempCount++;
                    break;

                case LABEL:
                    // IMPORTANTE: Label não pode ter indentação e precisa de % no LLVM IR
                    writer.println(instr.getResult() + ":");
                    continue; // evita imprimir com indentação abaixo

                case GOTO:
                    linha = "br label %" + instr.getResult();
                    break;

                case IF:
                    linha = "br i1 %" + instr.getArg1() + ", label %" + instr.getArg2() + ", label %" + instr.getResult();
                    break;

                default:
                    linha = "; instrução desconhecida: " + instr.toString();
                    break;
            }

            writer.println("  " + linha);
        }

        writer.println("  ret i32 0");
        writer.println("}");
    }
}
