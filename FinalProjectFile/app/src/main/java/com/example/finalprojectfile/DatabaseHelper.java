package com.example.finalprojectfile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Login.db";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DBNAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("CREATE TABLE USERS(username TEXT primary key, password TEXT)");
        myDB.execSQL("CREATE TABLE USERS1(username TEXT primary key, password TEXT, points INTEGER DEFAULT 0)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int i, int i1) {
        myDB.execSQL("DROP TABLE IF EXISTS USERS");
        myDB.execSQL("DROP TABLE IF EXISTS USERS1");

        onCreate(myDB);

    }

    //To insert user data
    public Boolean insertData(String username, String password)
    {
        int boogusData = 0;
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("points", boogusData);
        long result = myDB.insert("users1",null,contentValues);
        if(result == -1) return false;
        else
            return true;
    }

    //To check user uniqueness
    public Boolean checkusername(String username)
    {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT * FROM users1 WHERE username = ?", new String[]{username});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    //To check username and password
    public Boolean checkusernamepassword(String username, String password)
    {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT * FROM users1 WHERE username = ? and password = ?", new String[]{username, password});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean updatePassword(String username, String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("password", password);
        Cursor cursor = myDB.rawQuery("SELECT * FROM users1 WHERE username = ?", new String[]{username});
        if(cursor.getCount() > 0)
        {
            long result = myDB.update("users1", values, "username = ?", new String[]{username});
            if(result == -1)
            {
                return false;
            }
            else{
                return true;
            }
        }
        else
        {
            return false;
        }

    }

    public Boolean updatePoints(String username, Integer point){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("point", point);
        Cursor cursor = myDB.rawQuery("SELECT * FROM users1 WHERE username = ?", new String[]{username});
        if(cursor.getCount() > 0)
        {
            long result = myDB.update("users1", values, "username = ?", new String[]{username});
            if(result == -1)
            {
                return false;
            }
            else{
                return true;
            }
        }
        else
        {
            return false;
        }

    }

    public int getScore(String username){
        int result = -1;
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor res = myDB.rawQuery("SELECT points FROM users1 WHERE username = ?",new String[]{username});
        while(res.moveToNext())
        {
            result = res.getInt(0);
        }
        return result;
    }

    /*
    public void addBitmap(String username, byte[] image)
    {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("image", image);
        Cursor cursor = myDB.rawQuery("SELECT * FROM users WHERE username = ?", new String[]{username});
        myDB.update("users", values, "username = ?", new String[]{username});

    }

    public byte[] getBitmapByName(String username)
    {
        SQLiteDatabase myDB = this.getWritableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] select = {"image"};

        qb.setTables("users");

        Cursor cursor = qb.query(myDB,select,"username = ?", new String[]{username},null,null, null);
        byte[] result = null;
        if(cursor.moveToFirst())
        {
            do{
                result = cursor.getBlob(cursor.getColumnIndex("image"));
            }while(cursor.moveToNext());
        }
        return result;
    }*/
}
