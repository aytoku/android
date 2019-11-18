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

public class InformationFragment extends Fragment {
    public static final String TAG = "InformationFragment";

    public static InformationFragment getInstance(Bundle args) {

        InformationFragment f = new InformationFragment();
        f.setArguments(args);

        return f;
    }

    private ImageButton imageButton;
    private ImageButton imageButton1;
    private ImageButton imageButton2;
    private ImageButton imageButton3;
    private TextView textView;
    private TextView textView1;
    private TextView textView2;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.info,
                container, false);

        imageButton = view.findViewById(R.id.ll_info_button);
        imageButton1 = view.findViewById(R.id.ll_info_img_arrow3);
        imageButton2 = view.findViewById(R.id.ll_info_img_arrow2);
        imageButton3 = view.findViewById(R.id.ll_info_img_arrow);

        textView = view.findViewById(R.id.ll_info_title);
        textView1 = view.findViewById(R.id.ll_info_title1);
        textView2 = view.findViewById(R.id.ll_info_title2);

        Bundle _args = new Bundle();
        final Fragment menuOneFragment = MenuOneFragment.getInstance(_args);
        final Fragment aboutAppFragment = AboutAppFragment.getInstance(_args);
        final Fragment partnersFragment = PartnersFragment.getInstance(_args);
        final Fragment tariffsFragment = TariffsFragment.getInstance(_args);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_main, menuOneFragment);
                fragmentTransaction.commit();
            }
        });

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_main, aboutAppFragment);
                fragmentTransaction.commit();
            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_main, aboutAppFragment);
                fragmentTransaction.commit();
            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_main, partnersFragment);
                fragmentTransaction.commit();
            }
        });

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_main, partnersFragment);
                fragmentTransaction.commit();
            }
        });

        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_main, tariffsFragment);
                fragmentTransaction.commit();
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_main, tariffsFragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}