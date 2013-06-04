
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
    private static int mSequence = 0;
    private static Configuration oldConfig = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG + "onCreate|", "invoked. sequence=" + mSequence++);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Log.v(TAG + "onPostCreate|", "invoked. sequence=" + mSequence++);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG + "onStart|", "invoked. sequence=" + mSequence++);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG + "onResume|", "invoked. sequence=" + mSequence++);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.v(TAG + "onPostResume|", "invoked. sequence=" + mSequence++);

    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        Log.v(TAG + "onCreateView|", "invoked. sequence=" + mSequence++);
        return super.onCreateView(parent, name, context, attrs);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG + "onPause|", "invoked. sequence=" + mSequence++);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG + "onStop|", "invoked. sequence=" + mSequence++);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG + "onRestart|", "invoked. sequence=" + mSequence++);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG + "onDestroy|", "invoked. sequence=" + mSequence++);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (oldConfig != null) {
            Log.v(TAG + "onConfigurationChanged|", "invoked. newConfig:" + newConfig.diff(oldConfig) + "sequence=" + mSequence++);
        } else {
            Log.v(TAG + "onConfigurationChanged|", "invoked. sequence=" + mSequence++);
        }
        oldConfig = newConfig;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.v(TAG + "onBackPressed|", "invoked. sequence=" + mSequence++);
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        Log.v(TAG + "onContentChanged|", "invoked. sequence=" + mSequence++);
    }
}
