package com.example.mathapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LeapYear extends AppCompatActivity {

    private EditText input_year;
    private Button btn_run;
    private TextView result_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leap_year);

        input_year = findViewById(R.id.leapYear_input);
        btn_run = findViewById(R.id.leapYear_btn_run);
        result_text = findViewById(R.id.leapYear_text_result);

        btn_run.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try{
                    if(input_year.getText().toString().equals("")){
                        input_year.setError(getResources().getString(R.string.input_empty));
                    }else{
                        int year = Integer.parseInt(input_year.getText().toString());
                        String result = (year%4==0) ? getResources().getString(R.string.true_leapYear) : getResources().getString(R.string.false_leapYear);
                        result_text.setText(input_year.getText().toString() + " " + result);
                    }
                }catch(Exception e){
                    Toast.makeText(LeapYear.this, getResources().getString(R.string.ERR_GLOBAL), Toast.LENGTH_LONG);
                }
            }
        });
    }
}