package com.devices1.mobile.simplecalculator.states;

import com.devices1.mobile.simplecalculator.CalculatorData;
import com.devices1.mobile.simplecalculator.Key;


public class DecimalPartFirst extends StateBase {

    public DecimalPartFirst(CalculatorData data) {
        super(data.addPointToFirst());
    } //Le pasamos data añadiendo el punto para que al pulsarlo por primera vez lo ponga

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
                return new Initial(data.getInput());
        }
        return this;
    }


}
