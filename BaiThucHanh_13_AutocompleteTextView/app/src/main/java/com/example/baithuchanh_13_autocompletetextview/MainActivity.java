package com.example.baithuchanh_13_autocompletetextview;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //Khai bao 2 CompleTextView
    AutoCompleteTextView singleComplete;
    MultiAutoCompleteTextView multiComplete;
    //Khởi tạo mảng tam để Test
    String arr[]={"ha noi","Hue","Sai gon","ha giang","hoi an","Kien giang","Lam dong","Long khanh"};
    TextView selection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selection = (TextView) findViewById(R.id.selection);
        //lấy đối tượng AutoCompleteTextView ra
        singleComplete=(AutoCompleteTextView)findViewById(R.id.editauto);
        ArrayAdapter<String> myadapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                arr);
        //Thiết lập ArrayAdapter
        singleComplete.setAdapter(myadapter);

        //lấy đối tượng MultiAutoCompleteTextView ra
        multiComplete=(MultiAutoCompleteTextView)findViewById(R.id.multiAutoCompleteTextView1);
        //Thiết lập ArrayAdapter
        multiComplete.setAdapter(new ArrayAdapter<String>
                (
                        this,
                        android.R.layout.simple_list_item_1,
                        arr));
        //đối với MultiAutoCompleteTextView bắt buộc phải gọi dòng lệnh này
        multiComplete.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        singleComplete.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                selection.setText(singleComplete.getText());
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }
}