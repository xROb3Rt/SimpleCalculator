package com.devices1.mobile.simplecalculator;

import android.view.View;
import static com.devices1.mobile.simplecalculator.Key.*;

public class CalculatorPresenter {

    ICalculatorView view;
    ICalculatorModel model;

    public CalculatorPresenter(ICalculatorView view, ICalculatorModel model) {
        this.view = view;
        this.model = model;
        updateScreens();
    }

    private void updateScreens(){
        view.showInput(model.readInput());
        view.showResult(model.readResult());
    }

    void onNumericKeyPressed(char digit){

        model.inputKey(new Key(Type.NUMBER, digit));
        updateScreens();

    }

    void onDecimalPointPressed(){

        model.inputKey(new Key(Type.POINT));
        updateScreens();
    }

    void onOperatorKeyPressed(char opChar){

        model.inputKey(new Key(Type.OPERATOR));
        updateScreens();
    }

    void onEqualKeyPressed(){

        model.inputKey(new Key(Type.EQUAL));
        updateScreens();
    }

    void onClearPressed(){

        model.inputKey(new Key(Type.CLEAR));
        updateScreens();
    }

    void onAllClearPressed(){

        model.inputKey(new Key(Type.ALL_CLEAR));
        updateScreens();
    }

}
