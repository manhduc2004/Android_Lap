package com.example.baithuchanh_5;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private EditText edtNamDuong;
    private TextView tvNamAm;
    private Button btnChuyenDoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Ánh xạ view từ layout
        edtNamDuong   = findViewById(R.id.nam_duong_lich_input);
        tvNamAm       = findViewById(R.id.nam_am_lich_output);
        btnChuyenDoi  = findViewById(R.id.btnChuyenDoi);

        // 2. Thiết lập sự kiện click cho nút "Chuyển đổi"
        btnChuyenDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = edtNamDuong.getText().toString().trim();
                if (s.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập năm dương lịch", Toast.LENGTH_SHORT).show();
                    return;
                }

                int namDuong;
                try {
                    namDuong = Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Giá trị không hợp lệ", Toast.LENGTH_SHORT).show();
                    return;
                }

                String can = "";
                switch (namDuong % 10) {
                    case 0: can = "Canh"; break;
                    case 1: can = "Tân";   break;
                    case 2: can = "Nhâm";  break;
                    case 3: can = "Quý";   break;
                    case 4: can = "Giáp";  break;
                    case 5: can = "Ất";    break;
                    case 6: can = "Bính";  break;
                    case 7: can = "Đinh";  break;
                    case 8: can = "Mậu";   break;
                    case 9: can = "Kỷ";    break;
                }

                String chi = "";
                switch (namDuong % 12) {
                    case 0:  chi = "Thân"; break;
                    case 1:  chi = "Dậu";  break;
                    case 2:  chi = "Tuất"; break;
                    case 3:  chi = "Hợi";  break;
                    case 4:  chi = "Tý";   break;
                    case 5:  chi = "Sửu";  break;
                    case 6:  chi = "Dần";  break;
                    case 7:  chi = "Mão";  break;
                    case 8:  chi = "Thìn"; break;
                    case 9:  chi = "Tỵ";   break;
                    case 10: chi = "Ngọ";  break;
                    case 11: chi = "Mùi";  break;
                }

                // 4. Hiển thị kết quả
                tvNamAm.setText(can + " " + chi);
            }
        });
    }
}