package com.example.baithuchanh_13_customlayout_2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SubActivity extends Activity {
    TextView txtname2;
    ImageView img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub); // Layout hiển thị chi tiết

        txtname2 = findViewById(R.id.textView2);
        img2 = findViewById(R.id.imageView2);

        int position = getIntent().getIntExtra("HINHANH", 0);

        txtname2.setText(MainActivity.arrayname[position]);
        img2.setImageResource(MainActivity.imagel[position]);
    }
}