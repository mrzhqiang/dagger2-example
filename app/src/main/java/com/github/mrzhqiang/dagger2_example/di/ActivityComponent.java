package com.github.mrzhqiang.dagger2_example.di;

import com.github.mrzhqiang.dagger2_example.MainActivity;
import com.github.mrzhqiang.dagger2_example.account.Account;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AccountModule.class)
public interface ActivityComponent {

    Account account();

    void inject(MainActivity activity);
}