package com.example.mathapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Score extends AppCompatActivity {

    private Button btn_run, btn_clear;
    private EditText input_score, input_name;
    private TextView text_result;
    private ImageView img_user;

    public String formatResult(String msg1, String msg2, String studentName){
        return msg1 + " " + studentName + " " + msg2 + " ";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        btn_run = findViewById(R.id.btn_run_score);
        btn_clear = findViewById(R.id.btn_clear_score);
        input_name = findViewById(R.id.input_name);
        input_score = findViewById(R.id.input_score);
        text_result = findViewById(R.id.result_score);
        img_user = findViewById(R.id.img_user_score);

        /*
        2. Desarrollar una aplicación que determine la calificación de un estudiante universitario de
acuerdo a la siguiente condición: de 0 hasta 10,5 será Malo; más de 10,5 hasta 14 será Regular; más de
14 hasta 18 será Bueno; de 19 hasta 20 será Excelente. Se debe considerar que hay que validar la nota
ingresada ya que esta no puede ser menor que 0 (cero) o mayor que 20. Al presionar el botón mostrar
también se debe mostrar una imagen en la sección donde está el imageView.
         */

        btn_run.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String msg1, msg2, student_name;
                msg1 = getResources().getString(R.string.message_result1_score);
                msg2 = getResources().getString(R.string.message_result2_score);
                student_name = input_name.getText().toString();

                try{
                    img_user.setImageDrawable(img_user.getResources().getDrawable(R.drawable.student));
                    if(input_score.getText().toString().equals("")){
                        input_score.setError(getResources().getString(R.string.input_empty));
                    }else{
                        float score = Float.parseFloat(input_score.getText().toString());
                        if(score >= 0 && score <= 10.5){
                            text_result.setText(formatResult(msg1, msg2, student_name) + getResources().getString(R.string.bad));
                        }else if(score > 10.5 && score <= 14){
                            text_result.setText(formatResult(msg1, msg2, student_name) + getResources().getString(R.string.normal));
                        }else if(score > 14 && score <= 18){
                            text_result.setText(formatResult(msg1, msg2, student_name)  + getResources().getString(R.string.good));
                        }else if(score >= 19 && score <= 20){
                            text_result.setText(formatResult(msg1, msg2, student_name) + getResources().getString(R.string.excellent));
                        }else{
                            input_score.setError(getResources().getString(R.string.ERR_score_out_range));
                        }
                    }
                }catch(Exception e){
                    Toast.makeText(Score.this, getResources().getString(R.string.ERR_GLOBAL), Toast.LENGTH_LONG).show();
                }
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                text_result.setText("");
                input_score.setText("");
                input_name.setText("");
                img_user.setImageDrawable(img_user.getResources().getDrawable(R.drawable.usuario));
            }
        });
    }
}