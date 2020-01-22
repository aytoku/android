package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.myapplication_1.R;

public class InformationPartnersFragment extends Fragment {

    public static final String TAG = "InformationPartnersFragment";

    public static InformationPartnersFragment getInstance(Bundle args) {

        InformationPartnersFragment informationPartnersFragment = new InformationPartnersFragment();
        informationPartnersFragment.setArguments(args);

        return informationPartnersFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.information_partners,
                container, false);

        return view;
    }
}