package com.github.mrzhqiang.dagger2_example.di;

import com.github.mrzhqiang.dagger2_example.account.Account;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
final class AccountModule {

    @Singleton
    @Provides
    Account provideAccount() {
        return new Account();
    }

}