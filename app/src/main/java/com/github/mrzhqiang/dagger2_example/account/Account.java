package com.github.mrzhqiang.dagger2_example.account;

import androidx.annotation.NonNull;
import java.util.Date;
import javax.inject.Inject;

public class Account {
  public String username;
  public String password;

  @Inject
  public Date current;

  @Inject
  public Account() {
    this.username = "fssd";
    this.password = "123456";
  }

  @NonNull
  @Override public String toString() {
    return "Account{" +
        "username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", current=" + current +
        '}';
  }
}
