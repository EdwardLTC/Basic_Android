package com.edward.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.edward.assignment.custom.DialogCustomCreateClass;

public class MainActivity extends AppCompatActivity {
    Button addClasses;
    Button showClasses;
    Button studentManagement;
    Button exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addClasses = findViewById(R.id.addClassBtn);
        showClasses = findViewById(R.id.showAllClasses);
        studentManagement =findViewById(R.id.studentManagementSystem);
        exit =findViewById(R.id.Exit);

        studentManagement.setOnClickListener(view -> startActivity( new Intent(MainActivity.this,Student_Management.class)));

        showClasses.setOnClickListener(view -> startActivity( new Intent(MainActivity.this,Classes_System.class)));

        addClasses.setOnClickListener(view -> {
            DialogCustomCreateClass DC = new DialogCustomCreateClass(MainActivity.this);
            DC.show();
        });

        exit.setOnClickListener(view -> startActivity(new Intent(MainActivity.this,LoginActivity.class)));
    }
}