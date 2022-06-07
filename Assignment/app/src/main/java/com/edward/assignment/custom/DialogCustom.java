package com.edward.assignment.custom;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.edward.assignment.R;
import com.edward.assignment.model.Classes;
import com.edward.assignment.model.ClassesDAO;

public class DialogCustom extends Dialog implements android.view.View.OnClickListener {
    public Activity c;
    public Dialog d;
    public Button yes, no;
    public  EditText id;
    public EditText name;

    public DialogCustom(Activity activity) {
        super(activity);
        this.c = activity;
    }

    public DialogCustom(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected DialogCustom(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_components);
        yes = (Button) findViewById(R.id.Add);
        no = (Button) findViewById(R.id.Exit);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);
        id = findViewById(R.id.classId);
        name =findViewById(R.id.className);
    }

    @Override
    public void onClick(View view) {
        ClassesDAO CD =  new ClassesDAO(c);
        switch (view.getId()) {
            case R.id.Add:
                CD.insertClass(new Classes(id.getText().toString(),name.getText().toString()));
                System.out.println(CD.getList());
                Toast.makeText(c, "Add success", Toast.LENGTH_SHORT).show();
                dismiss();
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
