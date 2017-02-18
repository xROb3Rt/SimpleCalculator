package com.devices1.mobile.simplecalculator;


import com.devices1.mobile.simplecalculator.states.IState;
import com.devices1.mobile.simplecalculator.states.Initial;

public class CalculatorModel implements  ICalculatorModel{

    IState currentState;


    public CalculatorModel() {

        this.currentState = new Initial();

    }

    @Override
    public void inputKey(Key key) {

        currentState = currentState.inputKey(key);

    }

    @Override
    public String readInput() {

        return currentState.readInput();
    }

    @Override
    public String readResult() {

        return currentState.readResult();
    }
}
