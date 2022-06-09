package com.edward.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private TextView user;
    private TextView password;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login = findViewById(R.id.loginBtn);
        Button regis = findViewById(R.id.regisBtn);
        Button exit = findViewById(R.id.Exit);
        user = findViewById(R.id.user);
        password = findViewById(R.id.password);
        checkBox= findViewById(R.id.ckbox);

        SharedPreferences loginPreferences = getSharedPreferences("isRemember",MODE_PRIVATE);
        SharedPreferences.Editor editor =loginPreferences.edit();

        boolean saveLogin = loginPreferences.getBoolean("saveLogin", false);
        if (saveLogin) {
            SharedPreferences preferences = getSharedPreferences("Account",MODE_PRIVATE);
            user.setText(preferences.getString("user", ""));
            password.setText(preferences.getString("pass", ""));
            checkBox.setChecked(true);
        }

        login.setOnClickListener(view -> {
            String usr = user.getText().toString();
            String pas = password.getText().toString();

            SharedPreferences preferences = getSharedPreferences("Account",MODE_PRIVATE);
            String baseUser = preferences.getString("user","");
            String basePass = preferences.getString("pass","");

            if (checkBox.isChecked()) {
                editor.putBoolean("saveLogin", true);
            } else {
                editor.clear();
            }
            editor.apply();

            if (usr.equals(baseUser) && pas.equals(basePass)){
                Toast.makeText(LoginActivity.this, "Login success", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
            else {
                Toast.makeText(LoginActivity.this, "Login false", Toast.LENGTH_SHORT).show();
            }

        });

        regis.setOnClickListener(view -> startActivity(new Intent(LoginActivity.this,RegisterActivity.class)));

        exit.setOnClickListener(view -> System.exit(0));

    }
}