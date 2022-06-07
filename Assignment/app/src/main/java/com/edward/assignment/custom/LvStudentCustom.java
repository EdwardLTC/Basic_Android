package com.edward.assignment.custom;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.edward.assignment.R;
import com.edward.assignment.model.Classes;
import com.edward.assignment.model.Students;

import java.util.ArrayList;

public class LvStudentCustom extends BaseAdapter {
    private ArrayList<Students> list;
    private Context context;

    public LvStudentCustom(ArrayList<Students> list, Context context) {
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

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view==null){
            LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
            view = layoutInflater.inflate(R.layout.lv_component,viewGroup,false);
        }
        TextView id = view.findViewById(R.id.edtId);
        TextView name =view.findViewById(R.id.edtName);
        TextView num = view.findViewById(R.id.edtNum);

        num.setText(String.valueOf(i+1));
        name.setText(list.get(i).getFullName());
        id.setText(list.get(i).getClasses());
        return view;
    }
}
