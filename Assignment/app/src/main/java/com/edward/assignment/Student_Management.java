package com.edward.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.edward.assignment.model.ClassesDAO;
import com.edward.assignment.model.StudentDAO;
import com.edward.assignment.model.students;
import com.google.android.material.badge.BadgeUtils;

import java.util.ArrayList;
import java.util.List;

public class Student_Management extends AppCompatActivity {
    private Spinner spnCategory;
    ListView lv ;
    StudentDAO SD = new StudentDAO();
    ClassesDAO CD = new ClassesDAO();
    Button add;
    EditText FN;
    EditText DOB;
    String Classes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_management);
        spnCategory = findViewById(R.id.sp_subject);
        lv = findViewById(R.id.studentListView);
        setSpinner();
        fillData();

        add = findViewById(R.id.addBtn);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FN = findViewById(R.id.FNedt);
                    String FullName = FN.getText().toString();

                    DOB = findViewById(R.id.DOBedt);
                    String Dob = DOB.getText().toString();

                    String classes = spnCategory.getSelectedItem().toString();

                    SD.addStudent( new students(FullName,Dob,classes));
                    Toast.makeText(getApplicationContext(),"add Success",Toast.LENGTH_LONG).show();
                    fillData();
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Error: " + e.toString(),Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    public  void setSpinner(){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < CD.getList().size(); i++) {
            list.add(CD.getList().get(i).getClassName());
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnCategory.setAdapter(adapter);

    }

    public void fillData(){
        ArrayAdapter<students> adapter = new ArrayAdapter<students>(this, android.R.layout.simple_list_item_1,android.R.id.text1,SD.getList());

        lv.setAdapter(adapter);
    }

}