package com.edward.assignment;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.edward.assignment.custom.LvClassCustom;
import com.edward.assignment.model.Classes;
import com.edward.assignment.model.ClassesDAO;

import java.util.ArrayList;

public class Classes_System extends AppCompatActivity {
    ListView lv ;
    ClassesDAO CD =  new ClassesDAO(this);
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes_system);
        lv = findViewById(R.id.classesListView);
        LvClassCustom adapter = new LvClassCustom((ArrayList<Classes>) CD.getList(),this);
        lv.setAdapter(adapter);

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Classes classes = (Classes) adapterView.getAdapter().getItem(i);
                AlertDialog.Builder builder = new AlertDialog.Builder(Classes_System.this);
                builder.setTitle("Alert");
                builder.setMessage("Are you sure to delete "+classes.getClassName()+" :>");
                builder.setPositiveButton("Okla", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (CD.deleteClass(classes.getClassID())){
                            Toast.makeText(Classes_System.this,"Remove success",Toast.LENGTH_SHORT).show();
                            LvClassCustom adapter = new LvClassCustom((ArrayList<Classes>) CD.getList(),Classes_System.this);
                            lv.setAdapter(adapter);
                        }else {
                            Toast.makeText(Classes_System.this,"Remove false",Toast.LENGTH_SHORT).show();
                        }

                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.create();
                builder.show();
                return false;
            }

        });
    }
}