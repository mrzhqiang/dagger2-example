package com.github.mrzhqiang.dagger2_example.account;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.Date;

@Entity(tableName = "account")
public class Account {

    @PrimaryKey(autoGenerate = true)
    private Long id;

    @NonNull
    @ColumnInfo(index = true)
    private String username;
    @NonNull
    private String password;
    @NonNull
    private Date created;
    @NonNull
    private Date updated;

    public Account(@NonNull String username, @NonNull String password,
                   @NonNull Date created, @NonNull Date updated) {
        this.username = username;
        this.password = password;
        this.created = created;
        this.updated = updated;
    }

    public static Account of(@NonNull String username, @NonNull String password) {
        return new Account(username, password, new Date(), new Date());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    @NonNull
    public Date getCreated() {
        return created;
    }

    public void setCreated(@NonNull Date created) {
        this.created = created;
    }

    @NonNull
    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(@NonNull Date updated) {
        this.updated = updated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equal(id, account.id)
                && Objects.equal(username, account.username)
                && Objects.equal(password, account.password)
                && Objects.equal(created, account.created)
                && Objects.equal(updated, account.updated);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, username, password, created, updated);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("username", username)
                .add("password", password)
                .add("created", created)
                .add("updated", updated)
                .toString();
    }

}