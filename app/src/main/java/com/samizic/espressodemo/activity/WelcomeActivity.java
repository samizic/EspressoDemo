package com.samizic.espressodemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.samizic.espressodemo.R;

public class WelcomeActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_welcome);

        String username = getIntent().getExtras().getString("username");

        TextView textView = (TextView) findViewById(R.id.welcome_text);

        textView.setText("Welcome " + username);

    }
}
