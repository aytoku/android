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

public class AboutAppFragment  extends Fragment {

    public static final String TAG = "AboutAppFragment";

    public static AboutAppFragment getInstance(Bundle args) {

        AboutAppFragment f = new AboutAppFragment();
        f.setArguments(args);

        return f;
    }

    ImageButton imageButton;
    ImageButton imageButton1;
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.about_app,
                container, false);

        imageButton = view.findViewById(R.id.rl_about_app_button);
        imageButton1 = view.findViewById(R.id.rl_about_app_img_arrow1);
        textView = view.findViewById(R.id.rl_about_app_policy);

        Bundle _args = new Bundle();
        final Fragment informationFragment = InformationFragment.getInstance(_args);
        final Fragment privacyPolicyFragment = PrivacyPolicyFragment.getInstance(_args);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_main, informationFragment);
                fragmentTransaction.commit();
            }
        });

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_main, privacyPolicyFragment);
                fragmentTransaction.commit();
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_main, privacyPolicyFragment);
                fragmentTransaction.commit();
            }
        });

        return view;

    }
}
