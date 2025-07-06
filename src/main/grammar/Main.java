package main.grammar;

import main.tac.GeradorTAC;
import main.tac.TACInstruction;
import main.llmv.GeradorLLVM;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.err.println("Uso: java main.grammar.Main <arquivo-fonte>");
            System.exit(1);
        }

        // LEXER e PARSER
        CharStream input = CharStreams.fromFileName(args[0]);
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

        // GERADOR LLVM
        GeradorLLVM geradorLLVM = new GeradorLLVM();
        List<String> codigoLLVM = geradorLLVM.gerarCodigoLLVM(codigoTAC);

        try (PrintWriter writer = new PrintWriter("saida.ll")) {
            for (String linha : codigoLLVM) {
                writer.println(linha);
            }
        }

        System.out.println("Arquivo saida.ll gerado com sucesso.");
    }
}
