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

public class WebViewFragment extends Fragment {

    public static final String TAG = "WebViewFragment";

    public static WebViewFragment getInstance(Bundle args) {

        WebViewFragment webViewFragment = new WebViewFragment();
        webViewFragment.setArguments(args);

        return webViewFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.webview,
                container, false);

        WebView webView = view.findViewById(R.id.ll_webView);
        ImageButton imageButton = view.findViewById(R.id.ll_webview_button);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://faem.ru/soglashenie.html");
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                final Auth111Fragment auth111Fragment = Auth111Fragment.getInstance(bundle);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, auth111Fragment);
                fragmentTransaction.commit();
            }
        });
        return view;
    }
}