package com.github.mrzhqiang.dagger2_example.di;

import com.github.mrzhqiang.dagger2_example.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        JsonModule.class,
        SecurityModule.class,
        SharePreferencesModule.class})
public interface AppComponent {

    void inject(MainActivity activity);

}