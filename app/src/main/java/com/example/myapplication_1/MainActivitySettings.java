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

import com.example.myapplication_1.Adapters.SettingsAdapter;

public class MainActivitySettings extends AppCompatActivity {

    RecyclerView rv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.settings);

        rv = findViewById(R.id.recycler_settings);

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
            SettingsAdapter.AdapterGridViewMenu.ItemsMenu[] itemsMenu = getMenuItems();//model_data

            SettingsAdapter.AdapterGridViewMenu adapterGridViewMenu = new SettingsAdapter.AdapterGridViewMenu(itemsMenu, getBaseContext());//this;
            recyclerViewMenu.setAdapter( adapterGridViewMenu );
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getBaseContext(), RecyclerView.VERTICAL, false ) );
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
    }



    private SettingsAdapter.AdapterGridViewMenu.ItemsMenu[] getMenuItems() {

        SettingsAdapter.AdapterGridViewMenu.ItemsMenu []_arr = new SettingsAdapter.AdapterGridViewMenu.ItemsMenu[]{

                new SettingsAdapter.AdapterGridViewMenu.ItemsMenu(getResources().getColor(R.color.my_gray),
                        R.mipmap.ic_launcher_round,
                        "Не звонить"),
                new SettingsAdapter.AdapterGridViewMenu.ItemsMenu(getResources().getColor(R.color.my_gray),
                        R.mipmap.ic_launcher_round,
                        "Не предлагать сообщения о\nснижении цены")
        };
        return _arr;
    }



}