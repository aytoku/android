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
        Order115Fragment order115Fragment = new Order115Fragment();
        order115Fragment.setArguments(args);

        return order115Fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.order_1_1_5,
                container, false);

        RecyclerView order115_rv = view.findViewById(R.id.rl_create_order_1_1_5_recycler);
        try {
            Order115Adapter.Order115Items[] order115Items = getOrder115Items();
            List<Order115Adapter.Order115Items> order115ItemsList = new ArrayList<>(Arrays.asList(order115Items));
            RecyclerView.Adapter order115Adapter = new Order115Adapter(order115ItemsList, getActivity().getBaseContext());
            order115_rv.setAdapter(order115Adapter);
            order115_rv.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ));
            order115_rv.setItemAnimator( new DefaultItemAnimator() );
        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    private Order115Adapter.Order115Items[] getOrder115Items() {
        Order115Adapter.Order115Items[] arr = new Order115Adapter.Order115Items[]{
                new Order115Adapter.Order115Items(
                        "\uD83D\uDE0A",
                        "Заказал по ошибке"),

                new Order115Adapter.Order115Items(
                        "\uD83D\uDE0A",
                        "Заказал по ошибке"),

                new Order115Adapter.Order115Items(
                        "\uD83D\uDE0A",
                        "Заказал по ошибке"),

                new Order115Adapter.Order115Items(
                        "\uD83D\uDE0A",
                        "Заказал по ошибке"),

                new Order115Adapter.Order115Items(
                        "\uD83D\uDE0A",
                        "Заказал по ошибке")
        };
        return arr;
    }
}