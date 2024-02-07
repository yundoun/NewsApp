package com.example.newsapp;

// RecyclerView에 표시될 각 항목의 데이터 구조를 정의 : text1 과 image
public class FirstDataModel {
    String title;
    int image;

    public FirstDataModel(String text1, int image) {
        this.title = text1;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }
}
