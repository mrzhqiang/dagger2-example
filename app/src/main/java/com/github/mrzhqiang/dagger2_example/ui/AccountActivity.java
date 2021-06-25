package com.github.mrzhqiang.dagger2_example.ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mrzhqiang.dagger2_example.DaggerApplication;
import com.github.mrzhqiang.dagger2_example.R;
import com.github.mrzhqiang.dagger2_example.account.Account;
import com.github.mrzhqiang.dagger2_example.di.ActivityComponent;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.inject.Named;

public class AccountActivity extends AppCompatActivity {

    @Inject
    @Named("pretty")
    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        ActivityComponent component = DaggerApplication.ofComponent(this);
        component.inject(this);

        Account firstAccount = component.account();
        ((TextView) findViewById(R.id.first_account)).setText(firstAccount.toString());
        Account secondAccount = component.account();
        ((TextView) findViewById(R.id.second_account)).setText(secondAccount.toString());

        Log.i("Account", "first equals second: " + firstAccount.equals(secondAccount));

        Log.i("Account", "first account: " + gson.toJson(firstAccount));
        Log.i("Account", "second account: " + gson.toJson(secondAccount));
    }
}