package com.devices1.mobile.simplecalculator.states;

import com.devices1.mobile.simplecalculator.CalculatorData;
import com.devices1.mobile.simplecalculator.Key;

public class DecimalPartSecond extends StateBase{

    public DecimalPartSecond(CalculatorData data) {
        super(data.addPointToFirst()); //CAMBIAR A addPointToSecond()
    }

    @Override
    protected IState inputNormalKey(Key key) {
        switch (key.getType()) {

            case NUMBER:
                data = data.addDigitToFirst(key.getC(), false); // CAMBIAR A addDigitToSecond y poner true
                return this;
            case OPERATOR:
                break;
            case POINT:
                break;
            case EQUAL:
                return new Initial(data.getInput());
        }
        return this;
    }
}
