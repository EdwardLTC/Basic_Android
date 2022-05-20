package com.edward.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);
        TextView result = findViewById(R.id.result);
        Intent intent = getIntent();
        String rs = intent.getExtras().getString("result");
        result.setText(rs);
    }
}