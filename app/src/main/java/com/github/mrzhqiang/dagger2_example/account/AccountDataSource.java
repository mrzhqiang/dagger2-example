package com.github.mrzhqiang.dagger2_example.account;

import com.github.mrzhqiang.dagger2_example.data.DataSource;
import com.github.mrzhqiang.dagger2_example.data.LocalDataSource;
import com.github.mrzhqiang.dagger2_example.data.RemoteDataSource;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

final class AccountDataSource implements DataSource<String, Account> {

    @LocalDataSource
    @Inject
    DataSource<String, Account> local;

    @RemoteDataSource
    @Inject
    DataSource<String, Account> remote;

    @Inject
    public AccountDataSource() {
    }

    @Override
    public List<Account> findAll() {
        return findAll(false);
    }

    public List<Account> findAll(boolean forceRemote) {
        List<Account> accounts = local.findAll();
        if (forceRemote || accounts.isEmpty()) {
            local.deleteAll();
            accounts.clear();
            remote.findAll().forEach(account -> {
                local.save(account);
                accounts.add(account);
            });
        }
        return accounts;
    }

    @Override
    public Optional<Account> findBy(String id) {
        Optional<Account> optional = local.findBy(id);
        if (!optional.isPresent()) {
            optional = remote.findBy(id);
            optional.ifPresent(local::save);
        }
        return optional;
    }

    @Override
    public boolean save(Account data) {
        // 如果保存到远端成功，但保存到本地失败，这没有关系
        // 在 findById 时，发现本地不存在会自动从远端获取，然后存到本地
        // 但 findAll 无法甄别异常，必须调用 findAll(true) 来强制刷新本地数据
        return remote.save(data) && local.save(data);
    }

    @Override
    public boolean deleteAll() {
        return remote.deleteAll() && local.deleteAll();
    }

    @Override
    public boolean deleteBy(String id) {
        return remote.deleteBy(id) && local.deleteBy(id);
    }
}
