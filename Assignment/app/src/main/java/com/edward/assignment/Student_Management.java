package com.edward.assignment;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.edward.assignment.custom.LvStudentCustom;
import com.edward.assignment.model.ClassesDAO;
import com.edward.assignment.model.StudentDAO;
import com.edward.assignment.model.Students;

import java.util.ArrayList;
import java.util.List;

public class Student_Management extends AppCompatActivity {
    private Spinner spnCategory;
    ListView lv ;
    StudentDAO SD = new StudentDAO(this);
    ClassesDAO CD = new ClassesDAO(this);

    Button add;
    Button rm;
    Button update;
    Button back;

    EditText FN;
    EditText ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_management);
        spnCategory = findViewById(R.id.sp_subject);

        lv = findViewById(R.id.studentListView);
        FN = findViewById(R.id.FNedt);
        ID = findViewById(R.id.Idedt);

        add = findViewById(R.id.addBtn);
        update =findViewById(R.id.updateBtn);
        rm = findViewById(R.id.remveBtn);
        back=findViewById(R.id.wayBack);

        setSpinner();
        fillData();


        lv.setOnItemClickListener((parent, view, position, id) -> {
            Students item = (Students) parent.getAdapter().getItem(position);
            try {
                FN.setText(item.getFullName());
                ID.setText(item.getId());
            }catch(Exception ignored){
            }

        });

        add.setOnClickListener(view -> {
            try {
                String FullName = FN.getText().toString();
                String id = ID.getText().toString();
                String classes = spnCategory.getSelectedItem().toString();
                if (FullName.isEmpty()||id.isEmpty()){
                    Toast.makeText(getApplicationContext(),"add False",Toast.LENGTH_LONG).show();
                    return;
                }
                if (SD.insertStudent( new Students(FullName,id,classes))){
                    Toast.makeText(getApplicationContext(),"add Success",Toast.LENGTH_LONG).show();
                    fillData();
                    FN.setText("");
                    ID.setText("");
                }
                else {
                    Toast.makeText(getApplicationContext(),"add False",Toast.LENGTH_LONG).show();
                }
            }
            catch (Exception e){
                Toast.makeText(getApplicationContext(),"Error: " + e,Toast.LENGTH_LONG).show();
            }

        });


        rm.setOnClickListener(view -> {
            String id = ID.getText().toString();
            if (id.isEmpty()){
                Toast.makeText(Student_Management.this,"Remove false",Toast.LENGTH_SHORT).show();
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(Student_Management.this);
            builder.setTitle("Alert");
            builder.setMessage("Are you sure to delete "+id+" :>");
            builder.setPositiveButton("Okla", (dialogInterface, i) -> {
                if (SD.deleteStudent(id)){
                    FN.setText("");
                    ID.setText("");
                    Toast.makeText(Student_Management.this,"Remove success",Toast.LENGTH_SHORT).show();
                    fillData();
                }else {
                    Toast.makeText(Student_Management.this,"Remove false",Toast.LENGTH_SHORT).show();
                }

            });

            builder.setNegativeButton("No", (dialogInterface, i) -> {
            });

            builder.create();
            builder.show();
        });

        update.setOnClickListener(view -> {
            String id = ID.getText().toString();
            String name =FN.getText().toString();
            String classes = spnCategory.getSelectedItem().toString();

            if (id.isEmpty()||name.isEmpty()){
                Toast.makeText(Student_Management.this,"Update false",Toast.LENGTH_SHORT).show();
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(Student_Management.this);
            builder.setTitle("Alert");
            builder.setMessage("Are you sure to update "+id+" :>");
            builder.setPositiveButton("Okla", (dialogInterface, i) -> {
                if (SD.updateStudent(new Students(name,id,classes))){
                    FN.setText("");
                    ID.setText("");
                    Toast.makeText(Student_Management.this,"Update success",Toast.LENGTH_SHORT).show();
                    System.out.println(SD.getList());
                    fillData();
                }else {
                    Toast.makeText(Student_Management.this,"Update false",Toast.LENGTH_SHORT).show();
                }

            });

            builder.setNegativeButton("No", (dialogInterface, i) -> {
            });

            builder.create();
            builder.show();
        });

        back.setOnClickListener(view -> startActivity(new Intent(Student_Management.this,MainActivity.class)));

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
        LvStudentCustom adapter = new LvStudentCustom(SD.getList(),Student_Management.this);
        lv.setAdapter(adapter);
    }

}