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
                return new AfterOperator(new CalculatorData(data.getResult()),key.getC());
            case POINT:
                data = data.addPointToSecond();
                return this;
            case EQUAL:
                return new Initial(data.getResult());
            case ALL_CLEAR:
                return new Initial("0");
            case CLEAR:
                if(data.getInput().length() > 1){
                    if(data.getInput().charAt(data.getInput().length() - 1) == '.'){
                        return new AfterOperator(data.clearSecondChar());
                    }
                    else{
                        data = data.clearSecondChar();
                        return this;
                    }
                }else{
                    return new Initial("0");
                }
        }
        return this;
    }
}
