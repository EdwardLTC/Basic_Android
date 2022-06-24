package com.edward.assignment.model;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.edward.assignment.Helper.MyStudentSQLite;

import java.util.ArrayList;

public class StudentDAO {
    private static MyStudentSQLite myStudentSQLite;

    public StudentDAO(Context context){
        myStudentSQLite = new MyStudentSQLite(context);
    }

    public ArrayList<Students> getList(){
        ArrayList<Students> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = myStudentSQLite.getReadableDatabase();

        @SuppressLint("Recycle") Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM StudentDB",null);
        if (cursor.getCount()!=0){
            cursor.moveToFirst();
            do{
                list.add(new Students(cursor.getString(1),cursor.getString(0),cursor.getString(2)));
            }while (cursor.moveToNext());
        }
        return list;
    }

    public ArrayList<Students> getListStudentInClass(String className){
        ArrayList<Students> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = myStudentSQLite.getReadableDatabase();

        @SuppressLint("Recycle") Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM StudentDB  WHERE class = ?",new String[] {className});
        if (cursor.getCount()!=0){
            cursor.moveToFirst();
            do{
                list.add(new Students(cursor.getString(1),cursor.getString(0),cursor.getString(2)));
            }while (cursor.moveToNext());
        }
        return list;
    }

    public  boolean insertStudent(Students student){
        long value = -1;
        try {
            SQLiteDatabase sqLiteDatabase = myStudentSQLite.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", student.getId());
            contentValues.put("name", student.getFullName());
            contentValues.put("class", student.getClasses());
            value=sqLiteDatabase.insert("StudentDB", null, contentValues);
        }catch (Exception e){
            Log.d(e.toString(), "insertProduct: ");
        }
        return value != -1;
    }

    public boolean updateStudent(Students students){
        long value = -1;
        try{
            SQLiteDatabase sqLiteDatabase =  myStudentSQLite.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", students.getFullName());
            contentValues.put("class", students.getClasses());
            value =sqLiteDatabase.update("StudentDB", contentValues,"id = ?",new String[]{String.valueOf(students.getId())});

        }catch (Exception ignored){
        }
        return value != -1;
    }

    public boolean deleteStudent(String id){
        long value = -1;
        try {
            SQLiteDatabase sqLiteDatabase =  myStudentSQLite.getWritableDatabase();
            value= sqLiteDatabase.delete("StudentDB","id = ?", new String[]{String.valueOf(id)});
        }
        catch (Exception ignored){

        }
        return value!=-1;
    }

}
