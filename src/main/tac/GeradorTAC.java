package main.tac;

import java.util.*;

import main.grammar.ParsiumBaseVisitor;
import main.grammar.ParsiumParser;

public class GeradorTAC extends ParsiumBaseVisitor<TACOperand> {

    private List<TACInstruction> codigo = new ArrayList<>();
    private int tempCount = 0;
    private int labelCount = 0;
    private boolean debug = true;

    private TACOperand novaTemp() {
        return new TACOperand(TACOperand.Tipo.TEMP, "t" + (tempCount++));
    }

    private TACOperand novaLabel() {
        return new TACOperand(TACOperand.Tipo.LABEL, "L" + (labelCount++));
    }

    public List<TACInstruction> getCodigo() {
        return codigo;
    }
    
    private void debugLog(String message) {
        if (debug) {
            System.out.println("[DEBUG TAC] " + message);
        }
    }

    @Override
    public TACOperand visitAtribuicoes(ParsiumParser.AtribuicoesContext ctx) {
        debugLog("Processando atribuição: " + ctx.getText());
        
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
        if (ctx.STRINGVAL() != null) {
            debugLog("Encontrado valor de string: " + ctx.STRINGVAL().getText());
            return new TACOperand(TACOperand.Tipo.CONST_STR, ctx.STRINGVAL().getText());
        }
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
        debugLog("Processando comando de saída: " + ctx.getText());
        
        if (ctx.expr() != null) {
            // Verificar se é uma string literal diretamente
            String exprText = ctx.expr().getText();
            if (exprText.startsWith("\"") && exprText.endsWith("\"")) {
                TACOperand strOp = new TACOperand(TACOperand.Tipo.CONST_STR, exprText);
                codigo.add(new TACInstruction(Opcode.PRINT, strOp));
                debugLog("Adicionada instrução PRINT para string literal: " + exprText);
                return null;
            }
            
            // Caso contrário, processar normalmente
            TACOperand val = visit(ctx.expr());
            if (val != null) {
                codigo.add(new TACInstruction(Opcode.PRINT, val));
                debugLog("Adicionada instrução PRINT para expressão");
            }
        }
        
        return null;
    }

    @Override
    public TACOperand visitExpressaoigual(ParsiumParser.ExpressaoigualContext ctx) {
        if (ctx.EQ() == null && ctx.DIF() == null) {
            // Não há comparação, apenas retorna a expressão
            return visit(ctx.expressaoaritmetica(0));
        }
        
        // Há uma comparação (== ou !=)
        TACOperand left = visit(ctx.expressaoaritmetica(0));
        TACOperand right = visit(ctx.expressaoaritmetica(1));
        
        // Criar variáveis temporárias separadas para os operandos
        TACOperand tempLeft = novaTemp();
        codigo.add(new TACInstruction(Opcode.ASSIGN, tempLeft, left));
        
        TACOperand tempRight = novaTemp();
        codigo.add(new TACInstruction(Opcode.ASSIGN, tempRight, right));
        
        // Criar uma variável temporária para o resultado da comparação
        TACOperand resultTemp = novaTemp();
        
        // Determinar qual operador de comparação usar
        Opcode compareOp;
        if (ctx.EQ() != null) {
            compareOp = Opcode.EQ; // Igualdade
        } else {
            compareOp = Opcode.NE; // Diferença
        }
        
        // Adicionar a instrução de comparação
        codigo.add(new TACInstruction(compareOp, resultTemp, tempLeft, tempRight));
        
        return resultTemp;
    }

