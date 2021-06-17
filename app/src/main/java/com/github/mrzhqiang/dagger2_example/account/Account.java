package com.github.mrzhqiang.dagger2_example.account;

import androidx.annotation.NonNull;

import java.util.Objects;

public class Account {

    private static final String NUMBER = "1234567890";

    public String username;
    public String password;

    public Account() {
        this.username = randomNumber(4);
        this.password = randomNumber(6);
    }

    private String randomNumber(int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(NUMBER.charAt((int) (Math.random() * NUMBER.length())));
        }
        return builder.toString();
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