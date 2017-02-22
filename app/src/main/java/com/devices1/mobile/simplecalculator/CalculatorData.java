package com.devices1.mobile.simplecalculator;

import java.math.BigDecimal;

import static com.devices1.mobile.simplecalculator.CalculatorArithmetic.Operations.Addition;
import static com.devices1.mobile.simplecalculator.CalculatorArithmetic.Operations.Division;
import static com.devices1.mobile.simplecalculator.CalculatorArithmetic.Operations.Product;
import static com.devices1.mobile.simplecalculator.CalculatorArithmetic.Operations.Subtraction;

public final class CalculatorData {

    private final String input, result;

    private BigDecimal first;
    private String second;
    private CalculatorArithmetic.Operations operation;
    private boolean error;

    public boolean isError() {
        return error;
    }

    private CalculatorData(String input, String result, BigDecimal first, String second, CalculatorArithmetic.Operations operation, boolean error) {
        this.input = input;
        this.result = result;
        this.first = first;
        this.second = second;
        this.operation = operation;
        this.error = error;
    }

    public CalculatorData(String input, boolean error) {
        this(input, "", null, null, null, error);
    }

    public CalculatorData(String input) {
        this(input, false);
    }

    public CalculatorData addDigitToFirst(char digit, boolean hasPoint){
        String newInput;

        if (hasPoint){
            if(input.length() < 9){
                newInput = input + digit;
            }
            else{
                newInput = input;
            }

        }
        else {
            if(input.length() < 8){
                if(input.equals("0")){
                    newInput = ""+digit;
                }
                else {
                    newInput = input + digit;
                }
            }
            else{
                newInput = input;
            }
        }

        return  new CalculatorData(newInput);

    }

    public CalculatorData addPointToFirst(){

        if(!input.contains(".")){
            return new CalculatorData(input + ".");
        }
        else{
            return new CalculatorData(input);
        }
    }

    public CalculatorData addDigitToSecond(char digit, boolean hasPoint) {

        String newInput;
        String newSecond;

        if (hasPoint) {

            if (second.length() < 9) {
                newInput = input + digit;
                newSecond = second + digit;
            } else {
                newInput = input;
                newSecond = second;
            }
        } else {
            if (second.length() < 8) {
                if (second.equals("0")){
                    newSecond = "" + digit;
                    newInput = input.substring(0,input.length()-1) + digit;
                }else {
                    newSecond = second + digit;
                    newInput = input + digit;
                }
            }
            else{
                newInput=input;
                newSecond=second;
            }
        }

        BigDecimal bdSecond = new BigDecimal(newSecond);
        BigDecimal result = CalculatorArithmetic.operate(first,operation,bdSecond);

        String resultString;
        boolean error;

        if(result == null){
            resultString = "Error";
            error = true;
        }else{
            resultString = CalculatorArithmetic.toString(result,"Error");
            error = false;
        }

        return new CalculatorData(newInput,resultString,first,newSecond,operation,error);
    }

    public CalculatorData addPointToSecond(){
        if(second.equals("")){
            return new CalculatorData(input+"0.",result,first,second+"0.",operation,error);
        }else{
            if(!second.contains(".")){
                return new CalculatorData(input+".",result,first,second+".",operation,error);
            }
            else{
                return new CalculatorData(input,result,first,second,operation,error);
            }

        }
    }

    public String getInput() {return input;}

    public String getResult() {return result;}

    public CalculatorData setOperation (char op, boolean operation){

        String newInput = "";
        String newResult;
        BigDecimal newBigDecimal;

        if(operation){
            char [] newArray = input.toCharArray();
            for(int i = 0; i< input.length();i++){
                if(newArray[i] == '+' || newArray[i] == '-' || newArray[i] == '*' || newArray[i] == '/'){
                    newInput +=op;
                    break;
                }else{
                    newInput +=newArray[i];
                }
            }

            newResult = result;
            newBigDecimal = first;
        }else{
            newInput = input + op;
            newResult = input;

            newBigDecimal = new BigDecimal(input);
        }

        return new CalculatorData(newInput,newResult,newBigDecimal,"", charToOperation(op), false);
    }

    public CalculatorData clearChar(){
        String newInput = input.substring(0, input.length() - 1);
        return new CalculatorData(newInput);
    }

    public CalculatorData clearSecondChar(){
        if(second.length() > 1){
            String newInput = input.substring(0, input.length() -1);
            String newSecond = second.substring(0, second.length() - 1);

            BigDecimal newBigDecimal = CalculatorArithmetic.operate(first, this.operation, new BigDecimal(newSecond));
            return new CalculatorData(newInput, CalculatorArithmetic.toString(newBigDecimal, "Error"), this.first, newSecond, this.operation, false);
        }else{
            String newInput = input;
            if(!second.equals("")){
                newInput = input.substring(0, input.length() -1);
            }
            String newSecond = "";
            return new CalculatorData(newInput, newInput, this.first, newSecond, this.operation, false);
        }
    }

    private static CalculatorArithmetic.Operations charToOperation(char op) {
        switch (op){
            case '+':
                return Addition;
            case '-':
                return Subtraction;
            case '*':
                return Product;
            case '/':
                return Division;
        }
        return null;
    }


}
