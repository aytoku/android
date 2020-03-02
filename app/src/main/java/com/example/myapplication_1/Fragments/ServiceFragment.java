package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication_1.R;

public class ServiceFragment extends Fragment {

    public static final String TAG = "ServiceFragment";

    public static ServiceFragment getInstance(Bundle args) {

        ServiceFragment serviceFragment = new ServiceFragment();
        serviceFragment.setArguments(args);

        return serviceFragment;
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
        final TextView textView = view.findViewById(R.id.rl_service_ad_ride);

        final Bundle bundle = new Bundle();
        final Menu11Fragment menu11Fragment = Menu11Fragment.getInstance(bundle);
        final Menu162Fragment menu161Fragment = Menu162Fragment.getInstance(bundle);
        final TravelStoryFragment travelStoryFragment = TravelStoryFragment.getInstance(bundle);
        final ProgramErrorFragment programErrorFragment = ProgramErrorFragment.getInstance(bundle);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, menu11Fragment);
                fragmentTransaction.commit();
            }
        });
        relativeLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, travelStoryFragment);
                fragmentTransaction.commit();
            }
        });
        relativeLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = textView.getText().toString();
                Bundle _args = new Bundle();
                _args.putString("message", message);
                programErrorFragment.setArguments(_args);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, programErrorFragment);
                fragmentTransaction.commit();
            }
        });
        relativeLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, menu161Fragment);
                fragmentTransaction.commit();
            }
        });
        return view;
    }
}