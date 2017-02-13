package com.devices1.mobile.simplecalculator.states;

import com.devices1.mobile.simplecalculator.CalculatorData;
import com.devices1.mobile.simplecalculator.Key;


public class DecimalPartFirst implements IState {

    public DecimalPartFirst(CalculatorData calculatorData) {
    }

    @Override
    public IState inputKey(Key key) {
        return null;
    }

    @Override
    public String readInput() {
        return null;
    }

    @Override
    public String readResult() {
        return null;
    }
}
