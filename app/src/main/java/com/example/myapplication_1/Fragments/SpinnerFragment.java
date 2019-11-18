package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import com.example.myapplication_1.R;

public class SpinnerFragment extends Fragment {

    public static final String TAG = "SpinnerFragment";

    public static SpinnerFragment getInstance(Bundle args) {

        SpinnerFragment f = new SpinnerFragment();
        f.setArguments(args);

        return f;
    }

    String[] choose = {"Эконом", "Стандарт", "Не эконом"};
    String[] choose_cities = {"Владикавказ", "Ногир", "Беслан"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.information_partners,
                container, false);

        Spinner spinner = (Spinner) view.findViewById(R.id.choose);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, choose);

        Spinner spinner1 = (Spinner) view.findViewById(R.id.choose_cities);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, choose_cities);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner1.setAdapter(adapter1);

        return view;
    }
}