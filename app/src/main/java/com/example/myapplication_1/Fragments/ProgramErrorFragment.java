package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication_1.R;

public class ProgramErrorFragment extends Fragment {

    public static final String TAG = "ProgramErrorTwoFragment";

    public static ProgramErrorFragment getInstance(Bundle args) {

        ProgramErrorFragment programErrorFragment = new ProgramErrorFragment();
        programErrorFragment.setArguments(args);

        return programErrorFragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.programm_error_2,
                container, false);

        TextView title = view.findViewById(R.id.rl_program_error1_title);
        Bundle bundle = getArguments();
        String message = bundle.getString("message");
        title.setText(message);

        ImageButton imageButton = view.findViewById(R.id.rl_program_error1_img);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle _args = new Bundle();
                final Fragment menu162Fragment = Menu162Fragment.getInstance(_args);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, menu162Fragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}