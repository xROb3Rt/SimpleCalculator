package com.devices1.mobile.simplecalculator;


public interface IState {

    IState inputKey(Key key);
    String readInput();
    String readResult();


}
