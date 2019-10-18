package com.example.myapplication_1;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.Order115Adapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivityOrder115 extends AppCompatActivity {

    RecyclerView rv;
    RecyclerView.Adapter adapterGridViewMenu;
    private List<Order115Adapter.AdapterGridViewMenu.ItemsMenu> itemsMenuList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.order_1_1_5);

        rv = findViewById(R.id.cl_create_order_1_1_5_recycler);

        final RecyclerView recyclerViewMenu = rv;

        try {

            Order115Adapter.AdapterGridViewMenu.ItemsMenu[] itemsMenu = getMenuItems();
            itemsMenuList = new ArrayList<>(Arrays.asList(itemsMenu));
            adapterGridViewMenu = new Order115Adapter.AdapterGridViewMenu(itemsMenuList, getBaseContext());
            recyclerViewMenu.setAdapter(adapterGridViewMenu);
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getBaseContext(), RecyclerView.VERTICAL, false ));
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {

        return super.onCreateView(parent, name, context, attrs);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private Order115Adapter.AdapterGridViewMenu.ItemsMenu[] getMenuItems() {

        Order115Adapter.AdapterGridViewMenu.ItemsMenu[] arr = new Order115Adapter.AdapterGridViewMenu.ItemsMenu[]{

                new Order115Adapter.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "\uD83D\uDE0A",
                        "Заказал по ошибке"),

                new Order115Adapter.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "\uD83D\uDE0A",
                        "Заказал по ошибке"),

                new Order115Adapter.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "\uD83D\uDE0A",
                        "Заказал по ошибке"),

                new Order115Adapter.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "\uD83D\uDE0A",
                        "Заказал по ошибке"),


                new Order115Adapter.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "\uD83D\uDE0A",
                        "Заказал по ошибке")
        };
        return arr;
    }
}

