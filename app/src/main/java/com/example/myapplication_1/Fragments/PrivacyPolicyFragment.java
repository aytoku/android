package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication_1.R;

public class PrivacyPolicyFragment extends Fragment {

    public static final String TAG = "PrivacyPolicyFragment";

    public static PrivacyPolicyFragment getInstance(Bundle args) {

        PrivacyPolicyFragment f = new PrivacyPolicyFragment();
        f.setArguments(args);

        return f;
    }

    ImageButton imageButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.policy_confidentiality,
                container, false);

        imageButton = view.findViewById(R.id.rl_choose_place_button);

        Bundle _args = new Bundle();
        final Fragment aboutAppFragment = AboutAppFragment.getInstance(_args);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_main, aboutAppFragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}