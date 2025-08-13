package com.example.baithuchanh_8;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class CallPhoneActivity extends AppCompatActivity {
    EditText edtcall;
    ImageButton btncall;
    Button btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call); // Assuming call_layout is the XML layout for this activity

        edtcall =  findViewById(R.id.edtcall);
        btnback =  findViewById(R.id.btnback);
        btncall = findViewById(R.id.btncall);

        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + edtcall.getText().toString()));

                // Yêu cầu người dùng đồng ý quyền truy cập vào tính năng gọi điện
                if (ActivityCompat.checkSelfPermission(CallPhoneActivity.this,
                        android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(CallPhoneActivity.this,
                            new String[]{android.Manifest.permission.CALL_PHONE}, 1);
                    return;
                }
                startActivity(callIntent);
            }
        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
