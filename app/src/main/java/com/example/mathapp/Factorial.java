package com.example.mathapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Factorial extends AppCompatActivity {

    private EditText input_number;
    private Button btn_run;
    private TextView result_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factorial);

        input_number = findViewById(R.id.factorial_input);
        btn_run = findViewById(R.id.factorial_btn_run);
        result_text = findViewById(R.id.factorial_result_text);

        btn_run.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try{
                    int i=1, total=1, number = Integer.parseInt(input_number.getText().toString());
                    if(input_number.getText().toString().equals("")){
                        input_number.setError(getResources().getString(R.string.input_empty));
                    }else{
                        do{
                            total *= i+1;
                            result_text.setText(String.valueOf(getResources().getString(R.string.result) + " " + total));
                            i++;
                        }while(i != number);
                    }
                }catch(Exception e){
                    Toast.makeText(Factorial.this, getResources().getString(R.string.ERR_GLOBAL), Toast.LENGTH_LONG);
                }
            }
        });
    }
}