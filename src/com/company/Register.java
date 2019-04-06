package com.company;

public class Register {
    private String registerName;
    private String registerLocation;
    private int registerValue;

    public Register(String registerName, String registerLocation, int registerValue) {
        this.registerName = registerName;
        this.registerLocation = registerLocation;
        this.registerValue = registerValue;
    }

    public String getRegisterName() {
        return registerName;
    }

    public String getRegisterLocation() {
        return registerLocation;
    }

    public int getRegisterValue() {
        return registerValue;
    }

    public void setRegisterValue(int val) {
        this.registerValue = val;
    }
}
