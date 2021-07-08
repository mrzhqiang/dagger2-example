package com.github.mrzhqiang.dagger2_example.data.source;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Qualifier
@Retention(RUNTIME)
public @interface RemoteDataSource {
}
