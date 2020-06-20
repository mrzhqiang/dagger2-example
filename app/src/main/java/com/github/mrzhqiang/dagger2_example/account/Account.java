package com.github.mrzhqiang.dagger2_example.account;

import androidx.annotation.NonNull;

public class Account {
  public String username;
  public String password;

  private final User user;

  public Account(User user) {
    this.username = "fssd";
    this.password = "123456";
    this.user = user;
  }

  @NonNull
  @Override public String toString() {
    return "Account{" +
        "username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", user=" + user +
        '}';
  }
}
