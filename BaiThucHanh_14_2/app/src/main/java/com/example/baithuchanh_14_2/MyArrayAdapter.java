package com.example.baithuchanh_14_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyArrayAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Item> list;

    public MyArrayAdapter(Context context, int layout, List<Item> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layout, parent, false);
            holder = new ViewHolder();
            holder.txtMa = convertView.findViewById(R.id.txtMa);
            holder.txtTen = convertView.findViewById(R.id.txtTen);
            holder.imgLike = convertView.findViewById(R.id.imgLike);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Item item = list.get(position);
        holder.txtMa.setText(item.getMa());
        holder.txtTen.setText(item.getTen());
        holder.imgLike.setImageResource(item.isLike() ?
                android.R.drawable.btn_star_big_on : android.R.drawable.btn_star_big_off);

        holder.imgLike.setOnClickListener(v -> {
            item.setLike(!item.isLike());
            notifyDataSetChanged();
        });

        return convertView;
    }

    private static class ViewHolder {
        TextView txtMa, txtTen;
        ImageView imgLike;
    }
}