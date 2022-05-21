package com.edward.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class QuadraticEquation extends AppCompatActivity {

    EditText varA;
    EditText varB;
    EditText varC;
    TextView fuc;
    TextView rs;

    Button btn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadratic_equation);

        varA = findViewById(R.id.varA);
        varB = findViewById(R.id.varB);
        varC = findViewById(R.id.varC);

        rs =findViewById(R.id.result);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                try {
                    float number1 = Float.parseFloat(varA.getText().toString());
                    float number2 = Float.parseFloat(varB.getText().toString());
                    float number3 = Float.parseFloat(varC.getText().toString());

                    fuc = findViewById(R.id.fuc);
                    fuc.setText(number1+"^2 + "+number2+"X + "+number3 + " = 0");
                    String result = giaiPTBac2(number1,number2,number3);
                    rs.setText(result);
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(), e.toString(),Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    public static String giaiPTBac2(float a, float b, float c) {
        if (a == 0) {
            if (b == 0) {
                return "Phương trình vô nghiệm!";
            } else {
                return "Phương trình có một nghiệm: " + "x = " + (-c / b);
            }
        }
        else {
            float delta = b * b - 4 * a * c;
            float x1;
            float x2;
            if (delta > 0) {
                x1 = (float) ((-b + Math.sqrt(delta)) / (2 * a));
                x2 = (float) ((-b - Math.sqrt(delta)) / (2 * a));
                return "Phương trình có 2 nghiệm là: " + "x1 = " + x1 + " và x2 = " + x2;
            } else if (delta == 0) {
                x1 = (-b / (2 * a));
                return "Phương trình có nghiệm kép: " + "x1 = x2 = " + x1;
            } else {
                return "Phương trình vô nghiệm!";
            }
        }
    }
}