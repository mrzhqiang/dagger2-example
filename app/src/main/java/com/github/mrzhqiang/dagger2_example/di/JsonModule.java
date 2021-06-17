package com.github.mrzhqiang.dagger2_example.di;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
final class JsonModule {

    @Singleton
    @Provides
    Gson provideGson() {
        return new Gson();
    }
}
