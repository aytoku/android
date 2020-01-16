package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication_1.R;

public class ProgramErrorTwoFragment extends Fragment {

    public static final String TAG = "ProgramErrorTwoFragment";
    ImageButton imageButton;

    public static ProgramErrorTwoFragment getInstance(Bundle args) {

        ProgramErrorTwoFragment f = new ProgramErrorTwoFragment();
        f.setArguments(args);

        return f;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.programm_error_2,
                container, false);

        Bundle _args = new Bundle();
        final Fragment menu162Fragment = Menu162Fragment.getInstance(_args);

        imageButton = view.findViewById(R.id.ll_program_error1_img);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.rl_main, menu162Fragment);
                        fragmentTransaction.commit();
                    }
                });
            }
        });

        return view;

    }
}