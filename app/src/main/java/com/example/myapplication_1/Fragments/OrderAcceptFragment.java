package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.myapplication_1.R;

public class OrderAcceptFragment extends Fragment {

    public static final String TAG = "OrderAcceptFragment";

    public static OrderAcceptFragment getInstance(Bundle args) {

        OrderAcceptFragment f = new OrderAcceptFragment();
        f.setArguments(args);

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.order_accept,
                container, false);

        TextView textView = view.findViewById(R.id.cv_order_accept_desc);
        textView.setText(Html.fromHtml("Введите цифру <b>1234</b>, чтобы\nподтвердить завершение на\nданном расстоянии до места\nназначения"));

        return view;
    }
}