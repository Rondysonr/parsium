package main.tac;

public class TACInstruction {
    private Opcode opcode;
    private TACOperand arg1;
    private TACOperand arg2;
    private TACOperand result;

    public TACInstruction(Opcode opcode, TACOperand result, TACOperand arg1, TACOperand arg2) {
        this.opcode = opcode;
        this.result = result;
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    public TACInstruction(Opcode opcode, TACOperand result, TACOperand arg1) {
        this(opcode, result, arg1, null);
    }

    public TACInstruction(Opcode opcode, TACOperand result) {
        this(opcode, result, null, null);
    }

    public Opcode getOpcode() {
        return opcode;
    }

    public TACOperand getArg1() {
        return arg1;
    }

    public TACOperand getArg2() {
        return arg2;
    }

    public TACOperand getResult() {
        return result;
    }

    @Override
    public String toString() {
        return opcode + " " + result +
                (arg1 != null ? ", " + arg1 : "") +
                (arg2 != null ? ", " + arg2 : "");
    }
}
