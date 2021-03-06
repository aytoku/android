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

public class EditMyAddressFragment extends Fragment {

    public static final String TAG = "EditMyAddressFragment";

    public static EditMyAddressFragment getInstance(Bundle args) {

        EditMyAddressFragment editMyAddressFragment = new EditMyAddressFragment();
        editMyAddressFragment.setArguments(args);

        return editMyAddressFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.edit_my_address_fragment,
                container, false);

        TextView textView = view.findViewById(R.id.rl_edit_my_address_delete);
        ImageButton button = view.findViewById(R.id.rl_edit_my_address_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                AddressFragment addressFragment = AddressFragment.getInstance(bundle);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, addressFragment);
                fragmentTransaction.commit();
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                AddressFragment addressFragment = AddressFragment.getInstance(bundle);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, addressFragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}