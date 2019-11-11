package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.myapplication_1.R;

public class RefusePaymentFragment extends Fragment {

    public static final String TAG = "RefusePaymentFragment";

    public static RefusePaymentFragment getInstance(Bundle args) {

        RefusePaymentFragment f = new RefusePaymentFragment();
        f.setArguments(args);

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.refuse_payment_method,
                container, false);

        return view;

    }
}