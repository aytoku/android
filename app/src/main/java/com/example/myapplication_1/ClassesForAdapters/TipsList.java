package com.example.myapplication_1.ClassesForAdapters;

import java.util.List;

public class TipsList {

    private List<Integer> price;

    public TipsList( List<Integer> price){
        this.price = price;
    }

    public  List<Integer>  getPrice(){
        return this.price;
    }

    public void setPrice( List<Integer> price){
        this.price = price;
    }
}
