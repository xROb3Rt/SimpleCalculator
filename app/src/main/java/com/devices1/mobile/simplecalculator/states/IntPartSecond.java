package com.devices1.mobile.simplecalculator.states;

import com.devices1.mobile.simplecalculator.CalculatorData;
import com.devices1.mobile.simplecalculator.Key;

public class IntPartSecond extends StateBase{

    public IntPartSecond(CalculatorData data,char digit) {
        super(data.addDigitToSecond(digit, false));
        }

    @Override
    protected IState inputNormalKey(Key key) {
        switch (key.getType()) {

            case NUMBER:
                data = data.addDigitToSecond(key.getC(), false);
                return this;
            case OPERATOR:
                return new AfterOperator(new CalculatorData(data.getResult()),key.getC());
            case POINT:
                return new DecimalPartSecond(data);
            case EQUAL:
                return new Initial(data.getResult());
            case ALL_CLEAR:
                return new Initial("0");
            case CLEAR:
                char lastC = data.getInput().charAt(data.getInput().length() - 1);
                if(lastC == '+' || lastC == '-' || lastC == '*' || lastC == '/'){
                    return new AfterOperator(data.clearChar());
                }else{
                    data = data.clearSecondChar();
                    return this;
                }
        }
        return this;
    }
}
