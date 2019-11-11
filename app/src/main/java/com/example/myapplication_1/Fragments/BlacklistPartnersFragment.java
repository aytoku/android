package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.BlacklistPartnersAdapter;
import com.example.myapplication_1.R;

public class BlacklistPartnersFragment extends Fragment {

    public static final String TAG = "BlacklistPartnersFragment";

    public static BlacklistPartnersFragment getInstance(Bundle args) {

        BlacklistPartnersFragment f = new BlacklistPartnersFragment();
        f.setArguments(args);

        return f;
    }

    RecyclerView rv;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.black_list_partner,
                container, false);

        rv = view.findViewById(R.id.ll_blackList_partner_recycler_partners);

        return view;

    }

    @Override
    public void onStart() {
        super.onStart();

        RecyclerView recyclerViewMenu = rv;

        try {
            BlacklistPartnersAdapter.AdapterGridViewMenu.ItemsMenu[] itemsMenu = getMenuItems();//model_data

            BlacklistPartnersAdapter.AdapterGridViewMenu adapterGridViewMenu = new BlacklistPartnersAdapter.AdapterGridViewMenu(itemsMenu, getActivity().getBaseContext());//this;
            recyclerViewMenu.setAdapter( adapterGridViewMenu );
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ) );
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
    }

    private BlacklistPartnersAdapter.AdapterGridViewMenu.ItemsMenu[] getMenuItems() {

        BlacklistPartnersAdapter.AdapterGridViewMenu.ItemsMenu []_arr = new BlacklistPartnersAdapter.AdapterGridViewMenu.ItemsMenu[]{

                new BlacklistPartnersAdapter.AdapterGridViewMenu.ItemsMenu(getResources().getColor(R.color.my_gray),
                        R.drawable.checkbox,
                        "Партнер 1"),
                new BlacklistPartnersAdapter.AdapterGridViewMenu.ItemsMenu(getResources().getColor(R.color.my_gray),
                        R.drawable.icon_accept_checkbox,
                        "Партнер 2"),
                new BlacklistPartnersAdapter.AdapterGridViewMenu.ItemsMenu(getResources().getColor(R.color.my_gray),
                        R.drawable.icon_accept_checkbox,
                        "Партнер 2"),
                new BlacklistPartnersAdapter.AdapterGridViewMenu.ItemsMenu(getResources().getColor(R.color.my_gray),
                        R.drawable.icon_accept_checkbox,
                        "Партнер 2"),
                new BlacklistPartnersAdapter.AdapterGridViewMenu.ItemsMenu(getResources().getColor(R.color.my_gray),
                        R.drawable.icon_accept_checkbox,
                        "Партнер 2"),
                new BlacklistPartnersAdapter.AdapterGridViewMenu.ItemsMenu(getResources().getColor(R.color.my_gray),
                        R.drawable.checkbox,
                        "Партнер 1"),
                new BlacklistPartnersAdapter.AdapterGridViewMenu.ItemsMenu(getResources().getColor(R.color.my_gray),
                        R.drawable.checkbox,
                        "Партнер 1"),
                new BlacklistPartnersAdapter.AdapterGridViewMenu.ItemsMenu(getResources().getColor(R.color.my_gray),
                        R.drawable.checkbox,
                        "Партнер 1"),
                new BlacklistPartnersAdapter.AdapterGridViewMenu.ItemsMenu(getResources().getColor(R.color.my_gray),
                        R.drawable.checkbox,
                        "Партнер 1")
        };
        return _arr;
    }
}