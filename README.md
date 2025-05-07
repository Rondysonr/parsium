Parsium – Projeto de Compiladores
Parsium é uma linguagem de programação criada exclusivamente para fins acadêmicos na disciplina de Compiladores. Inspirada em PHP, a linguagem oferece recursos como:

Declaração de variáveis (int, string)

Comandos de entrada e saída

Expressões aritméticas, lógicas e relacionais

Estruturas condicionais (if, else)

Laços de repetição (while)

Este projeto implementa a gramática da linguagem Parsium utilizando ANTLR 4.13.2, com analisadores léxico e sintático, geração de árvore sintática abstrata (AST) em .dot e exportação para .png.

📁 Estrutura de Pastas
css
Copiar
Editar
Parsium/
├── lib/
│   └── antlr-4.13.2-complete.jar
├── src/
│   ├── compiler.bat
│   ├── teste.txt                  ← Arquivo de teste (Parsium)
│   └── main/
│       └── grammar/
│           ├── Parsium.g4
│           ├── ParsiumLexer.java
│           ├── ParsiumParser.java
│           ├── ParsiumScanner.java
│           ├── ParsiumParserScanner.java
│           ├── ASTDotExporter.java
│           ├── ParserErrorListener.java
│           └── ParsiumErrorListener.java
📦 Requisitos
Java JDK 17

ANTLR 4.13.2 JAR

Graphviz (para converter .dot em .png)

⚙️ Compilação e Execução
🔁 Modo automático
bat
Copiar
Editar
cd src
compiler.bat
🔧 Modo manual
bash
Copiar
Editar
cd Parsium/src
javac -cp ".;../lib/antlr-4.13.2-complete.jar" main/grammar/Parsium.g4
javac -cp ".;../lib/antlr-4.13.2-complete.jar" main/grammar/*.java
java -cp ".;../lib/antlr-4.13.2-complete.jar" main.grammar.ParsiumScanner teste.txt
java -cp ".;../lib/antlr-4.13.2-complete.jar" main.grammar.ParsiumParserScanner teste.txt
🌳 Geração da AST
Após a execução, será gerado o arquivo arvore.dot.

Para converter em imagem:

bash
Copiar
Editar
dot -Tpng arvore.dot -o arvore.png
📄 Exemplo de Código (arquivo teste.txt)
parsium
Copiar
Editar
int $x;
$x = 10;

if ($x >= 5) {
  echo "maior ou igual a 5";
} else {
  echo "menor que 5";
}

while ($x < 15) {
  echo $x;
  $x = $x + 1;
}
📂 Logs
LogLexicos.txt – saída do analisador léxico

arvore.dot – árvore sintática no formato DOT

arvore.png – representação visual da AST

📝 Sintaxe da Linguagem Parsium
Declarações de Variáveis
parsium
Copiar
Editar
int $idade;
string $nome;
Atribuições
parsium
Copiar
Editar
$idade = 25;
$nome = "João";
Entrada e Saída
parsium
Copiar
Editar
$entrada = readline();
echo $idade;
echo "Olá mundo!";
Expressões
Aritméticas
parsium
Copiar
Editar
$resultado = $a + $b * 2;
Lógicas
parsium
Copiar
Editar
if (($a > 5) && ($b < 10)) {
  echo "ok";
}
Relacionais
parsium
Copiar
Editar
if ($x != 10) {
  echo "diferente";
}
Condicional if-else
parsium
Copiar
Editar
if ($x == 10) {
  echo "igual";
} else {
  echo "diferente";
}
Laço while
parsium
Copiar
Editar
while ($x < 10) {
  echo $x;
  $x = $x + 1;
}
🧑‍💻 Autores
Projeto acadêmico desenvolvido pelos discentes Nicolas Falcão Heemann e Rondyson Railan Siqueira dos Reis
Disciplina: Compiladores
Curso: Engenharia da Computação – IFMT Campus Cel. Octayde Jorge da Silva

