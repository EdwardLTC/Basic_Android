package com.edward.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;

import com.edward.lab4.model.AdapterListView;
import com.edward.lab4.model.Staff;

import java.util.ArrayList;

public class lvActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ListView listView = findViewById(R.id.lv);
        ArrayList<Staff> staffList = new ArrayList<>();
        staffList.add(new Staff("TC","SG",R.drawable.ic_launcher_foreground));
        staffList.add(new Staff("TD","SG",R.drawable.ic_launcher_foreground));
        staffList.add(new Staff("TE","SG",R.drawable.ic_launcher_foreground));
        staffList.add(new Staff("TV","SG",R.drawable.ic_launcher_foreground));

        AdapterListView adapter = new AdapterListView(staffList, lvActivity.this);

        listView.setAdapter(adapter);
    }
}