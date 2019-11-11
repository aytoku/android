package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.myapplication_1.R;

public class ReasonForRejectionFragment extends Fragment {

    public static final String TAG = "ReasonForRejectionFragment";

    public static ReasonForRejectionFragment getInstance(Bundle args) {

        ReasonForRejectionFragment f = new ReasonForRejectionFragment();
        f.setArguments(args);

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.order_1_1_5,
                container, false);

        return view;

    }
}