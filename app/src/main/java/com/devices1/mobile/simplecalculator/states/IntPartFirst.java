package com.devices1.mobile.simplecalculator.states;


import com.devices1.mobile.simplecalculator.CalculatorData;
import com.devices1.mobile.simplecalculator.Key;

public class IntPartFirst extends StateBase {


    public IntPartFirst(char digit) {
        super(new CalculatorData(""+digit));
    }

    @Override
    protected IState inputNormalKey(Key key) {
        switch (key.getType()) {

            case NUMBER:
                data = data.addDigitToFirst(key.getC(), false);
                return this;
            case OPERATOR:
                return new AfterOperator(data,key.getC());
            case POINT:
                return new DecimalPartFirst(data);
            case EQUAL:
                return new Initial(data.getInput());
            case ALL_CLEAR:
                return new Initial("0");
            case CLEAR:
                if(data.getInput().length() > 1){
                        data = data.clearChar();
                        return this;
                }else{
                    return new Initial("0");
                }
        }
        return this;
    }
}
