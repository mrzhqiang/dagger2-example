package com.github.mrzhqiang.dagger2_example.di;

import com.github.mrzhqiang.dagger2_example.account.Account;
import com.google.gson.Gson;

import javax.inject.Singleton;

import cn.mrzhqiang.security.crypto.factory.PasswordEncoderFactories;
import cn.mrzhqiang.security.crypto.password.PasswordEncoder;
import dagger.Module;
import dagger.Provides;

@Module
final class AccountModule {

    @Provides
    Account provideAccount() {
        return new Account();
    }

    @Singleton
    @Provides
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Singleton
    @Provides
    Gson gson() {
        return new Gson();
    }
}