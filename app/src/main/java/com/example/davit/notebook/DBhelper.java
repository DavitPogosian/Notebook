package com.example.davit.notebook;

/**
 * Created by Davit on 10/11/2017.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper
{

    public static final String DB_NAME="notebook.db";
    public static final String TABLE_NAME="words";
    public  Cursor r=null;
    private SQLiteDatabase db;

    public DBhelper(Context context) {
        super(context, DB_NAME, null, 1);

        SQLiteDatabase mydb=this.getWritableDatabase();
    }

    @Override// todo irada /change/ en , fr and domain
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME +" (ID integer primary key AUTOINCREMENT ,en TEXT , fr TEXT  ,domain TEXT)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(db);
    }

    public void close() {
        if (db != null && db.isOpen()) {
            try {
                db.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void open() {
        try {
            db = getWritableDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean deleteNote(String where) {
        return delete(TABLE_NAME, where);
    }
    public boolean delete(String table, String where) {
        open();
        long index = db.delete(table, where, null);
        close();
        return index > 0;
    }








    public Cursor GetWordByID(int ID)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result= db.rawQuery("Select * from "+TABLE_NAME+ " WHERE ID="+ID,null);
        return result;
    }
    public Cursor GetAll()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result= db.rawQuery("Select * from "+TABLE_NAME,null);
        return result;
    }

    public void DeletWord(int ID)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        //Log.d("from DBhalper.DeletProduct","going to delete "+ID);

        r = GetWordByID(ID);
        if(r.getCount()!=0)
        {
            db.delete(TABLE_NAME,"ID=" + ID, null);
        }
        else
        {
          //  Log.d("from DBhalper.DeletProduct","r.getCount()= "+r.getCount());
        }


    }

    public Cursor GetNrOfWords()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result= db.rawQuery("SELECT count(*) FROM "+TABLE_NAME,null);
        return result;
    }
    // todo ,Irada/ change/ con
    public void EditWordByID(int ID, String fr, String en,String domain)
    {
        fr=fr.toLowerCase();
        en=en.toLowerCase();
        domain=domain.toLowerCase();
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

    public Cursor GetWordByLetterInFr(String letter)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result= db.rawQuery("Select * from "+TABLE_NAME+ " WHERE fr like'"+letter+"%'",null);
        return result;

    }
    public Cursor Search(String request){
        request=request.toLowerCase();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result= db.rawQuery("Select * from "+TABLE_NAME+ " WHERE domain='"+request+"' or fr='"+request+"' or en ='"+request+"'",null);
        return result;

    }
    public Cursor GetWordByLetterInEn(String letter)
    {
        SQLiteDatabase db = this.getWritableDatabase();
     //   SELECT * FROM Customers where CustomerName like 'a%';
        Cursor result= db.rawQuery("Select * from "+TABLE_NAME+ " WHERE en like'"+letter+"%'",null);
        return result;

    }

    public boolean AddWord(String fr, String en,String domain)
    {
        fr=fr.toLowerCase();
        en=en.toLowerCase();
        //domain=domain.toLowerCase();
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cont = new ContentValues();
        cont.put("fr", fr);
        cont.put("en", en);
        if(domain!=null)
        cont.put("domain", domain.toLowerCase());
        Cursor c;
//        =serchdom(domain);
//        if(c.getCount() != 0)
//            return false;
        c=serchen(en);
        if(c.getCount() != 0)
            return false;
         c=serchfr(fr);
        if(c.getCount() != 0)
            return false;



        long res = db.insert(TABLE_NAME, null, cont);
        if (res==-1)
          return   false;
        else
            return true;

    }
    public Cursor serchfr(String s)
    {

        s=s.toLowerCase();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result= db.rawQuery("Select * from "+TABLE_NAME+ " WHERE fr like'"+s+"%'",null);

        return result;

    }

    public Cursor serchen(String s)
    {

        s=s.toLowerCase();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result= db.rawQuery("Select * from "+TABLE_NAME+ " WHERE en like'"+s+"%'",null);
        return result;
    }
    public Cursor serchdom(String s)
    {
        s=s.toLowerCase();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result= db.rawQuery("Select * from "+TABLE_NAME+ " WHERE domain like'"+s+"%'",null);
        return result;
    }
}
