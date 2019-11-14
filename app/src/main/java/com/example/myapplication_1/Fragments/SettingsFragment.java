package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.SettingsAdapter;
import com.example.myapplication_1.R;

public class SettingsFragment extends Fragment {

    public static final String TAG = "SettingsFragment";

    public static SettingsFragment getInstance(Bundle args) {

        SettingsFragment f = new SettingsFragment();
        f.setArguments(args);

        return f;
    }

    RecyclerView rv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.settings,
                container, false);

        rv = view.findViewById(R.id.recycler_settings);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        RecyclerView recyclerViewMenu = rv;

        try {
            SettingsAdapter.ItemsMenu[] itemsMenu = getMenuItems();//model_data

            SettingsAdapter adapterGridViewMenu = new SettingsAdapter(itemsMenu, getActivity().getBaseContext());//this;
            recyclerViewMenu.setAdapter( adapterGridViewMenu );
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ) );
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
    }

    private SettingsAdapter.ItemsMenu[] getMenuItems() {

        SettingsAdapter.ItemsMenu []_arr = new SettingsAdapter.ItemsMenu[]{

                new SettingsAdapter.ItemsMenu(getResources().getColor(R.color.my_gray),
                        R.mipmap.ic_launcher_round,
                        "Не звонить"),
                new SettingsAdapter.ItemsMenu(getResources().getColor(R.color.my_gray),
                        R.mipmap.ic_launcher_round,
                        "Не предлагать сообщения о\nснижении цены")
        };
        return _arr;
    }
}