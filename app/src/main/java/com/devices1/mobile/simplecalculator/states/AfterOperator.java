package com.devices1.mobile.simplecalculator.states;

import com.devices1.mobile.simplecalculator.CalculatorData;
import com.devices1.mobile.simplecalculator.Key;

public class AfterOperator extends StateBase {

    public AfterOperator(CalculatorData data, char op) {
        super(data.setOperation(op, false));
    }

    public AfterOperator(CalculatorData data){
        super(data);
    }

    @Override
    public IState inputNormalKey(Key key) {
        switch (key.getType())
        {
            case NUMBER:
                return new IntPartSecond(data,key.getC());
            case POINT:
                return new DecimalPartSecond(data);
            case EQUAL:
                return new Initial(data.getResult());
            case OPERATOR:
                return new AfterOperator(new CalculatorData(data.getResult()), key.getC());
            case ALL_CLEAR:
                return new Initial("0");
            case CLEAR:
                return new DecimalPartFirst(data.clearChar());
        }
        return this;
    }

}
