package com.devices1.mobile.simplecalculator.states;

import com.devices1.mobile.simplecalculator.CalculatorData;
import com.devices1.mobile.simplecalculator.Key;

public class IntPartSecond extends StateBase{

    public IntPartSecond(CalculatorData data,char digit) {
        super(data.addDigitToSecond(digit, false)); //CAMBIAR A public IntPartSecond(Calculator data, char digit) {super(data.addDigitSecond(digit,false));}
        }

    @Override
    protected IState inputNormalKey(Key key) {
        switch (key.getType()) {

            case NUMBER:
                data = data.addDigitToSecond(key.getC(), false);
                return this;
            case OPERATOR:
                return new AfterOperator(data,key.getC());
            case POINT:
                return new DecimalPartSecond(data);
            case EQUAL:
                return new Initial(data.getInput());
        }
        return this;
    }
}
