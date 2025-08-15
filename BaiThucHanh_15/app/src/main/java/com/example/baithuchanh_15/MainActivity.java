package com.example.baithuchanh_15;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText edtMaLop, edtTenLop, edtSiSo;
    private Button btnInsert, btnDelete, btnUpdate, btnQuery;
    private ListView lvLop;

    private DBHelper helper;
    private SQLiteDatabase db;

    private ArrayAdapter<String> adapter;
    private ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new DBHelper(this);
        db = helper.getWritableDatabase();

        mapViews();
        bindEvents();
        loadAll();   // hiển thị dữ liệu ban đầu (nếu có)
    }

    private void mapViews() {
        edtMaLop = findViewById(R.id.edtMaLop);
        edtTenLop = findViewById(R.id.edtTenLop);
        edtSiSo   = findViewById(R.id.edtSiSo);

        btnInsert = findViewById(R.id.btnInsert);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnQuery  = findViewById(R.id.btnQuery);

        lvLop = findViewById(R.id.lvLop);

        data = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        lvLop.setAdapter(adapter);
    }

    private void bindEvents() {

        btnInsert.setOnClickListener(v -> {
            String ma = edtMaLop.getText().toString().trim();
            String ten = edtTenLop.getText().toString().trim();
            String sisoStr = edtSiSo.getText().toString().trim();

            if (!validate(ma, ten, sisoStr)) return;

            int siso = Integer.parseInt(sisoStr);

            ContentValues cv = new ContentValues();
            cv.put(DBHelper.COL_MA, ma);
            cv.put(DBHelper.COL_TEN, ten);
            cv.put(DBHelper.COL_SISO, siso);

            long r = db.insert(DBHelper.TBL_LOP, null, cv);
            if (r == -1) {
                Toast.makeText(this, "Thêm thất bại (trùng mã lớp?)", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Đã thêm", Toast.LENGTH_SHORT).show();
                clearInputs();
                loadAll();
            }
        });

        btnDelete.setOnClickListener(v -> {
            String ma = edtMaLop.getText().toString().trim();
            if (TextUtils.isEmpty(ma)) {
                edtMaLop.requestFocus();
                edtMaLop.setError("Nhập mã lớp để xóa");
                return;
            }
            int r = db.delete(DBHelper.TBL_LOP, DBHelper.COL_MA + "=?", new String[]{ma});
            Toast.makeText(this, r > 0 ? "Đã xóa" : "Không tìm thấy mã lớp", Toast.LENGTH_SHORT).show();
            loadAll();
        });

        btnUpdate.setOnClickListener(v -> {
            String ma = edtMaLop.getText().toString().trim();
            String ten = edtTenLop.getText().toString().trim();
            String sisoStr = edtSiSo.getText().toString().trim();

            if (!validate(ma, ten, sisoStr)) return;

            int siso = Integer.parseInt(sisoStr);
            ContentValues cv = new ContentValues();
            cv.put(DBHelper.COL_TEN, ten);
            cv.put(DBHelper.COL_SISO, siso);

            int r = db.update(DBHelper.TBL_LOP, cv, DBHelper.COL_MA + "=?", new String[]{ma});
            Toast.makeText(this, r > 0 ? "Đã cập nhật" : "Không tìm thấy mã lớp", Toast.LENGTH_SHORT).show();
            loadAll();
        });

        btnQuery.setOnClickListener(v -> loadAll());
    }

    private boolean validate(String ma, String ten, String sisoStr) {
        if (TextUtils.isEmpty(ma)) {
            edtMaLop.requestFocus();
            edtMaLop.setError("Không được trống");
            return false;
        }
        if (TextUtils.isEmpty(ten)) {
            edtTenLop.requestFocus();
            edtTenLop.setError("Không được trống");
            return false;
        }
        if (TextUtils.isEmpty(sisoStr)) {
            edtSiSo.requestFocus();
            edtSiSo.setError("Nhập sĩ số");
            return false;
        }
        try {
            int n = Integer.parseInt(sisoStr);
            if (n < 0) {
                edtSiSo.setError("Sĩ số >= 0");
                return false;
            }
        } catch (NumberFormatException e) {
            edtSiSo.setError("Sĩ số phải là số");
            return false;
        }
        return true;
    }

    private void clearInputs() {
        edtMaLop.setText("");
        edtTenLop.setText("");
        edtSiSo.setText("");
    }

    private void loadAll() {
        data.clear();
        Cursor c = db.query(DBHelper.TBL_LOP, null, null, null, null, null, DBHelper.COL_MA + " ASC");
        while (c.moveToNext()) {
            String ma = c.getString(c.getColumnIndexOrThrow(DBHelper.COL_MA));
            String ten = c.getString(c.getColumnIndexOrThrow(DBHelper.COL_TEN));
            int siso = c.getInt(c.getColumnIndexOrThrow(DBHelper.COL_SISO));
            data.add(ma + " - " + ten + " - " + siso);
        }
        c.close();
        adapter.notifyDataSetChanged();
    }
}