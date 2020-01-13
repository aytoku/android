package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.myapplication_1.R;

public class MachinePurposeLowerPartFragment extends Fragment {

    public static final String TAG = "MachinePurposeLowerPartFragment";

    public static MachinePurposeLowerPartFragment getInstance(Bundle args) {

        MachinePurposeLowerPartFragment f = new MachinePurposeLowerPartFragment();
        f.setArguments(args);

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.cell_machine_purpose_lower_part,
                container, false);

        return view;
    }
}
