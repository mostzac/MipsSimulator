package com.company.Function;

import com.company.Instruction;
import com.company.Simulator.Register;
import com.company.UserInterface.GUI;

import java.util.ArrayList;

public class Memory implements Function {

    int val1;
    Register reg1;
    String regString;
    int memAddress;
    int valM;
    Instruction instr;
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
        add("MTHI");
        add("MFLO");
        add("MTLO");
    }};


    // constructor
    public Memory() {
    }

    @Override
    public void setInstruction(Instruction instr) {
        this.instr = instr;
    }

    @Override
    public void handleInstruction(Instruction instr) {
        setInstruction(instr);
        String function = instr.getFunction();
        ArrayList vals = instr.getVals();
        if (vals.size() == 2) {
            regString = vals.get(0).toString();
            reg1 = GUI.registers[Integer.parseInt(regString.substring(1)) - 1];
            val1 = reg1.getRegisterValue();
            String[] a = vals.get(1).toString().split("\\(R");
            if (a.length == 1) { // immediate
                valM = Integer.parseInt(a[0]);
            } else if (a.length == 2) { // MEM[offset + (R*)]
                memAddress = Integer.parseInt(a[0]) + Integer.parseInt(a[1].substring(0, a[1].length() - 1)) - 1;
                valM = GUI.getDataMemory().getDataAtIndex(memAddress);
            }
        } else if (vals.size() == 1) {
            regString = vals.get(0).toString();
            reg1 = GUI.registers[Integer.parseInt(regString.substring(1)) - 1];
            val1 = reg1.getRegisterValue();
            valM = 0;
        } else {
            val1 = 0;
            reg1 = null;
            regString = "";
            valM = 0;
        }
    }

    // LB function, load byte
    private void LB() {
        reg1.setRegisterValue(valM);
        GUI.StepCounterIncrease();
    }

    // SB function, store byte
    private void SB() {
        GUI.getDataMemory().setDataAtIndex(memAddress, (0xFF & val1));
        GUI.StepCounterIncrease();
    }

    // MFHI function, move content of HI register into specified register
    private void MFHI() {
        reg1.setRegisterValue(GUI.getHIValue());
        System.out.println("Move HI register into " + regString + " .");
        GUI.StepCounterIncrease();
    }

    // MFLO function, move content of LO register into specified register
    private void MFLO() {
        reg1.setRegisterValue(GUI.getLOValue());
        System.out.println("Move LO register into " + regString + " .");
        GUI.StepCounterIncrease();
    }

    // MTHI function, move content of HI register into specified register
    private void MTHI() {
        GUI.setHIValue(reg1.getRegisterValue());
        System.out.println("Move " + regString + " into HI special register.");
        GUI.StepCounterIncrease();
    }

    // MTHI function, move content of LO register into specified register
    private void MTLO() {
        GUI.setLOValue(reg1.getRegisterValue());
        System.out.println("Move " + regString + " into LO special register.");
        GUI.StepCounterIncrease();
    }


    @Override
    public void execute() {
        int index = memory.indexOf(instr.getFunction());
        switch (index) {
            case 0:
                LB();
                break;
            case 1:
                LB();
                break;
            case 2:
                LB();
                break;
            case 3:
                LB();
                break;
            case 4:
                LB();
                break;
            case 5:
                LB();
                break;
            case 6:
                LB();
                break;
            case 7:
                LB();
                break;
            case 8:
                SB();
                break;
            case 9:
                SB();
                break;
            case 10:
                SB();
                break;
            case 11:
                MFHI();
                break;
            case 12:
                MTHI();
                break;
            case 13:
                MFLO();
                break;
            case 14:
                MTLO();
                break;
            default:
                System.out.println("Instruction not found.");
        }
    }

    @Override
    public void memoryAccess() {

    }

    @Override
    public void writeBack() {

    }
}
