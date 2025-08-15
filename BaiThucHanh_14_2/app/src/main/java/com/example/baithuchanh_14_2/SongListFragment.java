package com.example.baithuchanh_14_2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class SongListFragment extends Fragment {

    private static final String ARG_SONGS = "songs";

    public static SongListFragment newInstance(String[][] songs) {
        SongListFragment fragment = new SongListFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_SONGS, songs);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(android.R.layout.list_content, container, false);
        ListView listView = view.findViewById(android.R.id.list);

        String[][] songs = (String[][]) getArguments().getSerializable(ARG_SONGS);
        List<Item> items = new ArrayList<>();
        for (String[] s : songs) {
            items.add(new Item(s[0], s[1], false));
        }

        MyArrayAdapter adapter = new MyArrayAdapter(getContext(), R.layout.listitem, items);
        listView.setAdapter(adapter);

        return view;
    }
}
