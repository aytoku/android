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

import com.example.myapplication_1.Adapters.PartnersAdapter;

public class MainActivityPartners extends AppCompatActivity {

    RecyclerView rv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.partners);

        rv = findViewById(R.id.recycler_partners);
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
            PartnersAdapter.AdapterGridViewMenu.ItemsMenu[] itemsMenu = getMenuItems();//model_data

            PartnersAdapter.AdapterGridViewMenu adapterGridViewMenu = new PartnersAdapter.AdapterGridViewMenu(itemsMenu, getBaseContext());//this;
            recyclerViewMenu.setAdapter( adapterGridViewMenu );
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getBaseContext(), RecyclerView.VERTICAL, false ) );
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
    }

    private PartnersAdapter.AdapterGridViewMenu.ItemsMenu[] getMenuItems() {

        PartnersAdapter.AdapterGridViewMenu.ItemsMenu []_arr = new PartnersAdapter.AdapterGridViewMenu.ItemsMenu[]{

                new PartnersAdapter.AdapterGridViewMenu.ItemsMenu(getResources().getColor(R.color.my_gray),
                        R.drawable.ic_vector_grey,
                        "Партнер 1"),
                new PartnersAdapter.AdapterGridViewMenu.ItemsMenu(getResources().getColor(R.color.my_gray),
                        R.drawable.ic_vector_grey,
                        "Партнер 2")
        };
        return _arr;
    }
}