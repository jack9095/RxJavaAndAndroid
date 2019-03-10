package com.kuanquan.testdemo.app;

import android.app.Application;
import android.support.multidex.MultiDex;

import com.fly.kuanquan.EventBusIndex;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Administrator on 2019/2/16.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        EventBus.builder().addIndex(new EventBusIndex()).installDefaultEventBus();

    }
}
