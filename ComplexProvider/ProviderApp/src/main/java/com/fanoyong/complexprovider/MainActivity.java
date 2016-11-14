package com.fanoyong.complexprovider;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends Activity {

    private static final String TAG = "ConsumerActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ContentResolver contentResolver = this.getContentResolver();
        String queryString = "SELECT * from content://com.fanoyong.complexprovider/sms";
        Uri uri = Uri.parse(queryString);
        Cursor cursor = contentResolver.query(uri, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                if (cursor.getColumnIndex("ADDRESS") == -1) {
                    android.util.Log.d(TAG, "ADDRESS: " + cursor.getString(cursor.getColumnIndex("ADDRESS")));
                }
                if (cursor.getColumnIndex("BODY") == -1) {
                    android.util.Log.d(TAG, "BODY: " + cursor.getString(cursor.getColumnIndex("BODY")));
                }
            } while (cursor.moveToNext());
        }
    }
}
