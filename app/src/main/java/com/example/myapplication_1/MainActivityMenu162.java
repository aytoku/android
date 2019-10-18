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

import com.example.myapplication_1.Adapters.AdapterMenu162;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivityMenu162 extends AppCompatActivity {

    RecyclerView rv;
    RecyclerView.Adapter adapterGridViewMenu;
    private List<AdapterMenu162.AdapterGridViewMenu.ItemsMenu> itemsMenuList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.menu_1_6_2);

        rv = findViewById(R.id.rl_menu_1_6_2_recycler);

        final RecyclerView recyclerViewMenu = rv;

        try {

            AdapterMenu162.AdapterGridViewMenu.ItemsMenu[] itemsMenu = getMenuItems();
            itemsMenuList = new ArrayList<>(Arrays.asList(itemsMenu));
            adapterGridViewMenu = new AdapterMenu162.AdapterGridViewMenu(itemsMenuList, getBaseContext());
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

