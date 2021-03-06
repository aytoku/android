package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.myapplication_1.R;

public class PaymentChangeFragment extends Fragment {

    public static final String TAG = "PaymentChangeFragment";

    public static PaymentChangeFragment getInstance(Bundle args) {

        PaymentChangeFragment paymentChangeFragment = new PaymentChangeFragment();
        paymentChangeFragment.setArguments(args);

        return paymentChangeFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.payment_change,
                container, false);

        return view;
    }
}
