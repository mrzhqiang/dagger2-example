package com.github.mrzhqiang.dagger2_example.account;

import com.github.mrzhqiang.dagger2_example.data.DataSource;
import com.github.mrzhqiang.dagger2_example.data.LocalDataSource;
import com.github.mrzhqiang.dagger2_example.data.RemoteDataSource;
import com.github.mrzhqiang.dagger2_example.di.ActivityScoped;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Named;

import cn.mrzhqiang.security.crypto.factory.PasswordEncoderFactories;
import cn.mrzhqiang.security.crypto.password.PasswordEncoder;
import dagger.Module;
import dagger.Provides;

@Module
public final class AccountModule {

    @ActivityScoped
    @Provides
    static PasswordEncoder providePasswordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    //    @ActivityScoped
    @Provides
    static Gson provideGson() {
        return new Gson();
    }

    @Named("pretty")
    @Provides
    static Gson providePrettyGson() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    @RemoteDataSource
    @Provides
    static DataSource<String, Account> provideRemoteAccountDataSource() {
        return new AccountRemoteDataSource();
    }

    @LocalDataSource
    @Provides
    static DataSource<String, Account> provideLocalAccountDataSource() {
        return new AccountLocalDataSource();
    }
}