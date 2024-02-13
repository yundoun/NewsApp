package com.example.newsapp;

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

public class NewsReadActivity extends Fragment {
    ArrayList<ReadDataModel> Read_itemList = new ArrayList<>();
    int [] images = {
            R.drawable.a_news1, R.drawable.a_news2
    };

    private final String[] dates = {
            "2024.02.13 (화)", "2024.02.14 (수)" // 날짜 데이터가 하나만 있었으나, 이미지 두 개에 맞추어 두 개의 날짜를 제공합니다.
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View secondView = inflater.inflate(R.layout.activity_news_read, container, false);

        RecyclerView recyclerView = secondView.findViewById(R.id.rv_read);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        setItemList(); // itemList를 초기화합니다.

        ReadRvAdapter adapter = new ReadRvAdapter(getActivity(), Read_itemList);
        recyclerView.setAdapter(adapter);

        return secondView;
    }

    private void setItemList() {
        // 날짜 배열의 길이를 기준으로 합니다. 이미지와 날짜 배열의 길이가 같아야 합니다.
        for (int i = 0; i < dates.length; i++) {
            Read_itemList.add(new ReadDataModel(images[i], dates[i]));
        }
    }
}