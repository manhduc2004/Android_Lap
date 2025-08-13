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
public class SendSMSActivity extends AppCompatActivity {
    EditText edtsms;
    Button btnback;
    ImageButton btnsms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendsms);

        edtsms =  findViewById(R.id.edtsms);
        btnback =  findViewById(R.id.btnback);
        btnsms = findViewById(R.id.btnsms);

        btnsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_SENDTO,
                        Uri.parse("smsto:" + edtsms.getText().toString()));
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