package main.tac;

import java.util.*;

import main.grammar.ParsiumBaseVisitor;
import main.grammar.ParsiumParser;

public class GeradorTAC extends ParsiumBaseVisitor<TACOperand> {

    private List<TACInstruction> codigo = new ArrayList<>();
    private int tempCount = 0;
    private int labelCount = 0;

    private TACOperand novaTemp() {
        return new TACOperand(TACOperand.Tipo.TEMP, "t" + (tempCount++));
    }

    private TACOperand novaLabel() {
        return new TACOperand(TACOperand.Tipo.LABEL, "L" + (labelCount++));
    }

    public List<TACInstruction> getCodigo() {
        return codigo;
    }

    @Override
    public TACOperand visitAtribuicoes(ParsiumParser.AtribuicoesContext ctx) {
        TACOperand var = new TACOperand(TACOperand.Tipo.VAR, ctx.VAR().getText());
        TACOperand valor = visit(ctx.expr());
        codigo.add(new TACInstruction(Opcode.ASSIGN, var, valor));
        return var;
    }

    @Override
    public TACOperand visitExpressaoaritmetica(ParsiumParser.ExpressaoaritmeticaContext ctx) {
        if (ctx.termo().size() == 1) {
            return visit(ctx.termo(0));
        } else {
            TACOperand left = visit(ctx.termo(0));
            for (int i = 1; i < ctx.termo().size(); i++) {
                TACOperand right = visit(ctx.termo(i));
                String op = ctx.getChild(2 * i - 1).getText();
                TACOperand temp = novaTemp();
                Opcode opcode = switch (op) {
                    case "+" -> Opcode.ADD;
                    case "-" -> Opcode.SUB;
                    default -> throw new RuntimeException("Operador nao suportado: " + op);
                };
                codigo.add(new TACInstruction(opcode, temp, left, right));
                left = temp;
            }
            return left;
        }
    }

    @Override
    public TACOperand visitTermo(ParsiumParser.TermoContext ctx) {
        if (ctx.fator().size() == 1) {
            return visit(ctx.fator(0));
        } else {
            TACOperand left = visit(ctx.fator(0));
            for (int i = 1; i < ctx.fator().size(); i++) {
                TACOperand right = visit(ctx.fator(i));
                String op = ctx.getChild(2 * i - 1).getText();
                TACOperand temp = novaTemp();
                Opcode opcode = switch (op) {
                    case "*" -> Opcode.MUL;
                    case "/" -> Opcode.DIV;
                    default -> throw new RuntimeException("Operador nao suportado: " + op);
                };
                codigo.add(new TACInstruction(opcode, temp, left, right));
                left = temp;
            }
            return left;
        }
    }

    @Override
    public TACOperand visitFator(ParsiumParser.FatorContext ctx) {
        if (ctx.NUMEROS() != null)
            return new TACOperand(TACOperand.Tipo.CONST_INT, ctx.NUMEROS().getText());
        if (ctx.VAR() != null)
            return new TACOperand(TACOperand.Tipo.VAR, ctx.VAR().getText());
        if (ctx.STRINGVAL() != null)
            return new TACOperand(TACOperand.Tipo.CONST_STR, ctx.STRINGVAL().getText());
        if (ctx.expr() != null)
            return visit(ctx.expr());
        if (ctx.LEIA() != null) {
            TACOperand temp = novaTemp();
            codigo.add(new TACInstruction(Opcode.INPUT, temp));
            return temp;
        }
        if (ctx.NOT() != null) {
            TACOperand val = visit(ctx.fator());
            TACOperand temp = novaTemp();
            codigo.add(new TACInstruction(Opcode.NOT, temp, val));
            return temp;
        }
        return null;
    }

    @Override
    public TACOperand visitSaida(ParsiumParser.SaidaContext ctx) {
        TACOperand val = visit(ctx.expr());
        codigo.add(new TACInstruction(Opcode.PRINT, val));
        return null;
    }

    @Override
    public TACOperand visitLoop(ParsiumParser.LoopContext ctx) {
        TACOperand labelFalse = novaLabel();
        TACOperand labelEnd = novaLabel();

        TACOperand cond = visit(ctx.expr());
        codigo.add(new TACInstruction(Opcode.IF_FALSE, labelFalse, cond));

        visit(ctx.bloco(0));

        codigo.add(new TACInstruction(Opcode.GOTO, labelEnd));
        codigo.add(new TACInstruction(Opcode.LABEL, labelFalse));

        if (ctx.SENAO() != null) {
            visit(ctx.bloco(1));
        }

        codigo.add(new TACInstruction(Opcode.LABEL, labelEnd));

        return null;
    }

    @Override
    public TACOperand visitWhile(ParsiumParser.WhileContext ctx) {
        TACOperand labelStart = novaLabel();
        TACOperand labelFalse = novaLabel();

        codigo.add(new TACInstruction(Opcode.LABEL, labelStart));

        TACOperand cond = visit(ctx.expr());
        codigo.add(new TACInstruction(Opcode.IF_FALSE, labelFalse, cond));

        visit(ctx.bloco());

        codigo.add(new TACInstruction(Opcode.GOTO, labelStart));
        codigo.add(new TACInstruction(Opcode.LABEL, labelFalse));

        return null;
    }
}
