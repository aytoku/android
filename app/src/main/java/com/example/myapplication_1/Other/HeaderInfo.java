package com.example.myapplication_1.Other;

import java.util.ArrayList;

public class HeaderInfo {

    private String name;
    private ArrayList<DetailInfo> productList = new ArrayList<DetailInfo>();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<DetailInfo> getProductList() {
        return productList;
    }
    void setProductList(ArrayList<DetailInfo> productList) {
        this.productList = productList;
    }
}
