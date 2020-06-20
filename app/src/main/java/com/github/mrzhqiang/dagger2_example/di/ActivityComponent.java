package com.github.mrzhqiang.dagger2_example.di;

import com.github.mrzhqiang.dagger2_example.MainActivity;
import dagger.Component;

@Component(modules = AccountModule.class)
interface ActivityComponent {
  void inject(MainActivity activity);
}
