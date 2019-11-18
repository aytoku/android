package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import com.example.myapplication_1.R;

public class SpinnerTariffsFragment extends Fragment {

    public static final String TAG = "SpinnerTariffsFragment";

    public static SpinnerTariffsFragment getInstance(Bundle args) {

        SpinnerTariffsFragment f = new SpinnerTariffsFragment();
        f.setArguments(args);

        return f;
    }

    String[] choose = {"Эконом", "Стандарт", "Не эконом"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.tariffs,
                container, false);

        Spinner spinner = (Spinner) view.findViewById(R.id.choose);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, choose);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        return view;
    }
}