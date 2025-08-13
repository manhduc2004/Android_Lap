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

public class MainActivity extends AppCompatActivity {
    EditText edta, edtb, edtKQ;
    Button btnKQ;

    // Dùng launcher mới để thay thế startActivityForResult
    ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edta = findViewById(R.id.edta);
        edtb = findViewById(R.id.edtb);
        edtKQ = findViewById(R.id.edtKQ);
        btnKQ = findViewById(R.id.btnKQ);

        // Khởi tạo launcher
        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == 33 || result.getResultCode() == 34) {
                            Intent data = result.getData();
                            if (data != null) {
                                int kq = data.getIntExtra("kq", 0);
                                String text = result.getResultCode() == 33 ? "Tổng 2 số là: " : "Hiệu 2 số là: ";
                                edtKQ.setText(text + kq);
                            }
                        }
                    }
                }
        );

        btnKQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(edta.getText().toString());
                int b = Integer.parseInt(edtb.getText().toString());

                Intent myintent = new Intent(MainActivity.this, SubActivity.class);
                myintent.putExtra("soa", a);
                myintent.putExtra("sob", b);

                // Sử dụng launcher mới thay cho startActivityForResult
                activityResultLauncher.launch(myintent);
            }
        });
    }
}