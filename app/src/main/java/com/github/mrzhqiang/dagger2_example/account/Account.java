package com.github.mrzhqiang.dagger2_example.account;

import androidx.annotation.NonNull;

import java.util.Objects;

public class Account {

    public String username;
    public String password;

    public Account() {
        this.username = "fssd";
        this.password = "123456";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(username, account.username) &&
                Objects.equals(password, account.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    @NonNull
    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}