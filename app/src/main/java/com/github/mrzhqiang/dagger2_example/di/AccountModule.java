package com.github.mrzhqiang.dagger2_example.di;

import cn.mrzhqiang.security.crypto.factory.PasswordEncoderFactories;
import cn.mrzhqiang.security.crypto.password.PasswordEncoder;
import com.github.mrzhqiang.dagger2_example.account.Account;
import dagger.Module;
import dagger.Provides;

@Module final class AccountModule {
  @Provides Account provideAccount() {
    return new Account();
  }

  @Provides PasswordEncoder providePasswordEncoder() {
    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }
}
