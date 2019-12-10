package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
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

        ImageButton imageButton = view.findViewById(R.id.ll_setting_button);

        Bundle _args = new Bundle();
        final Fragment menu11Fragment = Menu11Fragment.getInstance(_args);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_main, menu11Fragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        RecyclerView recyclerViewMenu = rv;

        try {
            SettingsAdapter.ItemsMenu[] itemsMenu = getMenuItems();

            SettingsAdapter adapterGridViewMenu = new SettingsAdapter(itemsMenu, getActivity().getBaseContext());
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
                        "Не звонить"),
                new SettingsAdapter.ItemsMenu(getResources().getColor(R.color.my_gray),
                        "Не предлагать сообщения о\nснижении цены")
        };
        return _arr;
    }
}