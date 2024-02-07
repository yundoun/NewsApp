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

public class Fragment1 extends Fragment {

    ArrayList<FirstDataModel> firstDataModels = new ArrayList<>();
    RecyclerView recyclerView;
    FirstRvAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View firstView = inflater.inflate(R.layout.fragment1, container, false);

        // 리사이클러뷰 참조 얻기
        recyclerView = firstView.findViewById(R.id.rv_first);

        // 레이아웃 매니저 설정
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // 데이터 설정
        setFirstDataModels();

        adapter = new FirstRvAdapter(getActivity(), firstDataModels);
        recyclerView.setAdapter(adapter);

        return firstView;
    }

    private void setFirstDataModels(){
        String[] items = getResources().getStringArray(R.array.first_items);
        for (int i =0; i<items.length; i++){
            firstDataModels.add(new FirstDataModel(items[i]));
        }
    }

}