package com.github.mrzhqiang.dagger2_example.di;

import com.github.mrzhqiang.dagger2_example.MainActivity;
import dagger.Component;

@Component
public interface ActivityComponent {
  void inject(MainActivity activity);
}
