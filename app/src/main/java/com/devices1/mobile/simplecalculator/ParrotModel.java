package com.devices1.mobile.simplecalculator;

public class ParrotModel implements ICalculatorModel{

    private String lastKey;

    public ParrotModel() {
    }


    @Override
    public void inputKey(Key key) {
        if (key.getC() != 0)
            lastKey = key.getType().name() + ": " + key.getC();
        else
            lastKey = key.getType().name();
    }

    @Override
    public String readInput() {
        return lastKey;
    }

    @Override
    public String readResult() {
        return "";
    }
}
