package com.example.baithuchanh_20;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnstart;
    TextView txtmsg;
    MyAsyncTask myTask = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnstart = findViewById(R.id.btnstart);
        txtmsg = findViewById(R.id.txtmsg);
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doStart();
            }
        });
    }

    private void doStart() {
        //this task is executed on a background thread
        myTask = new MyAsyncTask(MainActivity.this, txtmsg);
        myTask.execute();
    }
}