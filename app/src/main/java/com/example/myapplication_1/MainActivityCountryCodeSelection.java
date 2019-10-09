package com.example.myapplication_1;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.CountryCodeSelectionAdapter;

public class MainActivityCountryCodeSelection extends AppCompatActivity {

    ImageButton androidImageButton;

    RecyclerView rv;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        androidImageButton = (ImageButton) findViewById(R.id.img_cross_grey);


        setContentView(R.layout.country_code_selection);

        rv = (RecyclerView) findViewById(R.id.rl_country_code_selection_recycler);

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

            CountryCodeSelectionAdapter.AdapterGridViewMenu.ItemsMenu[] itemsMenu = getMenuItems();//model_data

            CountryCodeSelectionAdapter.AdapterGridViewMenu adapterGridViewMenu = new CountryCodeSelectionAdapter.AdapterGridViewMenu(itemsMenu, getBaseContext());//this;
            recyclerViewMenu.setAdapter( adapterGridViewMenu );
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getBaseContext(), RecyclerView.VERTICAL, false ) );
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }

    }

    private CountryCodeSelectionAdapter.AdapterGridViewMenu.ItemsMenu[] getMenuItems() {

        CountryCodeSelectionAdapter.AdapterGridViewMenu.ItemsMenu []_arr = new CountryCodeSelectionAdapter.AdapterGridViewMenu.ItemsMenu[]{

                new CountryCodeSelectionAdapter.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Г",
                        R.mipmap.georgia,
                        "Грузия",
                        new CountryCodeSelectionAdapter.AdapterGridViewMenu.ItemsMenu.CallBack() {
                            @Override
                            public void call(CountryCodeSelectionAdapter.AdapterGridViewMenu.ItemsMenu itemsMenu) {

                                try {

                                    Bundle _args = new Bundle();

                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, "+995"),
                new CountryCodeSelectionAdapter.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),"Р",
                        R.mipmap.russia,
                        "Россия",
                        new CountryCodeSelectionAdapter.AdapterGridViewMenu.ItemsMenu.CallBack() {
                            @Override
                            public void call(CountryCodeSelectionAdapter.AdapterGridViewMenu.ItemsMenu itemsMenu) {

                                try {

                                    Bundle _args = new Bundle();

                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, "+7")

        };
        return _arr;

    }



}

