package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.example.myapplication_1.R;

public class TariffsFragment extends Fragment {

    public static final String TAG = "TariffsFragment";
    ImageButton imageButton;

    public static TariffsFragment getInstance(Bundle args) {

        TariffsFragment f = new TariffsFragment();
        f.setArguments(args);

        return f;
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
