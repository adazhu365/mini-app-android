package edu.sitengvirginia.androidminiapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class EditItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent rIntent = getIntent();
        ((EditText) findViewById(R.id.editText)).setText(rIntent.getStringExtra("name"));
        ((EditText) findViewById(R.id.editText2)).setText(rIntent.getStringExtra("description"));
        ((EditText) findViewById(R.id.editText3)).setText(rIntent.getStringExtra("latitude"));
        ((EditText) findViewById(R.id.editText4)).setText(rIntent.getStringExtra("longitude"));
        String date = rIntent.getStringExtra("date");
        String[] arraystring = date.split("/");


        ((DatePicker)findViewById(R.id.datepicker)).updateDate(Integer.parseInt(arraystring[0]),
                Integer.parseInt(arraystring[1]),Integer.parseInt(arraystring[2]));
        final TextView textview  = findViewById(R.id.button);
        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent receivedIntent = getIntent();
                int position = receivedIntent.getIntExtra("position", 0);
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
                boolean checked = receivedIntent.getBooleanExtra("position", false);

                Intent resultIntent = new Intent();
                resultIntent.putExtra("name", etName1.getText().toString());
                resultIntent.putExtra("description", etName2.getText().toString());
                resultIntent.putExtra("latitude", etName3.getText().toString());
                resultIntent.putExtra("longitude", etName4.getText().toString());
                resultIntent.putExtra("date", date);
                resultIntent.putExtra("position", position);
                resultIntent.putExtra("checked", checked);
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
