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

            EarningsPageAdapter.AdapterGridViewMenu.ItemsMenu[] itemsMenu = getMenuItems();//model_data

            EarningsPageAdapter.AdapterGridViewMenu adapterGridViewMenu = new EarningsPageAdapter.AdapterGridViewMenu(itemsMenu, getActivity().getBaseContext());//this;
            recyclerViewMenu.setAdapter( adapterGridViewMenu );
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ) );
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

