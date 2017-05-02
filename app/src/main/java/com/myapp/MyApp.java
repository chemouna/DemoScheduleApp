package com.myapp;

import android.app.Application;
import com.myapp.data.ScheduleManager;

public class MyApp extends Application {

    private ScheduleManager scheduleManager;

    @Override
    public void onCreate() {
        super.onCreate();
        scheduleManager = new ScheduleManager(getApplicationContext());
    }

    public ScheduleManager getScheduleManager() {
        return scheduleManager;
    }
}
