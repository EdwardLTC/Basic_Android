package com.edward.assignment.model;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.edward.assignment.Helper.MyClassesSQLite;
import com.edward.assignment.custom.DialogCustom;

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

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM ClassDB",null);
        if (cursor.getCount()!=0){
            cursor.moveToFirst();
            do{
                list.add( new Classes(cursor.getString(0),cursor.getString(1)));
            }while (cursor.moveToNext());
        }
        return list;
    }

    public  boolean insertClass(Classes classes){
        try {
            SQLiteDatabase sqLiteDatabase = myClassesSQLite.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", classes.getClassID());
            contentValues.put("className", classes.getClassName());
            sqLiteDatabase.insert("ClassDB", null, contentValues);
        }catch (Exception e){
            Log.d(e.toString(), "insertProduct: ");
            return false;
        }
        return true;
    }

    public  boolean updateClass(Classes classes){
        try{
            SQLiteDatabase sqLiteDatabase =  myClassesSQLite.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("className", classes.getClassName());
            sqLiteDatabase.update("ClassDB", contentValues,"id = ?",new String[]{String.valueOf(classes.getClassID())});
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean deleteClass(String id){
        try {
            SQLiteDatabase sqLiteDatabase =  myClassesSQLite.getWritableDatabase();
            sqLiteDatabase.delete("ClassDB","id = ?", new String[]{String.valueOf(id)});
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

}
