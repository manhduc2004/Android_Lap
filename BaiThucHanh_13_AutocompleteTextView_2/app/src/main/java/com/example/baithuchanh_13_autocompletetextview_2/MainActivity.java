package com.example.baithuchanh_13_autocompletetextview_2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {

    String arr[] = {"Ipad", "Iphone", "Macbook", "Samsung Galaxy", "Samsung Note", "Samsung A", "Oppo Reno", "Oppo F", "Vivo V", "Vivo Y"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Đối tượng này dùng để hiển thị phần tử được chọn trong GridView
        final TextView selection = (TextView) findViewById(R.id.selecttion);
        final GridView gv = (GridView) findViewById(R.id.gridView1);

        //Gán DataSource vào ArrayAdapter
        ArrayAdapter<String> da = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                arr);

        //gán Datasource vào GridView
        gv.setAdapter(da);

        //Thiết lập sự kiện cho GridView
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                //Hiển thị phần tử được chọn trong GridView lên TextView
                selection.setText(arr[arg2]);
            }
        });
    }
}