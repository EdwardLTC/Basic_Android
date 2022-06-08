package com.edward.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    private EditText input;
    private TextView getInfo;
    private Button save;
    private Button show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.input);
        getInfo = findViewById(R.id.getInfor);
        save =findViewById(R.id.save);
        show =findViewById(R.id.show);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showData();
            }
        });

    }

    private void saveData(){
        try {
            String content = input.getText().toString();
            File path = getCacheDir();
            File file = new File(path,"EdCache.cache");
            file.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(file.getAbsoluteFile());
            outputStream.write(content.getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showData(){

        try {
            File path = getCacheDir();
            File file = new File(path,"EdCache.cache");
            Scanner scanner = new Scanner(file);
            StringBuilder data = new StringBuilder();
            while (scanner.hasNext()){
                data.append(scanner.nextLine()).append("\n");
            }
            getInfo.setText(data.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}