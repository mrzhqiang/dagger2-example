package com.github.mrzhqiang.dagger2_example.account;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
import java.util.Optional;

@Dao
public interface AccountDao {

    @Query("SELECT * FROM account")
    List<Account> findAll();

    @Query("SELECT * FROM account WHERE id = :id")
    Optional<Account> findById(Long id);

    @Query("SELECT * FROM account WHERE username = :username")
    Optional<Account> findByUsername(String username);

    @Insert
    long insert(Account account);

    @Update
    void update(Account account);

    @Delete
    void delete(Account account);

    @Query("DELETE from account")
    void deleteAll();
}
