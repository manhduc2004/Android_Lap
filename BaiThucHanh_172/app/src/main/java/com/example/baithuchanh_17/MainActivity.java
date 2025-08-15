package com.example.baithuchanh_17;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String DB_PATH_SUFFIX = "/databases/";
    SQLiteDatabase database = null;
    String DATABASE_NAME = "qlsach.db";

    ListView lv;
    ArrayList<String> mylist;
    ArrayAdapter<String> myadapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Ứng dụng đã khởi động!", Toast.LENGTH_SHORT).show();
        // XÓA file database cũ để đảm bảo luôn copy lại từ assets (chỉ dùng khi debug)
        File dbFile = getDatabasePath(DATABASE_NAME);
        if (dbFile.exists()) {
            dbFile.delete();
            Toast.makeText(this, "Đã xóa database cũ", Toast.LENGTH_SHORT).show();
        }
        processCopy();
        try {
            database = SQLiteDatabase.openDatabase(dbFile.getPath(), null, SQLiteDatabase.OPEN_READWRITE);
            lv = findViewById(R.id.lv1);
            mylist = new ArrayList<>();
            myadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mylist);
            lv.setAdapter(myadapter);

            Cursor c = database.query("tbsach", null, null, null, null, null, null);
            if (c != null && c.moveToFirst()) {
                do {
                    String data = c.getString(0) + " - " + c.getString(1) + " - " + c.getString(2);
                    mylist.add(data);
                } while (c.moveToNext());
                c.close();
                Toast.makeText(this, "Đã load dữ liệu thành công!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Không có dữ liệu trong bảng tbsach", Toast.LENGTH_SHORT).show();
            }
            myadapter.notifyDataSetChanged();
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi database: " + e.getMessage(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    private void processCopy(){
        File dbFile = getDatabasePath(DATABASE_NAME);
        if(!dbFile.exists()) {
            File dbFolder = new File(getApplicationInfo().dataDir + DB_PATH_SUFFIX);
            if(!dbFile.exists()){
                try{
                    CopyDataBaseFromAssets();
                    Toast.makeText(this, "Copy database thành công", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public File getDatabasePath(String dbName) {
        return new File(getApplicationInfo().dataDir + DB_PATH_SUFFIX + dbName);
    }

    public void CopyDataBaseFromAssets(){
        try{
            InputStream myInput;
            myInput = getAssets().open(DATABASE_NAME);
            String outFileName = String.valueOf(getDatabasePath(DATABASE_NAME));
            File f = new File(getApplicationInfo().dataDir + DB_PATH_SUFFIX);
            if (!f.exists()) {
                f.mkdir();
            }
            OutputStream myOutput = new FileOutputStream(outFileName);
            int size = myInput.available();
            byte[] buffer = new byte[size];
            myInput.read(buffer);
            myOutput.write(buffer);
            myOutput.flush();
            myOutput.close();
            myInput.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}