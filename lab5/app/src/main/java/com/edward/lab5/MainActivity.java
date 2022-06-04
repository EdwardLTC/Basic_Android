package com.edward.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.edward.lab5.DAO.Product;
import com.edward.lab5.DAO.ProductDAO;
import com.edward.lab5.model.ProductAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    protected  ProductDAO productDAO = new ProductDAO(this);
    protected int id;
    protected EditText name;
    protected EditText price;
    protected EditText IMG;
    protected Button add;
    protected Button update;
    protected ListView lvSanPham;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.edtTenSP);
        price = findViewById(R.id.edtGiaSP);
        IMG = findViewById(R.id.edtHinhSP);
        add = findViewById(R.id.btnThemSP);
        lvSanPham = findViewById(R.id.lvSanPham);
        update = findViewById(R.id.btnCapNhatSP);

        updateListview();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tensp = name.getText().toString();
                int giasp =  Integer.parseInt(price.getText().toString());
                String hinhsp = IMG.getText().toString();
                Product product = new Product(tensp,giasp,hinhsp);
                if (productDAO.insertProduct(product)){
                    Toast.makeText(MainActivity.this,"Add success",Toast.LENGTH_SHORT).show();
                    updateListview();
                }else {
                    Toast.makeText(MainActivity.this,"Add false",Toast.LENGTH_SHORT).show();
                }


            }
        });

        lvSanPham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Product product = (Product) adapterView.getAdapter().getItem(i);
                name.setText(product.getTenSP());
                price.setText(String.valueOf(product.getGiaSP()));
                IMG.setText(product.getHinHSP());
                id=product.getId();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tensp = name.getText().toString();
                int giasp = Integer.parseInt(price.getText().toString());
                String hinhsp = IMG.getText().toString();

                Product product = new Product(id,tensp,giasp,hinhsp);

                if (productDAO.updateProduct(product)){
                    Toast.makeText(MainActivity.this,"Edit success",Toast.LENGTH_SHORT).show();
                    updateListview();
                }else {
                    Toast.makeText(MainActivity.this,"Edit false",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    protected void  updateListview(){

        ArrayList<Product> alSanPham = productDAO.getAll();

        ProductAdapter adapter = new ProductAdapter(alSanPham, MainActivity.this);

        lvSanPham.setAdapter(adapter);
    }

}