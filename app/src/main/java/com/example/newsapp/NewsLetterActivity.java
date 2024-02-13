package com.example.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NewsLetterActivity extends Fragment implements NewsDetailInterface {

    ArrayList<LetterDataModel> itemList = new ArrayList<>();

    int[] images = {
            R.drawable.a_soccer
    };
    String[] date = {
            "2024-02-07"
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View firstView = inflater.inflate(R.layout.activity_news_letter, container, false);

        RecyclerView recyclerView = firstView.findViewById(R.id.rv_first);
        // 레이아웃 매니저 설정
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        // 데이터 설정
        setItemList();

        LetterRvAdapter adapter = new LetterRvAdapter(getActivity(), itemList, this);
        recyclerView.setAdapter(adapter);

        return firstView;
    }

    private void setItemList() {
        String[] items = getResources().getStringArray(R.array.first_items);
        for (String item : items) {
            itemList.add(new LetterDataModel(item, images[0], date[0]));
        }
    }

    @Override
    public void onItemClick(int position) {
        LetterDataModel selectedNews = itemList.get(position);

        Intent detailIntent = new Intent(getActivity(), NewsDetailActivity.class);
        detailIntent.putExtra("news_title", selectedNews.getTitle());
        detailIntent.putExtra("news_date", selectedNews.getDate());
        detailIntent.putExtra("news_image", selectedNews.getImage());
        startActivity(detailIntent);
    }
}