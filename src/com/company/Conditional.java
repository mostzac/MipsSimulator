package com.company;

public class Conditional implements Function{

    // constructor
    public Conditional() {
        System.out.println("breach instructions are handled.");
    }

    // BEQ fucntion, branches if two register are equal
    public String BEQ(Register r1, Register r2) {
        return "branches if r1 == r2";
    }

    // BGEZ function, branchs if register >= 0
    public String BGEZ(Register r1) {
        return "branches if r1 >= 0";
    }

    // BGEZAL function, branches if the register >= zero and saves the return address in $31
    public String BGEZAL(Register r1) {
        return "branches if r1 >= 0 and save return address to register $31";
    }

    // BGTZ function, branches if the register > 0
    public String BGTZ(Register r1) {
        return "branches if r1 > 0";
    }

    // BLEZ fucntion, breanches if the register <= 0
    public String BLEZ(Register r1) {
        return "branches if r1 <= 0";
    }

    // BLTZ fucntion, breanches if the register < 0
    public String BLTZ(Register r1) {
        return "branches if r1 < 0";
    }

    // BLTZAL function, branches if the register < zero and saves the return address in $31
    public String BLTZAL(Register r1) {
        return "branches if r1 < 0 and save return address to register $31";
    }

    // BNE fucntion, branches if two register are not equal
    public String BNQ(Register r1, Register r2) {
        return "branches if r1 != r2";
    }

    // J fucntion, jump to spicified address
    public String J(String address) {
        return "jump to " + address + " address";
    }

    // JAL fucntion, jump to spicified address and store return address into $31
    public String JAL(String address) {
        return "jump to " + address + " address and store return address to $31";
    }

    // JR function, jump to address which is stored at register
    public String JR(Register r1) {
        return "jump to address which is stored at r1";
    }

    // NOOP fucntion, do nothing
    public String NOOP() {
        return "do nothing";
    }

    // SYSCALL function, generates interrupt
    public String SYSCALL() {
        return "An interrupt is generated";
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