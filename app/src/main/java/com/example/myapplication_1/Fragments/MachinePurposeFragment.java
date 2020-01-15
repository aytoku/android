package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.MachinePurposeAdapter;
import com.example.myapplication_1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MachinePurposeFragment extends Fragment {

    public static final String TAG = "MachinePurposeFragment";

    public static MachinePurposeFragment getInstance(Bundle args) {

        MachinePurposeFragment f = new MachinePurposeFragment();
        f.setArguments(args);

        return f;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.machine_purpose_recycler,
                container, false);

        RecyclerView rv = view.findViewById(R.id.ll_machine_purpose_recycler_rv);

        final RecyclerView recyclerViewMenu = rv;

        try {

            MachinePurposeAdapter.ItemsMenu[] itemsMenu = getMenuItems();
            List<MachinePurposeAdapter.ItemsMenu> itemsMenuList = new ArrayList<>(Arrays.asList(itemsMenu));
            RecyclerView.Adapter adapterGridViewMenu = new MachinePurposeAdapter(itemsMenuList, getActivity().getBaseContext());
            recyclerViewMenu.setAdapter(adapterGridViewMenu);
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ));
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    private MachinePurposeAdapter.ItemsMenu[] getMenuItems() {

        MachinePurposeAdapter.ItemsMenu[] arr = new MachinePurposeAdapter.ItemsMenu[]{
                new MachinePurposeAdapter.ItemsMenu(
                        R.drawable.icon_grey_plus,
                        "Добавить остановку",
                        R.drawable.icon_arrow_right)
        };
        return arr;
    }
}