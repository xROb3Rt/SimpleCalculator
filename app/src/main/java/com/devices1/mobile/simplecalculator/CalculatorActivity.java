package com.devices1.mobile.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity implements  ICalculatorView {

    private TextView input;
    private TextView result;
    private CalculatorPresenter presenter;
    private char key;
    private Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        input = (TextView) findViewById(R.id.pantallaInput);
        result = (TextView) findViewById(R.id.pantallaOutput);

        ICalculatorModel model = new CalculatorModel();
        presenter = new CalculatorPresenter(this, model);

    }

    void numberPressed(View view) {


        button = (Button) view;
        key = button.getText().charAt(0);
        presenter.onNumericKeyPressed(key);


    }

    void operatorPressed(View view) {

        button = (Button) view;
        key = button.getText().charAt(0);
        presenter.onOperatorKeyPressed(key);


    }

    void pointPressed(View view) {


        presenter.onDecimalPointPressed();

    }

    void equalPressed(View view) {

        presenter.onEqualKeyPressed();

    }

    void allClearPressed(View view) {

        presenter.onAllClearPressed();
    }

    void clearPressed(View view) {

        presenter.onClearPressed();
    }

    @Override
    public void showInput(String entrada) {

        this.input.setText(entrada);

    }

    @Override
    public void showResult(String resultado) {

        this.result.setText(resultado);

    }
}
