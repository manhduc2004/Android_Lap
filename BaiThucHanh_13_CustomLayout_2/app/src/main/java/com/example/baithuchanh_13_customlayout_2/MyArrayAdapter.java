package com.example.baithuchanh_13_customlayout_2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<Image> {
    Activity context;
    ArrayList<Image> myArray;
    int layoutId;

    public MyArrayAdapter(Activity context, int layoutId, ArrayList<Image> arr) {
        super(context, layoutId, arr);
        this.context = context;
        this.layoutId = layoutId;
        this.myArray = arr;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View row = inflater.inflate(layoutId, null);

        ImageView imgitem = row.findViewById(R.id.imageView1);
        imgitem.setImageResource(myArray.get(position).getImg());

        TextView myname = row.findViewById(R.id.textView1);
        myname.setText(myArray.get(position).getName());

        return row;
    }
}
