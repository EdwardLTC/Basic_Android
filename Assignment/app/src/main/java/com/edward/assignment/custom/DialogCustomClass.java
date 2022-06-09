package com.edward.assignment.custom;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;


import com.edward.assignment.R;
import com.edward.assignment.StudentInClass;
import com.edward.assignment.model.Classes;
import com.edward.assignment.model.ClassesDAO;

public class DialogCustomClass extends Dialog {
    private final Activity c;
    private final Classes classes;
    private ClassesDAO CD ;
    public DialogCustomClass(Activity activity, Classes classes) {
        super(activity);
        this.c = activity;
        this.classes =classes;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_class);

        CD = new ClassesDAO(c);
        Button del = findViewById(R.id.rmClass);
        Button showClassStudents = findViewById(R.id.showAllStudent);
        Button reNameClass = findViewById(R.id.editClassName);

        del.setOnClickListener(view -> {
            if (CD.deleteClass(classes.getClassID())){
                Toast.makeText(c, "Delete Success", Toast.LENGTH_SHORT).show();
                dismiss();
            }
            else{
                Toast.makeText(c, "Delete False", Toast.LENGTH_SHORT).show();
            }
        });

        reNameClass.setOnClickListener(view -> {
            DialogRenameClass DRC = new DialogRenameClass(c,classes.getClassID());
            DRC.show();
        });

        showClassStudents.setOnClickListener(view -> {
            Intent intent = new Intent(c, StudentInClass.class);
            intent.putExtra("className",classes.getClassName());
            c.startActivity(intent);
        });
    }

}
