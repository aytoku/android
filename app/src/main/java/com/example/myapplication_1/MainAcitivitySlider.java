package com.example.myapplication_1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication_1.Adapters.ViewPagerAdapter;
import com.example.myapplication_1.Fragments.AddPointFragment;
import com.google.android.material.tabs.TabLayout;

import java.io.IOException;

public class MainAcitivitySlider extends Fragment {

    public static final String TAG = "AddPointFragment";

    public static AddPointFragment getInstance(Bundle args) {

        AddPointFragment f = new AddPointFragment();
        f.setArguments(args);

        return f;
    }

    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.slider_main,
                container, false);

        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager, true);

        ViewPagerAdapter viewPagerAdapter = null;
        try {
            viewPagerAdapter = new ViewPagerAdapter(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        viewPager.setAdapter(viewPagerAdapter);

        return view;
    }
}
