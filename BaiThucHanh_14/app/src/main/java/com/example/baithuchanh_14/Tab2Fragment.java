package com.example.baithuchanh_14;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Tab2Fragment extends Fragment {
    private ListView lv1;
    private ArrayList<String> list = new ArrayList<>();
    private ArrayAdapter<String> myarray;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout2, container, false);
        lv1 = view.findViewById(R.id.lv1);
        myarray = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, list);
        lv1.setAdapter(myarray);
        return view;
    }

    public void addResult(String result) {
        list.add(result);
        if (myarray != null) myarray.notifyDataSetChanged();
    }
}

