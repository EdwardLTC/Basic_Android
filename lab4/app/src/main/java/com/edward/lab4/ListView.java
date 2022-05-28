package com.edward.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.edward.lab4.model.Staff;

import java.util.ArrayList;

public class ListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ArrayList<Staff> staffList = new ArrayList<>();
        staffList.add(new Staff("TC","SG",R.drawable.ic_launcher_foreground));
        staffList.add(new Staff("TD","SG",R.drawable.ic_launcher_foreground));
        staffList.add(new Staff("TE","SG",R.drawable.ic_launcher_foreground));
        staffList.add(new Staff("TV","SG",R.drawable.ic_launcher_foreground));


    }
}