package com.edward.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActionLogin extends AppCompatActivity {
    private EditText user,pass;
    private Button regisAction,login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_action_login);

        user=findViewById(R.id.user);
        pass=findViewById(R.id.pass);
        regisAction=findViewById(R.id.regis);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usr = user.getText().toString();
                String pas = pass.getText().toString();

                SharedPreferences preferences = getSharedPreferences("Account",MODE_PRIVATE);
                String baseUser = preferences.getString("user","");
                String basePass = preferences.getString("pass","");

                if (usr.equals(baseUser) && pas.equals(basePass)){
                    Toast.makeText(ActionLogin.this, "Login success", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ActionLogin.this, MainActivity.class));
                }
                else {
                    Toast.makeText(ActionLogin.this, "Login false", Toast.LENGTH_SHORT).show();
                }

            }
        });
        regisAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActionLogin.this,ActionRegister.class));
            }
        });
    }
}