package main.grammar;

import java.util.*;

public class ParsiumSemantica extends ParsiumBaseVisitor<String> {
    private final Map<String, String> symbolTable = new HashMap<>();
    private final List<String> errors = new ArrayList<>();

    private void log(String msg) {
        System.out.println("[SEMANTICO] " + msg);
    }

    private void error(String msg) {
        String errorMsg = "[ERRO SEMANTICO] " + msg;
        System.err.println(errorMsg);
        errors.add(errorMsg);
    }

    public List<String> getErrors() {
        return errors;
    }

    @Override
    public String visitDeclaracoes(ParsiumParser.DeclaracoesContext ctx) {
        String tipo = ctx.getStart().getText(); // "int" ou "string"
        for (var varToken : ctx.VAR()) {
            String varName = varToken.getText();
            if (symbolTable.containsKey(varName)) {
                error("Variavel '" + varName + "' já foi declarada.");
            } else {
                symbolTable.put(varName, tipo);
                log("Variavel '" + varName + "' declarada como " + tipo);
            }
        }
        return null;
    }

    @Override
    public String visitAtribuicoes(ParsiumParser.AtribuicoesContext ctx) {
        String varName = ctx.VAR().getText();
        if (!symbolTable.containsKey(varName)) {
            error("Variavel '" + varName + "' nao foi declarada antes da atribuicao.");
        } else {
            log("Atribuicao feita a variavel '" + varName + "'");
        }
        visit(ctx.expr());
        return null;
    }

    @Override
    public String visitFator(ParsiumParser.FatorContext ctx) {
        if (ctx.NUMEROS() != null) {
            return "int";
        }
        if (ctx.STRINGVAL() != null) {
            return "string";
        }
        if (ctx.VAR() != null) {
            String varName = ctx.VAR().getText();
            if (!symbolTable.containsKey(varName)) {
                error("Uso da variavel '" + varName + "' sem declaracao.");
                return "erro";
            }
            return symbolTable.get(varName);
        }
        if (ctx.LEIA() != null) {
            return "string";
        }
        if (ctx.expr() != null) {
            return visit(ctx.expr());
        }
        if (ctx.NOT() != null) {
            String tipo = visit(ctx.fator());
            if (!"int".equals(tipo)) {
                error("Operador logico '!' usado com tipo invalido: " + tipo);
            }
            return "int";
        }
        return null;
    }

    @Override
    public String visitTermo(ParsiumParser.TermoContext ctx) {
        List<ParsiumParser.FatorContext> fatores = ctx.fator();
        String tipoFinal = visit(fatores.get(0));
        for (int i = 1; i < fatores.size(); i++) {
            String tipoAtual = visit(fatores.get(i));
            String operador = ctx.getChild(2 * i - 1).getText();

            if (!"int".equals(tipoFinal) || !"int".equals(tipoAtual)) {
                error("Operacao '" + operador + "' invalida entre tipos '" + tipoFinal + "' e '" + tipoAtual + "'.");
            }

            // Verifica divisão por zero se for literal
            if ("/".equals(operador) && fatores.get(i).NUMEROS() != null && fatores.get(i).NUMEROS().getText().equals("0")) {
                error("Divisao por zero detectada.");
            }
        }
        return "int";
    }

    @Override
    public String visitExpressaoaritmetica(ParsiumParser.ExpressaoaritmeticaContext ctx) {
        List<ParsiumParser.TermoContext> termos = ctx.termo();
        String tipoFinal = visit(termos.get(0));
        for (int i = 1; i < termos.size(); i++) {
            String tipoAtual = visit(termos.get(i));
            String operador = ctx.getChild(2 * i - 1).getText();
            if (!"int".equals(tipoFinal) || !"int".equals(tipoAtual)) {
                error("Operacao '" + operador + "' invalida entre tipos '" + tipoFinal + "' e '" + tipoAtual + "'.");
            }
        }
        return "int";
    }

    @Override
    public String visitExpressaoigual(ParsiumParser.ExpressaoigualContext ctx) {
        String left = visit(ctx.expressaoaritmetica(0));
        if (ctx.expressaoaritmetica().size() > 1) {
            String right = visit(ctx.expressaoaritmetica(1));
            String operador = ctx.getChild(1).getText();
            if (!left.equals(right)) {
                error("Comparacao '" + operador + "' entre tipos incompatíveis: '" + left + "' e '" + right + "'");
            }
        }
        return "int";
    }

    @Override
    public String visitRelacionalExpr(ParsiumParser.RelacionalExprContext ctx) {
        String left = visit(ctx.expressaoigual(0));
        if (ctx.expressaoigual().size() > 1) {
            String right = visit(ctx.expressaoigual(1));
            String operador = ctx.getChild(1).getText();
            if (!"int".equals(left) || !"int".equals(right)) {
                error("Operador '" + operador + "' usado com tipos invalidos: '" + left + "' e '" + right + "'");
            }
        }
        return "int";
    }

    @Override
    public String visitLogicExpr(ParsiumParser.LogicExprContext ctx) {
        List<ParsiumParser.RelacionalExprContext> exprs = ctx.relacionalExpr();
        for (int i = 0; i < exprs.size(); i++) {
            String tipo = visit(exprs.get(i));
            if (!"int".equals(tipo)) {
                error("Operacao logica com tipo invalido: '" + tipo + "'");
            }
        }
        return "int";
    }

    @Override
    public String visitExpr(ParsiumParser.ExprContext ctx) {
        return visit(ctx.logicExpr());
    }

    @Override
    public String visitProg(ParsiumParser.ProgContext ctx) {
        for (ParsiumParser.ProgramaContext prog : ctx.programa()) {
            visit(prog);
        }
        return null;
    }

    @Override
    public String visitLoop(ParsiumParser.LoopContext ctx) {
        visit(ctx.expr());
        visit(ctx.bloco(0));
        if (ctx.SENAO() != null) {
            visit(ctx.bloco(1));
        }
        return null;
    }

    @Override
    public String visitWhile(ParsiumParser.WhileContext ctx) {
        visit(ctx.expr());
        visit(ctx.bloco());
        return null;
    }

    @Override
    public String visitSaida(ParsiumParser.SaidaContext ctx) {
        visit(ctx.expr());
        return null;
    }
}
