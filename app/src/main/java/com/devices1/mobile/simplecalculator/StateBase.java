package com.devices1.mobile.simplecalculator;



public abstract class StateBase implements IState {
// QUITAR ABSTRACT LUEGO
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
