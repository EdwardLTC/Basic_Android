package com.edward.assignment.custom;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.edward.assignment.R;
import com.edward.assignment.model.ClassesDAO;


public class DialogRenameClass extends Dialog {

    private final Activity c;
    private EditText reName;
    private final String id;

    public DialogRenameClass(Activity activity, String id) {
        super(activity);
        this.c = activity;
        this.id =id;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_renameclass);

        ClassesDAO cd = new ClassesDAO(c);

        reName = findViewById(R.id.className);
        Button accept = findViewById(R.id.accept);
        Button exit = findViewById(R.id.Exit);

        accept.setOnClickListener(view -> {
            if (cd.updateClass(id,reName.getText().toString())){
                Toast.makeText(c, "Update Success", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(c, "Update False", Toast.LENGTH_SHORT).show();
            }
            dismiss();
        });

        exit.setOnClickListener(view -> dismiss());

    }

}
