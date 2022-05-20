package com.edward.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button addClasses;
    Button showClasses;
    Button studentManagement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addClasses =(Button) findViewById(R.id.addClassBtn);
        showClasses = (Button) findViewById(R.id.showAllClasses);
        studentManagement = (Button) findViewById(R.id.studentManagementSystem);

        studentManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(MainActivity.this,Student_Management.class));
            }
        });

        showClasses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(MainActivity.this,Classes_System.class));
            }
        });
    }
}