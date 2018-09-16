package edu.sitengvirginia.androidminiapp;

//used idea from https://developer.android.com/guide/topics/ui/floating-action-button


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

import org.json.JSONObject;

import java.util.ArrayList;

public class BucketListActivity extends AppCompatActivity {

    private FloatingActionButton myButton;
    RecyclerView rvItems;
    ArrayList<BucketItem> myList;
    private Snackbar snackbar;
    static final int req_code = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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

        myList = BucketItem.createInitialBucketList();
        Log.e("test", Integer.toString(myList.size()));
        rvItems = (RecyclerView) findViewById(R.id.rvItems);
        BucketListAdapter adapter = new BucketListAdapter(this, myList);
        rvItems.setAdapter(adapter);
        rvItems.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == 1) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                Uri resultUri = data.getData();

                String name = data.getDataString();
                Log.e("test", name);




            }
        }
    }


}