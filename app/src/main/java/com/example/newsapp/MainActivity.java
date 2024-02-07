package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();
        Fragment3 fragment3 = new Fragment3();

        // 초기 화면 설정
        getSupportFragmentManager().beginTransaction().add(R.id.frame, fragment1).commit();

        TabLayout tabs = findViewById(R.id.tabMain);

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();

                Fragment selectedFragment = null;

                switch(position){
                    case 0:
                        selectedFragment =fragment1;
                        break;
                    case 1:
                        selectedFragment = fragment2;
                        break;
                    case 2:
                        selectedFragment = fragment3;
                        break;
                }
                // 안드로이드 앱 내에서 동적으로 프래그먼트를 교체하는 역할
                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, selectedFragment).commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}