package com.devices1.mobile.simplecalculator.states;


import com.devices1.mobile.simplecalculator.Key;

public interface IState {

    IState inputKey(Key key);
    String readInput();
    String readResult();


}
