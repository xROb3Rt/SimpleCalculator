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


    public String getInput() {
        return input;
    }

    public String getResult() {
        return result;
    }


}
