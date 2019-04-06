package com.company;

public class Instruction {
    private String instructionInfo;//take Add R1,R2,R3 as example
    private String type;//Add
    String para1, para2, para3;
    private int instructionLocation;

    public Instruction(String info,int location) {
        this.instructionInfo = info;
        this.instructionLocation = location;
        parseInstruction(this.instructionInfo);
    }

    public void parseInstruction(String info){
        String[] t = info.split(" ");
        this.type = t[0];//Store Add
        para1 = "R1";
        para2 = "R2";
        para3 = "R3";
    }

    public String getInfo(){
        return this.instructionInfo;
    }
    public String getType(){
        return this.type;
    }
    public String getPara1(){
        return this.para1;
    }
    public String getPara2(){
        return this.para2;
    }
    public String getPara3(){
        return this.para3;
    }
    public int getLocation(){
        return this.instructionLocation;
    }
}
