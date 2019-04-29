package com.company.UserInterface;

import com.company.Controller;
import com.company.Instruction;
import com.company.Simulator.DataMemory;
import com.company.Simulator.Register;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GUI {

    static public Register[] registers;
    static public Register HI;
    static public Register LO;
    static public DataMemory memory = new DataMemory(100);
    static int stepCounter;
    JFrame frame;
    JLabel label, currentInstruction;
    JTextField fileText;
    JButton browse, load, step, run;
    //    JRadioButton stepRun, fullRun;
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
//        stepRun.setVisible(true);
//        fullRun.setVisible(true);
        step.setVisible(true);
        run.setVisible(true);
        regTable.setVisible(true);
        currentInstruction.setVisible(true);
    }

    private void setFrame() {
        frame = new JFrame();
        frame.setSize(700, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.add(label);
        frame.add(fileText);
        frame.add(browse);
        frame.add(load);
//        frame.add(stepRun);
//        frame.add(fullRun);
        frame.add(step);
        frame.add(run);
        frame.add(regTable);
        frame.add(currentInstruction);
    }

    private void setComponents() {
        label = new JLabel();
        label.setBounds(102, 610, 100, 20);
        label.setText("Enter file name:");
        fileText = new JTextField();
        fileText.setBounds(202, 610, 100, 20);
        browse = new JButton("Browse");
        browse.setBounds(305, 610, 80, 20);
        browse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    JFileChooser jf = new JFileChooser();
                    //jf.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    jf.setAcceptAllFileFilterUsed(false);
                    FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt");
                    jf.addChoosableFileFilter(filter);
                    jf.showOpenDialog(new JLabel("Browse"));
                    File f = jf.getSelectedFile();
                    String s = f.getAbsolutePath();
                    fileText.setText(s);
                } catch (NullPointerException ex) {
                    System.out.println("No file selected");
                }
            }
        });
        load = new JButton("Load");
        load.setBounds(390, 610, 80, 20);
        load.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String file = fileText.getText();
                try {
                    System.out.println("Loading . . .");
                    stepCounter = 0;
                    controller = new Controller();
                    controller.setStringFile(file);
                    instructions = controller.getInstructions();
                } catch (Exception ex) {
                    System.out.println("File not found.");
                }
            }
        });
//        stepRun = new JRadioButton("Step Run");
//        stepRun.setBounds(102, 625, 100, 20);
//        stepRun.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                fullRun.setSelected(false);
//            }
//        });
//        fullRun = new JRadioButton("Full Run", true);
//        fullRun.setBounds(205, 625, 100, 20);
//        fullRun.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                stepRun.setSelected(false);
//            }
//        });
        step = new JButton("Step Run");
        step.setBounds(150, 635, 150, 20);
        step.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (stepCounter < instructions.length) {
                        System.out.println("Step " + stepCounter + " . . .");
                        currentInstruction.setText(instructions[stepCounter].getInstruction());
                        controller.performNextInstruction(instructions[stepCounter]);
                        updateTable();
                    } else {
                        System.out.println("Finished");
                    }
                } catch (NullPointerException n) {
                    System.out.println("Please load instructions first");
                }
            }
        });
        run = new JButton("Complete Run");
        run.setBounds(350, 635, 150, 20);
        run.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    while (stepCounter < instructions.length) {
                        System.out.println("Running " + stepCounter + " . . .");
                        // currentInstruction.setText(instructions[stepCounter].getInstruction());
                        controller.performNextInstruction(instructions[stepCounter]);
                        updateTable();
                    }
                    System.out.println("Finished");
                } catch (NullPointerException n) {
                    System.out.println("Please load instructions first");
                }
            }
        });
        regTable = new JTable(35, 3);
        setInitVals();
        regTable.setBounds(120, 20, 400, 560);
        regTable.setGridColor(Color.BLACK);
        regTable.setShowGrid(true);
        currentInstruction = new JLabel("Current Instruction");
        currentInstruction.setBounds(252, 585, 300, 20);
    }

    private void setInitVals() {
        registers = new Register[32];
        regTable.setValueAt("Register Name", 0, 0);
        regTable.setValueAt("Location", 0, 1);
        regTable.setValueAt("Value", 0, 2);
        for (int i = 0; i < 32; i++) {
            registers[i] = new Register("R" + (i + 1), Integer.toHexString(i * 4), 0);
            regTable.setValueAt(registers[i].getRegisterName(), i + 1, 0);
            regTable.setValueAt(registers[i].getRegisterLocation(), i + 1, 1);
            regTable.setValueAt(registers[i].getRegisterValue(), i + 1, 2);
        }
        HI = new Register("HI", Integer.toHexString(32 * 4), 0);
        regTable.setValueAt(HI.getRegisterName(), 33, 0);
        regTable.setValueAt(HI.getRegisterLocation(), 33, 1);
        regTable.setValueAt(HI.getRegisterValue(), 33, 2);
        LO = new Register("LO", Integer.toHexString(33 * 4), 0);
        regTable.setValueAt(LO.getRegisterName(), 34, 0);
        regTable.setValueAt(LO.getRegisterLocation(), 34, 1);
        regTable.setValueAt(LO.getRegisterValue(), 34, 2);
    }

    private void updateTable() {
        regTable.setValueAt("Register Name", 0, 0);
        regTable.setValueAt("Location", 0, 1);
        regTable.setValueAt("Value", 0, 2);
        for (int i = 0; i < 32; i++) {
            regTable.setValueAt(registers[i].getRegisterName(), i + 1, 0);
            regTable.setValueAt(registers[i].getRegisterLocation(), i + 1, 1);
            regTable.setValueAt(registers[i].getRegisterValue(), i + 1, 2);
        }
        regTable.setValueAt(HI.getRegisterName(), 33, 0);
        regTable.setValueAt(HI.getRegisterLocation(), 33, 1);
        regTable.setValueAt(HI.getRegisterValue(), 33, 2);
        regTable.setValueAt(LO.getRegisterName(), 34, 0);
        regTable.setValueAt(LO.getRegisterLocation(), 34, 1);
        regTable.setValueAt(LO.getRegisterValue(), 34, 2);
    }

    public static void offsetStepCounter(int offset) {
        stepCounter += offset / 4;
    }

    public static void setStepCounter(int address) {
        stepCounter = address;
    }

    public static Register[] getRegisterFile() {
        return registers;
    }

    public static void setRegister(int index, int value) {
        registers[index].setRegisterValue(value);
    }

    public static int getStepCounter() {
        return stepCounter;
    }

    public static void StepCounterIncrease() {
        stepCounter++;
    }

    public static DataMemory getDataMemory() {
        return memory;
    }

    public static int getHIValue() {
        return HI.getRegisterValue();
    }

    public static int getLOValue() {
        return LO.getRegisterValue();
    }

    public static void setHIValue(int value) {
        HI.setRegisterValue(value);
    }

    public static void setLOValue(int value) {
        LO.setRegisterValue(value);
    }

}
