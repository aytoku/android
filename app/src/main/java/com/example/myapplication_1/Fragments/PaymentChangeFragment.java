package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication_1.R;

public class PaymentChangeFragment extends Fragment {

    public static final String TAG = "PaymentChangeFragment";
    Button button;

    public static PaymentChangeFragment getInstance(Bundle args) {

        PaymentChangeFragment f = new PaymentChangeFragment();
        f.setArguments(args);

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.payment_change,
                container, false);

        button = view.findViewById(R.id.ll_payment_change_button);

        addListener();

        return view;
    }

    public void addListener(){

        Bundle _args = new Bundle();
        final Fragment machinePurposeTwoFragment = MachinePurposeTwoFragment.getInstance(_args);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_main, machinePurposeTwoFragment);
                fragmentTransaction.commit();
            }
        });
    }
}
