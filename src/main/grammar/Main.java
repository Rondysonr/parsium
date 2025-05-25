package main.grammar;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws Exception {
        String code = Files.readString(Paths.get("clasificacao_triangulo.txt"));

        ParsiumLexer lexer = new ParsiumLexer(CharStreams.fromString(code));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ParsiumParser parser = new ParsiumParser(tokens);

        ParseTree tree = parser.prog();

        ParsiumSemantica analyzer = new ParsiumSemantica();
        analyzer.visit(tree);

        if (!analyzer.getErrors().isEmpty()) {
            System.out.println("\n[!] Erros semanticos encontrados:");
            analyzer.getErrors().forEach(System.out::println);
        } else {
            System.out.println("\n Sem erros semanticos.");
        }
    }
}
