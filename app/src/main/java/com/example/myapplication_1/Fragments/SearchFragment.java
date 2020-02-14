package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication_1.R;

public class SearchFragment extends Fragment {

    public static final String TAG = "SearchFragment";
    private LinearLayout linearLayout;
    private EditText editText;

    public static SearchFragment getInstance(Bundle args) {

        SearchFragment searchFragment = new SearchFragment();
        searchFragment.setArguments(args);

        return searchFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.search,
                container, false);

        linearLayout = view.findViewById(R.id.ll_search_button);
        editText = view.findViewById(R.id.ll_search_address_title);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                AddressFragment addressFragment = AddressFragment.getInstance(bundle);
                String message = editText.getText().toString();
                bundle.putString("message", message);
                addressFragment.setArguments(bundle);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, addressFragment);
                fragmentTransaction.commit();
            }
        });
        return view;
    }
}