package com.github.mrzhqiang.dagger2_example.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.github.mrzhqiang.dagger2_example.account.Account;
import com.github.mrzhqiang.dagger2_example.account.AccountDao;

@Database(entities = {
        Account.class,
}, version = 1, exportSchema = false)
@TypeConverters(DatabaseTypeConverters.class)
public abstract class ExampleDatabase extends RoomDatabase {

    public abstract AccountDao accountDao();
}
