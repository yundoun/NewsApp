package com.example.newsapp;

// RecyclerView에 표시될 각 항목의 데이터 구조를 정의 : text1 과 image
public class LetterDataModel {
    String title, date;
    int image;

    public LetterDataModel(String text1, int image, String date) {
        this.title = text1;
        this.image = image;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }
    public String getDate() {return date;}
    public int getImage() {return image;}
}
