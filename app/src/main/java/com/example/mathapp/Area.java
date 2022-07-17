package com.example.mathapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Area extends AppCompatActivity {

    private EditText input_radio, input_base, input_height;
    private Button btn_run, btn_clear;
    private TextView result_text;
    private RadioButton btn_circle, btn_triangle, btn_rectangle;
    private RadioGroup btn_group;
    private LinearLayout layout_radio, layout_base, layout_height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);

        input_radio = findViewById(R.id.area_input_radio);
        input_base = findViewById(R.id.area_input_base);
        input_height = findViewById(R.id.area_input_height);
        btn_run = findViewById(R.id.area_btn_run);
        btn_clear = findViewById(R.id.area_btn_clear);
        result_text = findViewById(R.id.area_text_result);
        btn_circle = findViewById(R.id.area_btn_circle);
        btn_triangle = findViewById(R.id.area_btn_triangle);
        btn_rectangle = findViewById(R.id.area_btn_rectangle);

        btn_group = findViewById(R.id.area_group_btn);
        layout_radio = findViewById(R.id.area_layout_radio);
        layout_base = findViewById(R.id.area_layout_base);
        layout_height = findViewById(R.id.area_layout_height);

        DecimalFormat decimal = new DecimalFormat(".##");

        btn_group.clearCheck();

        btn_circle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                layout_base.setVisibility(View.GONE);
                layout_height.setVisibility(View.GONE);
                layout_radio.setVisibility(View.VISIBLE);
            }
        });


        btn_triangle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                layout_radio.setVisibility(View.GONE);
                layout_height.setVisibility(View.VISIBLE);
                layout_base.setVisibility(View.VISIBLE);
            }
        });


        btn_rectangle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                layout_radio.setVisibility(View.GONE);
                layout_height.setVisibility(View.VISIBLE);
                layout_base.setVisibility(View.VISIBLE);
            }
        });

        btn_run.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try{
                    double radio, base, height;
                    radio = Double.parseDouble(input_radio.getText().toString());
                    base = Double.parseDouble(input_base.getText().toString());
                    height = Double.parseDouble(input_height.getText().toString());

                    if(btn_circle.isChecked()){
                        result_text.setText(String.valueOf((Math.round((Math.PI*Math.pow(radio, 2)))*100.0)/100.0));
                    }

                    if(btn_rectangle.isChecked()){
                        result_text.setText(String.valueOf(base*height));
                    }

                    if(btn_triangle.isChecked()){
                        result_text.setText(String.valueOf((base*height)/2));
                    }
                }catch(Exception e){
                    Toast.makeText(Area.this, getResources().getString(R.string.ERR_GLOBAL), Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result_text.setText("");
                input_radio.setText("");
                input_base.setText("");
                input_height.setText("");
            }
        });
    }
}