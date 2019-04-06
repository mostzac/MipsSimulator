package com.company;

public class Simulator {
    private InstructionMemory InstMemory;
    private DataMemory DataMemory;
    private Register[] Registers;
    private int runningType;//0：single 1:complete
    private Controller controller;

    public Simulator(String[] instructions,int dataMemorysize,int runningType){
        this.InstMemory = new InstructionMemory(instructions);
        this.DataMemory = new DataMemory(dataMemorysize);
        this.Registers = new Register[32];
        this.runningType = runningType;
    }

    public void run(){
        if(runningType==0){
            controller.fetch();
            controller.decode();
            controller.execute();
            controller.memoryAccess();
            controller.writeBack();
        }
    }
}
