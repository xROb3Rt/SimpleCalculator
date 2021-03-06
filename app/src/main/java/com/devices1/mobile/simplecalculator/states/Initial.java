package com.devices1.mobile.simplecalculator.states;


import com.devices1.mobile.simplecalculator.CalculatorData;
import com.devices1.mobile.simplecalculator.Key;

public class Initial extends StateBase {

    public Initial() {
        this("0");
    }

    public Initial(CalculatorData state) {
        super(state);
    }

    public Initial(String input) {
        super(new CalculatorData(input));
    }

    @Override
    public IState inputNormalKey(Key key) {
        switch (key.getType())
        {
            case NUMBER:
                return new IntPartFirst(key.getC());
            case POINT:
                return new DecimalPartFirst(new CalculatorData("0."));
            case EQUAL:
                return new Initial(data.getInput());
            case OPERATOR:
                if(data.getInput().equals("Error")){
                    return new Initial("0");
                }else{
                    return new AfterOperator(data, key.getC());
                }
            case ALL_CLEAR:
                return new Initial("0");

        }
        return this;
    }

}
