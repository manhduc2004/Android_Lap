package com.example.baithuchanh_14;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    private Tab1Fragment tab1Fragment;
    private Tab2Fragment tab2Fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tab1Fragment = new Tab1Fragment();
        tab2Fragment = new Tab2Fragment();

        // Set up communication from Tab1 to Tab2
        tab1Fragment.setOnAddResultListener(new Tab1Fragment.OnAddResultListener() {
            @Override
            public void onAddResult(String result) {
                tab2Fragment.addResult(result);
            }
        });

        Fragment[] fragments = new Fragment[]{tab1Fragment, tab2Fragment};
        ViewPagerAdapter adapter = new ViewPagerAdapter(this, fragments);

        ViewPager2 viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            if (position == 0) tab.setText("Cộng");
            else tab.setText("Kết quả");
        }).attach();
    }
}