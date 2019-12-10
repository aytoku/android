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

public class ServiceFragment extends Fragment {

    public static final String TAG = "ServiceFragment";

    public static ServiceFragment getInstance(Bundle args) {

        ServiceFragment f = new ServiceFragment();
        f.setArguments(args);

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.service,
                container, false);

        ImageButton imageButton = view.findViewById(R.id.ll_service_button);
        RelativeLayout relativeLayout1 = view.findViewById(R.id.rl_service1);
        RelativeLayout relativeLayout2 = view.findViewById(R.id.rl_service2);
        RelativeLayout relativeLayout3 = view.findViewById(R.id.rl_service3);

        Bundle _args = new Bundle();
        final Fragment menu11Fragment = Menu11Fragment.getInstance(_args);
        final Fragment menu161Fragment = Menu162Fragment.getInstance(_args);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_main, menu11Fragment);
                fragmentTransaction.commit();
            }
        });

        relativeLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_main, menu161Fragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}