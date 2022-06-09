package com.edward.assignment.custom;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.edward.assignment.R;
import com.edward.assignment.model.Classes;
import com.edward.assignment.model.ClassesDAO;

public class DialogCustomCreateClass extends Dialog implements android.view.View.OnClickListener {
    public Activity c;
    public Button yes, no;
    public EditText id;
    public EditText name;

    public DialogCustomCreateClass(Activity activity) {
        super(activity);
        this.c = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_components);
        yes = findViewById(R.id.Add);
        no = findViewById(R.id.Exit);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);
        id = findViewById(R.id.classId);
        name =findViewById(R.id.className);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        ClassesDAO CD =  new ClassesDAO(c);
        switch (view.getId()) {
            case R.id.Add:
                if (CD.insertClass(new Classes(id.getText().toString(),name.getText().toString()))){
                    System.out.println(CD.getList());
                    Toast.makeText(c, "Add success", Toast.LENGTH_SHORT).show();
                    dismiss();
                }
                else {
                    Toast.makeText(c, "Add false", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.Exit:
                Toast.makeText(c, "Add false", Toast.LENGTH_SHORT).show();
                dismiss();
                break;
            default:
                Toast.makeText(c, "Add false", Toast.LENGTH_SHORT).show();
                break;
        }
        dismiss();
    }
}
