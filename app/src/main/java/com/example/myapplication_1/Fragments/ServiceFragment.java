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

public class ServiceFragment extends Fragment {

    public static final String TAG = "ServiceFragment";

    public static ServiceFragment getInstance(Bundle args) {

        ServiceFragment f = new ServiceFragment();
        f.setArguments(args);

        return f;
    }
    private ImageButton imageButton;
    private ImageButton imageButton1;
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.service,
                container, false);

        imageButton = view.findViewById(R.id.ll_service_button);
        imageButton1 = view.findViewById(R.id.ll_service_img_arrow3);
        textView = view.findViewById(R.id.ll_service_program_error);

        Bundle _args = new Bundle();
        final Fragment menuOneFragment = MenuOneFragment.getInstance(_args);
        final Fragment menu162Fragment = Menu162Fragment.getInstance(_args);

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
                fragmentTransaction.replace(R.id.ll_main, menu162Fragment);
                fragmentTransaction.commit();
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_main, menu162Fragment);
                fragmentTransaction.commit();
            }
        });

        return view;

    }
}