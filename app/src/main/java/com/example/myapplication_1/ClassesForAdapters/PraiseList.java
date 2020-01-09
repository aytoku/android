package com.example.myapplication_1.ClassesForAdapters;

public class PraiseList {

    private int image;
    private String title;

    public PraiseList(int image, String title){
        this.image = image;
        this.title = title;
    }

    public int getImage(){
        return this.image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
