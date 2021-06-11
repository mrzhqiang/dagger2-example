package com.github.mrzhqiang.dagger2_example;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mrzhqiang.dagger2_example.account.Account;
import com.github.mrzhqiang.dagger2_example.di.ActivityComponent;
import com.github.mrzhqiang.dagger2_example.di.DaggerActivityComponent;
import com.google.gson.Gson;

import javax.inject.Inject;

import cn.mrzhqiang.security.crypto.password.PasswordEncoder;

public class MainActivity extends AppCompatActivity {

    @Inject
    Account account;
    @Inject
    PasswordEncoder passwordEncoder;
    @Inject
    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityComponent component = DaggerActivityComponent.create();
        component.inject(this);

        TextView contentText = findViewById(R.id.content_text);
        String content = String.format("username: %s, password: %s, encodePassword: %s",
                account.username,
                account.password,
                passwordEncoder.encode(account.password));
        contentText.setText(content);

        String account = gson.toJson(component.account());
        SharedPreferences preferences = getSharedPreferences("account", Context.MODE_PRIVATE);
        preferences.edit().putString("current", account).apply();

        String current = preferences.getString("current", null);
        if (current != null) {
            Account currentAccount = gson.fromJson(current, Account.class);
            Log.i("account", "account is equals: " + this.account.equals(currentAccount));
        }
    }
}