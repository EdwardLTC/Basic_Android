package com.edward.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.edward.assignment.model.Classes;
import com.edward.assignment.model.ClassesDAO;

public class Classes_System extends AppCompatActivity {
    ListView lv ;
    ClassesDAO CD =  new ClassesDAO();
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes_system);
        lv = findViewById(R.id.classesListView);
        ArrayAdapter<Classes> adapter = new ArrayAdapter<Classes>(this, android.R.layout.simple_list_item_1,android.R.id.text1,CD.getList());

        lv.setAdapter(adapter);

//        List<Classes> ls = new ArrayList<>();
//        ls = CD.getList();
//        for (int i = 0; i < ls.size(); i++) {
//            EditText editText = new EditText(getApplicationContext());
//            editText.setBackgroundResource(R.drawable.edittextradius);
//            editText.setTop(5);
//            editText.setText((i+1) +"  " +ls.get(i).getClassID()+"   "+ls.get(i).getClassName());
//            LinearLayout linear=(LinearLayout)findViewById(R.id.LLO1);
//            linear.addView(editText);
//        }

    }
}