package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.AdapterMenu162;
import com.example.myapplication_1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu162Fragment extends Fragment {

    public static final String TAG = "Menu162Fragment";

    public static Menu162Fragment getInstance(Bundle args) {

        Menu162Fragment f = new Menu162Fragment();
        f.setArguments(args);

        return f;
    }

    RecyclerView rv;
    RecyclerView.Adapter adapterGridViewMenu;
    private List<AdapterMenu162.AdapterGridViewMenu.ItemsMenu> itemsMenuList;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.menu_1_6_2,
                container, false);


        rv = view.findViewById(R.id.rl_menu_1_6_2_recycler);

        final RecyclerView recyclerViewMenu = rv;

        try {

            AdapterMenu162.AdapterGridViewMenu.ItemsMenu[] itemsMenu = getMenuItems();
            itemsMenuList = new ArrayList<>(Arrays.asList(itemsMenu));
            adapterGridViewMenu = new AdapterMenu162.AdapterGridViewMenu(itemsMenuList, getActivity().getBaseContext());
            recyclerViewMenu.setAdapter(adapterGridViewMenu);
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ));
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    private AdapterMenu162.AdapterGridViewMenu.ItemsMenu[] getMenuItems() {

        AdapterMenu162.AdapterGridViewMenu.ItemsMenu[] arr = new AdapterMenu162.AdapterGridViewMenu.ItemsMenu[]{

                new AdapterMenu162.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Большая стоимость",
                        R.drawable.icon_arrow_right),

                new AdapterMenu162.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Не дали сдачи",
                        R.drawable.icon_arrow_right),

                new AdapterMenu162.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Ошибка программы",
                        R.drawable.icon_arrow_right)
        };
        return arr;
    }
}

