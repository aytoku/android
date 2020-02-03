package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import com.example.myapplication_1.R;

import java.util.Objects;

public class DriverSpinnerFragment extends Fragment{

    public static final String TAG = "DriverSpinnerFragment";
    private String[] choose = {"По возрастанию цены", "По убыванию цены", "Не выбрано"};

    public static DriverSpinnerFragment getInstance(Bundle args){

        DriverSpinnerFragment driverSpinnerFragment = new DriverSpinnerFragment();
        driverSpinnerFragment.setArguments(args);

        return driverSpinnerFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.free_order_spinner,
                container, false);

        Spinner spinner = view.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Objects.requireNonNull(this.getActivity()), android.R.layout.simple_spinner_item, choose);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        return view;
    }
}