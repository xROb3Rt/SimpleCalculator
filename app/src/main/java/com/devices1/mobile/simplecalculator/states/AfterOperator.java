package com.devices1.mobile.simplecalculator.states;

import com.devices1.mobile.simplecalculator.CalculatorData;
import com.devices1.mobile.simplecalculator.Key;

public class AfterOperator extends StateBase {

    public AfterOperator(CalculatorData data, char op) {
        super(data.setOperation(op,false));
    }

    @Override
    public IState inputNormalKey(Key key) {
        switch (key.getType())
        {
            case NUMBER:
                return new IntPartSecond(key.getC()); // (data,key.getC())
            case POINT:
                return new DecimalPartSecond(new CalculatorData("0")); //recibe solo (data)
            case EQUAL:
                return new Initial(data.getInput());
            case OPERATOR:
                break;
        }
        return this;
    }

}
