package com.github.mrzhqiang.dagger2_example.di;

import com.github.mrzhqiang.dagger2_example.account.Account;
import com.github.mrzhqiang.dagger2_example.data.DataSource;
import com.github.mrzhqiang.dagger2_example.data.source.LocalDataSource;
import com.github.mrzhqiang.dagger2_example.data.source.RemoteDataSource;
import com.github.mrzhqiang.dagger2_example.data.source.local.AccountLocalDataSource;
import com.github.mrzhqiang.dagger2_example.data.source.remote.AccountRemoteDataSource;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Named;

import cn.mrzhqiang.security.crypto.factory.PasswordEncoderFactories;
import cn.mrzhqiang.security.crypto.password.PasswordEncoder;
import dagger.Module;
import dagger.Provides;

@Module
final class AccountModule {

    @ActivityScoped
    @Provides
    Account provideAccount() {
        return new Account();
    }

    @ActivityScoped
    @Provides
    PasswordEncoder providePasswordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    //    @ActivityScoped
    @Provides
    Gson provideGson() {
        return new Gson();
    }

    @Named("pretty")
    @Provides
    Gson providePrettyGson() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    @RemoteDataSource
    @Provides
    DataSource<String, Account> provideRemoteAccountDataSource() {
        AccountRemoteDataSource source = new AccountRemoteDataSource();
        source.save(new Account());
        source.save(new Account());
        source.save(new Account());
        source.save(new Account());
        source.save(new Account());
        return source;
    }

    @LocalDataSource
    @Provides
    DataSource<String, Account> provideLocalAccountDataSource() {
        return new AccountLocalDataSource();
    }
}