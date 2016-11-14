package com.fanoyong.complexprovider;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SmsDatabaseHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "smsdb";
    private static final String SQL_CREATE_MAIN = "CREATE TABLE " +
            "sms " +                       // Table's name
            "(" +                           // The columns in the table
            " _ID INTEGER PRIMARY KEY, " +
            " ADDRESS TEXT, " +
            " BODY TEXT)";

    public SmsDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_MAIN);
        String insertMe = "INSERT INTO sms (ADDRESS, BODY) VALUES (9171234567, HELLOWORLD)";
        sqLiteDatabase.execSQL(insertMe);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // FIXME
    }
}
