package com.example.myapplication_1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

class EditMyAddressFragment extends Fragment {

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

        return view;
    }
}
