package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.myapplication_1.R;

public class SearchCarFragment extends Fragment {

    public static final String TAG = "SearchCarFragment";

    public static SearchCarFragment getInstance(Bundle args) {

        SearchCarFragment searchCarFragment = new SearchCarFragment();
        searchCarFragment.setArguments(args);

        return searchCarFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.search_car,
                container, false);

        return view;
    }
}