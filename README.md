
# Parsium – Projeto de Compiladores

Este projeto implementa uma gramática baseada em PHP,analisador léxico e sintático utilizando a ferramenta [ANTLR 4.13.2](https://www.antlr.org/) para a linguagem de programação criada **Parsium**, com geração da árvore sintática (AST) em formato `.dot` e `.png`.

## 📁 Estrutura de Pastas

```
Parsium/
├── lib/
│   └── antlr-4.13.2-complete.jar
├── src/
│   ├── compiler.bat
│   ├── teste.txt                  ← Arquivo de teste (Parsium)
│   └── main/
│       └── grammar/
│           ├── Parsium.g4         ← Gramática 
│           ├── ParsiumLexer.java
│           ├── ParsiumParser.java
│           ├── ParsiumScanner.java         ← Analisador léxico
│           ├── ParsiumParserScanner.java   ← Analisador sintático + AST
│           ├── ASTDotExporter.java         ← Exporta AST para .dot
│           ├── ParserErrorListener.java    ← Tratamento de erros sintáticos
│           └── ParsiumErrorListener.java   ← Tratamento de erros léxicos
```

---

## 🚀 Requisitos

- [Java JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [ANTLR 4.13.2 JAR](https://www.antlr.org/download.html)
- [Graphviz](https://graphviz.org/download/) (para converter `.dot` em `.png`)

---

## ⚙️ Compilação e Execução

### ✅ Executar tudo automaticamente (recomendado)

1. Edite `compiler.bat`:
   ```bat
   cd src
   compiler.bat
   ```

> Isso irá compilar todos os arquivos `.java`, executar o `ParsiumScanner` e `ParsiumParserScanner`, gerar os logs, a AST e o `.png`.

---

### 🔧 Compilação manual

1. **Vá para a pasta `src`**:
   ```bash
   cd Parsium/src
   ```

2. **Compile os arquivos Java**:
   ```bash
   javac -cp ".;../lib/antlr-4.13.2-complete.jar" main/grammar/*.java
   ```

3. **Execute o analisador léxico** (gera log `LogLexicos.txt`):
   ```bash
   java -cp ".;../lib/antlr-4.13.2-complete.jar" main.grammar.ParsiumScanner teste.txt
   ```

4. **Execute o analisador sintático e gera arvore.dot***:
   ```bash
   java -cp ".;../lib/antlr-4.13.2-complete.jar" main.grammar.ParsiumParserScanner teste.txt
   ```

---

## 🌳 Geração da AST (.dot e .png)

O arquivo `ParsiumParserScanner.java` utiliza a classe `ASTDotExporter` para gerar a árvore sintática em formato `.dot`:

```bash
arvore.dot
```

### Para converter para imagem `.png`:

> Requer que o Graphviz esteja instalado e acessível pelo terminal (`dot`).

```bash
dot -Tpng arvore.dot -o arvore.png
```

---

## 📂 Arquivos de Entrada

O programa espera um arquivo `.txt` como entrada de código Parsium. Exemplo:

```parsium
int $x;
$x = 10;
echo $x;
```

Salve como `teste.txt` dentro da pasta `src`.

---

## 🛠 Logs

- **`LogLexicos.txt`** – saída do analisador léxico
- **`arvore.dot`** – representação em DOT da AST
- **`arvore.png`** – imagem da árvore sintática abstrata

---

## ✍️ Autores

Projeto acadêmico desenvolvido pelo discente Nicolas Falcão Heemann e Rondyson Railan Siqueira dos Reis para a disciplina de **Compiladores** – Engenharia da Computação.

---

