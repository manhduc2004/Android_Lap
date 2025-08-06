package com.example.baithuchanh_4_2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import java.text.DecimalFormat;


public class MainActivity extends Activity {

    Button btnChandoan;
    EditText editTen, editChieucao, editCanNang, editBMI,  editChandoan;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChandoan = findViewById(R.id.btnBMI);
        editTen = findViewById(R.id.name_input);
        editChieucao = findViewById(R.id.height_input);
        editCanNang = findViewById(R.id.weight_input);
        editBMI = findViewById(R.id.BMI_input);
        editChandoan = findViewById(R.id.chuan_doan_input);

        btnChandoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double H = Double.parseDouble(editChieucao.getText().toString());
                double W = Double.parseDouble(editCanNang.getText().toString());
                double BMI = W / Math.pow(H, 2);

                String chandoan = "";
                if (BMI < 18) {
                    chandoan = "Bạn gầy";
                } else if (BMI < 24.9) {
                    chandoan = "Bạn bình thường";
                } else if (BMI < 29.9) {
                    chandoan = "Bạn béo phì độ 1";
                } else if (BMI < 34.9) {
                    chandoan = "Bạn béo phì độ 2";
                } else {
                    chandoan = "Bạn béo phì độ 3";
                }

                DecimalFormat dcf = new DecimalFormat("#.0");
                editBMI.setText(dcf.format(BMI));
                editChandoan.setText(chandoan);
            }
        });
    }
}