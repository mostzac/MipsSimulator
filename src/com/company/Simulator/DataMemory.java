package com.company.Simulator;

public class DataMemory {
    private int[] dataMemory;

    public DataMemory(int size) {
        this.dataMemory = new int[size];
    }

    public int getDataAtIndex(int index) {
        return this.dataMemory[index];
    }

    public void setDataAtIndex(int index, int value) {
        this.dataMemory[index] = value;
    }
}
