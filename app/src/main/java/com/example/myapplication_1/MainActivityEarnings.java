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

public class MainActivityEarnings extends AppCompatActivity {

    RecyclerView rv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.earnings_page_card);

        rv = (RecyclerView) findViewById(R.id.earnings_page_card_recycler);
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

            EarningsPageAdapter.AdapterGridViewMenu.ItemsMenu[] itemsMenu = getMenuItems();//model_data

            EarningsPageAdapter.AdapterGridViewMenu adapterGridViewMenu = new EarningsPageAdapter.AdapterGridViewMenu(itemsMenu, getBaseContext());//this;
            recyclerViewMenu.setAdapter( adapterGridViewMenu );
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getBaseContext(), RecyclerView.VERTICAL, false ) );
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
    }

    private EarningsPageAdapter.AdapterGridViewMenu.ItemsMenu[] getMenuItems() {

        EarningsPageAdapter.AdapterGridViewMenu.ItemsMenu []_arr = new EarningsPageAdapter.AdapterGridViewMenu.ItemsMenu[]{

                new EarningsPageAdapter.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),"152\u20BD",   new String[] {"Загород"},   new EarningsPageAdapter.AdapterGridViewMenu.ItemsMenu.CallBack() {
                    @Override
                    public void call(EarningsPageAdapter.AdapterGridViewMenu.ItemsMenu itemsMenu) {

                        try {

                            Bundle _args = new Bundle();

                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }

                    }
                }, R.drawable.ic_road, "1км",  "Коста, 223/1", R.drawable.ic_grey_arrow, "Заводской"),

                new EarningsPageAdapter.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),"208\u20BD", new String[] {"Час-пик","Повышенный","Повышенный","Повышенный","Повышенный"}, new EarningsPageAdapter.AdapterGridViewMenu.ItemsMenu.CallBack() {
                    @Override
                    public void call(EarningsPageAdapter.AdapterGridViewMenu.ItemsMenu itemsMenu) {

                        try {

                            Bundle _args = new Bundle();

                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }

                    }
                }, R.drawable.ic_road, "1км",  "Коста, 223/1", R.drawable.ic_grey_arrow, "Кутузова, 22"),

                new EarningsPageAdapter.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),"208\u20BD", new String[] {"Повышенный"}, new EarningsPageAdapter.AdapterGridViewMenu.ItemsMenu.CallBack() {
                    @Override
                    public void call(EarningsPageAdapter.AdapterGridViewMenu.ItemsMenu itemsMenu) {

                        try {

                            Bundle _args = new Bundle();

                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }
                    }
                }, R.drawable.ic_road, "1км",  "Коста, 223/1", R.drawable.ic_grey_arrow, "Кутузова, 22"),


                new EarningsPageAdapter.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),"208\u20BD", new String[] {"Час-пик"}, new EarningsPageAdapter.AdapterGridViewMenu.ItemsMenu.CallBack() {
                    @Override
                    public void call(EarningsPageAdapter.AdapterGridViewMenu.ItemsMenu itemsMenu) {

                        try {

                            Bundle _args = new Bundle();

                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }

                    }
                }, R.drawable.ic_road, "1км",  "Коста, 223/1", R.drawable.ic_grey_arrow, "Кутузова, 22"),


                new EarningsPageAdapter.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),"208\u20BD", new String[] {"Час-пик","Повышенный"}, new EarningsPageAdapter.AdapterGridViewMenu.ItemsMenu.CallBack() {
                    @Override
                    public void call(EarningsPageAdapter.AdapterGridViewMenu.ItemsMenu itemsMenu) {

                        try {

                            Bundle _args = new Bundle();

                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }

                    }
                }, R.drawable.ic_road, "1км",  "Коста, 223/1", R.drawable.ic_grey_arrow, "Кутузова, 22"),


                new EarningsPageAdapter.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),"208\u20BD", new String[] {"Час-пик"}, new EarningsPageAdapter.AdapterGridViewMenu.ItemsMenu.CallBack() {
                    @Override
                    public void call(EarningsPageAdapter.AdapterGridViewMenu.ItemsMenu itemsMenu) {

                        try {

                            Bundle _args = new Bundle();

                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }

                    }
                }, R.drawable.ic_road, "1км",  "Коста, 223/1", R.drawable.ic_grey_arrow, "Кутузова, 22"),

                new EarningsPageAdapter.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),"208\u20BD", new String[] {"Час-пик","Повышенный","Повышенный"}, new EarningsPageAdapter.AdapterGridViewMenu.ItemsMenu.CallBack() {
                    @Override
                    public void call(EarningsPageAdapter.AdapterGridViewMenu.ItemsMenu itemsMenu) {

                        try {

                            Bundle _args = new Bundle();

                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }

                    }
                }, R.drawable.ic_road, "1км",  "Коста, 223/1", R.drawable.ic_grey_arrow, "Кутузова, 22"),
        };
        return _arr;
    }
}

