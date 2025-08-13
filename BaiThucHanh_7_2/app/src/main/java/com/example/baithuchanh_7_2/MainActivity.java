package com.example.baithuchanh_7_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edta, edtb;
    Button btnKQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edta = findViewById(R.id.edta);
        edtb = findViewById(R.id.edtb);
        btnKQ = findViewById(R.id.btnKQ);
        btnKQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(MainActivity.this, ResultActivity.class);
                Bundle bundle1 = new Bundle();
                int a = Integer.parseInt(edta.getText().toString());
                int b = Integer.parseInt(edtb.getText().toString());
                bundle1.putInt("soa", a);
                bundle1.putInt("sob", b);
                myintent.putExtra("mybackage", bundle1);
                startActivity(myintent);
            }
        });
    }
}