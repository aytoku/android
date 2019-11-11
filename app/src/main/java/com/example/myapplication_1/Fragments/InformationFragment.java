package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.myapplication_1.R;

public class InformationFragment extends Fragment {
    public static final String TAG = "InformationFragment";

    public static InformationFragment getInstance(Bundle args) {

        InformationFragment f = new InformationFragment();
        f.setArguments(args);

        return f;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.info,
                container, false);

        return view;

    }
}