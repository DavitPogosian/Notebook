package com.example.davit.notebook;

/**
 * Created by Davit on 10/11/2017.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.util.Log;

import java.io.ByteArrayOutputStream;

public class DBhelper extends SQLiteOpenHelper
{

    public static final String DB_NAME="notebook.db";
    public static final String TABLE_NAME="words";
    public  Cursor r=null;

    public DBhelper(Context context) {
        super(context, DB_NAME, null, 1);

        SQLiteDatabase mydb=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) { // todo irada /change/ en , fr and domain
        db.execSQL("create table "+TABLE_NAME +" (ID integer primary key AUTOINCREMENT ," +
                                                 " en TEXT , " +
                                                "fr TEXT  ," +
                                                 " domain TEXT");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(db);
    }


    public Cursor GetWordByID(int ID)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result= db.rawQuery("Select * from "+TABLE_NAME+ " WHERE ID="+ID,null);
        return result;
    }

    public void DeletWord(int ID)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Log.d("from DBhalper.DeletProduct","going to delete "+ID);
        r = GetWordByID(ID);
        if(r.getCount()!=0)
        {
            db.delete(TABLE_NAME,"ID=" + ID, null);
        }
        else
        {
            Log.d("from DBhalper.DeletProduct","r.getCount()= "+r.getCount());
        }


    }
    // todo ,Irada/ change/ con
    public void EditWordByID(int ID, String fr, String en,String domain)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues con=new ContentValues();
        con.put("fr",fr);
        con.put("en",en);
        con.put("domain",domain);
        db.update(TABLE_NAME, con, "ID=" + ID, null);
    }

    public Cursor GetWordByDomain(String domain)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result= db.rawQuery("Select * from "+TABLE_NAME+ " WHERE domain='"+domain+"'",null);
        return result;

    }

    public Cursor GetWordByLetterInFr(char letter)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result= db.rawQuery("Select * from "+TABLE_NAME+ " WHERE fr like'"+letter+"%'",null);
        return result;

    }
    public Cursor GetWordByLetterInEn(char letter)
    {
        SQLiteDatabase db = this.getWritableDatabase();
     //   SELECT * FROM Customers where CustomerName like 'a%';
        Cursor result= db.rawQuery("Select * from "+TABLE_NAME+ " WHERE en like'"+letter+"%'",null);
        return result;

    }

    public void AddWord(String fr, String en,String domain)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cont = new ContentValues();
        cont.put("fr", fr);
        cont.put("en", en);
        cont.put("domain", domain);
        long res = db.insert(TABLE_NAME, null, cont);

    }




}
