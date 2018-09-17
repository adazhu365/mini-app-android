package edu.sitengvirginia.androidminiapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;

public class AddItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Button button = findViewById(R.id.button);
        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText etName1 = (EditText) findViewById(R.id.editText);
                EditText etName2 = (EditText) findViewById(R.id.editText2);
                EditText etName3 = (EditText) findViewById(R.id.editText3);
                EditText etName4 = (EditText) findViewById(R.id.editText4);
                //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                int day = ((DatePicker)findViewById(R.id.datepicker)).getDayOfMonth();
                int month = ((DatePicker)findViewById(R.id.datepicker)).getMonth();
                int year = ((DatePicker)findViewById(R.id.datepicker)).getYear();
                String date = ((Integer)year).toString() + "/" + ((Integer)month).toString()
                        + "/" + ((Integer)day).toString();

                Intent resultIntent = new Intent();
                resultIntent.putExtra("name", etName1.getText().toString());
                resultIntent.putExtra("description", etName2.getText().toString());
                resultIntent.putExtra("latitude", etName3.getText().toString());
                resultIntent.putExtra("longitude", etName4.getText().toString());
                resultIntent.putExtra("date", date);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}
