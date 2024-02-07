package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private class ScreenSlidePagerAdapter extends FragmentStateAdapter {
        public ScreenSlidePagerAdapter(FragmentActivity fa) {
            super(fa);
        }

        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return new Fragment1();
                case 1:
                    return new Fragment2();
                case 2:
                    return new Fragment3();
                default:
                    return null; // 이 경우가 발생하지 않도록 주의
            }
        }

        @Override
        public int getItemCount() {
            return 3; // 탭의 총 개수
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ViewPager2 viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new ScreenSlidePagerAdapter(this));

        TabLayout tabs = findViewById(R.id.tabMain);
        new TabLayoutMediator(tabs, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("뉴스레터");
                    break;
                case 1:
                    tab.setText("신문보기");
                    break;
                case 2:
                    tab.setText("해외뉴스");
                    break;
                default:
                    tab.setText("탭 " + (position + 1));
                    break;
            }
        }).attach();
    }
}