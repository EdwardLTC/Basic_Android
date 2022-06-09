package com.edward.assignment.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyClassesSQLite extends SQLiteOpenHelper {
    public static String DB_NAME = "ClassDB";
    public static int DB_VERSION = 1;

    public MyClassesSQLite(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE ClassDB (id TEXT primary key, " + "className TEXT)";
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS  ClassDB";
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }
}
