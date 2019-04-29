package com.company.Function;

import com.company.Instruction;

public interface Function {
    void setInstruction(Instruction a);

    void handleInstruction(Instruction a);

    void execute();

    void memoryAccess();

    void writeBack();
}
