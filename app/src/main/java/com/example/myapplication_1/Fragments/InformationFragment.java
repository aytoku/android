package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication_1.R;

public class InformationFragment extends Fragment {

    public static final String TAG = "InformationFragment";

    public static InformationFragment getInstance(Bundle args) {

        InformationFragment f = new InformationFragment();
        f.setArguments(args);

        return f;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.info,
                container, false);

        ImageButton imageButton = view.findViewById(R.id.ll_info_button);
        RelativeLayout relativeLayout1 = view.findViewById(R.id.rl_info3);
        RelativeLayout relativeLayout2 = view.findViewById(R.id.rl_info2);
        RelativeLayout relativeLayout3 = view.findViewById(R.id.rl_info1);

        Bundle _args = new Bundle();
        final Fragment menu11Fragment = Menu11Fragment.getInstance(_args);
        final Fragment aboutAppFragment = AboutAppFragment.getInstance(_args);
        final Fragment partnersFragment = PartnersFragment.getInstance(_args);
        final Fragment spinnerTariffsFragment = SpinnerTariffsFragment.getInstance(_args);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, menu11Fragment);
                fragmentTransaction.commit();
            }
        });

        relativeLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, aboutAppFragment);
                fragmentTransaction.commit();
            }
        });

        relativeLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, partnersFragment);
                fragmentTransaction.commit();
            }
        });

        relativeLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, spinnerTariffsFragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}