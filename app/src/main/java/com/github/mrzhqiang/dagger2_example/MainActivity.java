package com.github.mrzhqiang.dagger2_example;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.github.mrzhqiang.dagger2_example.account.Account;
import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

  @Inject
  Account account;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    TextView contentText = findViewById(R.id.content_text);
    contentText.setText(account.toString());
  }
}