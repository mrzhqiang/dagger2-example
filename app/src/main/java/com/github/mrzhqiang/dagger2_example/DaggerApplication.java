package com.github.mrzhqiang.dagger2_example;

import android.app.Application;
import android.content.Context;

import com.github.mrzhqiang.dagger2_example.di.AppComponent;
import com.github.mrzhqiang.dagger2_example.di.AppModule;
import com.github.mrzhqiang.dagger2_example.di.DaggerAppComponent;

public final class DaggerApplication extends Application {

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        this.component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static AppComponent ofComponent(Context context) {
        return ((DaggerApplication) context.getApplicationContext()).component;
    }
}
