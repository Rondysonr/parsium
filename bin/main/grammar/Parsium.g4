grammar Parsium;

prog : programa* EOF ;

programa
    : declaracoes
    | atribuicoes
    | leitura
    | saida
    | loop
    | while
    | expr PVIRG         
    ;

declaracoes : (INT | STRING) VAR (',' VAR)* PVIRG ;

atribuicoes  : VAR IGUAL expr PVIRG ;

leitura : LEIA expr PVIRG ;

saida    : ESCREVA expr PVIRG ;

loop
    : SE IPAREN expr FPAREN bloco (SENAO bloco)?
    ;

while
    : ENQUANTO IPAREN expr FPAREN bloco 
    ;

bloco : ICHAVES programa* FCHAVES | programa ;

expr : logicExpr ;

logicExpr
    : relacionalExpr ((AND | OR) relacionalExpr)*
    ;

relacionalExpr
    : expressaoigual ((MAIORQ | MENORQ | MAIORIG | MENORIG) expressaoigual)?
    ;

expressaoigual
    : expressaoaritmetica ((EQ | DIF) expressaoaritmetica)?
    ;

expressaoaritmetica
    : termo ((SOMA | SUB) termo)*
    ;

termo
    : fator ((MUL | DIV) fator)*
    ;

fator
    : NUMEROS
    | VAR
    | STRINGVAL
    | LEIA IPAREN FPAREN
    | IPAREN expr FPAREN
    | NOT fator
    ;

SE        : 'if';
SENAO     : 'else';
ENQUANTO  : 'while';
ESCREVA   : 'echo';
LEIA      : 'readline';
INT       : 'int';
STRING    : 'string';

IPAREN    : '(';
FPAREN    : ')';
ICHAVES   : '{';
FCHAVES   : '}';
PVIRG     : ';';
IGUAL     : '=';
SOMA      : '+';
SUB       : '-';
MUL       : '*';
DIV       : '/';
EQ        : '==';
DIF       : '!=';
AND       : '&&';
OR        : '||';
NOT       : '!';
MAIORQ    : '>';
MENORQ    : '<';
MAIORIG   : '>=';
MENORIG   : '<=';

VAR       : '$' [a-zA-Z_][a-zA-Z0-9_]*;
NUMEROS   : [0-9]+;
STRINGVAL : '"' (~["\\] | '\\' .)* '"';

WS        : [ \t\r\n]+ -> skip;
