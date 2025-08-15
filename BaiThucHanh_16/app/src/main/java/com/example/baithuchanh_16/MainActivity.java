package com.example.baithuchanh_16;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edta, edtb, edtkq;
    Button btntong, btnclear;
    TextView txtlichsu;
    String lichsu = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edta = findViewById(R.id.edta);
        edtb = findViewById(R.id.edtb);
        edtkq = findViewById(R.id.edtkq);
        btntong = findViewById(R.id.btntong);
        btnclear = findViewById(R.id.btnclear);
        txtlichsu = findViewById(R.id.txtlichsu);

        // Lấy lại dữ liệu lịch sử đã lưu
        SharedPreferences myprefs = getSharedPreferences("mygaye", MODE_PRIVATE);
        lichsu = myprefs.getString("ls", "");
        txtlichsu.setText(lichsu);

        // Nút tính tổng
        btntong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int a = Integer.parseInt(edta.getText().toString());
                    int b = Integer.parseInt(edtb.getText().toString());
                    int kq = a + b;
                    edtkq.setText(String.valueOf(kq));

                    lichsu += a + " + " + b + " = " + kq + "\n";
                    txtlichsu.setText(lichsu);
                } catch (NumberFormatException e) {
                    edtkq.setText("Lỗi nhập!");
                }
            }
        });

        // Nút xóa lịch sử
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lichsu = "";
                txtlichsu.setText("");
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Lưu lịch sử vào SharedPreferences khi rời Activity
        SharedPreferences myprefs = getSharedPreferences("mygaye", MODE_PRIVATE);
        SharedPreferences.Editor myedit = myprefs.edit();
        myedit.putString("ls", lichsu);
        myedit.apply();
    }
}