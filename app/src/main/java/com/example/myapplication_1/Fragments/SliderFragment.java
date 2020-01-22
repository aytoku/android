package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication_1.Adapters.ChatViewPagerAdapter;
import com.example.myapplication_1.R;

public class SliderFragment extends Fragment {

    public static final String TAG = "SliderFragment";

    public static SliderFragment getInstance(Bundle args) {

        SliderFragment sliderFragment= new SliderFragment();
        sliderFragment.setArguments(args);

        return sliderFragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.slider_main,
                container, false);

        ViewPager viewPager = view.findViewById(R.id.viewPager);
        if (viewPager != null) {
            ChatViewPagerAdapter adapter = new ChatViewPagerAdapter(getFragmentManager());
            viewPager.setAdapter(adapter);
        }
        return view;
    }
}