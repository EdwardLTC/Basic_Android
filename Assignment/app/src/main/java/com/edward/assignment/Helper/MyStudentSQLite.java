package com.edward.assignment.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyStudentSQLite extends SQLiteOpenHelper {
    public static String DB_NAME = "StudentDB";
    public static int DB_VERSION = 1;

    public MyStudentSQLite(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    public MyStudentSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE StudentDB (id TEXT primary key, " +
                "name TEXT,class TEXT)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS  StudentDB";
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }
}
