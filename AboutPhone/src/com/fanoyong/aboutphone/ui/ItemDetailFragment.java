
package com.fanoyong.aboutphone.ui;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

import com.fanoyong.aboutphone.Constants;
import com.fanoyong.aboutphone.Content;
import com.fanoyong.aboutphone.Content.Item;
import com.fanoyong.aboutphone.R;

public class ItemDetailFragment extends Fragment {

    private Item mItem;

    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(Constants.ARG_ITEM_TYPE)) {
            mItem = Content.ITEM_ARRAY.get(getArguments().getInt(Constants.ARG_ITEM_TYPE));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_item_detail, container, false);
        if (mItem != null) {
            switch (mItem.getType()) {
                case Constants.NONE:
                case Constants.INFO_CONNECTIVITY:
                case Constants.INFO_CPU:
                case Constants.INFO_DISPLAY:
                case Constants.INFO_KERNEL:
                case Constants.INFO_MEMORY:
                case Constants.INFO_SENSORS:
                case Constants.INFO_TELEPHONY:
                case Constants.SHOW_GPS:
                default:
                    ScrollView sv = (ScrollView) rootView.findViewById(R.id.item_detail);
                    LinearLayout lv = (LinearLayout) sv.getParent();
                    lv.setGravity(Gravity.CENTER);

                    LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
                            LayoutParams.WRAP_CONTENT);
                    int bottom = (int) this.getResources().getDimension(R.dimen.margin_box_top);
                    int top = (int) this.getResources().getDimension(R.dimen.margin_box_top);
                    int right = (int) this.getResources().getDimension(R.dimen.margin_box_all);
                    int left = (int) this.getResources().getDimension(R.dimen.margin_box_all);
                    params.setMargins(left, top, right, bottom);

                    TextView tv1 = new TextView(lv.getContext());
                    tv1.setText("Test");
                    tv1.setTextAppearance(lv.getContext(), R.style.textView_Bigger);
                    tv1.setAllCaps(true);
                    sv.addView(tv1, params);
                    break;
            }
        }
        return rootView;
    }
}
