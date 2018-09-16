package edu.sitengvirginia.androidminiapp;

//used idea from https://developer.android.com/guide/topics/ui/floating-action-button


import java.text.ParseException;
import java.text.SimpleDateFormat;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.content.Intent;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

public class BucketListActivity extends AppCompatActivity {

    private FloatingActionButton myButton;
    RecyclerView rvItems;
    ArrayList<BucketItem> myList;
    private Snackbar snackbar;
    static final int req_code = 1;
    BucketListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myList = BucketItem.createInitialBucketList();


        myButton = findViewById(R.id.button);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                snackbar.make(view, "New item added", snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Intent add_intent = new Intent(BucketListActivity.this, AddItemActivity.class);
                startActivityForResult(add_intent, req_code);

            }
        });


        Log.e("test", Integer.toString(myList.size()));
        rvItems = (RecyclerView) findViewById(R.id.rvItems);
        adapter = new BucketListAdapter(this, myList);
        rvItems.setAdapter(adapter);
        rvItems.setLayoutManager(new LinearLayoutManager(this));

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == 1) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                String name = data.getStringExtra("name");
                Log.e("test", name);
                String description = data.getStringExtra("description");
                String latitude = data.getStringExtra("latitude");
                String longitude = data.getStringExtra("longitude");
                String date = data.getStringExtra("date");
                BucketItem b = BucketItem.createBucketItem(name, description, latitude, longitude,date);

                int l = 0;
                for (int i = 0; i < myList.size(); i++) {
                    try {
                        l += BucketItem.compareTo(myList.get(i).getMdate(), date);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

                myList.add(l, b);
                Log.e("test2", name);
                adapter.notifyDataSetChanged();
            }
        }
        if (requestCode == 2) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {

                String name = data.getStringExtra("name");
                Log.e("test", name);
                String description = data.getStringExtra("description");
                String latitude = data.getStringExtra("latitude");
                String longitude = data.getStringExtra("longitude");
                String date = data.getStringExtra("date");
                int position = data.getIntExtra("position", 0);
                BucketItem b = BucketItem.editBucketItem(myList.get(position), name, description, latitude, longitude, date);
                myList.remove(myList.get(position));
                int l = 0;
                for (int i = 0; i < myList.size(); i++) {
                    try {
                        l += BucketItem.compareTo(myList.get(i).getMdate(), date);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

                myList.add(l, b);
                Log.e("test2", name);
                adapter.notifyDataSetChanged();
            }
        }
    }


}