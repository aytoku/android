package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.PartnersAdapter;
import com.example.myapplication_1.R;

public class PartnersFragment extends Fragment {

    public static final String TAG = "PartnersFragment";

    public static PartnersFragment getInstance(Bundle args) {

        PartnersFragment f = new PartnersFragment();
        f.setArguments(args);

        return f;
    }

    RecyclerView rv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.partners,
                container, false);

        rv = view.findViewById(R.id.recycler_partners);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        RecyclerView recyclerViewMenu = rv;

        try {
            PartnersAdapter.ItemsMenu[] itemsMenu = getMenuItems();

            PartnersAdapter adapterGridViewMenu = new PartnersAdapter(itemsMenu, getActivity().getBaseContext());
            recyclerViewMenu.setAdapter( adapterGridViewMenu );
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ) );
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
    }

    private PartnersAdapter.ItemsMenu[] getMenuItems() {

        PartnersAdapter.ItemsMenu []_arr = new PartnersAdapter.ItemsMenu[]{

                new PartnersAdapter.ItemsMenu(getResources().getColor(R.color.my_gray),
                        R.drawable.ic_vector_grey,
                        "Партнер 1"),
                new PartnersAdapter.ItemsMenu(getResources().getColor(R.color.my_gray),
                        R.drawable.ic_vector_grey,
                        "Партнер 2")
        };
        return _arr;
    }
}