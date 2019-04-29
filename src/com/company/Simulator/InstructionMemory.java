package com.company.Simulator;

import com.company.Instruction;

public class InstructionMemory {
    //Taking Add R1,R2,R3
    private Instruction[] set;//

    public InstructionMemory(String[] instructionSet) {
        int index = 0;
        for (String a : instructionSet) {
            set[index] = new Instruction(a);
            index++;
        }
    }

    public Instruction getInstructionAtIndex(int index) {
        return this.set[index];
    }

}