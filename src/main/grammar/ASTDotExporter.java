package main.grammar;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileWriter;
import java.io.IOException;

public class ASTDotExporter {
    private static int nodeId = 0;
    private static FileWriter writer;

    public static void export(ParseTree tree, Parser parser, String filename) throws IOException {
        writer = new FileWriter(filename);
        writer.write("digraph AST {\n");
        walk(tree, parser, -1);  
        writer.write("}\n");
        writer.close();
    }

    private static int walk(ParseTree tree, Parser parser, int parentId) throws IOException {
        int currentId = nodeId++;
        String nodeLabel = escape(getNodeText(tree, parser));
        writer.write(String.format("  node%d [label=\"%s\"];\n", currentId, nodeLabel));

        if (parentId >= 0) {
            writer.write(String.format("  node%d -> node%d;\n", parentId, currentId));
        }

        for (int i = 0; i < tree.getChildCount(); i++) {
            walk(tree.getChild(i), parser, currentId);
        }

        return currentId;
    }

    private static String getNodeText(ParseTree tree, Parser parser) {
        String text = tree.getText();
        int ruleIndex = -1;

        try {
            ruleIndex = ((org.antlr.v4.runtime.RuleContext) tree).getRuleIndex();
        } catch (ClassCastException ignored) {}

        if (ruleIndex >= 0) {
            return parser.getRuleNames()[ruleIndex];
        }

        return text;
    }

    private static String escape(String label) {
        return label.replace("\"", "\\\"");
    }
}
