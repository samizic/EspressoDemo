package com.samizic.espressodemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.samizic.espressodemo.R;
import com.samizic.espressodemo.pojo.CustomObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdapterActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_adapter_example);

        ListView listView = (ListView) findViewById(R.id.list_view);

        final List<CustomObject> listOfObjects = new ArrayList<CustomObject>(10);

        for(int i=0; i<10; i++) {
            listOfObjects.add(new CustomObject(i));
        }

        listView.setAdapter(new ArrayAdapter<CustomObject>(this, android.R.layout.simple_list_item_1, listOfObjects));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CustomObject clickedItem = (CustomObject) parent.getItemAtPosition(position);
                Intent intent = new Intent(AdapterActivity.this, ItemDetailsActivity.class);
                intent.putExtra(ItemDetailsActivity.ITEM_NAME, clickedItem.getTitle());
                startActivity(intent);
            }
        });
    }
}
