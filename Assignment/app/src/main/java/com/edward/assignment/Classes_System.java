package com.edward.assignment;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.edward.assignment.custom.LvClassCustom;
import com.edward.assignment.custom.LvStudentCustom;
import com.edward.assignment.model.Classes;
import com.edward.assignment.model.ClassesDAO;


public class Classes_System extends AppCompatActivity {
    ListView lv ;
    ClassesDAO CD =  new ClassesDAO(this);
    Button back;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes_system);

        lv = findViewById(R.id.classesListView);
        back = findViewById(R.id.wayBack);

       fillData();

        lv.setOnItemLongClickListener((adapterView, view, i, l) -> {
            Classes classes = (Classes) adapterView.getAdapter().getItem(i);
            AlertDialog.Builder builder = new AlertDialog.Builder(Classes_System.this);
            builder.setTitle("Alert");
            builder.setMessage("Are you sure to delete "+classes.getClassName()+" :>");
            builder.setPositiveButton("Okla", (dialogInterface, i1) -> {
                if (CD.deleteClass(classes.getClassID())){
                    Toast.makeText(Classes_System.this,"Remove success",Toast.LENGTH_SHORT).show();
                    fillData();
                }else {
                    Toast.makeText(Classes_System.this,"Remove false",Toast.LENGTH_SHORT).show();
                }

            });

            builder.setNegativeButton("No", (dialogInterface, i12) -> {

            });

            builder.create();
            builder.show();
            return false;
        });

        back.setOnClickListener(view -> startActivity(new Intent(Classes_System.this,MainActivity.class)));

    }

    public void fillData(){
        LvClassCustom adapter = new LvClassCustom(CD.getList(),Classes_System.this);
        lv.setAdapter(adapter);
    }
}