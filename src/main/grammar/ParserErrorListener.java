package main.grammar;

import org.antlr.v4.runtime.*;

public class ParserErrorListener extends BaseErrorListener {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int linha, int PosicaoDaLinha,
                            String msg,
                            RecognitionException e) {
        System.err.printf("ERRO SINTATICO [Linha %d, Coluna %d]: %s%n", linha, PosicaoDaLinha, msg);
    }
}
