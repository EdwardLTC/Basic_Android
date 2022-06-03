package com.edward.lab5.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.edward.lab5.Helper.LiteSQL;

import java.util.ArrayList;

public class ProductDAO extends LiteSQL {
    private static LiteSQL liteSQL;

    public ProductDAO(Context context) {
        super(context);
        liteSQL = new LiteSQL(context);
    }

    public ArrayList<Product> getAll(){
        ArrayList<Product> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = liteSQL.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM SANPHAM",null);
        if (cursor.getCount()!=0){
            cursor.moveToFirst();
            do{
                list.add( new Product(cursor.getInt(0),cursor.getString(1),cursor.getInt(2),cursor.getString(3)));
            }while (cursor.moveToNext());
        }
        return list;
    }

}
