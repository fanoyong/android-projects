
package com.fanoyong.aboutphone.ui;

import com.fanoyong.aboutphone.R;
import com.fanoyong.aboutphone.R.id;
import com.fanoyong.aboutphone.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

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
    public void onItemSelected(int id) {
        if (mTwoPane) {
            Bundle arguments = new Bundle();
            arguments.putInt(ItemDetailFragment.ARG_ITEM_ID, id);
            ItemDetailFragment fragment = new ItemDetailFragment();
            fragment.setArguments(arguments);
            getFragmentManager().beginTransaction().replace(R.id.item_detail_container, fragment).commit();
        } else {
            Intent detailIntent = new Intent(this, ItemDetailActivity.class);
            detailIntent.putExtra(ItemDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }
}
