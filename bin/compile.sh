#!/bin/bash

# === CAMINHOS ===
ANTLR_JAR="e:/usuario/Downloads/Parsium/Parsium/lib/antlr-4.13.2-complete.jar"
SRC_DIR="e:/usuario/Downloads/Parsium/Parsium"
JAVA_SRC="$SRC_DIR/src/main"
OUTPUT_DIR="$SRC_DIR/src/out"
#TEST_FILE="$SRC_DIR/src/teste.txt"
TEST_FILE="$SRC_DIR/src/triangulo_pascal.txt"

# Limpar diretório de saída
echo "=== LIMPANDO DIRETÓRIO DE SAÍDA ==="
rm -rf "$OUTPUT_DIR"
mkdir -p "$OUTPUT_DIR"

# Compilar todos os arquivos Java
echo "=== COMPILANDO ARQUIVOS JAVA ==="
javac -cp ".;$ANTLR_JAR" -d "$OUTPUT_DIR" $(find "$JAVA_SRC" -name "*.java")

if [ $? -ne 0 ]; then
    echo "ERRO NA COMPILAÇÃO"
    exit 1
fi

# Copia arquivo de teste para o diretório de saída
cp "$TEST_FILE" "$OUTPUT_DIR/teste.txt" 2>/dev/null

# Cria um diretório de trabalho temporário para execução
TEMP_DIR="$OUTPUT_DIR/temp"
mkdir -p "$TEMP_DIR"

# Copia o arquivo de teste para o diretório temporário também
cp "$TEST_FILE" "$TEMP_DIR/teste.txt" 2>/dev/null

# Executa os programas a partir do diretório temporário para evitar poluir o out
cd "$TEMP_DIR"

echo
echo "=== EXECUTANDO ParsiumParserScanner ==="
java -cp "$OUTPUT_DIR;$ANTLR_JAR" main.grammar.ParsiumParserScanner "teste.txt" || echo "Erro ao executar ParsiumParserScanner"

echo
echo "=== EXECUTANDO ParsiumScanner ==="
java -cp "$OUTPUT_DIR;$ANTLR_JAR" main.grammar.ParsiumScanner "teste.txt" || echo "Erro ao executar ParsiumScanner"

echo
echo "=== EXECUTANDO ParsiumSemantica (Main) e GERANDO saida.tac e saida.ll ==="
java -cp "$OUTPUT_DIR;$ANTLR_JAR" main.grammar.Main "teste.txt" --gerar-tac || echo "Erro ao executar Main"

# Move os arquivos gerados de volta para o diretório de saída
if [ -f saida.tac ]; then
    mv saida.tac "$OUTPUT_DIR/"
    echo "Arquivo saida.tac gerado com sucesso."
    echo "=== CONTEÚDO DO ARQUIVO saida.tac ==="
    cat "$OUTPUT_DIR/saida.tac"
else
    echo "Falha ao gerar saida.tac"
fi

if [ -f saida.ll ]; then
    mv saida.ll "$OUTPUT_DIR/"
    echo "Arquivo saida.ll gerado com sucesso."
    echo "=== CONTEÚDO DO ARQUIVO saida.ll ==="
    cat "$OUTPUT_DIR/saida.ll"
    
    # Tentar encontrar o comando lli no PATH
    LLI_COMMAND=""
    
    if command -v lli &> /dev/null; then
        LLI_COMMAND="lli"
    elif command -v "C:/Program Files/LLVM/bin/lli.exe" &> /dev/null; then
        LLI_COMMAND="C:/Program Files/LLVM/bin/lli.exe"
    elif command -v "C:/LLVM/bin/lli.exe" &> /dev/null; then
        LLI_COMMAND="C:/LLVM/bin/lli.exe"
    elif [ -f "E:/usuario/Downloads/clang+llvm-20.1.7-x86_64-pc-windows-msvc/clang+llvm-20.1.7-x86_64-pc-windows-msvc/bin/lli.exe" ]; then
        LLI_COMMAND="E:/usuario/Downloads/clang+llvm-20.1.7-x86_64-pc-windows-msvc/clang+llvm-20.1.7-x86_64-pc-windows-msvc/bin/lli.exe"
    fi
    
    if [ -n "$LLI_COMMAND" ]; then
        echo
        echo "=== EXECUTANDO CÓDIGO LLVM COM LLI ==="
        cd "$OUTPUT_DIR"  # Mudamos para o diretório output para executar o LLVM
        "$LLI_COMMAND" saida.ll
    else
        echo
        echo "NOTA: O comando 'lli' não foi encontrado."
        echo "Por favor, instale o LLVM ou adicione-o ao PATH."
    fi
else
    echo "Falha ao gerar saida.ll"
fi

# Move o arquivo dot se existir
if [ -f arvore.dot ]; then
    mv arvore.dot "$OUTPUT_DIR/"
fi

# Volta para o diretório de saída
cd "$OUTPUT_DIR"

echo
echo "=== CONVERTENDO arvore.dot PARA PNG ==="
if [ -f arvore.dot ]; then
    # Tentar vários caminhos possíveis para o dot
    if command -v dot &> /dev/null; then
        dot -Tpng -Gcharset=latin1 arvore.dot -o arvore.png
    elif [ -f "C:/Program Files/Graphviz/bin/dot.exe" ]; then
        "C:/Program Files/Graphviz/bin/dot.exe" -Tpng -Gcharset=latin1 arvore.dot -o arvore.png
    elif [ -f "/c/Program Files/Graphviz/bin/dot.exe" ]; then
        "/c/Program Files/Graphviz/bin/dot.exe" -Tpng -Gcharset=latin1 arvore.dot -o arvore.png
    else
        echo "Não foi possível encontrar o comando dot para gerar o PNG."
        echo "Você pode visualizar o arquivo arvore.dot em um visualizador online:"
        echo "- https://dreampuf.github.io/GraphvizOnline/"
    fi
    
    if [ -f "arvore.png" ]; then
        echo "AST gerado em arvore.png"
    fi
else
    echo "Arquivo arvore.dot não encontrado"
fi

# Limpar diretório temporário
rm -rf "$TEMP_DIR"

# Remover arquivos Parsium gerados no out
echo "=== LIMPANDO ARQUIVOS PARSIUM INDESEJADOS ==="
rm -f "$OUTPUT_DIR/Parsium"*.java "$OUTPUT_DIR/Parsium"*.tokens "$OUTPUT_DIR/Parsium"*.interp

# Mostrar onde estão os arquivos de saída
echo
echo "=== ARQUIVOS DE SAÍDA ==="
echo "Diretório: $OUTPUT_DIR"
echo "Arquivos gerados:"
ls -la "$OUTPUT_DIR" | grep -v "\.class$"

echo "Processo concluído com sucesso!"