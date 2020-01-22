package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.myapplication_1.R;

public class ErrorOneFragment extends Fragment {

    public static final String TAG = "ErrorOneFragment";

    public static ErrorOneFragment getInstance(Bundle args) {

        ErrorOneFragment errorOneFragment = new ErrorOneFragment();
        errorOneFragment.setArguments(args);

        return errorOneFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.menu_1_6_2,
                container, false);

        return view;
    }
}
