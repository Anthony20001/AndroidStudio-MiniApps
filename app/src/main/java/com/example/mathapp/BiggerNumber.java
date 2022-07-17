package com.example.mathapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BiggerNumber extends AppCompatActivity {

    private EditText input_number1, input_number2, input_number3;
    private Button btn_run;
    private TextView result_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bigger_number);

        input_number1 = findViewById(R.id.biggerNumber_input1);
        input_number2 = findViewById(R.id.biggerNumber_input2);
        input_number3 = findViewById(R.id.biggerNumber_input3);
        btn_run = findViewById(R.id.biggerNumber_btn_run);
        result_text = findViewById(R.id.biggerNumber_text_result);

        btn_run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    float num1=0, num2=0, num3=0, max_num=0;
                    num1 = Float.parseFloat(input_number1.getText().toString());
                    num2 = Float.parseFloat(input_number2.getText().toString());
                    num3 = Float.parseFloat(input_number3.getText().toString());

                    if(input_number1.getText().toString().equals("")){
                        input_number1.setError(getResources().getString(R.string.input_empty));
                    }else if(input_number2.getText().toString().equals("")){
                        input_number2.setError(getResources().getString(R.string.input_empty));
                    }else if(input_number3.getText().toString().equals("")){
                        input_number3.setError(getResources().getString(R.string.input_empty));
                    }else{
                        if (num1 > num2 && num1 > num3) {
                            max_num = num1;
                        }else if(num2 > num1 && num2 > num3){
                            max_num = num2;
                        }else if(num3 > num2 && num3 > num1){
                            max_num = num3;
                        }
                        result_text.setText(String.valueOf(max_num));
                    }
                }catch(Exception e){
                    Toast.makeText(BiggerNumber.this, getResources().getString(R.string.ERR_GLOBAL), Toast.LENGTH_LONG);
                }
            }
        });
    }
}