package com.edward.lab1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnPlus;
    Button btnMinus;
    Button btnDiv ;
    Button btnMulti ;

    EditText vA ;
    EditText vB ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlus =  findViewById(R.id.btn_Plus);
        btnMinus  = findViewById(R.id.btn_Minus);
        btnDiv = findViewById(R.id.btn_Division);
        btnMulti = findViewById(R.id.btn_Multi);

        vA = findViewById(R.id.var1);
        vB = findViewById(R.id.var2);

    }

    @Override
    public void onClick(View view) {
        try{
            float varA = Float.parseFloat(vA.getText().toString());
            float varB = Float.parseFloat(vB.getText().toString());
            Intent intent = new Intent(MainActivity.this,ResultActivity2.class);
            if (view == btnPlus){
                float rs = varA +varB;
                String s = Float.toString(rs);
                intent.putExtra("result",s);
                startActivity(intent);
            }
            if (view ==  btnDiv){
                float rs = varA /varB;
                String s = Float.toString(rs);
                intent.putExtra("result",s);
                startActivity(intent);
            }
            if (view ==  btnMinus){
                float rs = varA -varB;
                String s = Float.toString(rs);
                intent.putExtra("result",s);
                startActivity(intent);
            }
            if (view ==  btnMulti){
                float rs = varA *varB;
                String s = Float.toString(rs);
                intent.putExtra("result",s);
                startActivity(intent);
            }
        }catch (Exception ignored){
            AlertDialog.Builder AD = new AlertDialog.Builder(this);
            AD.setTitle("Error");
            AD.setMessage(ignored.toString());
            AD.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });
            AlertDialog al = AD.create();
            al.show();
        }

    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lab2", "onRestart: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lab2", "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lab2", "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lab2", "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lab2", "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lab2", "onDestroy: ");
    }



}