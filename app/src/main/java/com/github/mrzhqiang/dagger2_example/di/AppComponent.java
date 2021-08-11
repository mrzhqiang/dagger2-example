package com.github.mrzhqiang.dagger2_example.di;

import com.github.mrzhqiang.dagger2_example.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(MainActivity activity);
}
