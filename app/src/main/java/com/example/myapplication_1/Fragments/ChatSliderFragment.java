package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication_1.R;
import com.google.android.material.tabs.TabLayout;

public class ChatSliderFragment extends Fragment {

    public static final String TAG = "ChatSliderFragment";

    public static ChatSliderFragment getInstance(Bundle args) {

        ChatSliderFragment chatSliderFragment = new ChatSliderFragment();
        chatSliderFragment.setArguments(args);

        return chatSliderFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.chat_slider,
                container, false);

        ViewPager viewPager = view.findViewById(R.id.chat_slider_viewPager);
        TabLayout tabLayout = view.findViewById(R.id.chat_slider_tabLayout);
        tabLayout.setupWithViewPager(viewPager, true);

        return view;
    }
}