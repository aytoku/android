package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication_1.R;

public class PrivacyPolicyFragment extends Fragment {

    public static final String TAG = "PrivacyPolicyFragment";

    public static PrivacyPolicyFragment getInstance(Bundle args) {

        PrivacyPolicyFragment privacyPolicyFragment = new PrivacyPolicyFragment();
        privacyPolicyFragment.setArguments(args);

        return privacyPolicyFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.policy_confidentiality,
                container, false);

        ImageButton imageButton = view.findViewById(R.id.rl_choose_place_button);
        WebView webView = view.findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("http://faem.ru/licensiya.html");

        Bundle _args = new Bundle();
        final AboutAppFragment aboutAppFragment = AboutAppFragment.getInstance(_args);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, aboutAppFragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}