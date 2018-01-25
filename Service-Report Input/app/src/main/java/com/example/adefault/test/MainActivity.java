package com.example.adefault.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.*;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Button startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v){
                        TextView text = findViewById(R.id.text);
                        text.setText("Hello Hazzen");
                    }
                }
        );
        startButton.setOnLongClickListener(
                new OnLongClickListener(){
                    public boolean onLongClick(View v){
                        TextView longClick = findViewById(R.id.text);
                        longClick.setText("Long press");
                        return false;
                    }
                }
        );
    }

}
