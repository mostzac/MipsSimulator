package com.company;

import java.util.ArrayList;

public class Instruction {
  String instruction;
  String function;
  ArrayList vals = new ArrayList();

  public Instruction(String instruction) {
    this.instruction = instruction;
    parseInstruction();
  }

  private void parseInstruction() {
    String[] data = instruction.split("\\s+");
    function = data[0];
    for (int i = 1; i < data.length; i++) {
      String currVal = data[i].toUpperCase();
      vals.add(currVal);
    }
  }

  public String getInstruction() {
    return instruction;
  }

  public String getFunction() {
    return function;
  }

  public ArrayList getVals() {
    return vals;
  }
}
