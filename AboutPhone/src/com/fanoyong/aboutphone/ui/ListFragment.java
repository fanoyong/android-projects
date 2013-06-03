
package com.fanoyong.aboutphone.ui;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fanoyong.aboutphone.Constants;
import com.fanoyong.aboutphone.R;

public class ListFragment extends Fragment {

    private static final String TAG = "AP|ListFragment|";
    private static OnClickListener mOnClickListener;

    static {
        mOnClickListener = new OnClickListener() {
            @Override
            public void onClick(View mView) {
                int mType = Constants.NONE;
                switch (mView.getId()) {
                    case R.id.btn_hardware:
                        Log.v(TAG + "onCreateView|onClick|", "Hardware clicked.");
                        mType = Constants.INFO_CPU;
                        break;
                    case R.id.btn_kernel:
                        Log.v(TAG + "onCreateView|onClick|", "Kernel clicked.");
                        mType = Constants.INFO_KERNEL;
                        break;
                    case R.id.btn_display:
                        Log.v(TAG + "onCreateView|onClick|", "Display clicked.");
                        mType = Constants.INFO_DISPLAY;
                        break;
                    case R.id.btn_sensors:
                        Log.v(TAG + "onCreateView|onClick|", "Sensors clicked.");
                        mType = Constants.INFO_SENSORS;
                        break;
                    case R.id.btn_connectivity:
                        Log.v(TAG + "onCreateView|onClick|", "Connectivity clicked.");
                        mType = Constants.INFO_CONNECTIVITY;
                        break;
                    case R.id.btn_telephony:
                        Log.v(TAG + "onCreateView|onClick|", "Telephony clicked.");
                        mType = Constants.INFO_TELEPHONY;
                        break;
                    case R.id.btn_location:
                        Log.v(TAG + "onCreateView|onClick|", "Location clicked.");
                        mType = Constants.SHOW_GPS;
                        break;
                    default:
                        Log.v(TAG + "onCreateView|onClick|", "Not belong to anything.");
                        mType = Constants.NONE;
                        break;
                }
                try {
                    if (Integer.valueOf(mType) != null) {
                        displayDetail(mType);
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    Log.e(TAG, "Something wrong with button.");
                }
            }
        };
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG + "onCreate|", "start");
        Log.v(TAG + "onCreate|", "end");
    }

    protected static void displayDetail(int mType) {
        Log.v(TAG + "displayDetail|", "start with type: " + mType);
        Log.v(TAG + "displayDetail|", "end");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.v(TAG + "onCreateView|", "start");
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        ImageView btnHardware = (ImageView) rootView.findViewById(R.id.btn_hardware);
        ImageView btnKernel = (ImageView) rootView.findViewById(R.id.btn_kernel);
        ImageView btnDisplay = (ImageView) rootView.findViewById(R.id.btn_display);
        ImageView btnSensors = (ImageView) rootView.findViewById(R.id.btn_sensors);
        ImageView btnConnectivity = (ImageView) rootView.findViewById(R.id.btn_connectivity);
        ImageView btnTelephony = (ImageView) rootView.findViewById(R.id.btn_telephony);
        ImageView btnLocation = (ImageView) rootView.findViewById(R.id.btn_location);

        btnHardware.setOnClickListener(mOnClickListener);
        btnKernel.setOnClickListener(mOnClickListener);
        btnDisplay.setOnClickListener(mOnClickListener);
        btnSensors.setOnClickListener(mOnClickListener);
        btnConnectivity.setOnClickListener(mOnClickListener);
        btnTelephony.setOnClickListener(mOnClickListener);
        btnLocation.setOnClickListener(mOnClickListener);
        Log.v(TAG + "onCreateView|", "end");

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.v(TAG + "onAttach|", "start");
        Log.v(TAG + "onAttach|", "end");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.v(TAG + "onDetach|", "start");
        Log.v(TAG + "onDetach|", "end");
    }
}
