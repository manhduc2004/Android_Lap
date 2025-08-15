package com.example.baithuchanh_12_2;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends Activity {
    //Khai báo các biến
    ListView lv;
    ArrayList<String> arraywork;
    ArrayAdapter<String> arrAdapter;
    EditText edtwork, edth, edtm;
    TextView txtdate;
    Button btnwork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Tìm kiếm các View
        edth = findViewById(R.id.edthour);
        edtm = findViewById(R.id.edtminute);
        edtwork = findViewById(R.id.edtwork);
        btnwork = findViewById(R.id.btnadd);
        lv = findViewById(R.id.lvwork);
        txtdate = findViewById(R.id.txtdate);

        //Xử lý dữ liệu và Adapter
        arraywork = new ArrayList<>();
        arrAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arraywork);
        lv.setAdapter(arrAdapter);

        //Lấy ngày giờ hệ thống và hiển thị
        Date currentDate = Calendar.getInstance().getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        txtdate.setText("Hom Nay: " + dateFormat.format(currentDate));

        //Viết phương thức khi click vào Button btnwork
        btnwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Nếu 1 trong 3 Edit Text không có nội dung thì hiện lên thông báo bằng hộp thoại Dialog
                if (edtwork.getText().toString().equals("") || edth.getText().toString().equals("") || edtm.getText().toString().equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Info missing");
                    builder.setMessage("Please enter all information of the work");
                    builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // TODO Auto-generated method stub
                        }
                    });
                    builder.show();
                } else {
                    //Lấy nội dung công việc và thời gian ra từ Edit Text và đưa vào Mảng arraywork, cập nhật lại Adapter
                    String str = edtwork.getText().toString() + " - " + edth.getText().toString() + ":" + edtm.getText().toString();
                    //Để Thêm dữ liệu cho ListView, chúng ta cần 2 bước:
                    //Cập thêm liệu cho mảng
                    arraywork.add(str);
                    //Cập nhật lại Adapter
                    arrAdapter.notifyDataSetChanged();
                    edth.setText("");
                    edtm.setText("");
                    edtwork.setText("");
                }
            }
        });
    }
}