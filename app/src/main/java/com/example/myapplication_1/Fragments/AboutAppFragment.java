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

public class AboutAppFragment  extends Fragment {

    public static final String TAG = "AboutAppFragment";

    public static AboutAppFragment getInstance(Bundle args) {

        AboutAppFragment f = new AboutAppFragment();
        f.setArguments(args);

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.about_app,
                container, false);

        ImageButton imageButton = view.findViewById(R.id.rl_about_app_button);
        RelativeLayout relativeLayout = view.findViewById(R.id.rl_about_app_ll_about_app_rl_about_app);
        RelativeLayout relativeLayout1 = view.findViewById(R.id.rl_about_app_rl_about_app1);

        Bundle _args = new Bundle();
        final Fragment informationFragment = InformationFragment.getInstance(_args);
        final Fragment privacyPolicyFragment = PrivacyPolicyFragment.getInstance(_args);
        final Fragment userAgreementFragment = UserAgreementFragment.getInstance(_args);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_main, informationFragment);
                fragmentTransaction.commit();
            }
        });

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_main, privacyPolicyFragment);
                fragmentTransaction.commit();
            }
        });

        relativeLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_main, userAgreementFragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}