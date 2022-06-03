package com.edward.lab5.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LiteSQL extends SQLiteOpenHelper {
    public static String DB_NAME = "QLSANPHAM";
    public static int DB_VERSION = 1;

    public LiteSQL(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE SANPHAM(id integer primary key autoincrement, " +
                "tensp TEXT, giasp integer, hinhsp TEXT)";
        sqLiteDatabase.execSQL(sql);
        String sqlInsert = "INSERT INTO SANPHAM VALUES(1, 'Sản phẩm A', 1000, 'hinh.jpg')," +
                "(2, 'Sản phẩm B', 3000, 'hinh.jpg')," +
                "(3, 'Sản phẩm C', 2000, 'hinh.jpg')";
        sqLiteDatabase.execSQL(sqlInsert);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS  SANPHAM";
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }
}
