package com.example.myapplication_1.Alerts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.TariffsPickAdapter;
import com.example.myapplication_1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TariffsPickAlert extends DialogFragment {

    public static final String TAG = "TariffsPickFragment";

    public static TariffsPickAlert getInstance(Bundle args) {

        TariffsPickAlert f = new TariffsPickAlert();
        f.setArguments(args);

        return f;
    }

    RecyclerView rv;
    RecyclerView.Adapter adapterGridViewMenu;
    private List<TariffsPickAdapter.ItemsMenu> itemsMenuList;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.tarrifs_pick,
                container, false);

        rv = view.findViewById(R.id.ll_tariffs_pick_recycler);

        final RecyclerView recyclerViewMenu = rv;

        try {

            TariffsPickAdapter.ItemsMenu[] itemsMenu = getMenuItems();
            itemsMenuList = new ArrayList<>(Arrays.asList(itemsMenu));
            adapterGridViewMenu = new TariffsPickAdapter(itemsMenuList, getActivity().getBaseContext());
            recyclerViewMenu.setAdapter(adapterGridViewMenu);
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager(getActivity().getBaseContext(), RecyclerView.VERTICAL, false));
            recyclerViewMenu.setItemAnimator(new DefaultItemAnimator());

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return view;
    }

    private TariffsPickAdapter.ItemsMenu[] getMenuItems() {

        TariffsPickAdapter.ItemsMenu[] arr = new TariffsPickAdapter.ItemsMenu[]{

                new TariffsPickAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Эконом",
                        new TariffsPickAdapter.ItemsMenu.CallBack() {
                            @Override
                            public void call(TariffsPickAdapter.ItemsMenu itemsMenu) {
                                try {
                                    Bundle _args = new Bundle();
                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        },R.drawable.ic_empty_switch),

                new TariffsPickAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Стандарт",
                        new TariffsPickAdapter.ItemsMenu.CallBack() {
                            @Override
                            public void call(TariffsPickAdapter.ItemsMenu itemsMenu) {
                                try {
                                    Bundle _args = new Bundle();
                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        },R.drawable.ic_empty_switch),

                new TariffsPickAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Комфорт",
                        new TariffsPickAdapter.ItemsMenu.CallBack() {
                            @Override
                            public void call(TariffsPickAdapter.ItemsMenu itemsMenu) {
                                try {
                                    Bundle _args = new Bundle();
                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        },R.drawable.ic_empty_switch),

                new TariffsPickAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Доставка",
                        new TariffsPickAdapter.ItemsMenu.CallBack() {
                            @Override
                            public void call(TariffsPickAdapter.ItemsMenu itemsMenu) {
                                try {
                                    Bundle _args = new Bundle();
                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        },R.drawable.ic_empty_switch),

                new TariffsPickAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Грузовое",
                        new TariffsPickAdapter.ItemsMenu.CallBack() {
                            @Override
                            public void call(TariffsPickAdapter.ItemsMenu itemsMenu) {
                                try {
                                    Bundle _args = new Bundle();
                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        },R.drawable.ic_empty_switch)
        };
        return arr;
    }
}