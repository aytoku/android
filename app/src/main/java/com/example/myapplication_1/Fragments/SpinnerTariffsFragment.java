package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication_1.R;

public class SpinnerTariffsFragment extends Fragment {

    public static final String TAG = "SpinnerTariffsFragment";
    private String[] choose = {"Эконом", "Стандарт", "Не эконом"};

    public static SpinnerTariffsFragment getInstance(Bundle args) {

        SpinnerTariffsFragment spinnerTariffsFragment = new SpinnerTariffsFragment();
        spinnerTariffsFragment.setArguments(args);

        return spinnerTariffsFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.tariffs,
                container, false);

        ImageButton imageButton = view.findViewById(R.id.rl_tariffs_button);
        Spinner spinner = (Spinner) view.findViewById(R.id.choose);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, choose);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Bundle _args = new Bundle();
        final InformationFragment informationFragment = InformationFragment.getInstance(_args);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, informationFragment);
                fragmentTransaction.commit();
            }
        });
        return view;
    }
}