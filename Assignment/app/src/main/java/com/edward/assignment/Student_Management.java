package com.edward.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.edward.assignment.model.Classes;
import com.edward.assignment.model.ClassesDAO;
import com.edward.assignment.model.StudentDAO;
import com.edward.assignment.model.students;

import java.util.ArrayList;
import java.util.List;

public class Student_Management extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spnCategory;
    ListView lv ;
    StudentDAO SD = new StudentDAO();
    ClassesDAO CD = new ClassesDAO();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_management);
        spnCategory = (Spinner) findViewById(R.id.sp_subject);
        lv = findViewById(R.id.studentListView);
        setSpinner();
        fillData();
    }

    public  void setSpinner(){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < CD.getList().size(); i++) {
            list.add(CD.getList().get(i).getClassName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnCategory.setAdapter(adapter);
    }

    public void fillData(){
        ArrayAdapter adapter = new ArrayAdapter<students>(this, android.R.layout.simple_list_item_1,android.R.id.text1,SD.getList());

        lv.setAdapter(adapter);
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}