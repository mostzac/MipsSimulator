package com.company;

import com.company.Instruction;

import java.io.FileReader;
import java.io.BufferedReader;

public class FileParser {
  String stringFile;
  String dataString;
  String[] dataList;
  Instruction[] instructionList;

  public FileParser (String stringFile) {
    this.stringFile = stringFile;
    read();
  }

  private void read() {
    try {
      BufferedReader br = new BufferedReader(new FileReader(stringFile));
      StringBuilder sb = new StringBuilder();
      String line = br.readLine();

      while (line != null) {
          sb.append(line);
          sb.append(System.lineSeparator());
          line = br.readLine();
      }
      dataString = sb.toString();
      br.close();
    }
    catch (Exception e) {
      System.err.println("File does not exist or was not found.");
    }

    dataList = dataString.split("\\n");
    parseInstructions();
  }

  private void parseInstructions() {
    int length = dataList.length;
    instructionList = new Instruction[length];
    for (int i = 0; i < dataList.length; i++) {
      Instruction curr = new Instruction(dataList[i]);
      instructionList[i] = curr;
    }
  }

  public Instruction[] getInstructions() {
    return instructionList;
  }
}
