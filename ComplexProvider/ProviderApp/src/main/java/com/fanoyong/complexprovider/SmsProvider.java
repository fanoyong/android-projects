package com.fanoyong.complexprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class SmsProvider extends ContentProvider {

    private static final String TAG = "SmsProvider";

    private static final UriMatcher sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    private static int SMS = 1;
    private static int SMS_ID = 2;

    static {
        sURIMatcher.addURI(SmsContract.AUTHORITY, "sms", SMS);
        sURIMatcher.addURI(SmsContract.AUTHORITY, "sms/#", SMS_ID);
    }

    private SmsDatabaseHelper mOpenHelper;

    public SmsProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        int ret = 0;
        return ret;
    }

    @Override
    public String getType(Uri uri) {
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        int match = sURIMatcher.match(uri);
        // TODO
        String ret = null;
        return ret;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        long ret = db.insert("sms", null, values);
        return uri;
    }

    @Override
    public boolean onCreate() {
        mOpenHelper = new SmsDatabaseHelper(this.getContext(), SmsDatabaseHelper.DBNAME, null, 1);
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        Cursor ret = db.query("sms", projection, selection, selectionArgs, null, null, sortOrder);
        return ret;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        int ret = 0;
        return ret;
    }
}
