package com.devices1.mobile.simplecalculator;


import java.math.BigDecimal;

import static com.devices1.mobile.simplecalculator.CalculatorArithmetic.Operations.Addition;
import static com.devices1.mobile.simplecalculator.CalculatorArithmetic.Operations.Division;
import static com.devices1.mobile.simplecalculator.CalculatorArithmetic.Operations.Product;
import static com.devices1.mobile.simplecalculator.CalculatorArithmetic.Operations.Subtraction;

public final class CalculatorData {

    private final String input, result;

    private BigDecimal first;
    private String second;
    private CalculatorArithmetic.Operations operation;
    private boolean error;

    public boolean isError() {
        return error;
    }

    private CalculatorData(String input, String result, BigDecimal first, String second, CalculatorArithmetic.Operations operation, boolean error) {
        this.input = input;
        this.result = result;
        this.first = first;
        this.second = second;
        this.operation = operation;
        this.error = error;
    }

    public CalculatorData(String input, boolean error) {
        this(input, "", null, null, null, error);
    }

    public CalculatorData(String input) {
        this(input, false);
        //this.input = input;
        //this.result = "";
    }

    public CalculatorData addDigitToFirst(char digit, boolean hasPoint){

        String newInput;

        if (hasPoint){
            if(input.length() <= 9){
                newInput = input + digit;
            }
            else{
                newInput = input;
            }

        }
        else {
            if(input.length() <= 8){
                newInput = input + digit;
            }
            else{
                newInput = input;
            }
        }

        return  new CalculatorData(newInput);

    }

    public CalculatorData addPointToFirst(){
        return new CalculatorData(input + ".");
    }


    public String getInput() {
        return input;
    }

    public String getResult() {
        return result;
    }

    public CalculatorData setOperation (char op, boolean operation){ //ATASCADO NO SE COMO SE DEBE DE HACER

        if(operation == false){

            return new CalculatorData(this.input+op,input,new BigDecimal(input), null, charToOperation(op),false );
        }
        else{

            return new CalculatorData(this.input+op,input,new BigDecimal(input), null, charToOperation(op),false );
        }

    }

    private static CalculatorArithmetic.Operations charToOperation(char op) {
        switch (op){
            case '+':
            return Addition;
            case '-':
            return Subtraction;
            case '*':
            return Product;
            case '/':
            return Division;
        }
        return null;
    }


}
