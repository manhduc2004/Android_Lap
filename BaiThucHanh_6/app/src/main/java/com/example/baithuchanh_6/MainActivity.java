package com.example.baithuchanh_6;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.window.OnBackInvokedDispatcher;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtTen, editCMND, editBosung;
    CheckBox chkDocBao, chkDocSach, chkDocCoding;
    Button btnsend;
    RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edtTen = findViewById(R.id.editHoTen);
        editCMND = findViewById(R.id.editCMND);
        editBosung = findViewById(R.id.editBosung);
        chkDocBao = findViewById(R.id.chkDocBao);
        chkDocSach = findViewById(R.id.chkDocSach);
        chkDocCoding = findViewById(R.id.chkDocCoding);
        btnsend = findViewById(R.id.btnguitt);

        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doShowInformation();
            }
        });
        // Đăng ký callback cho sự kiện back
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
                b.setTitle("Question");
                b.setMessage("Are you sure you want to exit?");
                b.setIcon(R.drawable.ic_baseline_exit_to_app_24);
                b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                b.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                b.show();
            }
        });
    }

    public void doShowInformation(){
        // Kiểm tra tên hợp lệ
        String ten = edtTen.getText().toString();
        ten = ten.trim();
        if (ten.length() < 3) {
            edtTen.requestFocus();
            edtTen.selectAll();
            Toast.makeText(this, "Tên phải có ít nhất 3 ký tự", Toast.LENGTH_SHORT).show();
            return;
        }

        // Kiểm tra CMND hợp lệ
        String cmnd = editCMND.getText().toString();
        cmnd = cmnd.trim();
        if (cmnd.length() != 9 && cmnd.length() != 12) {
            editCMND.requestFocus();
            editCMND.selectAll();
            Toast.makeText(this, "CMND phải có 9 hoặc 12 ký tự", Toast.LENGTH_SHORT).show();
            return;
        }

        // Kiểm tra bằng cấp
        String bang = "";
        group = findViewById(R.id.radioGroup1);
        int id = group.getCheckedRadioButtonId();
        if (id == -1){
            Toast.makeText(this, "Phải chọn bằng cấp", Toast.LENGTH_SHORT).show();
            return;
        }
        RadioButton rad = findViewById(id);
        bang = rad.getText().toString();

        // Kiểm tra sở thích
        String soThich = "";
        if (chkDocBao.isChecked()) {
            soThich += chkDocBao.getText().toString() + "\n";
        }
        if (chkDocSach.isChecked()) {
            soThich += chkDocSach.getText().toString() + "\n";
        }
        if (chkDocCoding.isChecked()) {
            soThich += chkDocCoding.getText().toString() + "\n";
        }
        String bosung = editBosung.getText().toString();

        //Tạo dialog hiển thị thông tin
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông tin cá nhân");
        builder.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        // tạo nội dung hiển thị
        String msg = ten + "\n" +
                "CMND: " + cmnd + "\n" +
                "Bằng cấp: " + bang + "\n" +
                "Sở thích: \n" + soThich +
                "Thông tin bổ sung: " + bosung + "\n";
        msg += "\n--------------------------------\n";
        builder.setMessage(msg);
        builder.create().show();
    }
}