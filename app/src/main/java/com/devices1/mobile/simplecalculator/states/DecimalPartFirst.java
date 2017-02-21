package com.devices1.mobile.simplecalculator.states;

import com.devices1.mobile.simplecalculator.CalculatorData;
import com.devices1.mobile.simplecalculator.Key;


public class DecimalPartFirst extends StateBase {

    public DecimalPartFirst(CalculatorData data) {
        super(data.addPointToFirst());
    }

    @Override
    protected IState inputNormalKey(Key key) {
        switch (key.getType()) {
            case NUMBER:
                data = data.addDigitToFirst(key.getC(), true);
                return this;
            case OPERATOR:
                return new AfterOperator(data,key.getC());
            case POINT:
                data = data.addPointToFirst();
                return this;
            case EQUAL:
                return new Initial(data.getResult());
        }
        return this;
    }


}
