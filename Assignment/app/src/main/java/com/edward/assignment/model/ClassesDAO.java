package com.edward.assignment.model;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.edward.assignment.Helper.MyClassesSQLite;

import java.util.ArrayList;

public class ClassesDAO extends MyClassesSQLite{
    private static MyClassesSQLite myClassesSQLite;

    public ClassesDAO(Context context){
        super(context);
        myClassesSQLite = new MyClassesSQLite(context);
    }

    public ArrayList<Classes> getList(){
        ArrayList<Classes> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = myClassesSQLite.getReadableDatabase();

        @SuppressLint("Recycle") Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM ClassDB",null);
        if (cursor.getCount()!=0){
            cursor.moveToFirst();
            do{
                list.add( new Classes(cursor.getString(0),cursor.getString(1)));
            }while (cursor.moveToNext());
        }
        return list;
    }

    public  boolean insertClass(Classes classes){
        long value = -1;
        try {
            SQLiteDatabase sqLiteDatabase = myClassesSQLite.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", classes.getClassID());
            contentValues.put("className", classes.getClassName());
            value = sqLiteDatabase.insert("ClassDB", null, contentValues);
        }catch (Exception e){
            Log.d(e.toString(), "insertProduct: ");
        }
        System.out.println(value);
        return value != -1;

    }

    public  boolean updateClass(String id,String ReName){
        long value = -1;
        try{
            SQLiteDatabase sqLiteDatabase =  myClassesSQLite.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("className",ReName);
            value = sqLiteDatabase.update("ClassDB", contentValues,"id = ?",new String[]{id});
        }catch (Exception ignored){
        }
        return value != -1;
    }

    public boolean deleteClass(String id){
        long value = -1;
        try {
            SQLiteDatabase sqLiteDatabase =  myClassesSQLite.getWritableDatabase();
            value= sqLiteDatabase.delete("ClassDB","id = ?", new String[]{String.valueOf(id)});
        }
        catch (Exception ignored){
        }
        return value != -1;
    }

}
