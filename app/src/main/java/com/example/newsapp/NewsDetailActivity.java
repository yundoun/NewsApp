package com.example.newsapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar; // 올바른 Toolbar 임포트

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NewsDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        String newsTitle = getIntent().getStringExtra("news_title");
        String newsDate = getIntent().getStringExtra("news_date");
        int newsImage = getIntent().getIntExtra("news_image", 0); // 기본값으로 0을 사용

        TextView titleTextView = findViewById(R.id.detailNewsTitle);
        TextView dateTextView = findViewById(R.id.detailNewsDate);
        ImageView imageView = findViewById(R.id.detailNewsImage);

        titleTextView.setText(newsTitle);
        dateTextView.setText(newsDate);
        imageView.setImageResource(newsImage);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // 뒤로 가기 버튼 활성화
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        FloatingActionButton fabBack = findViewById(R.id.fab_back);
        fabBack.setOnClickListener((View.OnClickListener) view -> {
            // 액티비티 종료하여 이전 화면으로 돌아가기
            finish();
        });

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // 현재 액티비티 종료
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
