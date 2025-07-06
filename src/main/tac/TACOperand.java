package main.tac;


public class TACOperand {
    public enum Tipo { VAR, TEMP, LABEL, CONST_INT, CONST_STR }
    public final Tipo tipo;
    public final String valor;

    public TACOperand(Tipo tipo, String valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return valor;
    }
}
