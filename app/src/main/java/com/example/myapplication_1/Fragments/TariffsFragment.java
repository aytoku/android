package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.myapplication_1.R;

public class TariffsFragment extends Fragment {

    public static final String TAG = "TariffsFragment";

    public static TariffsFragment getInstance(Bundle args) {

        TariffsFragment tariffsFragment = new TariffsFragment();
        tariffsFragment.setArguments(args);

        return tariffsFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.tariffs,
                container, false);

        return view;

    }
}
