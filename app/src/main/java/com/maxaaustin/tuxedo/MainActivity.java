package com.maxaaustin.tuxedo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String username;
    private TextView mainUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainUsername = (TextView) findViewById(R.id.main_username);
        username = getIntent().getStringExtra("username");
        mainUsername.setText(username);
    }
}
