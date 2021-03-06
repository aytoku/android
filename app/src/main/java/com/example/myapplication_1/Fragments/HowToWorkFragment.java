package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.myapplication_1.R;

public class HowToWorkFragment extends Fragment {

    public static final String TAG = "HowToWork";

    public static HowToWorkFragment getInstance(Bundle args){
        HowToWorkFragment howToWorkFragment = new HowToWorkFragment();
        howToWorkFragment.setArguments(args);

        return howToWorkFragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.how_to_work, container, false);

        return view;
    }
}
