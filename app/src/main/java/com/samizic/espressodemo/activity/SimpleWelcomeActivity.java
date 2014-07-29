package com.samizic.espressodemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.samizic.espressodemo.R;

public class SimpleWelcomeActivity extends Activity {

    private EditText _username;
    private Button _btnSayHello;
    private TextView _welcome_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_simple_welcome);

        _username = (EditText) findViewById(R.id.editText_username);
        _btnSayHello = (Button) findViewById(R.id.btn_say_hello);
        _welcome_message = (TextView) findViewById(R.id.welcome_text);

        _welcome_message.setVisibility(View.GONE);

        _btnSayHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = _username.getText().toString();

                if(TextUtils.isEmpty(name)){
                    _welcome_message.setText("");
                    _welcome_message.setVisibility(View.GONE);
                }
                else{
                    _welcome_message.setText("Welcome " + name);
                    _welcome_message.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}
