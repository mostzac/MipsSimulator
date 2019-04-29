package com.company.Function;

import com.company.Instruction;
import com.company.Simulator.Register;
import com.company.UserInterface.GUI;

import java.util.ArrayList;

public class Arithmetic implements Function {

    int val1, val2, val3;
    Register storeRegister;
    Instruction instr;
    ArrayList<String> arithmetic = new ArrayList<String>() {{
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


    // constructor
    public Arithmetic() {
    }

    @Override
    public void setInstruction(Instruction instr) {
        this.instr = instr;
    }


    @Override
    public void handleInstruction(Instruction instr) {
        setInstruction(instr);
        //String function = instr.getFunction();
        ArrayList vals = instr.getVals();
        if (vals.size() == 3) {
            String reg3 = vals.get(0).toString();
            String reg1 = vals.get(1).toString();
            String reg2 = vals.get(2).toString();
            if (reg1.substring(0, 1).equals("R")) {
                Register register = GUI.registers[Integer.parseInt(reg1.substring(1)) - 1];
                val1 = register.getRegisterValue();
            } else {
                val1 = Integer.parseInt(reg1);
            }

            if (reg2.substring(0, 1).equals("R")) {
                Register register = GUI.registers[Integer.parseInt(reg2.substring(1)) - 1];
                val2 = register.getRegisterValue();
            } else {
                val2 = Integer.parseInt(reg2);
            }
            if (reg3.substring(0, 1).equals("R")) {
                this.storeRegister = GUI.registers[Integer.parseInt(reg3.substring(1)) - 1];
            }
        } else if (vals.size() == 2) {
            String reg1 = vals.get(0).toString();
            String reg2 = vals.get(1).toString();
            if (reg2.substring(0, 1).equals("R")) {
                Register register = GUI.registers[Integer.parseInt(reg2.substring(1)) - 1];
                val2 = register.getRegisterValue();
            } else {
                val2 = Integer.parseInt(reg2);
            }
            if (reg1.substring(0, 1).equals("R")) {
                Register register = GUI.registers[Integer.parseInt(reg1.substring(1)) - 1];
                val1 = register.getRegisterValue();
            } else {
                val1 = Integer.parseInt(reg1);
            }
        } else {
            val1 = 0;
            val2 = 0;
            val3 = 0;
        }

    }

    private void ADD() {
        storeRegister.setRegisterValue(val1 + val2);
        GUI.StepCounterIncrease();
    }

    private void SUB() {
        storeRegister.setRegisterValue(val1 - val2);
        GUI.StepCounterIncrease();
    }

    private void MULT() {
        storeRegister.setRegisterValue(val1 * val2);
        GUI.StepCounterIncrease();
    }

    private void DIV() {
        GUI.setLOValue(val1 / val2);
        GUI.setHIValue(val1 % val2);
        GUI.StepCounterIncrease();
    }

    public void AND() {
        storeRegister.setRegisterValue(val1 & val2);
        GUI.StepCounterIncrease();
    }

    private void OR() {
        storeRegister.setRegisterValue(val1 | val2);
        GUI.StepCounterIncrease();
    }

    private void XOR() {
        storeRegister.setRegisterValue(val1 ^ val2);
        GUI.StepCounterIncrease();
    }

    private void SLL() {
        storeRegister.setRegisterValue(val1 << val2);
        GUI.StepCounterIncrease();
    }

    private void SRA() {//>> signed right shift  1010 - 1101
        storeRegister.setRegisterValue(val1 >> val2);
        GUI.StepCounterIncrease();
    }


    private void SLT() {
        if (val1 < val2) {
            storeRegister.setRegisterValue(1);
        } else {
            storeRegister.setRegisterValue(0);
        }
        GUI.StepCounterIncrease();
    }

    private void SR() {//>>>unsigned right shift  1010 - 0101
        storeRegister.setRegisterValue(val1 >>> val2);
        GUI.StepCounterIncrease();
    }


    @Override
    public void execute() {
        int index = arithmetic.indexOf(instr.getFunction());
        switch (index) {
            case 0:
                ADD();
                break;
            case 1:
                ADD();
                break;
            case 2:
                ADD();
                break;
            case 3:
                ADD();
                break;
            case 4:
                AND();
                break;
            case 5:
                AND();
                break;
            case 6:
                DIV();
                break;
            case 7:
                DIV();
                break;
            case 8:
                MULT();
                break;
            case 9:
                MULT();
                break;
            case 10:
                OR();
                break;
            case 11:
                OR();
                break;
            case 12:
                SLL();
                break;
            case 13:
                SLL();
                break;
            case 14:
                SLT();
                break;
            case 15:
                SLT();
                break;
            case 16:
                SLT();
                break;
            case 17:
                SLT();
                break;
            case 18:
                SRA();
                break;
            case 19:
                SR();
                break;
            case 20:
                SR();
                break;
            case 21:
                SUB();
                break;
            case 22:
                SUB();
                break;
            case 23:
                XOR();
                break;
            case 24:
                XOR();
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
