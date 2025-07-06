package main.tac;

public enum Opcode {
    ASSIGN,      // :=
    ADD,         // +
    SUB,         // -
    MUL,         // *
    DIV,         // /
    INPUT,       // leitura
    PRINT,       // saída
    GOTO,        // goto label
    IF_FALSE,    // if_false_goto
    IF,          // if_goto
    LABEL,       // definição de label
    NOT          // negação lógica
}
