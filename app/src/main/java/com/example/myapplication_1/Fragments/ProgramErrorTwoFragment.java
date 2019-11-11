package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.myapplication_1.R;

public class ProgramErrorTwoFragment extends Fragment {

    public static final String TAG = "ProgramErrorTwoFragment";

    public static ProgramErrorTwoFragment getInstance(Bundle args) {

        ProgramErrorTwoFragment f = new ProgramErrorTwoFragment();
        f.setArguments(args);

        return f;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.programm_error_2,
                container, false);

        return view;

    }
}