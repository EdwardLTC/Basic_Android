package com.edward.assignment.model;

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

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM StudentDB",null);
        if (cursor.getCount()!=0){
            cursor.moveToFirst();
            do{
                list.add(new Students(cursor.getString(1),cursor.getString(0),cursor.getString(2)));
            }while (cursor.moveToNext());
        }
        return list;
    }

    public  boolean insertStudent(Students student){
        try {
            SQLiteDatabase sqLiteDatabase = myStudentSQLite.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", student.getId());
            contentValues.put("name", student.getFullName());
            contentValues.put("class", student.getClasses());
            sqLiteDatabase.insert("StudentDB", null, contentValues);
            return true;
        }catch (Exception e){
            Log.d(e.toString(), "insertProduct: ");
            return false;
        }

    }

    public  boolean updateStudent(Students students){
        try{
            SQLiteDatabase sqLiteDatabase =  myStudentSQLite.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", students.getFullName());
            contentValues.put("class", students.getClasses());
            sqLiteDatabase.update("StudentDB", contentValues,"id = ?",new String[]{String.valueOf(students.getId())});
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean deleteStudent(String id){
        try {
            SQLiteDatabase sqLiteDatabase =  myStudentSQLite.getWritableDatabase();
            sqLiteDatabase.delete("StudentDB","id = ?", new String[]{String.valueOf(id)});
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

}
