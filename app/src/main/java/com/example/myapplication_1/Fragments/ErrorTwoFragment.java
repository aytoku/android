package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.myapplication_1.R;

public class ErrorTwoFragment extends Fragment {

    public static final String TAG = "ErrorTwoFragment";

    public static ErrorTwoFragment getInstance(Bundle args) {

        ErrorTwoFragment f = new ErrorTwoFragment();
        f.setArguments(args);

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.programm_error_2,
                container, false);

        return view;

    }
}