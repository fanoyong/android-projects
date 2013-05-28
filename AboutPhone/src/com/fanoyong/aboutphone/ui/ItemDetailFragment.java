
package com.fanoyong.aboutphone.ui;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.fanoyong.aboutphone.Constants;
import com.fanoyong.aboutphone.R;

public class ItemDetailFragment extends Fragment {

    public ItemDetailFragment() {
    }

    private int mType;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(Constants.ARG_ITEM_TYPE)) {
            mType = getArguments().getInt(Constants.ARG_ITEM_TYPE);
        }
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_item_detail, container, false);

        ScrollView sv = (ScrollView) rootView.findViewById(R.id.item_detail);
        LinearLayout mPage = null;
        switch (mType) {
            case Constants.NONE:

            case Constants.INFO_CONNECTIVITY:
                mPage = (LinearLayout) UiBuilder.infoConnectivity(this.getActivity());
                break;
            case Constants.INFO_CPU:
                mPage = (LinearLayout) UiBuilder.infoCPU(this.getActivity());
                break;
            case Constants.INFO_DISPLAY:
                mPage = (LinearLayout) UiBuilder.infoDisplay(this.getActivity());
                break;
            case Constants.INFO_KERNEL:
                mPage = (LinearLayout) UiBuilder.infoKernel(this.getActivity());
                break;
            case Constants.INFO_SENSORS:
                mPage = (LinearLayout) UiBuilder.infoSensors(this.getActivity());
                break;
            case Constants.INFO_TELEPHONY:
                mPage = (LinearLayout) UiBuilder.infoTelephony(this.getActivity());
                break;
            case Constants.SHOW_GPS:
                mPage = (LinearLayout) UiBuilder.showGPS(this.getActivity());
                break;
            default:
        }
        if (mPage != null) {
            sv.addView(mPage);
        } else {
        }
        return rootView;
    }
}
