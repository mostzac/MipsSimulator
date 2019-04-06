package com.company;

public class Memory implements Function{

    // constructor
    public Memory() {
        System.out.println("Memory is assigned to MIPS");
    }

    // LB fucntion, load byte
    public String LB() {
        return "A byte is loaded";
    }

    // SB function, store byte
    public String SB() {
        return "A byte is stored";
    }

    // LW function, load word
    public String LW() {
        return "A word is loaded";
    }

    // SW function, store word
    public String SW() {
        return "A word is stored";
    }

    // LUI function, load upper immediate
    public String LUI() {
        return "A value is loaded into register";
    }

    // MFHI function, move content of HI register into specified register
    public String MFHI() {
        return "A value is moved from HI register";
    }

    // MFLO function, move content of LO register into specified register
    public String MFLO() {
        return "A value is moved from LO register";
    }

    @Override
    public void execute() {

    }

    @Override
    public void memoryAccess() {

    }

    @Override
    public void writeBack() {

    }
}
