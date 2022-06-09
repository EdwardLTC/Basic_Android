package com.edward.assignment;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.edward.assignment.custom.DialogCustomClass;
import com.edward.assignment.custom.LvClassCustom;
import com.edward.assignment.model.Classes;
import com.edward.assignment.model.ClassesDAO;


public class Classes_System extends AppCompatActivity {
    ListView lv ;
    ClassesDAO CD;
    Button back;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes_system);

        lv = findViewById(R.id.classesListView);
        back = findViewById(R.id.wayBack);
        CD =  new ClassesDAO(this);
        lv.setOnItemClickListener((adapterView, view, i, l) -> {
            Classes classes = (Classes) adapterView.getAdapter().getItem(i);
            DialogCustomClass DCC = new DialogCustomClass(this,classes);
            DCC.show();
        });

        back.setOnClickListener(view -> startActivity(new Intent(Classes_System.this,MainActivity.class)));

    }

    public void fillData(){
        LvClassCustom adapter = new LvClassCustom(CD.getList(),Classes_System.this);
        lv.setAdapter(adapter);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus){
            CD =  new ClassesDAO(this);
            fillData();
        }
    }
}