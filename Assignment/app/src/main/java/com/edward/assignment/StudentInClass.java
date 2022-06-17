package com.edward.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.edward.assignment.custom.LvStudentCustom;
import com.edward.assignment.model.Classes;
import com.edward.assignment.model.StudentDAO;

public class StudentInClass extends AppCompatActivity {
    ListView lv ;
    TextView txtField;
    Button back;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_in_class);
        StudentDAO SD = new StudentDAO(this);

        lv=findViewById(R.id.studentListView);
        txtField= findViewById(R.id.txtField);
        back =findViewById(R.id.wayBack);

        Intent intent = getIntent();
        String className = intent.getStringExtra("className");
        txtField.setText("Student in Class "+className);
        LvStudentCustom adapter = new LvStudentCustom(SD.getListStudentInClass(className),StudentInClass.this);
        lv.setAdapter(adapter);

        back.setOnClickListener(view -> startActivity(new Intent(StudentInClass.this, Classes_System.class)));

    }


}