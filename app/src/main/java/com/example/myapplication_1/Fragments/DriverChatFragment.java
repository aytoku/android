package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.myapplication_1.R;

public class DriverChatFragment extends Fragment {

    public static final String TAG = "DriverChatFragment";

    public static DriverChatFragment getInstance(Bundle args) {

        DriverChatFragment driverChatFragment = new DriverChatFragment();
        driverChatFragment.setArguments(args);

        return driverChatFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.driver_chat,
                container, false);

        return view;
    }
}