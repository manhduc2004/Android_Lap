package com.example.baithuchanh_7_1;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChildActivity extends AppCompatActivity {
    @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.child_activity);

        Button btn = (Button) findViewById(R.id.btn2);
        TextView txt1 = (TextView) findViewById(R.id.textView2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ChildActivity.this, MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}
