package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication_1.R;

public class SloppyDrivingFragment extends Fragment {

    public static final String TAG = "SloppyDrivingFragment";

    public static SloppyDrivingFragment getInstance(Bundle args) {

        SloppyDrivingFragment sloppyDrivingFragment = new SloppyDrivingFragment();
        sloppyDrivingFragment.setArguments(args);

        return sloppyDrivingFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.sloppy_driving,
                container, false);

        ImageButton imageButton = view.findViewById(R.id.rl_sloppy_driving_img);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                ServiceFragment serviceFragment = ServiceFragment.getInstance(bundle);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, serviceFragment);
                fragmentTransaction.commit();
            }
        });

        return view;

    }
}
