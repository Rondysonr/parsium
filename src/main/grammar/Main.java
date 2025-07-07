package main.grammar;
import main.tac.GeradorTAC;
import main.tac.TACInstruction;
import main.llmv.GeradorLLVM;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.*;
import java.util.*;

public class Main {
    private static void salvarTAC(List<TACInstruction> codigoTAC, String nomeArquivo) {
        try (PrintWriter writer = new PrintWriter(nomeArquivo)) {
            for (TACInstruction instr : codigoTAC) {
                writer.println(instr.toString());
            }
        } catch (Exception e) {
            System.err.println("Erro na geração do código intermediário (TAC): " + e.getMessage());
            System.exit(1);
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.err.println("Uso: java main.grammar.Main <arquivo-fonte> [--gerar-tac]");
            System.exit(1);
        }

        boolean gerarTAC = false;
        for (String arg : args) {
            if (arg.equals("--gerar-tac")) {
                gerarTAC = true;
            }
        }

        // LEXER e PARSER
        org.antlr.v4.runtime.CharStream input = org.antlr.v4.runtime.CharStreams.fromFileName(args[0]);
        ParsiumLexer lexer = new ParsiumLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ParsiumParser parser = new ParsiumParser(tokens);

        // Listener de erro sintático
        ParserErrorListener errorListener = new ParserErrorListener();
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);

        ParseTree tree = parser.prog();

        if (errorListener.temErros()) {
            errorListener.exibirErros();
            System.exit(1);
        }

        ParsiumSemantica semantico = new ParsiumSemantica();
        semantico.visit(tree);

        if (!semantico.getErrors().isEmpty()) {
            System.err.println("Erros semanticos encontrados:");
            for (String erro : semantico.getErrors()) {
                System.err.println(erro);
            }
            System.exit(1);
        }

        // GERADOR TAC
        GeradorTAC geradorTAC = new GeradorTAC();
        geradorTAC.visit(tree);
        List<TACInstruction> codigoTAC = geradorTAC.getCodigo();

        // Salvar TAC se solicitado
        if (gerarTAC) {
            salvarTAC(codigoTAC, "saida.tac");
            System.out.println("Arquivo saida.tac gerado com sucesso.");
        }

        // GERADOR LLVM
        GeradorLLVM geradorLLVM = new GeradorLLVM();
        try (PrintWriter writer = new PrintWriter("saida.ll")) {
            geradorLLVM.gerarCodigoLLVM(codigoTAC, writer);
        }

        System.out.println("Arquivo saida.ll gerado com sucesso.");
    }
}