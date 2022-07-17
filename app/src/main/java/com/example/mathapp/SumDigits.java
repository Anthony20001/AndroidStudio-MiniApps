package com.example.mathapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SumDigits extends AppCompatActivity {

    private EditText input_Digits;
    private Button btn_run;
    private TextView result_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum_digits);

        input_Digits = findViewById(R.id.sumDigits_input);
        btn_run = findViewById(R.id.sumDigits_btn_run);
        result_text = findViewById(R.id.sumDigits_text_result);


        btn_run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    float total=0;
                    String digits = input_Digits.getText().toString();
                    if(input_Digits.getText().toString().equals("")){
                        input_Digits.setError(getResources().getString(R.string.input_empty));
                    }else{
                        for(int i=0; i<digits.length(); i++){
                            total += Float.parseFloat(String.valueOf(digits.charAt(i)));
                        }
                        result_text.setText(String.valueOf(getResources().getString(R.string.result)+" "+total));
                    }
                }catch(Exception e){
                    Toast.makeText(SumDigits.this, getResources().getString(R.string.ERR_GLOBAL), Toast.LENGTH_LONG);
                }
            }
        });
    }
}