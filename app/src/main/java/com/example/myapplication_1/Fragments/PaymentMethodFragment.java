package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

public class PaymentMethodFragment extends Fragment {

    ImageButton androidImageButton;

    RecyclerView rv;
    public static final String TAG = "PaymentMethodFragment";

    public static PaymentMethodFragment getInstance(Bundle args) {

        PaymentMethodFragment f = new PaymentMethodFragment();
        f.setArguments(args);

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.payment_method,
                container, false);

        androidImageButton = view.findViewById(R.id.img_cross_grey);

        return view;
    }
}