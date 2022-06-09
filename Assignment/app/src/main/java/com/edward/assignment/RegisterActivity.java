package com.edward.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private EditText user;
    private EditText pass;
    private EditText rePass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_activity);

        user=findViewById(R.id.user);
        pass=findViewById(R.id.password);
        rePass=findViewById(R.id.rePassword);
        Button regis = findViewById(R.id.regisBtn);
        Button mtLogin = findViewById(R.id.mtLogin);
        Button exit = findViewById(R.id.Exit);

        exit.setOnClickListener(view -> System.exit(0));

        mtLogin.setOnClickListener(view -> startActivity(new Intent(RegisterActivity.this,LoginActivity.class)));

        regis.setOnClickListener(view -> {
            String usr = user.getText().toString();
            String pas = pass.getText().toString();
            String rpas = rePass.getText().toString();
            if (rpas.equals(pas)){
                SharedPreferences preferences =getSharedPreferences("Account",MODE_PRIVATE);
                SharedPreferences.Editor editor =preferences.edit();
                editor.putString("user",usr);
                editor.putString("pass",pas);
                editor.apply();
                Toast.makeText(RegisterActivity.this, "Success", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }else {
                Toast.makeText(RegisterActivity.this, "False,  Re enter password", Toast.LENGTH_SHORT).show();
            }
        });
    }

}