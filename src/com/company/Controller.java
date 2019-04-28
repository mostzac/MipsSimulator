package com.company;

import com.company.Function.*;
import com.company.UserInterface.GUI;

public class Controller {
    String stringFile;
//    Register[] regs;
    FileParser file;
    Instruction[] instructionList;

    public Controller() {}

    public void setStringFile(String stringFile) {
        this.stringFile = stringFile;
        decodeString();
    }

    private void decodeString() {
        file = new FileParser(stringFile);
        instructionList = file.getInstructions();
    }

    public Instruction[] getInstructions() {
        return instructionList;
    }

    public void performNextInstruction(Instruction instr) {
        FunctionFactory a = new FunctionFactory();
        Function func = a.factory(instr.getFunction());
        func.setInstruction(instr);
        func.execute();
    }
}