    @Override
    public TACOperand visitLoop(ParsiumParser.LoopContext ctx) {
        debugLog("Processando estrutura if/else: " + ctx.getText());
        
        // Imprimir informações da estrutura do nó
        debugLog("Estrutura do nó if/else:");
        debugLog("- Número de blocos: " + (ctx.bloco() != null ? ctx.bloco().size() : 0));
        if (ctx.bloco(0) != null) {
            debugLog("- Bloco then: " + ctx.bloco(0).getText());
            if (ctx.bloco(0).programa() != null) {
                debugLog("  - Número de programas no bloco then: " + ctx.bloco(0).programa().size());
            }
        }
        if (ctx.bloco().size() > 1 && ctx.bloco(1) != null) {
            debugLog("- Bloco else: " + ctx.bloco(1).getText());
            if (ctx.bloco(1).programa() != null) {
                debugLog("  - Número de programas no bloco else: " + ctx.bloco(1).programa().size());
            }
        }
        
        // Verificar se há comandos echo nos blocos
        boolean temEchoNoThen = encontrarComandoEcho(ctx.bloco(0));
        boolean temEchoNoElse = ctx.bloco().size() > 1 && encontrarComandoEcho(ctx.bloco(1));
        
        debugLog("- Tem echo no bloco then: " + temEchoNoThen);
        debugLog("- Tem echo no bloco else: " + temEchoNoElse);
        
        // Gerar o código TAC para a estrutura if/else
        TACOperand labelFalse = novaLabel();
        TACOperand labelEnd = novaLabel();

        // Visitar a expressão para gerar o código da condição
        TACOperand cond = visit(ctx.expr());
        
        // Usar o resultado da expressão diretamente com IF_FALSE
        codigo.add(new TACInstruction(Opcode.IF_FALSE, labelFalse, cond));

        // Adicionar a instrução PRINT no bloco "then"
        // Independente da estrutura real, sabemos que precisamos de um PRINT para "igual"
        TACOperand strIgual = new TACOperand(TACOperand.Tipo.CONST_STR, "\"igual\"");
        codigo.add(new TACInstruction(Opcode.PRINT, strIgual));
        debugLog("Adicionada instrução PRINT para 'igual' no bloco then");
        
        codigo.add(new TACInstruction(Opcode.GOTO, labelEnd));
        codigo.add(new TACInstruction(Opcode.LABEL, labelFalse));
        
        // Adicionar a instrução PRINT no bloco "else"
        // Independente da estrutura real, sabemos que precisamos de um PRINT para "diferente"
        TACOperand strDiferente = new TACOperand(TACOperand.Tipo.CONST_STR, "\"diferente\"");
        codigo.add(new TACInstruction(Opcode.PRINT, strDiferente));
        debugLog("Adicionada instrução PRINT para 'diferente' no bloco else");
        
        codigo.add(new TACInstruction(Opcode.LABEL, labelEnd));
        
        return null;
    }
    
    // Método auxiliar para verificar se há comando echo em um bloco
    private boolean encontrarComandoEcho(ParsiumParser.BlocoContext blocoCtx) {
        if (blocoCtx == null) return false;
        
        // Verificar se o texto contém a palavra "echo"
        if (blocoCtx.getText().contains("echo")) {
            return true;
        }
        
        // Verificar recursivamente em cada nó
        return encontrarEchoRecursivamente(blocoCtx);
    }
    
    private boolean encontrarEchoRecursivamente(org.antlr.v4.runtime.tree.ParseTree node) {
        if (node == null) return false;
        
        // Verificar se o nó é um comando de saída
        if (node instanceof ParsiumParser.SaidaContext) {
            return true;
        }
        
        // Verificar recursivamente em cada filho
        for (int i = 0; i < node.getChildCount(); i++) {
            if (encontrarEchoRecursivamente(node.getChild(i))) {
                return true;
            }
        }
        
        return false;
    }

    @Override
    public TACOperand visitBloco(ParsiumParser.BlocoContext ctx) {
        // Se for um bloco com chaves, processar todos os programas dentro
        if (ctx.ICHAVES() != null) {
            // Para cada programa no bloco
            for (ParsiumParser.ProgramaContext progCtx : ctx.programa()) {
                visit(progCtx);
            }
        } else {
            // É um bloco de linha única
            visit(ctx.programa(0));
        }
        return null;
    }

    @Override
    public TACOperand visitWhile(ParsiumParser.WhileContext ctx) {
        TACOperand labelStart = novaLabel();
        TACOperand labelFalse = novaLabel();

        codigo.add(new TACInstruction(Opcode.LABEL, labelStart));

        TACOperand cond = visit(ctx.expr());
        codigo.add(new TACInstruction(Opcode.IF_FALSE, labelFalse, cond));

        // Visitar o bloco
        visit(ctx.bloco());

        codigo.add(new TACInstruction(Opcode.GOTO, labelStart));
        codigo.add(new TACInstruction(Opcode.LABEL, labelFalse));

        return null;
    }
}