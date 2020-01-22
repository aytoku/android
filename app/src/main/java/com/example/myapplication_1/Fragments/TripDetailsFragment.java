package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication_1.R;

public class TripDetailsFragment extends Fragment {

    public static final String TAG = "PaymentChangeFragment";
    private ImageButton button;

    public static PaymentChangeFragment getInstance(Bundle args) {

        PaymentChangeFragment paymentChangeFragment = new PaymentChangeFragment();
        paymentChangeFragment.setArguments(args);

        return paymentChangeFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.trip_details,
                container, false);

        button = view.findViewById(R.id.rl_order_details_button);
        addListener();
        return view;
    }

    private void addListener(){
        Bundle _args = new Bundle();
        final Fragment machinePurposeTwoFragment = MachinePurposeLowerPartFragment.getInstance(_args);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, machinePurposeTwoFragment);
                fragmentTransaction.commit();
            }
        });
    }
}