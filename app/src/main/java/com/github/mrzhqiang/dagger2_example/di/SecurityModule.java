package com.github.mrzhqiang.dagger2_example.di;

import javax.inject.Singleton;

import cn.mrzhqiang.security.crypto.factory.PasswordEncoderFactories;
import cn.mrzhqiang.security.crypto.password.PasswordEncoder;
import dagger.Module;
import dagger.Provides;

@Module
final class SecurityModule {

    @Singleton
    @Provides
    PasswordEncoder providePasswordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
