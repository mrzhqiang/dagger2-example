package com.github.mrzhqiang.dagger2_example;

import android.app.Application;
import android.content.Context;

import com.github.mrzhqiang.dagger2_example.di.ActivityComponent;
import com.github.mrzhqiang.dagger2_example.di.DaggerActivityComponent;

public class DaggerApplication extends Application {

    private ActivityComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerActivityComponent.create();
    }

    public static ActivityComponent ofComponent(Context context) {
        return ((DaggerApplication) context.getApplicationContext()).component;
    }
}
