
package com.fanoyong.activitylifecycle;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {

    private static final String TAG = "ActivityLifeCycle|";

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.v(TAG + "onConfigurationChanged|", "invoked.");
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        Log.v(TAG + "onCreateView|", "invoked.");
        return super.onCreateView(parent, name, context, attrs);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG + "onDestroy|", "invoked.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG + "onPause|", "invoked.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG + "onRestart|", "invoked.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG + "onResume|", "invoked.");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG + "onStart|", "invoked.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG + "onStop|", "invoked.");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG + "onCreate|", "invoked.");
    }

}
