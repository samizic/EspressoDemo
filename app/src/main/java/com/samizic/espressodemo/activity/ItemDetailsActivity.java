package com.samizic.espressodemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.samizic.espressodemo.R;

public class ItemDetailsActivity extends Activity {

    public static final String ITEM_NAME = "ITEM_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_item_details);

        String itemName = getIntent().getExtras().getString(ITEM_NAME);

        setTitle(itemName + " Details");

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(itemName);
    }
}
