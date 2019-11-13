package com.example.myapplication_1;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication_1.Adapters.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.io.IOException;

public class MainActivitySlider extends Activity {

    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.slider_main);

        viewPager = (ViewPager)findViewById(R.id.viewPager);
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager, true);

        ViewPagerAdapter viewPagerAdapter = null;
        try {
            viewPagerAdapter = new ViewPagerAdapter(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        viewPager.setAdapter(viewPagerAdapter);
    }
}
