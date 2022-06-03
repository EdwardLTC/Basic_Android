package com.edward.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.edward.lab5.DAO.Product;
import com.edward.lab5.DAO.ProductDAO;
import com.edward.lab5.model.ProductAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ProductDAO productDAO = new ProductDAO(this);

        ListView lvSanPham = findViewById(R.id.lvSanPham);

        System.out.println(productDAO.getAll());
        ArrayList<Product> alSanPham = productDAO.getAll();

        ProductAdapter adapter = new ProductAdapter(alSanPham, MainActivity.this);

        lvSanPham.setAdapter(adapter);
    }
}