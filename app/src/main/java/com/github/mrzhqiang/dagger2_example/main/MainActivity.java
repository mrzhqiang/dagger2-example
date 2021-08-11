package com.github.mrzhqiang.dagger2_example.main;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mrzhqiang.dagger2_example.DaggerApplication;
import com.github.mrzhqiang.dagger2_example.R;
import com.github.mrzhqiang.dagger2_example.account.Account;
import com.github.mrzhqiang.dagger2_example.account.AccountDao;

import java.util.List;

import javax.inject.Inject;

public final class MainActivity extends AppCompatActivity {

    @Inject
    AccountDao accountDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerApplication.ofComponent(this).inject(this);

        TextView contentText = findViewById(R.id.content_text);
        AsyncTask.execute(() -> {
            accountDao.insert(Account.of("aaaa", "123456"));
            accountDao.insert(Account.of("bbbb", "123456"));
            List<Account> list = accountDao.findAll();
            runOnUiThread(() -> contentText.setText(list.toString()));
        });

//        startActivity(new Intent(this, AccountActivity.class));
    }
}