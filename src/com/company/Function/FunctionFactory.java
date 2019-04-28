package com.company.Function;

import java.util.ArrayList;

public class FunctionFactory{
    ArrayList arithmetic, memory, conditional;


    public Function factory(String function)  {
      function = function.toUpperCase();
      if(function == null){
        return null;
      }

      if (arithmetic.contains(function)) {
        return new Arithmetic();
      }
      else if (memory.contains(function)) {
        return new Memory();
      }
      else if (conditional.contains(function)) {
        return new Conditional();
      }
      return null;
    }
}
