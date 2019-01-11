package com.demo.livedatawithwebservice;

import com.facebook.stetho.Stetho;

import android.app.Application;
import android.content.Context;

/**
 * Created by devanshramen on 16/12/2017.
 */

public class MApplication extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        context = getApplicationContext();
    }
}