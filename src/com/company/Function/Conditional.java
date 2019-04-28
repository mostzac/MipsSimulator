package com.company.Function;

import com.company.Instruction;
import com.company.Simulator.Register;
import com.company.UserInterface.GUI;

import java.util.ArrayList;

public class Conditional implements Function {

    int val1, val2, offset, address;
    Instruction instr;

    // constructor
    public Conditional() {
        handleInstruction();
    }

    @Override
    public void setInstruction(Instruction instr) {
        this.instr = instr;
    }

    private void handleInstruction() {
        String function = instr.getFunction();
        ArrayList vals = instr.getVals();
        if (offsetting.contains(function)) {
            if (vals.size() == 2) {
                String reg1 = vals.get(0).toString();
                Register register = GUI.registers[Integer.parseInt(reg1.substring(1))];
            }
        } else if (addressing.contains(function)) {

        } else {
            val1 = 0;
            val2 = 0;
            offset = 0;
            address = 0;
        }
    }

    // BEQ fucntion, branches if two register are equal
    private void BEQ() {
        if (val1 == val2) {
            GUI.offsetStepCounter(offset);
        }
    }

    // BGEZ function, branchs if register >= 0
    private void BGEZ() {
        if (val1 >= 0) {
            GUI.offsetStepCounter(offset);
        }
    }

    // BGEZAL function, branches if the register >= zero and saves the return address in $31
    private void BGEZAL() {
        if (val1 >= 0) {
            GUI.setRegister(31, GUI.getSetpCounter()+1);
            GUI.offsetStepCounter(offset);
        }
    }

    // BGTZ function, branches if the register > 0
    private void BGTZ() {
        if (val1 > 0) {
            GUI.offsetStepCounter(offset);
        }
    }

    // BLEZ fucntion, breanches if the register <= 0
    private void BLEZ() {
        if (val1 <= 0) {
            GUI.offsetStepCounter(offset);
        }
    }

    // BLTZ fucntion, breanches if the register < 0
    private void BLTZ() {
        if (val1 < 0) {
            GUI.offsetStepCounter(offset);
        }
    }

    // BLTZAL function, branches if the register < zero and saves the return address in $31
    private void BLTZAL() {
        if (val1 < 0) {
            GUI.setRegister(31, GUI.getSetpCounter()+1);
            GUI.offsetStepCounter(offset);

        }
    }

    // BNE fucntion, branches if two register are not equal
    private void BNQ() {
        if (val1 != val2) {
            GUI.offsetStepCounter(offset);
        }
    }

    // J fucntion, jump to spicified address
    private void J() {
        GUI.setStepCounter(address);
    }

    // JAL fucntion, jump to spicified address and store return address into $31
    private void JAL() {
        GUI.setRegister(31, GUI.getSetpCounter()+1);
        GUI.setStepCounter(address);
    }

    // JR function, jump to address which is stored at register
    private void JR() {
        GUI.setStepCounter(val1);
    }

    // NOOP fucntion, do nothing
    private void NOOP() {
        return;
    }

    // SYSCALL function, generates interrupt
    private void SYSCALL() {
        System.out.println("INTERRUPT: syscall operation.");
    }


    @Override
    public void execute() {
        int index = conditional.indexOf(function);
        switch (index) {
            case 0:
                BEQ();
                break;
            case 1:
                BGEZ();
                break;
            case 2:
                BGEZAL();
                break;
            case 3:
                BGTZ();
                break;
            case 4:
                BLEZ();
                break;
            case 5:
                BLTZ();
                break;
            case 6:
                BLTZAL();
                break;
            case 7:
                BNQ();
                break;
            case 8:
                J();
                break;
            case 9:
                JAL();
                break;
            case 10:
                NOOP();
                break;
            case 11:
                SYSCALL();
                break;
            default:
                System.out.println("Instruction not found");
        }
    }

    @Override
    public void memoryAccess() {

    }

    @Override
    public void writeBack() {

    }
}
