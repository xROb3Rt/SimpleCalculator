package com.devices1.mobile.simplecalculator.states;

import com.devices1.mobile.simplecalculator.CalculatorData;
import com.devices1.mobile.simplecalculator.Key;

public class IntPartSecond extends StateBase{

    public IntPartSecond(char digit) {
        super(new CalculatorData(""+digit)); //CAMBIAR A public IntPartSecond(Calculator data, char digit) {
                                                               //super(data.addDigitSecond(digit,false));}
        }

    @Override
    protected IState inputNormalKey(Key key) {
        switch (key.getType()) {

            case NUMBER:
                data = data.addDigitToFirst(key.getC(), false); //CAMBIAR A addDigitToSecond
                return this;
            case OPERATOR:
                break;
            case POINT:
                return new DecimalPartSecond(data);
            case EQUAL:
                return new Initial(data.getInput());
        }
        return this;
    }
}
