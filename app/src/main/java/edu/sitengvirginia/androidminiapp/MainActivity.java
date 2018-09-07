package edu.sitengvirginia.androidminiapp;

//used idea from https://developer.android.com/guide/topics/ui/floating-action-button


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.FloatingActionButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView myText;
    private FloatingActionButton myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myText = findViewById(R.id.textView);
        myButton = findViewById(R.id.button);
    }

    public void changeText(View view) {
        myText.setText("You clicked the button!");
    }
}