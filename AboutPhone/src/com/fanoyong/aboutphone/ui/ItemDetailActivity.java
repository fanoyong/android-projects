
package com.fanoyong.aboutphone.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import com.fanoyong.aboutphone.Constants;
import com.fanoyong.aboutphone.R;

public class ItemDetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putInt(Constants.ARG_ITEM_TYPE, getIntent().getIntExtra(Constants.ARG_ITEM_TYPE, Constants.NONE));
            ItemDetailFragment fragment = new ItemDetailFragment();
            fragment.setArguments(arguments);
            getFragmentManager().beginTransaction().add(R.id.item_detail_container, fragment).commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
