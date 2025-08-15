package com.example.baithuchanh_13_customlayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String namephone[] = {
            "Điện thoại Iphone 12",
            "Điện thoại SamSung S20",
            "Điện thoại Nokia 6",
            "Điện thoại Bphone 2020",
            "Điện thoại Oppo 5",
            "Điện thoại VSmart joy2"
    };

    int imagephone[] = {
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground
    };

    String pricephone[] = {
            "20,000,000đ",
            "18,500,000đ",
            "5,000,000đ",
            "7,500,000đ",
            "6,800,000đ",
            "4,500,000đ"
    };

    ArrayList<Phone> mylist;
    MyArrayAdapter myadapter;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        mylist = new ArrayList<>();

        for (int i = 0; i < namephone.length; i++) {
            mylist.add(new Phone(namephone[i], imagephone[i], pricephone[i]));
        }

        myadapter = new MyArrayAdapter(this, R.layout.layout_listview, mylist);
        lv.setAdapter(myadapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myintent = new Intent(MainActivity.this, SubActivity.class);
                myintent.putExtra("name", namephone[position]);
                myintent.putExtra("price", pricephone[position]);
                startActivity(myintent);
            }
        });
    }
}