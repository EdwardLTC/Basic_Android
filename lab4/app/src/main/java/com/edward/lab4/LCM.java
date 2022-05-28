package com.edward.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class LCM extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lcm);
        EditText result  = findViewById(R.id.Result);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int varA = bundle.getInt("VarA");
        int varB = bundle.getInt("VarB");

        result.setText(String.valueOf(solveLCM(varA,varB)));

    }

    private static int solveLCM(int VarA, int VarB){
        int step;
        int max;
        int lcm = 0 ;
        if(VarA > VarB ){
            max = step = VarA;
        }
        else{
            max = step = VarB;
        }

        while(VarA!= 0) {
            if(max % VarA == 0 && max % VarB == 0) {
                lcm = max;
                break;
            }
            max += step;
        }
        return lcm;
    }
}