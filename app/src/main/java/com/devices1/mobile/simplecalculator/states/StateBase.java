package com.devices1.mobile.simplecalculator.states;


import com.devices1.mobile.simplecalculator.CalculatorData;
import com.devices1.mobile.simplecalculator.Key;

public abstract class StateBase implements IState {

    protected CalculatorData data;
    protected abstract IState inputNormalKey(Key key);


    public StateBase(CalculatorData data) {
        this.data = data;
    }


    @Override
    public IState inputKey(Key key) {
        switch (key.getType()) {
            case NUMBER:
            case OPERATOR:
            case POINT:
            case EQUAL:
                return inputNormalKey(key);
        }

        return inputNormalKey(key);

    }

    @Override
    public String readInput() {
        return data.getInput();
    }

    @Override
    public String readResult() {
        return data.getResult();
    }
}
