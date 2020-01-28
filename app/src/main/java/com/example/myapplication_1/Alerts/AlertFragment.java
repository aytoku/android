package com.example.myapplication_1.Alerts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.myapplication_1.R;

public class AlertFragment extends Fragment {

    public static final String TAG = "AlertFragment";

    public static AlertFragment getInstance(Bundle args) {

        AlertFragment alertFragment = new AlertFragment();
        alertFragment.setArguments(args);

        return alertFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.alert,
                container, false);

        return view;
    }
}