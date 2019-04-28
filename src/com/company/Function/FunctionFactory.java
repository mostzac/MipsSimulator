package com.company.Function;

import java.util.ArrayList;

public class FunctionFactory {
    ArrayList arithmetic = new ArrayList<String>() {{}};
    ArrayList<String> memory = new ArrayList<String>() {{}};
    ArrayList<String> conditional = new ArrayList<String>() {{
        add("BEQ");
        add("BGEZ");
        add("BGEZAL");
        add("BGTZ");
        add("BLEZ");
        add("BLTZ");
        add("BLTZAL");
        add("BNQ");
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
