package main.grammar;

import org.antlr.v4.runtime.*;
import java.util.ArrayList;
import java.util.List;

public class ParserErrorListener extends BaseErrorListener {
    private final List<String> erros = new ArrayList<>();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int linha, int posicao,
                            String msg,
                            RecognitionException e) {
        String erro = String.format("ERRO SINTATICO [Linha %d, Coluna %d]: %s", linha, posicao, msg);
        erros.add(erro);
    }

    public boolean temErros() {
        return !erros.isEmpty();
    }

    public void exibirErros() {
        for (String erro : erros) {
            System.err.println(erro);
        }
    }
}
