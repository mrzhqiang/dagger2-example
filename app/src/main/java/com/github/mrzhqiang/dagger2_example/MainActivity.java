package com.github.mrzhqiang.dagger2_example;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import cn.mrzhqiang.security.crypto.password.PasswordEncoder;
import com.github.mrzhqiang.dagger2_example.account.Account;
import com.github.mrzhqiang.dagger2_example.di.DaggerActivityComponent;
import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

  @Inject Account account;
  @Inject PasswordEncoder passwordEncoder;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    DaggerActivityComponent.create().inject(this);

    TextView contentText = findViewById(R.id.content_text);
    String content = String.format("username: %s, password: %s, encodePassword: %s",
        account.username,
        account.password,
        passwordEncoder.encode(account.password));
    contentText.setText(content);
  }
}