package com.edward.lab4.model;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.edward.lab4.R;

import java.util.ArrayList;

public class AdapterListView extends BaseAdapter {
    private ArrayList<Staff> staffList;
    private Context context;

    public AdapterListView(ArrayList<Staff> staffList, Context context) {
        this.staffList = staffList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return staffList.size();
    }

    @Override
    public Object getItem(int i) {
        return staffList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
            view = layoutInflater.inflate(R.layout.item_lv,viewGroup,false);
        }
        TextView name = view.findViewById(R.id.name);
        TextView address = view.findViewById(R.id.address);
        ImageView img = view.findViewById(R.id.img);

        name.setText(staffList.get(i).getName());
        address.setText((staffList.get(i).getAddress()));
        img.setImageResource(staffList.get(i).getIdImg());

        return view;
    }
}
