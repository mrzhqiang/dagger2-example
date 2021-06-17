package com.github.mrzhqiang.dagger2_example.di;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
final class SharePreferencesModule {

    private final Context context;

    SharePreferencesModule(Context context) {
        this.context = context.getApplicationContext();
    }

    @Singleton
    @Provides
    SharedPreferences provideSharePreferences() {
        return context.getSharedPreferences("dagger2", Context.MODE_PRIVATE);
    }
}