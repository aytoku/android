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

public class UserAgreementFragment extends Fragment {

    public static final String TAG = "UserAgreementFragment";

    public static UserAgreementFragment getInstance(Bundle args) {

        UserAgreementFragment f = new UserAgreementFragment();
        f.setArguments(args);

        return f;
    }

    ImageButton imageButton;
    WebView webView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.user_agreement,
                container, false);

        imageButton = view.findViewById(R.id.rl_choose_place_button);

        webView = view.findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://faem.ru/soglashenie.html");

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