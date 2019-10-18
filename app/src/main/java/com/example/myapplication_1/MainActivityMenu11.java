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

import com.example.myapplication_1.Adapters.AdapterMenu11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivityMenu11 extends AppCompatActivity {

    RecyclerView rv;
    RecyclerView.Adapter adapterGridViewMenu;
    private List<AdapterMenu11.AdapterGridViewMenu.ItemsMenu> itemsMenuList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.menu_1_1);

        rv = findViewById(R.id.rl_menu_1_1_recycler);

        final RecyclerView recyclerViewMenu = rv;

        try {

            AdapterMenu11.AdapterGridViewMenu.ItemsMenu[] itemsMenu = getMenuItems();
            itemsMenuList = new ArrayList<>(Arrays.asList(itemsMenu));
            adapterGridViewMenu = new AdapterMenu11.AdapterGridViewMenu(itemsMenuList, getBaseContext());
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

