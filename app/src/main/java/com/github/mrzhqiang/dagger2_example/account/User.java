package com.github.mrzhqiang.dagger2_example.account;

import androidx.annotation.NonNull;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Inject;

public class User {
  public Integer id;
  public String name;
  public String sex;
  public String mail;
  public String address;

  private static AtomicInteger ID_GENERATE = new AtomicInteger(0);

  @Inject
  public User() {
    this.id = ID_GENERATE.incrementAndGet();
    this.name = "用户" + id;
    this.sex = id % 2 == 0 ? "男" : "女";
    this.mail = String.format("%s@qq.com", 10000 + Math.random() * 90000);
    this.address = "";
  }

  @NonNull
  @Override public String toString() {
    return "User{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", sex='" + sex + '\'' +
        ", mail='" + mail + '\'' +
        ", address='" + address + '\'' +
        '}';
  }
}
