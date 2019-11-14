package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.Error12Adapter;
import com.example.myapplication_1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Error12Fragment extends Fragment {


    public static final String TAG = "Error12Fragment";

    public static Error12Fragment getInstance(Bundle args) {

        Error12Fragment f = new Error12Fragment();
        f.setArguments(args);

        return f;
    }

    RecyclerView rv;
    RecyclerView rv1;
    private List<Error12Adapter.ItemsMenu> itemsMenuList;
    private List<Error12Adapter.ItemsMenu> itemsMenuList1;
    RecyclerView.Adapter adapterGridViewMenu;
    RecyclerView.Adapter adapterGridViewMenu1;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.error_1_2,
                container, false);

        rv = view.findViewById(R.id.ll_error_1_2_recycler);

        rv1 = view.findViewById(R.id.ll_error_1_2_recycler1);

        final RecyclerView recyclerViewMenu = rv;

        try {

            Error12Adapter.ItemsMenu[] itemsMenu = getMenuItems();
            itemsMenuList = new ArrayList<>(Arrays.asList(itemsMenu));
            adapterGridViewMenu = new Error12Adapter(itemsMenuList, getActivity().getBaseContext());
            recyclerViewMenu.setAdapter(adapterGridViewMenu);
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ));
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }

        final RecyclerView recyclerViewMenu1 = rv1;

        try {

            Error12Adapter.ItemsMenu[] itemsMenu = getMenuItems();
            itemsMenuList1 = new ArrayList<>(Arrays.asList(itemsMenu));
            adapterGridViewMenu1 = new Error12Adapter(itemsMenuList1, getActivity().getBaseContext());
            recyclerViewMenu1.setAdapter(adapterGridViewMenu1);
            recyclerViewMenu1.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.HORIZONTAL, false ));
            recyclerViewMenu1.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
        return view;
    }

    private Error12Adapter.ItemsMenu[] getMenuItems() {

        Error12Adapter.ItemsMenu[] arr = new Error12Adapter.ItemsMenu[]{

                new Error12Adapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        R.drawable.ic_driver_cross,
                        "Вежливость","", R.drawable.icon_arrow_right
                ),

                new Error12Adapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        R.drawable.ic_driver_cross,
                        "Вежливость","", R.drawable.icon_arrow_right
                ),

                new Error12Adapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        R.drawable.ic_driver_cross,
                        "Вежливость","", R.drawable.icon_arrow_right
                )
        };
        return arr;
    }
}