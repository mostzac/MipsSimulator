package com.company.UserInterface;

import com.company.Controller;
import com.company.Instruction;
import com.company.Simulator.Register;
import com.company.Simulator.Simulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI {

    static public Register[] registers;
    static int stepCounter;
    JFrame frame;
    JLabel label, currentInstruction;
    JTextField fileText;
    JButton browse, load, step, run;
    JRadioButton stepRun, fullRun;
    JTable regTable;
    public Controller controller;
    static public Instruction[] instructions;

    public GUI() {
        stepCounter = 0;
        setComponents();
        setFrame();
        open();
    }

    private void open() {
        frame.setVisible(true);
        label.setVisible(true);
        fileText.setVisible(true);
        browse.setVisible(true);
        load.setVisible(true);
        stepRun.setVisible(true);
        fullRun.setVisible(true);
        step.setVisible(true);
        run.setVisible(true);
        regTable.setVisible(true);
        currentInstruction.setVisible(true);
    }

    private void setFrame() {
        frame = new JFrame();
        frame.setSize(900,900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.add(label);
        frame.add(fileText);
        frame.add(browse);
        frame.add(load);
        frame.add(stepRun);
        frame.add(fullRun);
        frame.add(step);
        frame.add(run);
        frame.add(regTable);
        frame.add(currentInstruction);
    }

    private void setComponents() {
        label = new JLabel();
        label.setBounds(2,600,100,20);
        label.setText("Enter file name:");
        fileText = new JTextField();
        fileText.setBounds(102, 600, 100, 20);
        browse = new JButton("Browse");
        browse.setBounds(205, 600, 80, 20);
        browse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Browsing . . .");
            }
        });
        load = new JButton("Load");
        load.setBounds(290, 600, 80, 20);
        load.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Loading . . .");
                String file = fileText.getText();
                try {
                    controller = new Controller();
                    controller.setStringFile(file);
                    instructions = controller.getInstructions();
                }
                catch (Exception ex) {
                    System.err.println("ERROR: File not found.");
                }
            }
        });
        stepRun = new JRadioButton("Step Run");
        stepRun.setBounds(102, 625, 100, 20);
        stepRun.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fullRun.setSelected(false);
            }
        });
        fullRun = new JRadioButton("Full Run", true);
        fullRun.setBounds(205, 625, 100, 20);
        fullRun.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stepRun.setSelected(false);
            }
        });
        step = new JButton("Step");
        step.setBounds(307, 625, 80, 20);
        step.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Step " + stepCounter + " . . .");
                currentInstruction.setText(instructions[stepCounter].getInstruction());
                controller.performNextInstruction(instructions[stepCounter]);
                updateTable();
                stepCounter++;
            }
        });
        run = new JButton("Run");
        run.setBounds(390, 625, 80, 20);
        run.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Running . . .");
                currentInstruction.setText("Running . . .");
                for (int i = 0; i < instructions.length; i++) {
                    controller.performNextInstruction(instructions[i]);
                }
                updateTable();
            }
        });
        regTable = new JTable(32, 3);
        setInitVals();
        regTable.setBounds(2, 2, 400, 520);
        regTable.setGridColor(Color.BLACK);
        regTable.setShowGrid(true);
        currentInstruction = new JLabel("Current Instruction");
        currentInstruction.setBounds(2, 550, 300, 20);
    }

    private void setInitVals() {
        registers = new Register[32];
        for (int i = 0; i < 32; i++) {
            registers[i] = new Register("R" + (i+1), Integer.toHexString(i*4), 0);
            regTable.setValueAt(registers[i].getRegisterName(), i, 0);
            regTable.setValueAt(registers[i].getRegisterLocation(), i, 1);
            regTable.setValueAt(registers[i].getRegisterValue(), i, 2);
        }
    }

    private void updateTable() {
        for (int i = 0; i < 32; i++) {
            regTable.setValueAt(registers[i].getRegisterName(), i, 0);
            regTable.setValueAt(registers[i].getRegisterLocation(), i, 1);
            regTable.setValueAt(registers[i].getRegisterValue(), i, 2);
        }
    }

    public static void offsetStepCounter(int offset) {
        stepCounter += offset/4;
    }

    public static void setStepCounter(int address) {
        stepCounter = address;
    }

    public static Register[] getRegisterFile(){return registers;}

    public static void setRegister(int index,int value){registers[index].setRegisterValue(value);}

    public static int getStepCounter(){return stepCounter;}
}
