package com.example.newsapp;

// RecyclerView에 표시될 각 항목의 데이터 구조를 정의 : text1 과 image
public class FirstDataModel {
    String text1;

    public FirstDataModel(String text1) {
        this.text1 = text1;
    }

    public String getText1() {
        return text1;
    }
}
