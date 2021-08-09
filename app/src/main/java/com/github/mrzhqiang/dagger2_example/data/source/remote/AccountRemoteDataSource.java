package com.github.mrzhqiang.dagger2_example.data.source.remote;

import com.github.mrzhqiang.dagger2_example.account.Account;
import com.github.mrzhqiang.dagger2_example.data.DataSource;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class AccountRemoteDataSource implements DataSource<String, Account> {
    private static final long DELAY = TimeUnit.SECONDS.toMillis(2);

    private final Map<String, Account> remoteAccount = new LinkedHashMap<>();

    @Override
    public List<Account> findAll() {
        delay();
        return new ArrayList<>(remoteAccount.values());
    }

    @Override
    public Optional<Account> findBy(String id) {
        delay();
        return Optional.ofNullable(remoteAccount.get(id));
    }

    @Override
    public boolean save(Account data) {
        delay();
        remoteAccount.put(data.getUsername(), data);
        return true;
    }

    @Override
    public boolean deleteAll() {
        delay();
        remoteAccount.clear();
        return true;
    }

    @Override
    public boolean deleteBy(String id) {
        delay();
        remoteAccount.remove(id);
        return true;
    }

    private void delay() {
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException ignore) {
        }
    }
}
