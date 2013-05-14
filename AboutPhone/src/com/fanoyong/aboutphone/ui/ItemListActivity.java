
package com.fanoyong.aboutphone.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.fanoyong.aboutphone.Constants;
import com.fanoyong.aboutphone.R;

public class ItemListActivity extends Activity implements ItemListFragment.Callbacks {

    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        if (findViewById(R.id.item_detail_container) != null) {
            mTwoPane = true;
            ((ItemListFragment) getFragmentManager().findFragmentById(R.id.item_list)).setActivateOnItemClick(true);
        }
    }

    @Override
    public void onItemSelected(int type) {
        if (mTwoPane) {
            Bundle arguments = new Bundle();
            arguments.putInt(Constants.ARG_ITEM_TYPE, type);
            ItemDetailFragment fragment = new ItemDetailFragment();
            fragment.setArguments(arguments);
            getFragmentManager().beginTransaction().replace(R.id.item_detail_container, fragment).commit();
        } else {
            Intent detailIntent = new Intent(this, ItemDetailActivity.class);
            detailIntent.putExtra(Constants.ARG_ITEM_TYPE, type);
            startActivity(detailIntent);
        }
    }
}
