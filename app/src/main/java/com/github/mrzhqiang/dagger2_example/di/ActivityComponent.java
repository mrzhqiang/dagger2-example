package com.github.mrzhqiang.dagger2_example.di;

import com.github.mrzhqiang.dagger2_example.account.AccountActivity;
import com.github.mrzhqiang.dagger2_example.account.AccountModule;

import dagger.Component;

@ActivityScoped
@Component(modules = {AccountModule.class})
public interface ActivityComponent {

    void inject(AccountActivity activity);
}