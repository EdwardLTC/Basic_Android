package com.edward.lab5.model;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.edward.lab5.DAO.Product;
import com.edward.lab5.R;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {
    private ArrayList<Product> alSanPham;
    private Context context;

    public ProductAdapter(ArrayList<Product> alSanPham, Context context) {
        this.alSanPham = alSanPham;
        this.context = context;
    }

    @Override
    public int getCount() {
        return alSanPham.size();
    }

    @Override
    public Object getItem(int i) {
        return alSanPham.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
            view = layoutInflater.inflate(R.layout.item_sanpham, viewGroup, false);
        }

        TextView txtTenSP = view.findViewById(R.id.txtTenSP);
        TextView txtGiaSP = view.findViewById(R.id.txtGiaSP);
        ImageView ivHinhSP = view.findViewById(R.id.ivHinhSP);

        txtTenSP.setText(alSanPham.get(i).getTenSP());
        txtGiaSP.setText(String.valueOf(alSanPham.get(i).getGiaSP()));

        //set hình ảnh

        return view;
    }
}
