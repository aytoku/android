package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.AdapterMenu11;
import com.example.myapplication_1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu11Fragment extends Fragment {

    public static final String TAG = "Menu11Fragment";

    public static Menu11Fragment getInstance(Bundle args) {

        Menu11Fragment f = new Menu11Fragment();
        f.setArguments(args);

        return f;
    }

    RecyclerView rv;
    RecyclerView.Adapter adapterGridViewMenu;
    private List<AdapterMenu11.AdapterGridViewMenu.ItemsMenu> itemsMenuList;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.menu_1_1,
                container, false);

        rv = view.findViewById(R.id.rl_menu_1_1_recycler);

        final RecyclerView recyclerViewMenu = rv;

        try {

            AdapterMenu11.AdapterGridViewMenu.ItemsMenu[] itemsMenu = getMenuItems();
            itemsMenuList = new ArrayList<>(Arrays.asList(itemsMenu));
            adapterGridViewMenu = new AdapterMenu11.AdapterGridViewMenu(itemsMenuList, getActivity().getBaseContext());
            recyclerViewMenu.setAdapter(adapterGridViewMenu);
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ));
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
        return view;
    }

    private AdapterMenu11.AdapterGridViewMenu.ItemsMenu[] getMenuItems() {

        AdapterMenu11.AdapterGridViewMenu.ItemsMenu[] arr = new AdapterMenu11.AdapterGridViewMenu.ItemsMenu[]{

                new AdapterMenu11.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "+7 963 377 88 44"),

                new AdapterMenu11.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Способы оплаты"),

                new AdapterMenu11.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Бонусы"),

                new AdapterMenu11.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "История поездок"),

                new AdapterMenu11.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Мои адреса"),

                new AdapterMenu11.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Настройки"),

                new AdapterMenu11.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Информация")
        };
        return arr;
    }
}

