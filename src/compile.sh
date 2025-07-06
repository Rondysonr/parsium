#!/bin/bash

# === CAMINHOS ===
ANTLR_JAR="../lib/antlr-4.13.2-complete.jar"
SRC_DIR="."
JAVA_SRC="$SRC_DIR/main/grammar"
OUTPUT_DIR="$SRC_DIR/out"
TEST_FILE="$SRC_DIR/teste.txt"

echo "=== COMPILANDO OS ARQUIVOS JAVA NECESSÁRIOS ==="
mkdir -p "$OUTPUT_DIR"
find "$JAVA_SRC" -name "*.java" | xargs javac -cp ".:$ANTLR_JAR" -d "$OUTPUT_DIR"
if [ $? -ne 0 ]; then
    echo "ERRO NA COMPILAÇÃO"
    exit 1
fi

# Copia arquivo de teste para o diretório de saída
cp "$TEST_FILE" "$OUTPUT_DIR" 2>/dev/null

cd "$OUTPUT_DIR"

echo
echo "=== EXECUTANDO ParsiumParserScanner ==="
java -cp ".:$ANTLR_JAR" main.grammar.ParsiumParserScanner "teste.txt"

echo
echo "=== EXECUTANDO ParsiumScanner ==="
java -cp ".:$ANTLR_JAR" main.grammar.ParsiumScanner "teste.txt"

echo
echo "=== EXECUTANDO ParsiumSemantica (Main) e GERANDO saida.tac e saida.ll ==="
java -cp ".:$ANTLR_JAR" main.grammar.Main "teste.txt" --gerar-tac

if [ -f saida.tac ]; then
    echo "Arquivo saida.tac gerado com sucesso."
else
    echo "Falha ao gerar saida.tac"
fi

if [ -f saida.ll ]; then
    echo "Arquivo saida.ll gerado com sucesso."
else
    echo "Falha ao gerar saida.ll"
fi

echo
echo "=== CONVERTENDO arvore.dot PARA PNG ==="
if [ -f arvore.dot ]; then
    dot -Tpng -Gcharset=latin1 arvore.dot -o arvore.png
    echo "AST gerado em arvore.png"
else
    echo "Arquivo arvore.dot não encontrado"
fi