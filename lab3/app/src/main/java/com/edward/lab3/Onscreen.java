package com.edward.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Onscreen extends AppCompatActivity {
    Button QE;
    Button LV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);
        QE = findViewById(R.id.quadraticEquation);
        LV = findViewById(R.id.listView);
        QE.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(Onscreen.this,QuadraticEquation.class));
                }
        });

        LV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Onscreen.this,viewList.class));
            }
        });

    }
}