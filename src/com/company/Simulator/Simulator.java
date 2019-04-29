package com.company.Simulator;

import com.company.Controller;

public class Simulator {
    private InstructionMemory InstMemory;
    private DataMemory DataMemory;
    private Register[] Registers;
    private int runningType;//0：single 1:complete
    private Controller controller;

    public Simulator() {
        this.Registers = new Register[32];
        for (int i = 0; i < 32; i++) {
            Registers[i] = new Register("R" + (i + 1), Integer.toHexString(i * 4), 0);
        }
    }

    public Simulator(String[] instructions, int dataMemorysize, int runningType) {
        this.InstMemory = new InstructionMemory(instructions);
        this.DataMemory = new DataMemory(dataMemorysize);
        this.Registers = new Register[32];
        this.runningType = runningType;
    }

    public void run() {
        if (runningType == 0) {

        }
    }

    public Register getRegisterAtIndex(int index) {
        return Registers[index];
    }
}
