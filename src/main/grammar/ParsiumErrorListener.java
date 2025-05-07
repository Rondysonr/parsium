package main.grammar;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Interval;

import java.util.ArrayList;
import java.util.List;

public class ParsiumErrorListener extends BaseErrorListener {

    private List<String> lexicoErrors = new ArrayList<>();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int linha,
                            int PosicaoLinha,
                            String msg,
                            RecognitionException e) {

        String simbolo = "";

        if (e instanceof LexerNoViableAltException) {
            LexerNoViableAltException lex = (LexerNoViableAltException) e;
            CharStream input = ((Lexer) recognizer).getInputStream();
            int start = lex.getStartIndex();
            int end = input.index();
            simbolo = input.getText(Interval.of(start, end));
        } else if (offendingSymbol instanceof Token) {
            simbolo = ((Token) offendingSymbol).getText();
        }

        String error = String.format("ERRO LEXICO [Linha %d, Coluna %d]: Simbolo '%s' invalido", linha, PosicaoLinha, simbolo);
        lexicoErrors.add(error);
        System.err.println(error);
    }

    public List<String> getLexicalErrors() {
        return lexicoErrors;
    }
}
