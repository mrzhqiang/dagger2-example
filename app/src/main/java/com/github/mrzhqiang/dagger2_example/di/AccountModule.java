package com.github.mrzhqiang.dagger2_example.di;

import com.github.mrzhqiang.dagger2_example.account.Account;
import com.github.mrzhqiang.dagger2_example.account.User;
import dagger.Module;
import dagger.Provides;

@Module final class AccountModule {
  @Provides Account account(User user) {
    return new Account(user);
  }
}
