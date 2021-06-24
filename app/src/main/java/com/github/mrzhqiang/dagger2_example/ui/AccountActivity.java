package com.github.mrzhqiang.dagger2_example.ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mrzhqiang.dagger2_example.DaggerApplication;
import com.github.mrzhqiang.dagger2_example.R;
import com.github.mrzhqiang.dagger2_example.account.Account;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        Account firstAccount = DaggerApplication.ofComponent(this).account();
        ((TextView) findViewById(R.id.first_account)).setText(firstAccount.toString());
        Account secondAccount = DaggerApplication.ofComponent(this).account();
        ((TextView) findViewById(R.id.second_account)).setText(secondAccount.toString());

        Log.i("Account", "first equals second: " + firstAccount.equals(secondAccount));
    }
}