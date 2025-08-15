package com.example.baithuchanh_14_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        viewPager.setAdapter(new MyViewPagerAdapter(this));

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            if (position == 0) tab.setText("Nhạc mới");
            else if (position == 1) tab.setText("Nhạc trẻ");
            else tab.setText("Nhạc remix");
        }).attach();
    }

    private static class MyViewPagerAdapter extends FragmentStateAdapter {
        public MyViewPagerAdapter(AppCompatActivity fa) {
            super(fa);
        }

        @Override
        public Fragment createFragment(int position) {
            if (position == 0) return SongListFragment.newInstance(new String[][]{
                    {"52300", "Em là ai Tôi là ai"},
                    {"52667", "Bài ca đất Phương Nam"},
                    {"52687", "Buồn của Anh"}
            });
            else if (position == 1) return SongListFragment.newInstance(new String[][]{
                    {"57236", "Gửi em ở cuối sông Hồng"},
                    {"51548", "Quê hương tuổi thơ tôi"},
                    {"57148", "Em gì ơi"}
            });
            else return SongListFragment.newInstance(new String[][]{
                        {"57689", "Người hãy quên em đi"},
                        {"58716", "Say tình - Remix"},
                        {"58916", "Người hãy quên em đi"}
                });
        }

        @Override
        public int getItemCount() {
            return 3;
        }
    }
}