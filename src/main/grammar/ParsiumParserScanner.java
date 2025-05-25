package main.grammar;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class ParsiumParserScanner {
    public static void main(String[] args) throws Exception {
        // Carrega o arquivo de entrada
        CharStream input = CharStreams.fromFileName(args[0]);

        // Cria o lexer e o parser
        ParsiumLexer lexer = new ParsiumLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ParsiumParser parser = new ParsiumParser(tokens);

        
        parser.removeErrorListeners();
        parser.addErrorListener(new ParserErrorListener()); 

        ParseTree tree = parser.prog();  

    
        ASTDotExporter.export(tree, parser, "arvore.dot");

        //percorre os comandos para debug
        for (int i = 0; i < tree.getChildCount(); i++) {
            System.out.println("Comando: " + tree.getChild(i).getText());
        }
    }
}
