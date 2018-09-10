package edu.sitengvirginia.androidminiapp;

//used idea from https://developer.android.com/guide/topics/ui/floating-action-button


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.FloatingActionButton;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class BucketListActivity extends AppCompatActivity {

    private FloatingActionButton myButton;
    RecyclerView rvItems;
    ArrayList<BucketItem> myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButton = findViewById(R.id.button);
        myList = BucketItem.createInitialBucketList();
        Log.e("test", Integer.toString(myList.size()));
        rvItems = (RecyclerView) findViewById(R.id.rvItems);
        BucketListAdapter adapter = new BucketListAdapter(this, myList);
        rvItems.setAdapter(adapter);
        rvItems.setLayoutManager(new LinearLayoutManager(this));
    }

}