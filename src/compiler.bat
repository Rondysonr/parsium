@echo off
setlocal

rem === CAMINHOS ===
set ANTLR_JAR=C:\Users\nicol\Downloads\Compiladores_v3\Compiladores_v3\Parsium\lib\antlr-4.13.2-complete.jar
set SRC_DIR=C:\Users\nicol\Downloads\Compiladores_v3\Compiladores_v3\Parsium\src
set JAVA_SRC=%SRC_DIR%\main\grammar
set TEST_FILE=%SRC_DIR%\Teste.txt

echo === COMPILANDO OS ARQUIVOS JAVA NECESSARIOS ===
mkdir "%OUTPUT_DIR%" 2>nul
javac -cp ".;%ANTLR_JAR%" -d "%OUTPUT_DIR%" %JAVA_SRC%\*.java
if %errorlevel% neq 0 (
    echo ERRO NA COMPILACAO
    exit /b 1
)

echo.
echo === EXECUTANDO ParsiumParserScanner ===
cd /d "%OUTPUT_DIR%"
java -cp ".;%ANTLR_JAR%" main.grammar.ParsiumParserScanner "%TEST_FILE%"

echo.

echo.
echo === EXECUTANDO ParsiumScanner ===
cd /d "%OUTPUT_DIR%"
java -cp ".;%ANTLR_JAR%" main.grammar.ParsiumScanner "%TEST_FILE%"

echo.

echo === CONVERTENDO ast.dot PARA PNG ===
if exist arvore.dot (
    dot -Tpng arvore.dot -o arvore.png
    echo AST gerado em arvore.png
) else (
    echo Arquivo arvore.dot não encontrado
)

endlocal
