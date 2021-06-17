package com.github.mrzhqiang.dagger2_example;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mrzhqiang.dagger2_example.account.Account;
import com.google.gson.Gson;

import javax.inject.Inject;

import cn.mrzhqiang.security.crypto.password.PasswordEncoder;

public class MainActivity extends AppCompatActivity {

    @Inject
    PasswordEncoder passwordEncoder;
    @Inject
    Gson gson;
    @Inject
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String accountJson = preferences.getString("account", null);
        if (accountJson != null) {
            Account account = gson.fromJson(accountJson, Account.class);
            TextView contentText = findViewById(R.id.content_text);
            String content = String.format("username: %s, password: %s, encodePassword: %s",
                    account.username,
                    account.password,
                    passwordEncoder.encode(account.password));
            contentText.setText(content);
        }
    }
}