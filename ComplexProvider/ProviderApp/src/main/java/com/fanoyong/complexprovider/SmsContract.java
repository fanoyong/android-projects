package com.fanoyong.complexprovider;

import android.net.Uri;
import android.provider.BaseColumns;

public class SmsContract {

    public static final String AUTHORITY = "com.samsung.complexprovider";

    private SmsContract() {}

    protected interface SmsColumns extends BaseColumns {
        Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/sms");
        String ADDRESS = "address";
        String BODY = "body";
    }
}
