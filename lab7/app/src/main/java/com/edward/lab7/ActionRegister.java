package com.edward.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActionRegister extends AppCompatActivity {
    private EditText user,pass,rePass;
    private Button regisAction,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_register);

        user=findViewById(R.id.user);
        pass=findViewById(R.id.pass);
        rePass=findViewById(R.id.rePass);
        regisAction=findViewById(R.id.regisAction);
        back=findViewById(R.id.wayBack);

        regisAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usr = user.getText().toString();
                String pas = pass.getText().toString();
                String rpas = rePass.getText().toString();
                if (rpas.equals(pas)){
                    SharedPreferences preferences =getSharedPreferences("Account",MODE_PRIVATE);
                    SharedPreferences.Editor editor =preferences.edit();
                    editor.putString("user",usr);
                    editor.putString("pass",pas);
                    editor.apply();
                    Toast.makeText(ActionRegister.this, "Success", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ActionRegister.this, ActionLogin.class));
                }else {
                    Toast.makeText(ActionRegister.this, "False,  Re enter password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActionRegister.this,ActionLogin.class));
            }
        });
    }
}