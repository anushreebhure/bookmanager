package com.example.bookmanagerapp.Fragment_Activity.MyBookActivityHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final  String DATABASE_NAME = "MyBook.db";
    public static final  String TABLE_NAME = "book_table";
    public static final  String COL_1 = "ACC_NO";
    public static final  String COL_2 = "BOOK_NAME";
    public static final  String COL_3 = "AUTHOR_NAME";
    public static final  String COL_4 = "PUBLISHER";

    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, 4);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table " + TABLE_NAME +" (ACC_NO INTEGER PRIMARY KEY AUTOINCREMENT ,BOOK_NAME TEXT,AUTHOR_NAME TEXT,PUBLISHER TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String book_name, String author_name, String publisher){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,book_name);
        contentValues.put(COL_3,author_name);
        contentValues.put(COL_4,publisher);

        long success= db.insert(TABLE_NAME,null,contentValues);
        if(success == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor getAllData(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cur = db.rawQuery("select * from "+TABLE_NAME,null);
        return cur;
    }


    public boolean updateData(String acc_no,String book_name,String author_name,String publisher){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,acc_no);
        contentValues.put(COL_2,book_name);
        contentValues.put(COL_3,author_name);
        contentValues.put(COL_4,publisher);

        db.update(TABLE_NAME,contentValues, "ACC_NO = ?",new String[]{acc_no});
        return true;
    }

    public Integer deleteData(String acc_no){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ACC_NO = ?",new String[]{acc_no});
    }



}
