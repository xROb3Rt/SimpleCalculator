package com.devices1.mobile.simplecalculator.states;

import com.devices1.mobile.simplecalculator.CalculatorArithmetic;
import com.devices1.mobile.simplecalculator.CalculatorData;
import com.devices1.mobile.simplecalculator.Key;

import java.math.BigDecimal;


public class DecimalPartFirst extends StateBase {

    public DecimalPartFirst(CalculatorData data) {
        super(data);
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
                return new Initial(CalculatorArithmetic.toString(new BigDecimal(data.getInput()), "Error"));
            case ALL_CLEAR:
                return new Initial("0");
            case CLEAR:
                if(data.getInput().length() > 1){
                    if(data.getInput().charAt(data.getInput().length() - 1) == '.'){
                        return new AfterOperator(data.clearChar());
                    }
                    else{
                        data = data.clearChar();
                        return this;
                    }
                }else{
                    return new Initial("0");
                }
        }
        return this;
    }


}
