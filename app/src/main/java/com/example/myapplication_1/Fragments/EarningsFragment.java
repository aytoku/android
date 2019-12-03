package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.EarningsPageAdapter;
import com.example.myapplication_1.R;

public class EarningsFragment extends Fragment {

    public static final String TAG = "EarningsFragment";

    public static EarningsFragment getInstance(Bundle args) {

        EarningsFragment f = new EarningsFragment();
        f.setArguments(args);

        return f;
    }

    RecyclerView rv;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.earnings_page_card,
                container, false);

        rv = view.findViewById(R.id.earnings_page_card_recycler);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        RecyclerView recyclerViewMenu = rv;

        try {

            EarningsPageAdapter.ItemsMenu[] itemsMenu = getMenuItems();//model_data

            EarningsPageAdapter adapterGridViewMenu = new EarningsPageAdapter(itemsMenu, getActivity().getBaseContext());//this;
            recyclerViewMenu.setAdapter( adapterGridViewMenu );
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ) );
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
    }

    private EarningsPageAdapter.ItemsMenu[] getMenuItems() {

        EarningsPageAdapter.ItemsMenu []_arr = new EarningsPageAdapter.ItemsMenu[]{

                new EarningsPageAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),"1 км", new String[] {"Коста 223/1"}, new String[] {"Детское кресло", "Курящий"}, R.drawable.ic_mini_ellipse, new EarningsPageAdapter.ItemsMenu.CallBack() {
                    @Override
                    public void call(EarningsPageAdapter.ItemsMenu itemsMenu) {

                        try {

                            Bundle _args = new Bundle();

                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }

                    }
                }, "До клиента", "1км", "Маршрут заказа", "152\u20BD", R.drawable.ic_lightning_yellow, "10"),

                new EarningsPageAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),"1 км", new String[] {"Коста 223/1","Универсам Наш, Хаджи Мамсурова Мамсурова, 42"}, new String[] {"Детское кресло"}, R.drawable.ic_mini_ellipse, new EarningsPageAdapter.ItemsMenu.CallBack() {

                    public void call(EarningsPageAdapter.ItemsMenu itemsMenu) {

                        try {

                            Bundle _args = new Bundle();

                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }

                    }
                },"До клиента", "1км", "Маршрут заказа", "208\u20BD", R.drawable.ic_lightning_yellow, "10"),

                new EarningsPageAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),"1 км", new String[] {"Коста 223/1","Молодежная, 7","Универсам Наш, Хаджи Мамсурова, 42 "}, new String[] {"Детское кресло"}, R.drawable.ic_mini_ellipse, new EarningsPageAdapter.ItemsMenu.CallBack() {

                    public void call(EarningsPageAdapter.ItemsMenu itemsMenu) {

                        try {

                            Bundle _args = new Bundle();

                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }

                    }
                },"До клиента", "1км", "Маршрут заказа", "208\u20BD", R.drawable.ic_lightning_yellow, "10"),

                new EarningsPageAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),"1 км", new String[] {"Коста 223/1", "Молодежная, 7", "Универсам Наш, Хаджи Мамсурова, 42 " ,"Алания молл, Московское шоссе, 3а"}, new String[] {"Детское кресло", "Детское кресло", "Детское кресло"}, R.drawable.ic_mini_ellipse, new EarningsPageAdapter.ItemsMenu.CallBack() {
                    @Override
                    public void call(EarningsPageAdapter.ItemsMenu itemsMenu) {

                        try {

                            Bundle _args = new Bundle();

                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }

                    }
                }, "До клиента", "1км", "Маршрут заказа", "152\u20BD", R.drawable.ic_lightning_yellow, "10"),
        };
        return _arr;
    }
}