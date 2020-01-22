package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.myapplication_1.R;

public class MenuTwoFragment extends Fragment {

    public static final String TAG = "MenuTwoFragment";

    public static MenuTwoFragment getInstance(Bundle args) {

        MenuTwoFragment menuTwoFragment = new MenuTwoFragment();
        menuTwoFragment.setArguments(args);

        return menuTwoFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.menu_1_1,
                container, false);

        return view;

    }
}