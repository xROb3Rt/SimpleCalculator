package com.devices1.mobile.simplecalculator;

import android.view.View;

import static com.devices1.mobile.simplecalculator.Key.*;

public class CalculatorPresenter {

    ICalculatorView view;
    ICalculatorModel model;
    Key key;

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
        //key = new Key.Type(NUMBER);
        updateScreens();

    }
    void onDecimalPointPressed(){}
    void onOperatorKeyPressed(char opChar){}
    void onEqualKeyPressed(){}
    void onClearPressed(){}
    void onAllClearPressed(){}

}
