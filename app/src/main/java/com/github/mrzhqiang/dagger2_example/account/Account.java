package com.github.mrzhqiang.dagger2_example.account;

import androidx.annotation.NonNull;

public class Account {
  public String username;
  public String password;

  public Account() {
    this.username = "fssd";
    this.password = "123456";
  }

  @NonNull
  @Override public String toString() {
    return "Account{" +
        "username='" + username + '\'' +
        ", password='" + password + '\'' +
        '}';
  }
}
