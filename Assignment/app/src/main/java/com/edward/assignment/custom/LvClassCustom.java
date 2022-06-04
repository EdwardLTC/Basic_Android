package com.edward.assignment.custom;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import com.edward.assignment.R;
import com.edward.assignment.model.Classes;

import java.util.ArrayList;
import java.util.List;

public class LvClassCustom extends BaseAdapter {
    private ArrayList<Classes> list;
    private Context context;

    public LvClassCustom(ArrayList<Classes> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view==null){
            LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
            view = layoutInflater.inflate(R.layout.lv_component,viewGroup,false);
        }
        EditText id = view.findViewById(R.id.edtId);
        EditText name =view.findViewById(R.id.edtName);
        EditText num = view.findViewById(R.id.edtNum);

        num.setText(String.valueOf(i+1));
        name.setText(list.get(i).getClassName());
        id.setText(list.get(i).getClassID());

        return view ;
    }
}