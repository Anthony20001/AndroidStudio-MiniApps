package com.example.mathapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private CardView btn_hypotenuse, btn_score, btn_equation, btn_area, btn_leapYear,
    btn_biggerNumber, btn_additionDigits, btn_primeNumber, btn_factorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_hypotenuse = findViewById(R.id.btn_hypotenuse);
        btn_score = findViewById(R.id.btn_score);
        btn_equation = findViewById(R.id.btn_equation);
        btn_area = findViewById(R.id.btn_area);
        btn_leapYear = findViewById(R.id.btn_leapYear);
        btn_biggerNumber = findViewById(R.id.btn_biggerNumber);
        btn_additionDigits = findViewById(R.id.btn_sumDigits);
        btn_primeNumber = findViewById(R.id.btn_primeNumber);
        btn_factorial = findViewById(R.id.btn_factorial);

        btn_hypotenuse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Hypotenuse.class);
                startActivity(intent);
            }
        });

        btn_score.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Score.class);
                startActivity(intent);
            }
        });

        btn_equation.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Equation.class);
                startActivity(intent);
            }
        });

        btn_area.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Area.class);
                startActivity(intent);
            }
        });

        btn_leapYear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LeapYear.class);
                startActivity(intent);
            }
        });

        btn_biggerNumber.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BiggerNumber.class);
                startActivity(intent);
            }
        });

        btn_additionDigits.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SumDigits.class);
                startActivity(intent);
            }
        });

        btn_additionDigits.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SumDigits.class);
                startActivity(intent);
            }
        });

        btn_primeNumber.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PrimeNumber.class);
                startActivity(intent);
            }
        });

        btn_factorial.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Factorial.class);
                startActivity(intent);
            }
        });
    }
}