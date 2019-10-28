package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.myapplication_1.R;

public class EnergyReductionFragment extends Fragment {

    public static final String TAG = "EnergyReductionFragment";

    public static EnergyReductionFragment getInstance(Bundle args) {

        EnergyReductionFragment f = new EnergyReductionFragment();
        f.setArguments(args);

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.energy_reduction,
                container, false);

        return view;
    }
}
