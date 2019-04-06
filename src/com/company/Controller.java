package com.company;


import java.util.HashSet;

public class Controller {
    private Instruction instr;
    private String instructionType;
    private HashSet<String> arithmeticFunctions;
    private HashSet<String> conditionalFunctions;
    private HashSet<String> MemoryFunctions;
    Function a;
    // constructor
    public Controller() {
        arithmeticFunctions.add("Add");
        System.out.println("deal with pipeline of MIPS");
    }

    //fetch fucntion
    public String fetch() {
        return "instruction is fetched";
    }

    // decode function
    public String decode() {
        instructionType = instr.getType();
        return "instruction is decoded";
    }

    // execute fucntion
    public String execute() {
        if(arithmeticFunctions.contains(instructionType)){
            a = new Arithmetic();
            a.execute();
        }else if(conditionalFunctions.contains(instructionType)){
            a = new Conditional();
            a.execute();
        }else if(MemoryFunctions.contains(instructionType)){
            a = new Memory();
            a.execute();
        }
        return instr.getInfo() + " is executed";
    }

    // memory access fucntion
    public String memoryAccess() {
        a.memoryAccess();
        return "memory is accesseds";
    }

    // write back fucntion
    public String writeBack() {
        a.writeBack();
        return "data is written into register";
    }
}