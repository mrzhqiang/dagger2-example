package com.github.mrzhqiang.dagger2_example.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mrzhqiang.dagger2_example.DaggerApplication;
import com.github.mrzhqiang.dagger2_example.R;
import com.github.mrzhqiang.dagger2_example.account.Account;
import com.github.mrzhqiang.dagger2_example.di.ActivityComponent;
import com.google.gson.Gson;

import javax.inject.Inject;

import cn.mrzhqiang.security.crypto.password.PasswordEncoder;

public class MainActivity extends AppCompatActivity {

    @Inject
    PasswordEncoder passwordEncoder;
    @Inject
    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityComponent component = DaggerApplication.ofComponent(this);
        component.inject(this);

        SharedPreferences preferences = getSharedPreferences("account", Context.MODE_PRIVATE);
        String accountJson = preferences.getString("current", null);
        Account account;
        if (accountJson != null) {
            account = gson.fromJson(accountJson, Account.class);
        } else {
            account = component.account();
            preferences.edit().putString("current", gson.toJson(account)).apply();
        }

        TextView contentText = findViewById(R.id.content_text);
        String content = String.format("username: %s, password: %s, encodePassword: %s",
                account.username,
                account.password,
                passwordEncoder.encode(account.password));
        contentText.setText(content);

        startActivity(new Intent(this, AccountActivity.class));
    }
}