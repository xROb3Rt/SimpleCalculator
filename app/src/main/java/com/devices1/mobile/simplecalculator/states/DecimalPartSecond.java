package com.devices1.mobile.simplecalculator.states;

import com.devices1.mobile.simplecalculator.CalculatorData;
import com.devices1.mobile.simplecalculator.Key;

public class DecimalPartSecond extends StateBase{

    public DecimalPartSecond(CalculatorData data) {
        super(data.addPointToSecond());
    }

    @Override
    protected IState inputNormalKey(Key key) {
        switch (key.getType()) {

            case NUMBER:
                data = data.addDigitToSecond(key.getC(), true);
                return this;
            case OPERATOR:
                return new AfterOperator(data,key.getC());
            case POINT:
                data = data.addPointToSecond();
                return this;
            case EQUAL:
                return new Initial(data.getResult());
        }
        return this;
    }
}
