package com.example.myapplication_1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.io.IOException;

public class MainAcitivitySlider extends AppCompatActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slider_main);

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        ViewPagerAdapter viewPagerAdapter = null;
        try {
            viewPagerAdapter = new ViewPagerAdapter(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        viewPager.setAdapter(viewPagerAdapter);
    }
}
