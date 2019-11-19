package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication_1.R;

public class NewCardFragment extends Fragment {

    public static final String TAG = "NewCardFragment";

    public static NewCardFragment getInstance(Bundle args) {

        NewCardFragment f = new NewCardFragment();
        f.setArguments(args);

        return f;
    }

    ImageButton imageButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.new_card,
                container, false);

        imageButton = view.findViewById(R.id.rl_new_card_button);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle _args = new Bundle();
                Fragment paymentMethodFragment = PaymentMethodFragment.getInstance(_args);

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_main, paymentMethodFragment);
                fragmentTransaction.commit();

            }
        });

        return view;

    }
}