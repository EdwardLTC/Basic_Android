package com.edward.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URI;

public class callAction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_action);
        EditText phoneNum = findViewById(R.id.phoneNum);
        Button btn = findViewById(R.id.click);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String num =  phoneNum.getText().toString();
                    Intent intent =new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+num));
                    startActivity(intent);
                }catch (Exception e){
                    Toast.makeText(callAction.this,"Error " + e.toString(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}