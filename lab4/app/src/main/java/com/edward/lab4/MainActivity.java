package com.edward.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText var1 = findViewById(R.id.a);
        EditText var2 = findViewById(R.id.b);

        Button click = findViewById(R.id.clickMe);



        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(MainActivity.this,LCM.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("VarA", Integer.parseInt(var1.getText().toString()));
                    bundle.putInt("VarB",Integer.parseInt(var2.getText().toString()));
                    intent.putExtras(bundle);
                    startActivity(intent);
                }catch (Exception e){
                    Log.d(e.toString(), "onClick: ");
                }

            }
        });

    }
}