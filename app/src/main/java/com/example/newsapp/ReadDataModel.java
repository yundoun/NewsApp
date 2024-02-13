package com.example.newsapp;

public class ReadDataModel {

    private int read_image;
    private String read_date;

    public ReadDataModel(int image, String date){
        this.read_image = image;
        this.read_date = date;
    }
    public int getImage() {
        return read_image;
    }

    public String getDate() {
        return read_date;
    }
}
