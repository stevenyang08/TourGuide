package com.example.android.tourguide;

import android.app.Application;
import android.content.Context;

/**
 * Created by stevenyang on 3/9/17.
 */


public class ThisApplication extends Application {
    private static Context mContext;
    @Override
    public void onCreate() {
        mContext = this;
        super.onCreate();
    }

    public static Context getContext() {
        return mContext;
    }
}