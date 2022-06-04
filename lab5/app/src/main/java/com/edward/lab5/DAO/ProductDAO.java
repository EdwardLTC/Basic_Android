package com.edward.lab5.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

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

    public  boolean insertProduct(Product product){
        try {
            SQLiteDatabase sqLiteDatabase = liteSQL.getWritableDatabase();
            ContentValues contentValues = new ContentValues();

            contentValues.put("tensp", product.getTenSP());
            contentValues.put("giasp", product.getGiaSP());
            contentValues.put("hinhsp", product.getHinHSP());
            sqLiteDatabase.insert("SANPHAM", null, contentValues);
        }catch (Exception e){
            Log.d(e.toString(), "insertProduct: ");
            return false;
        }
        return true;
    }

    public  boolean updateProduct(Product product){
        try{
            SQLiteDatabase sqLiteDatabase =  liteSQL.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("tensp",product.getTenSP());
            contentValues.put("giasp", product.getGiaSP());
            contentValues.put("hinhsp", product.getHinHSP());
            sqLiteDatabase.update("SANPHAM", contentValues,"id = ?",new String[]{String.valueOf(product.getId())});
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean deleteProduct(int id){
        try {
            SQLiteDatabase sqLiteDatabase =  liteSQL.getWritableDatabase();
            sqLiteDatabase.delete("SANPHAM","id = ?", new String[]{String.valueOf(id)});
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

}
