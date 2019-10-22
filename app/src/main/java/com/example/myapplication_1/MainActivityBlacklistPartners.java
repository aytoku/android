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

import com.example.myapplication_1.Adapters.BlacklistPartnersAdapter;

public class MainActivityBlacklistPartners extends AppCompatActivity {

    RecyclerView rv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.black_list_partner);

        rv = findViewById(R.id.ll_blackList_partner_recycler_partners);

    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {

        return super.onCreateView(parent, name, context, attrs);
    }

    @Override
    protected void onStart() {
        super.onStart();

        RecyclerView recyclerViewMenu = rv;

        try {
            BlacklistPartnersAdapter.AdapterGridViewMenu.ItemsMenu[] itemsMenu = getMenuItems();//model_data

            BlacklistPartnersAdapter.AdapterGridViewMenu adapterGridViewMenu = new BlacklistPartnersAdapter.AdapterGridViewMenu(itemsMenu, getBaseContext());//this;
            recyclerViewMenu.setAdapter( adapterGridViewMenu );
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getBaseContext(), RecyclerView.VERTICAL, false ) );
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