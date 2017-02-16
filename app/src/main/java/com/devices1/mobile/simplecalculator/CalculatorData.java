package com.devices1.mobile.simplecalculator;


public final class CalculatorData {

    private final String input, result;


    private CalculatorData(String input, String result) {
        this.input = input;
        this.result = result;
    }

    public CalculatorData(String input) {
        this.input = input;
        this.result = "";
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


}
