package com.edward.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button login;
    Button reset;
    TextView user;
    TextView password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.loginBtn);
        reset =findViewById(R.id.rsBtn);

        user = (EditText)findViewById(R.id.user);
        password = (EditText)findViewById(R.id.password);

        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String us = user.getText().toString();
                String ps = password.getText().toString();
//               if (us.equals("admin") && ps.equals("admin")){
                   startActivity(new Intent(LoginActivity.this,MainActivity.class));
                   Toast.makeText(getApplicationContext(), "Login success",Toast.LENGTH_LONG).show();
                   finish();
                }
//               else {
//                   Log.i(us, "onClick: ");
//                   Log.d(ps, "onClick: ");
//                    Toast.makeText(getApplicationContext(), "Login False",Toast.LENGTH_LONG).show();
//               }
//            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setText("");
                password.setText("");
            }
        });
    }
}