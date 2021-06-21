package com.github.mrzhqiang.dagger2_example.di;

import com.github.mrzhqiang.dagger2_example.account.Account;
import com.google.gson.Gson;

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

    @ActivityScoped
    @Provides
    Gson provideGson() {
        return new Gson();
    }
}