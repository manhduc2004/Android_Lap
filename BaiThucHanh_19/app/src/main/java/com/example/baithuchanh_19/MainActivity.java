package com.example.baithuchanh_19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnparse;
    ListView lv;
    ArrayList<String> mylist;
    ArrayAdapter<String> myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnparse = findViewById(R.id.btnparse);
        lv = findViewById(R.id.lv);

        mylist = new ArrayList<>();
        myadapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, mylist);
        lv.setAdapter(myadapter);

        btnparse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parseXML();
            }
        });
    }

    private void parseXML() {
        try {
            // Mở file employees.xml trong assets
            InputStream myInput = getAssets().open("employees.xml");

            // Tạo XmlPullParser
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(myInput, null);

            int eventType = parser.getEventType();
            String datashow = "";
            String currentTag = "";

            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        currentTag = parser.getName();
                        if (currentTag.equals("employee")) {
                            // Lấy attribute id và title
                            String id = parser.getAttributeValue(null, "id");
                            String title = parser.getAttributeValue(null, "title");
                            datashow = id + " - " + title + " - ";
                        }
                        break;

                    case XmlPullParser.TEXT:
                        String text = parser.getText().trim();
                        if (!text.isEmpty()) {
                            if (currentTag.equals("name")) {
                                datashow += text + " - ";
                            } else if (currentTag.equals("phone")) {
                                datashow += text;
                            }
                        }
                        break;

                    case XmlPullParser.END_TAG:
                        if (parser.getName().equals("employee")) {
                            mylist.add(datashow);
                            datashow = "";
                        }
                        currentTag = "";
                        break;
                }
                eventType = parser.next();
            }

            myadapter.notifyDataSetChanged();

        } catch (IOException | XmlPullParserException e) {
            e.printStackTrace();
        }
    }
}