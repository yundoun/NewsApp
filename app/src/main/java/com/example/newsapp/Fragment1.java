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

    int [] images = {
            R.drawable.a_soccer
    };
    String [] date = {
            "2024-02-07"
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View firstView = inflater.inflate(R.layout.fragment1, container, false);

        RecyclerView  recyclerView = firstView.findViewById(R.id.rv_first);
        // 레이아웃 매니저 설정
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        // 데이터 설정
        setFirstDataModels();

        FirstRvAdapter adapter = new FirstRvAdapter(getActivity(), firstDataModels);
        recyclerView.setAdapter(adapter);

        return firstView;
    }

    private void setFirstDataModels(){
        String[] items = getResources().getStringArray(R.array.first_items);
        for (int i =0; i<items.length; i++){
            firstDataModels.add(new FirstDataModel(items[i],images[0], date[0] ));
        }
    }

}