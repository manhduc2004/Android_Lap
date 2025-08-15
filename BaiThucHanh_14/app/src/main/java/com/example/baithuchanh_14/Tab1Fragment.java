package com.example.baithuchanh_14;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Tab1Fragment extends Fragment {
    private EditText edta, edtb;
    private Button btncong;
    private OnAddResultListener listener;

    public interface OnAddResultListener {
        void onAddResult(String result);
    }

    public void setOnAddResultListener(OnAddResultListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout1, container, false);
        edta = view.findViewById(R.id.edta);
        edtb = view.findViewById(R.id.edtb);
        btncong = view.findViewById(R.id.btncong);
        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int a = Integer.parseInt(edta.getText().toString());
                    int b = Integer.parseInt(edtb.getText().toString());
                    String c = a + " + " + b + " = " + (a + b);
                    if (listener != null) listener.onAddResult(c);
                    edta.setText("");
                    edtb.setText("");
                } catch (NumberFormatException ignored) {}
            }
        });
        return view;
    }
}

