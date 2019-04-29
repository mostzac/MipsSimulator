package com.company.Function;

import java.util.ArrayList;

public class FunctionFactory {
    ArrayList arithmetic = new ArrayList<String>() {{
        add("ADD");
        add("ADDU");
        add("ADDI");
        add("ADDIU");
        add("AND");
        add("ANDI");
        add("DIV");
        add("DIVU");
        add("MULT");
        add("MULTU");
        add("OR");
        add("ORI");
        add("SLL");
        add("SLLV");
        add("SLT");
        add("SLTU");
        add("SLTI");
        add("SLTIU");
        add("SRA");
        add("SRL");
        add("SRLV");
        add("SUB");
        add("SUBU");
        add("XOR");
        add("XORI");
    }};
    ArrayList<String> memory = new ArrayList<String>() {{
        add("LI");
        add("LHI");
        add("LLO");
        add("LB");
        add("LBU");
        add("LH");
        add("LHU");
        add("LW");
        add("SB");
        add("SH");
        add("SW");
        add("MFHI");
        add("MFLO");
        add("MTHI");
        add("MTLO");
    }};
    ArrayList<String> conditional = new ArrayList<String>() {{
        add("BEQ");
        add("BGEZ");
        add("BGEZAL");
        add("BGTZ");
        add("BLEZ");
        add("BLTZ");
        add("BLTZAL");
        add("BNE");
        add("J");
        add("JAL");
        add("JR");
        add("NOOP");
        add("SYSCALL");
    }};

    public Function factory(String function) {
        function = function.toUpperCase();
        if (function == null) {
            return null;
        }
        if (arithmetic.contains(function)) {
            return new Arithmetic();
        } else if (memory.contains(function)) {
            return new Memory();
        } else if (conditional.contains(function)) {
            return new Conditional();
        }
        return null;
    }
}
