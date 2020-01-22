package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.myapplication_1.R;

public class WriteFragment extends Fragment {

    public static final String TAG = "WriteFragment";

    public static WriteFragment getInstance(Bundle args) {

        WriteFragment writeFragment = new WriteFragment();
        writeFragment.setArguments(args);

        return writeFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.machine_purpose1,
                container, false);

        return view;
    }
}