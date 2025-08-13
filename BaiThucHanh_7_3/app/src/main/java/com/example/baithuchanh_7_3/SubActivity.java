package com.example.baithuchanh_7_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
// Code Java trong SubActivity.java
public class SubActivity extends AppCompatActivity {
    EditText edtaa, edtbb;
    Button btnTong, btnHieu;
    Intent myIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        edtaa = findViewById(R.id.edtaa);
        edtbb = findViewById(R.id.edtbb);

        btnTong = findViewById(R.id.btnTong);
        btnHieu = findViewById(R.id.btnHieu);

        myIntent = getIntent();
        // Nhận Intent
        // Lấy dữ liệu khỏi Intent
        int a = myIntent.getIntExtra("soa", 0);
        int b = myIntent.getIntExtra("sob", 0);
        edtaa.setText(a + "");
        edtbb.setText(b + "");

        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Xử lý kết quả
                int a = Integer.parseInt(edtaa.getText().toString());
                int b = Integer.parseInt(edtbb.getText().toString());
                int sum = a + b;

                myIntent.putExtra("kq", sum);
                setResult(33, myIntent); // Trả Intent kết quả
                finish(); // Hoạt động này sẽ quay về
            }
        });

        btnHieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Xử lý kết quả
                int a = Integer.parseInt(edtaa.getText().toString());
                int b = Integer.parseInt(edtbb.getText().toString());
                int hieu = a - b;

                myIntent.putExtra("kq", hieu);
                setResult(34, myIntent);
                finish();
            }
        });
    }
}
