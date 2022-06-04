package com.edward.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.edward.assignment.custom.LvClassCustom;
import com.edward.assignment.model.Classes;
import com.edward.assignment.model.ClassesDAO;

import java.util.ArrayList;

public class Classes_System extends AppCompatActivity {
    ListView lv ;
    ClassesDAO CD =  new ClassesDAO();
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes_system);
        lv = findViewById(R.id.classesListView);

        LvClassCustom adapter = new LvClassCustom((ArrayList<Classes>) CD.getList(),this);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                
            }
        });
    }
}