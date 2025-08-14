package com.example.baithuchanh_9;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnPlay;
    private ImageButton btnStop;
    private boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = findViewById(R.id.btnplay);
        btnStop = findViewById(R.id.btnstop);

        // Nút Play
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent serviceIntent = new Intent(MainActivity.this, MyService.class);
                serviceIntent.setAction("ACTION_PLAY");
                startService(serviceIntent);
                isPlaying = true;
            }
        });

        // Nút Stop
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent serviceIntent = new Intent(MainActivity.this, MyService.class);
                serviceIntent.setAction("ACTION_STOP");
                startService(serviceIntent);
                btnPlay.setImageResource(R.drawable.play1);
                isPlaying = false;
            }
        });
    }
}