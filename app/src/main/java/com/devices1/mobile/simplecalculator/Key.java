package com.devices1.mobile.simplecalculator;



public class Key {

    Type type;
    char c;

    public Key(Type type) {
        this.type = type;
    }

    public Key(Type type, char c) {
        this.type = type;
        this.c = c;
    }

    public Type getType() {
        return type;
    }

    public char getC() {
        return c;
    }

    public enum
    Type {
        NUMBER, OPERATOR, POINT, CLEAR, ALL_CLEAR, EQUAL
    }

}
