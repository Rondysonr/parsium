package main.grammar;

import org.antlr.v4.runtime.*;


import java.io.*;

public class ParsiumScanner {
    private static final String LOG_FILE = "  LogLexicos.txt";
    
    public static void main(String[] args) {
        if (args.length != 1) {
            System.exit(1);
        }
        
        String sourceFile = args[0];
        try {
            // Configuração para ler o arquivo fonte
            CharStream input = CharStreams.fromFileName(sourceFile);
            ParsiumLexer lexer = new ParsiumLexer(input);
            
            // Configurar gerenciamento de erros personalizado
            lexer.removeErrorListeners();
            ParsiumErrorListener errorListener = new ParsiumErrorListener();
            lexer.addErrorListener(errorListener);
            
            // Criando arquivo de log
            PrintWriter logWriter = new PrintWriter(new FileWriter(LOG_FILE));
            
            // Processando tokens
            Token token;
            logWriter.println("ANALISE LEXICA - " + sourceFile);
            logWriter.println("---------------------------------------------");
            logWriter.println("| TOKEN                | LEXEMA | LINHA:COL |");
            logWriter.println("---------------------------------------------");
            
            while ((token = lexer.nextToken()).getType() != Token.EOF){
                 {
                    String tokenName = lexer.getVocabulary().getSymbolicName(token.getType());
                    String lexeme = token.getText();
                    int line = token.getLine();
                    int col = token.getCharPositionInLine();
                    
                    // Formatando saída do token
                    String tokenInfo = String.format("| %-20s | %-6s | %4d:%-4d |", 
                                                   tokenName, lexeme, line, col);
                    
                    // Escrevendo no arquivo de log e exibindo na tela
                    logWriter.println(tokenInfo);
                    System.out.println(tokenInfo);
                }
            }
            
            logWriter.println("---------------------------------------------");
            
        
            
            logWriter.close();
            
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }
    }
}