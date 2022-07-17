package com.example.mathapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PrimeNumber extends AppCompatActivity {

    private EditText input_number;
    private Button btn_run;
    private TextView result_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime_number);

        input_number = findViewById(R.id.primeNumber_input);
        btn_run = findViewById(R.id.primeNumber_btn_run);
        result_text = findViewById(R.id.primeNumber_result_text);

        btn_run.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try{
                    int i = 1;
                    float rest, number = Float.parseFloat(input_number.getText().toString());
                    result_text.setText(getResources().getString(R.string.false_primeNumber));

                    if(input_number.getText().toString().equals("")){
                        input_number.setError(getResources().getString(R.string.input_empty));
                    }else{
                        do{
                            i++;
                            rest = number%i;
                            if(rest == 0 && number == i){
                                result_text.setText(number + " " + getResources().getString(R.string.true_primeNumber));
                            }
                        }while(rest != 0 && number != i);
                    }
                }catch(Exception e){
                    Toast.makeText(PrimeNumber.this, getResources().getString(R.string.ERR_GLOBAL), Toast.LENGTH_LONG);
                }
            }
        });
    }
}