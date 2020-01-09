package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication_1.R;

public class MachinePurposeTwoFragment extends Fragment {

    public static final String TAG = "MachinePurposeTwoFragment";
    ImageButton button;
    ImageButton button1;


    public static MachinePurposeTwoFragment getInstance(Bundle args) {

        MachinePurposeTwoFragment f = new MachinePurposeTwoFragment();
        f.setArguments(args);

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.cell_machine_purpose2,
                container, false);


        button = view.findViewById(R.id.ll_machine_purpose2_imgButton);

        button1 = view.findViewById(R.id.ll_machine_purpose2_rl_cell_machine_purpose2_1_imgButton);

        addListener();
        addListener2();

        return view;
    }

    public void addListener(){

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment paymentChangeFragment = new MachinePurposeTwoFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_main, paymentChangeFragment);
                fragmentTransaction.commit();
            }
        });
    }

    public void addListener2(){

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment tripDetailsFragment = new MachinePurposeTwoFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_main, tripDetailsFragment);
                fragmentTransaction.commit();
            }
        });
    }
}
