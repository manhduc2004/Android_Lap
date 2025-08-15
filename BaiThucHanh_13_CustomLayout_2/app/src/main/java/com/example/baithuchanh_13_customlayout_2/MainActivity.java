package com.example.baithuchanh_13_customlayout_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static String[] arrayname = {
            "Ảnh 1", "Ảnh 2", "Ảnh 3", "Ảnh 4",
            "Ảnh 5", "Ảnh 6", "Ảnh 7", "Ảnh 8",
            "Ảnh 9", "Ảnh 10", "Ảnh 11", "Ảnh 12"
    };
    public static int[] imagel = {
            R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground
    };

    GridView gridViewDemo;
    MyArrayAdapter adapterDanhSach;
    ArrayList<Image> arrimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridViewDemo = findViewById(R.id.grid1);
        arrimage = new ArrayList<>();

        // Khởi tạo dữ liệu
        for (int i = 0; i < imagel.length; i++) {
            arrimage.add(new Image(imagel[i], arrayname[i]));
        }

        adapterDanhSach = new MyArrayAdapter(this, R.layout.childlayout, arrimage);
        gridViewDemo.setAdapter(adapterDanhSach);

        // Sự kiện click item
        gridViewDemo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent1 = new Intent(MainActivity.this, SubActivity.class);
                intent1.putExtra("HINHANH", position);
                startActivity(intent1);
            }
        });
    }
}