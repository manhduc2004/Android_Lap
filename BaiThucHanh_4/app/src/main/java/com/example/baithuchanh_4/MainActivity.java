package com.example.baithuchanh_4;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import java.text.DecimalFormat;

public class MainActivity extends Activity {
    EditText edtdoC, edtdoF;
    Button btncf, btnfc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtdoC = findViewById(R.id.edit_text_2);
        edtdoF = findViewById(R.id.edit_text_1);
        btncf = findViewById(R.id.btnConvertToCelsius);
        btnfc = findViewById(R.id.btnConvertToFahrenheit);

        btncf.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                DecimalFormat dcf = new DecimalFormat("#.00");
                String doC = edtdoC.getText() + "";

                int C = Integer.parseInt(doC);
                edtdoF.setText(" " + dcf.format(C*1.8 + 32));
            }
        });

        btnfc.setOnClickListener(new View.OnClickListener() {;
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                DecimalFormat dcf = new DecimalFormat("#.00");
                String doF = edtdoF.getText() + "";

                if (!doF.isEmpty()) {
                    try {
                        int F = Integer.parseInt(doF);
                        edtdoC.setText(" " + dcf.format((F - 32) / 1.8));
                    } catch (NumberFormatException e) {
                        edtdoC.setText("Invalid input");
                    }
                } else {
                    edtdoC.setText("Please enter a value");
                }
            }
        });
    }
}