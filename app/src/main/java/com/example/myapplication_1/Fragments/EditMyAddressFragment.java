package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication_1.R;

public class EditMyAddressFragment extends Fragment {

    public static final String TAG = "EditMyAddressFragment";

    ImageButton button;

    public static EditMyAddressFragment getInstance(Bundle args) {

        EditMyAddressFragment f = new EditMyAddressFragment();
        f.setArguments(args);

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.edit_my_address_fragment,
                container, false);

        button = view.findViewById(R.id.rl_edit_my_address_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle _args = new Bundle();
                Fragment addressFragment = AddressFragment.getInstance(_args);

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_main, addressFragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}
