package com.example.myapplication_1.ClassesForAdapters;

import java.util.List;

public class TipsList {

    private String price;
    private List<Integer>list;

    public TipsList( String price, List<Integer>list){
        this.price = price;
        this.list = list;
    }

    public  String  getPrice(){
        return this.price;
    }

    public void setPrice( String price){
        this.price = price;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }
}
