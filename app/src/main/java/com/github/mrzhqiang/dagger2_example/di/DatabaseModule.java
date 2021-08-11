package com.github.mrzhqiang.dagger2_example.di;

import android.content.Context;

import androidx.room.Room;

import com.github.mrzhqiang.dagger2_example.account.AccountDao;
import com.github.mrzhqiang.dagger2_example.db.ExampleDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
final class DatabaseModule {

    private static final String DATABASE_NAME = "example";

    @Singleton
    @Provides
    static ExampleDatabase provideDatabase(Context context) {
        return Room.databaseBuilder(context, ExampleDatabase.class, DATABASE_NAME).build();
    }

    @Singleton
    @Provides
    static AccountDao provideAccountDao(ExampleDatabase db) {
        return db.accountDao();
    }
}
