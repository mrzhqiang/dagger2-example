package com.github.mrzhqiang.dagger2_example.data.source.local;

import com.github.mrzhqiang.dagger2_example.account.Account;
import com.github.mrzhqiang.dagger2_example.data.DataSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class AccountLocalDataSource implements DataSource<String, Account> {

    private final Map<String, Account> local = new ConcurrentHashMap<>();

    @Override
    public List<Account> findAll() {
        return new ArrayList<>(local.values());
    }

    @Override
    public Optional<Account> findBy(String id) {
        return Optional.ofNullable(local.get(id));
    }

    @Override
    public boolean save(Account data) {
        local.put(data.getUsername(), data);
        return true;
    }

    @Override
    public boolean deleteAll() {
        local.clear();
        return true;
    }

    @Override
    public boolean deleteBy(String id) {
        local.remove(id);
        return true;
    }
}
