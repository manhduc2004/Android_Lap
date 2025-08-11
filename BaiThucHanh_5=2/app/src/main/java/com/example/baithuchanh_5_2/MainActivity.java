package com.example.baithuchanh_5_2;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends Activity {

    Button btnTiepTuc, btnGiai, btnThoat;
    EditText edita, editb, editc;
    TextView txtkq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTiepTuc = findViewById(R.id.btnTiepTuc);
        btnGiai = findViewById(R.id.btnGiai);
        btnThoat = findViewById(R.id.btnThoat);
        edita = findViewById(R.id.editTextA);
        editb = findViewById(R.id.editTextB);
        editc = findViewById(R.id.editTextC);
        txtkq = findViewById(R.id.txtkq);

        btnGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sa = edita.getText().toString();
                String sb = editb.getText().toString();
                String sc = editc.getText().toString();

                int a = Integer.parseInt(sa);
                int b = Integer.parseInt(sb);
                int c = Integer.parseInt(sc);

                String kq ="";
                DecimalFormat dcf = new DecimalFormat("0.00");
                if (a == 0) {
                    if (b == 0) {
                        if (c == 0) {
                            kq = "Phương trình vô số nghiệm";
                        } else {
                            kq = "Phương trình vô nghiệm";
                        }
                    } else {
                        kq = "Phương trình có nghiệm: x = " + dcf.format(-c/b);
                    }
                } else {
                    double delta = b * b - 4 * a * c;
                    if (delta < 0) {
                        kq = "Phương trình vô nghiệm";
                    } else if (delta == 0) {
                        kq = "Phương trình có nghiệm kép: x1 = x2 = " + dcf.format(-b/ (2.0 * a));
                    } else {
                        kq = "Phương trình có hai nghiệm phân biệt: x1 = " + dcf.format((-b + Math.sqrt(delta)) / (2.0 * a)) + ", x2 = " + dcf.format((-b - Math.sqrt(delta)) / (2.0 * a));
                    }
                }
                txtkq.setText(kq);

                btnTiepTuc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        edita.setText("");
                        editb.setText("");
                        editc.setText("");
                        edita.requestFocus();
                    }
                });

                btnThoat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
            }
        });
    }

}