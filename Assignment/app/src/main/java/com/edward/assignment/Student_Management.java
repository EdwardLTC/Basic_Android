package com.edward.assignment;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Student_Management extends AppCompatActivity {
    private Spinner spnCategory;
    ListView lv ;
    StudentDAO SD = new StudentDAO();
    ClassesDAO CD = new ClassesDAO();
    Button add;
    Button rm;
    EditText FN;
    EditText DOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_management);
        spnCategory = findViewById(R.id.sp_subject);
        lv = findViewById(R.id.studentListView);
        setSpinner();
        fillData();

        FN = findViewById(R.id.FNedt);
        DOB = findViewById(R.id.DOBedt);

        add = findViewById(R.id.addBtn);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    String FullName = FN.getText().toString();
                    String Dob = DOB.getText().toString();
                    String classes = spnCategory.getSelectedItem().toString();
                    SD.addStudent( new students(FullName,Dob,classes));
                    Toast.makeText(getApplicationContext(),"add Success",Toast.LENGTH_LONG).show();
                    fillData();
                    FN.setText("");
                    DOB.setText("");
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Error: " + e.toString(),Toast.LENGTH_LONG).show();
                }

            }
        });

        rm = findViewById(R.id.remveBtn);
        rm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String FullName = FN.getText().toString();
                boolean check = SD.removeObj(FullName);
                Toast.makeText(getApplicationContext(),"remove Success",Toast.LENGTH_LONG).show();
                fillData();
                FN.setText("");
                DOB.setText("");
                System.out.println(check);
            }
        });


    }

    public  void setSpinner(){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < CD.getList().size(); i++) {
            list.add(CD.getList().get(i).getClassName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnCategory.setAdapter(adapter);

    }

    public void fillData(){
        ArrayAdapter<students> adapter = new ArrayAdapter<students>(this, android.R.layout.simple_list_item_1,android.R.id.text1,SD.getList());
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                students item = (students) lv.getItemAtPosition(position);
                System.out.println(item.toString());
                try {
                     FN.setText(item.getFullName());
                     DOB.setText(item.getDob());
                }catch(Exception e){
                    System.out.println(e);
                }

            }
        });

    };

}