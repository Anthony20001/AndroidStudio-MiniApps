package com.example.mathapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Equation extends AppCompatActivity {

    private Button btn_run, btn_clear;
    private TextView text_result;
    private EditText input_a, input_b, input_c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equation);

        input_a = findViewById(R.id.input_a_equation);
        input_b = findViewById(R.id.input_b_equation);
        input_c = findViewById(R.id.input_c_equation);
        btn_run = findViewById(R.id.btn_run_equation);
        btn_clear = findViewById(R.id.btn_clear_equation);
        text_result = findViewById(R.id.text_result_equation);

        btn_run.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try{
                    double a, b, c, determinant, solution1, solution2, temp;
                    a = Double.parseDouble(input_a.getText().toString());
                    b = Double.parseDouble(input_b.getText().toString());
                    c = Double.parseDouble(input_c.getText().toString());
                    temp = Math.pow(b, 2) - (4*a*c);

                    if(a > 0){
                        if(b > 0 && c > 0){
                            if(temp >= 0){
                                determinant = Math.sqrt(temp);
                                if(determinant == 0){
                                    solution1 = (b + determinant) / (2 * a);
                                    text_result.setText(String.valueOf(Math.round(solution1*100.0)/100.0));
                                }else{
                                    solution1 = (b + determinant) / (2 * a);
                                    solution2 = (b - determinant) / (2 * a);
                                    text_result.setText(String.valueOf(getResources().getString(R.string.result)+
                                            " "+(Math.round(solution1*100.0)/100.0)+ "; " + (Math.round(solution2*100.0)/100.0)));
                                }
                            }else{
                                text_result.setText(getResources().getString(R.string.no_solution));
                            }
                        }else{
                            Toast.makeText(Equation.this, getResources().getString(R.string.incomplete_equation), Toast.LENGTH_LONG);
                        }
                    }else{
                        input_a.setError(getResources().getString(R.string.ERR_A_ZERO));
                    }
                }catch(Exception e){
                    Toast.makeText(Equation.this, getResources().getString(R.string.ERR_GLOBAL), Toast.LENGTH_LONG).show();
                }
            }
        });


        btn_clear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                text_result.setText("");
                input_a.setText("");
                input_b.setText("");
                input_c.setText("");
            }
        });
    }
}