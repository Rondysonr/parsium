@echo off
setlocal

rem === CAMINHOS ===
set ANTLR_JAR=C:\Users\nicol\Downloads\Compiladores_v3\Compiladores_v3\Parsium\lib\antlr-4.13.2-complete.jar
set SRC_DIR=C:\Users\nicol\Downloads\Compiladores_v3\Compiladores_v3\Parsium\src
set JAVA_SRC=%SRC_DIR%\main\grammar
set TEST_FILE1=%SRC_DIR%\clasificacao_triangulo.txt
set TEST_FILE2=%SRC_DIR%\teste.txt
set OUTPUT_DIR=%SRC_DIR%\out

echo === COMPILANDO OS ARQUIVOS JAVA NECESSARIOS ===
mkdir "%OUTPUT_DIR%" 2>nul
javac -cp ".;%ANTLR_JAR%" -d "%OUTPUT_DIR%" %JAVA_SRC%\*.java
if %errorlevel% neq 0 (
    echo ERRO NA COMPILACAO
    exit /b 1
)

rem === COPIANDO TEST FILES PARA OUTPUT_DIR ===
copy "%TEST_FILE1%" "%OUTPUT_DIR%" >nul
copy "%TEST_FILE2%" "%OUTPUT_DIR%" >nul

cd /d "%OUTPUT_DIR%"

echo.
echo === EXECUTANDO ParsiumParserScanner ===
java -cp ".;%ANTLR_JAR%" main.grammar.ParsiumParserScanner "clasificacao_triangulo.txt"

echo.
echo === EXECUTANDO ParsiumScanner ===
java -cp ".;%ANTLR_JAR%" main.grammar.ParsiumScanner "clasificacao_triangulo.txt"

echo.
echo === EXECUTANDO ParsiumSemantica ===
java -cp ".;%ANTLR_JAR%" main.grammar.Main "teste.txt"

echo.
echo === CONVERTENDO ast.dot PARA PNG ===
if exist arvore.dot (
    dot -Tpng -Gcharset=latin1 arvore.dot -o arvore.png
    echo AST gerado em arvore.png
) else (
    echo Arquivo arvore.dot não encontrado
)

endlocal
