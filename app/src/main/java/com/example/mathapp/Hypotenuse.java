package com.example.mathapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;

import java.util.Arrays;
import java.util.stream.Stream;

public class Hypotenuse extends AppCompatActivity {

    private EditText hickA, hickB;
    private Button btn_run, btn_clear;
    private TextView text_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hypotenuse);

        btn_run = findViewById(R.id.btn_run_hypotenuse);
        btn_clear = findViewById(R.id.btn_clear_hypotenuse);
        hickA = findViewById(R.id.input_hicka);
        hickB = findViewById(R.id.input_hickb);
        text_result = findViewById(R.id.text_result_hypotenuse);

        btn_run.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try{
                    if(hickA.getText().equals("")){
                        hickA.setError(getResources().getString(R.string.input_empty));
                    }else if(hickB.getText().equals("")){
                        hickB.setError(getResources().getString(R.string.input_empty));
                    }else{
                        double result = Double.parseDouble(String.valueOf(hickB.getText()))/
                                Double.parseDouble(String.valueOf(hickA.getText()));
                        text_result.setText(String.valueOf(getResources().getString(R.string.result) + " " + result));
                    }
                }catch(Exception e){
                    Toast.makeText(Hypotenuse.this, getResources().getString(R.string.ERR_GLOBAL), Toast.LENGTH_LONG).show();
                }
            }
        });


        btn_clear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                text_result.setText("");
                hickA.setText("");
                hickB.setText("");
            }
        });
    }
}