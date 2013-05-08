
package com.fanoyong.phoneinfo.ui;

import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.fanoyong.phoneinfo.R;

public class InfoActivity extends Activity {
    LinearLayout page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        LinearLayout infoContainer = (LinearLayout) this.findViewById(R.id.InfoContainer);
        getInfo();
        infoContainer.addView(page);
    }

    private void getInfo() {
        page = new LinearLayout(this);
        page.setOrientation(LinearLayout.VERTICAL);

        infoCPU();
        infoKernel();
        infoDisplay();
        infoSensors();
        infoConnectivity();
        infoTelephony();
    }

    private void infoTelephony() {
        View child = null;
        page.addView(createHeader("Telephoney"));
        TelephonyManager tm = (TelephonyManager) this.getSystemService(TELEPHONY_SERVICE);

        String deviceswver = tm.getDeviceSoftwareVersion();
        if (deviceswver != null) {
            child = createLine("Device SW Version", deviceswver);
            if (child != null) {
                page.addView(child);
            }
        }
        String deviceid = tm.getDeviceId();
        if (deviceid != null) {
            child = createLine("Device ID", deviceid);
            if (child != null) {
                page.addView(child);
            }
        }
        int dataactivity = tm.getDataActivity();
        String temp = null;
        switch (dataactivity) {
            case TelephonyManager.DATA_ACTIVITY_DORMANT:
                temp = "Dormant";
                break;
            case TelephonyManager.DATA_ACTIVITY_IN:
                temp = "In";
                break;
            case TelephonyManager.DATA_ACTIVITY_INOUT:
                temp = "In / Out";
                break;
            case TelephonyManager.DATA_ACTIVITY_NONE:
                temp = "None";
                break;
            case TelephonyManager.DATA_ACTIVITY_OUT:
                temp = "Out";
                break;
            default:
        }
        if (temp != null) {
            child = createLine("Data Activity", temp);
            if (child != null) {
                page.addView(child);
            }
        }
        int datastate = tm.getDataState();
        temp = null;
        switch (datastate) {
            case TelephonyManager.DATA_CONNECTED:
                temp = "Connected";
                break;
            case TelephonyManager.DATA_CONNECTING:
                temp = "Connecting";
                break;
            case TelephonyManager.DATA_DISCONNECTED:
                temp = "Disconnected";
                break;
            case TelephonyManager.DATA_SUSPENDED:
                temp = "Suspended";
                break;
            default:
        }
        if (temp != null) {
            child = createLine("Data State", temp);
            if (child != null) {
                page.addView(child);
            }
        }
        int phonetype = tm.getPhoneType();
        temp = null;
        switch (phonetype) {
            case TelephonyManager.PHONE_TYPE_CDMA:
                temp = "CDMA";
                break;
            case TelephonyManager.PHONE_TYPE_GSM:
                temp = "GSM";
                break;
            case TelephonyManager.PHONE_TYPE_SIP:
                temp = "SIP";
                break;
            case TelephonyManager.PHONE_TYPE_NONE:
                temp = "None";
                break;
            default:
        }
        if (temp != null) {
            child = createLine("Phone type", temp);
            if (child != null) {
                page.addView(child);
            }
        }
        int networktype = tm.getNetworkType();
        temp = null;
        switch (networktype) {
            case TelephonyManager.NETWORK_TYPE_1xRTT:
                temp = "1xRTT";
                break;
            case TelephonyManager.NETWORK_TYPE_CDMA:
                temp = "CDMA";
                break;
            case TelephonyManager.NETWORK_TYPE_EDGE:
                temp = "EDGE";
                break;
            case TelephonyManager.NETWORK_TYPE_EHRPD:
                temp = "eHRPD";
                break;
            case TelephonyManager.NETWORK_TYPE_EVDO_0:
                temp = "EVDO 0";
                break;
            case TelephonyManager.NETWORK_TYPE_EVDO_A:
                temp = "EVDO A";
                break;
            case TelephonyManager.NETWORK_TYPE_EVDO_B:
                temp = "EVDO B";
                break;
            case TelephonyManager.NETWORK_TYPE_GPRS:
                temp = "GPRS";
                break;
            case TelephonyManager.NETWORK_TYPE_HSDPA:
                temp = "HSDPA";
                break;
            case TelephonyManager.NETWORK_TYPE_HSPA:
                temp = "HSPA";
                break;
            case TelephonyManager.NETWORK_TYPE_HSPAP:
                temp = "HSPAP";
                break;
            case TelephonyManager.NETWORK_TYPE_HSUPA:
                temp = "HSUPA";
                break;
            case TelephonyManager.NETWORK_TYPE_IDEN:
                temp = "IDEN";
                break;
            case TelephonyManager.NETWORK_TYPE_LTE:
                temp = "LTE";
                break;
            case TelephonyManager.NETWORK_TYPE_UMTS:
                temp = "UMTS";
                break;
            case TelephonyManager.NETWORK_TYPE_UNKNOWN:
                temp = "Unknown";
                break;

            default:
        }
        if (temp != null) {
            child = createLine("Network type", temp);
            if (child != null) {
                page.addView(child);
            }
        }
        String netop = tm.getNetworkOperator();
        if (netop != null) {
            child = createLine("Network Operator", netop);
            if (child != null) {
                page.addView(child);
            }
        }
        String netopname = tm.getNetworkOperatorName();
        if (netopname != null) {
            child = createLine("Network Operator Name", netopname);
            if (child != null) {
                page.addView(child);
            }
        }

        String netcountryiso = tm.getNetworkCountryIso();
        if (netcountryiso != null) {
            child = createLine("Network country ISO", netcountryiso);
            if (child != null) {
                page.addView(child);
            }
        }
        String subscriberid = tm.getSubscriberId();
        if (subscriberid != null) {
            child = createLine("Subscriber ID", subscriberid);
            if (child != null) {
                page.addView(child);
            }
        }

        String simcountryiso = tm.getSimCountryIso();
        if (simcountryiso != null) {
            child = createLine("SIM Country ISO", simcountryiso);
            if (child != null) {
                page.addView(child);
            }
        }
        int simstate = tm.getSimState();
        temp = null;
        switch (simstate) {
            case TelephonyManager.SIM_STATE_ABSENT:
                temp = "State Absent";
                break;
            case TelephonyManager.SIM_STATE_NETWORK_LOCKED:
                temp = "Network Locked";
                break;
            case TelephonyManager.SIM_STATE_PIN_REQUIRED:
                temp = "PIN Required";
                break;
            case TelephonyManager.SIM_STATE_PUK_REQUIRED:
                temp = "PUK Required";
                break;
            case TelephonyManager.SIM_STATE_READY:
                temp = "Ready";
                break;
            case TelephonyManager.SIM_STATE_UNKNOWN:
                temp = "Unknown";
                break;

            default:
        }
        if (temp != null) {
            child = createLine("SIM State", temp);
            if (child != null) {
                page.addView(child);
            }
        }
        String simserial = tm.getSimSerialNumber();
        if (simserial != null) {
            child = createLine("SIM Serial Number", simserial);
            if (child != null) {
                page.addView(child);
            }
        }
        String simop = tm.getSimOperator();
        if (simop != null) {
            child = createLine("SIM Operator", simop);
            if (child != null) {
                page.addView(child);
            }
        }
        String simopname = tm.getSimOperatorName();
        if (simopname != null) {
            child = createLine("Sim Operator name", simopname);
            if (child != null) {
                page.addView(child);
            }
        }
        String vmalphatag = tm.getVoiceMailAlphaTag();
        if (vmalphatag != null) {
            child = createLine("VoiceMail Alpha TAG", vmalphatag);
            if (child != null) {
                page.addView(child);
            }
        }
        String vmnumber = tm.getVoiceMailNumber();
        if (vmnumber != null) {
            child = createLine("VoiceMail Number", vmnumber);
            if (child != null) {
                page.addView(child);
            }
        }
    }

    private void infoConnectivity() {
        View child = null;
        page.addView(createHeader("Connectivity"));
        ConnectivityManager cm = (ConnectivityManager) this.getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo[] networkInfo = cm.getAllNetworkInfo();
        StringBuilder sb = new StringBuilder();
        for (NetworkInfo network : networkInfo) {
            sb.setLength(0);
            sb.append("Subtype: " + network.getSubtypeName() + " ");
            sb.append("State: " + network.getDetailedState().toString() + " ");
            sb.append("Reason: " + network.getReason() + " ");
            sb.append("ExtraInfo: " + network.getExtraInfo() + " ");

            child = createLine(network.getTypeName(), sb.toString());
            if (child != null) {
                page.addView(child);
            }
        }
    }

    private void infoSensors() {
        View child = null;
        page.addView(createHeader("Sensors"));
        SensorManager sm = (SensorManager) this.getSystemService(SENSOR_SERVICE);
        List<Sensor> sensors = sm.getSensorList(Sensor.TYPE_ALL);
        StringBuilder sb = new StringBuilder();
        for (Sensor sensor : sensors) {
            sb.setLength(0);
            sb.append("Type: " + sensor.getType() + " ");
            sb.append("Version: " + sensor.getVersion() + " ");
            sb.append("Vendor: " + sensor.getVendor() + " ");
            sb.append("Power: " + sensor.getPower() + " ");
            sb.append("MinDelay: " + sensor.getMinDelay() + " ");
            sb.append("MaxRange: " + sensor.getMaximumRange() + " ");
            sb.append("Resolution: " + sensor.getResolution());
            child = createLine(sensor.getName(), sb.toString());
            if (child != null) {
                page.addView(child);
            }
        }
    }

    private void infoDisplay() {
        View child = null;
        page.addView(createHeader("Display"));
        int width = this.getResources().getDisplayMetrics().widthPixels;
        if (width > 0) {
            child = createLine("Width", String.valueOf(width));
            if (child != null) {
                page.addView(child);
            }
        }
        int height = this.getResources().getDisplayMetrics().heightPixels;
        if (height > 0) {
            child = createLine("Height", String.valueOf(height));
            if (child != null) {
                page.addView(child);
            }
        }
        float density = this.getResources().getDisplayMetrics().density;
        if (density > 0) {
            child = createLine("Density", String.valueOf(density));
            if (child != null) {
                page.addView(child);
            }
        }
        float densitydpi = this.getResources().getDisplayMetrics().densityDpi;
        if (densitydpi > 0) {
            child = createLine("Density DPI", String.valueOf(densitydpi));
            if (child != null) {
                page.addView(child);
            }
            if (densitydpi >= DisplayMetrics.DENSITY_XXHIGH) {
                child = createLine("Density DPI", "xxhdpi");
                if (child != null) {
                    page.addView(child);
                }
            } else if (densitydpi >= DisplayMetrics.DENSITY_XHIGH) {
                child = createLine("Density DPI", "xhdpi");
                if (child != null) {
                    page.addView(child);
                }
            } else if (densitydpi >= DisplayMetrics.DENSITY_HIGH) {
                child = createLine("Density DPI", "hdpi");
                if (child != null) {
                    page.addView(child);
                }
            } else if (densitydpi >= DisplayMetrics.DENSITY_MEDIUM) {
                child = createLine("Density DPI", "mdpi");
                if (child != null) {
                    page.addView(child);
                }
            } else if (densitydpi >= DisplayMetrics.DENSITY_LOW) {
                child = createLine("Density DPI", "ldpi");
                if (child != null) {
                    page.addView(child);
                }
            } else {
                child = createLine("Density DPI", "unacceptable");
                if (child != null) {
                    page.addView(child);
                }
            }
        }
        float scaledDensity = this.getResources().getDisplayMetrics().scaledDensity;
        if (scaledDensity > 0) {
            child = createLine("Scaled Density", String.valueOf(scaledDensity));
            if (child != null) {
                page.addView(child);
            }
        }
        float xdpi = this.getResources().getDisplayMetrics().xdpi;
        if (xdpi > 0) {
            child = createLine("XDPI", String.valueOf(xdpi));
            if (child != null) {
                page.addView(child);
            }
        }
        float ydpi = this.getResources().getDisplayMetrics().ydpi;
        if (ydpi > 0) {
            child = createLine("YDPI", String.valueOf(ydpi));
            if (child != null) {
                page.addView(child);
            }
        }
    }

    private void infoKernel() {
        View child = null;
        page.addView(createHeader("Kernel"));
        String bootloader = android.os.Build.BOOTLOADER;
        if (bootloader != null) {
            child = createLine("Bootloader", bootloader);
            if (child != null) {
                page.addView(child);
            }
        }
        String display = android.os.Build.DISPLAY;
        if (display != null) {
            child = createLine("Display Version", display);
            if (child != null) {
                page.addView(child);
            }
        }
        String fingerprint = android.os.Build.FINGERPRINT;
        if (fingerprint != null) {
            child = createLine("Fingerprint", fingerprint);
            if (child != null) {
                page.addView(child);
            }
        }

        String host = android.os.Build.HOST;
        if (host != null) {
            child = createLine("Host", host);
            if (child != null) {
                page.addView(child);
            }
        }
        String id = android.os.Build.ID;
        if (id != null) {
            child = createLine("ID", id);
            if (child != null) {
                page.addView(child);
            }
        }

        String serial = android.os.Build.SERIAL;
        if (serial != null) {
            child = createLine("Serial", serial);
            if (child != null) {
                page.addView(child);
            }
        }
        String tags = android.os.Build.TAGS;
        if (tags != null) {
            child = createLine("TAGS", tags);
            if (child != null) {
                page.addView(child);
            }
        }
        long time = android.os.Build.TIME;
        if (time > 0) {
            child = createLine("Time", String.valueOf(time));
            if (child != null) {
                page.addView(child);
            }
        }
        String type = android.os.Build.TYPE;
        if (type != null) {
            child = createLine("Type", type);
            if (child != null) {
                page.addView(child);
            }
        }
        String unknown = android.os.Build.UNKNOWN;
        if (unknown != null) {
            child = createLine("unknown", unknown);
            if (child != null) {
                page.addView(child);
            }
        }
        String user = android.os.Build.USER;
        if (user != null) {
            child = createLine("user", user);
            if (child != null) {
                page.addView(child);
            }
        }
        String radioversion = android.os.Build.getRadioVersion();
        if (radioversion != null) {
            child = createLine("Radioversion", radioversion);
            if (child != null) {
                page.addView(child);
            }
        }
        String codename = android.os.Build.VERSION.CODENAME;
        if (codename != null) {
            child = createLine("Codename", codename);
            if (child != null) {
                page.addView(child);
            }
        }
        String incremental = android.os.Build.VERSION.INCREMENTAL;
        if (incremental != null) {
            child = createLine("Incremental", incremental);
            if (child != null) {
                page.addView(child);
            }
        }
        String release = android.os.Build.VERSION.RELEASE;
        if (release != null) {
            child = createLine("Release", release);
            if (child != null) {
                page.addView(child);
            }
        }
        int sdkInt = android.os.Build.VERSION.SDK_INT;
        if (sdkInt > 0) {
            child = createLine("SDK INT", String.valueOf(sdkInt));
            if (child != null) {
                page.addView(child);
            }
        }
    }

    private void infoCPU() {
        View child = null;

        page.addView(createHeader("CPU/Hardware"));
        String cpu_abi = android.os.Build.CPU_ABI;
        if (cpu_abi != null) {
            child = createLine("CPU ABI", cpu_abi);
            if (child != null) {
                page.addView(child);
            }
        }
        String cpu_abi2 = android.os.Build.CPU_ABI2;
        if (cpu_abi2 != null) {
            child = createLine("CPU ABI2", cpu_abi2);
            if (child != null) {
                page.addView(child);
            }
        }
        String board = android.os.Build.BOARD;
        if (board != null) {
            child = createLine("Board", board);
            if (child != null) {
                page.addView(child);
            }
        }
        String hardware = android.os.Build.HARDWARE;
        if (hardware != null) {
            child = createLine("Hardware", hardware);
            if (child != null) {
                page.addView(child);
            }
        }
        String manufacturer = android.os.Build.MANUFACTURER;
        if (manufacturer != null) {
            child = createLine("Manufacturer", manufacturer);
            if (child != null) {
                page.addView(child);
            }
        }
        String model = android.os.Build.MODEL;
        if (model != null) {
            child = createLine("Model Name", model);
            if (child != null) {
                page.addView(child);
            }
        }
        String device = android.os.Build.DEVICE;
        if (device != null) {
            child = createLine("Device Name", device);
            if (child != null) {
                page.addView(child);
            }
        }
        String product = android.os.Build.PRODUCT;
        if (product != null) {
            child = createLine("Product Name", product);
            if (child != null) {
                page.addView(child);
            }
        }
        String brand = android.os.Build.BRAND;
        if (brand != null) {
            child = createLine("Brand", brand);
            if (child != null) {
                page.addView(child);
            }
        }
    }

    private View createHeader(String string) {
        LinearLayout child = new LinearLayout(this);
        child.setGravity(Gravity.CENTER);
        LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        int bottom = (int) this.getResources().getDimension(R.dimen.margin_box_all) * 2;
        int top = (int) this.getResources().getDimension(R.dimen.margin_box_all) * 2;
        int right = (int) this.getResources().getDimension(R.dimen.margin_box_all);
        int left = (int) this.getResources().getDimension(R.dimen.margin_box_all);
        params.setMargins(left, top, right, bottom);

        TextView tv1 = new TextView(this);
        tv1.setText(string);
        tv1.setTextAppearance(this, R.style.textView_Bigger_Cap);
        child.addView(tv1, params);
        return child;

    }

    private View createLine(String name, String content) {
        LinearLayout child = new LinearLayout(this);
        // child.setGravity(Gravity.CENTER);
        LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        int bottom = (int) this.getResources().getDimension(R.dimen.margin_box_all);
        int top = (int) this.getResources().getDimension(R.dimen.margin_box_all);
        int right = (int) this.getResources().getDimension(R.dimen.margin_box_all);
        int left = (int) this.getResources().getDimension(R.dimen.margin_box_all);

        params.setMargins(left, top, right, bottom);
        TextView tv1 = new TextView(this);
        tv1.setText(name);
        tv1.setTextAppearance(this, R.style.textView_Cap);
        tv1.setTextColor(Color.CYAN);
        tv1.setWidth((int) this.getResources().getDimension(R.dimen.name_width));
        // tv1.setGravity(Gravity.CENTER);
        TextView tv2 = new TextView(this);
        tv2.setText(content);
        tv2.setTextAppearance(this, R.style.textView);
        // tv2.setGravity(Gravity.CENTER);
        child.addView(tv1, params);
        child.addView(tv2, params);
        return child;
    }
}
