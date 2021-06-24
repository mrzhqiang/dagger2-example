package com.github.mrzhqiang.dagger2_example.di;

import com.github.mrzhqiang.dagger2_example.ui.MainActivity;
import com.github.mrzhqiang.dagger2_example.account.Account;

import dagger.Component;

@ActivityScoped
@Component(modules = {AccountModule.class})
public interface ActivityComponent {

    Account account();

    void inject(MainActivity activity);
}