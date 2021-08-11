package com.github.mrzhqiang.dagger2_example.account;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mrzhqiang.dagger2_example.R;
import com.github.mrzhqiang.dagger2_example.di.ActivityComponent;
import com.github.mrzhqiang.dagger2_example.di.DaggerActivityComponent;

import java.util.List;

import javax.inject.Inject;

public final class AccountActivity extends AppCompatActivity {

    @Inject
    AccountDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        ActivityComponent component = DaggerActivityComponent.create();
        component.inject(this);

        List<Account> all = dataSource.findAll();
        ((TextView) findViewById(R.id.first_account)).setText(all.get(0).toString());
        ((TextView) findViewById(R.id.second_account)).setText(all.get(1).toString());

        Log.i("Account", "all account: " + all);
    }
}