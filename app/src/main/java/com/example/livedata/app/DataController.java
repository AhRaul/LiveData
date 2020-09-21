package com.example.livedata.app;

import android.app.Application;

public class DataController extends Application {

    private static DataController instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static DataController getInstance() {
        return instance;
    }
}
