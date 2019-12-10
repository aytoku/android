package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.Order115Adapter;
import com.example.myapplication_1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order115Fragment extends Fragment {

    public static final String TAG = "Order115Fragment";

    public static Order115Fragment getInstance(Bundle args) {

        Order115Fragment f = new Order115Fragment();
        f.setArguments(args);

        return f;
    }

    RecyclerView rv;
    RecyclerView.Adapter adapterGridViewMenu;
    private List<Order115Adapter.ItemsMenu> itemsMenuList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.order_1_1_5,
                container, false);

        rv = view.findViewById(R.id.cl_create_order_1_1_5_recycler);
        final RecyclerView recyclerViewMenu = rv;

        try {

            Order115Adapter.ItemsMenu[] itemsMenu = getMenuItems();
            itemsMenuList = new ArrayList<>(Arrays.asList(itemsMenu));
            adapterGridViewMenu = new Order115Adapter(itemsMenuList, getActivity().getBaseContext());
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

    private Order115Adapter.ItemsMenu[] getMenuItems() {

        Order115Adapter.ItemsMenu[] arr = new Order115Adapter.ItemsMenu[]{

                new Order115Adapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "\uD83D\uDE0A",
                        "Заказал по ошибке"),

                new Order115Adapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "\uD83D\uDE0A",
                        "Заказал по ошибке"),

                new Order115Adapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "\uD83D\uDE0A",
                        "Заказал по ошибке"),

                new Order115Adapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "\uD83D\uDE0A",
                        "Заказал по ошибке"),


                new Order115Adapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "\uD83D\uDE0A",
                        "Заказал по ошибке")
        };
        return arr;
    }
}