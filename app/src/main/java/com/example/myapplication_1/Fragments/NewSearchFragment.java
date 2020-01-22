package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.NewSearchAdapter;
import com.example.myapplication_1.Adapters.NewSearchAddressesAdapter;
import com.example.myapplication_1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewSearchFragment extends Fragment {

    public static final String TAG = "NewSearchFragment";

    public static NewSearchFragment getInstance(Bundle args) {

        NewSearchFragment newSearchFragment = new NewSearchFragment();
        newSearchFragment.setArguments(args);

        return newSearchFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.search_new,
                container, false);

        RecyclerView new_search_rv = view.findViewById(R.id.search_new_recyclerView);
        RecyclerView new_search_addresses_rv = view.findViewById(R.id.search_new_recyclerView1);

        final RecyclerView recyclerView = new_search_rv;
        try {
            NewSearchAdapter.NewSearchItems[] newSearchItems = getNewSearchItems();
            List<NewSearchAdapter.NewSearchItems> newSearchAdapterList = new ArrayList<>(Arrays.asList(newSearchItems));
            RecyclerView.Adapter newSearchAdapter = new NewSearchAdapter(newSearchAdapterList, getActivity().getBaseContext());
            recyclerView.setAdapter(newSearchAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext(), RecyclerView.VERTICAL, false));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
        }catch (NullPointerException e){
            e.printStackTrace();
        }

        RecyclerView recyclerView_addresses = new_search_addresses_rv;
        try {
            NewSearchAddressesAdapter.NewSearchAddressesItems[] newSearchAddressesItems = getNewSearchAddressesItems();
            List<NewSearchAddressesAdapter.NewSearchAddressesItems> newSearchAddressesItemsList = new ArrayList<>(Arrays.asList(newSearchAddressesItems));
            RecyclerView.Adapter newSearchAddressesAdapter = new NewSearchAddressesAdapter(newSearchAddressesItemsList, getActivity().getBaseContext());
            recyclerView_addresses.setAdapter(newSearchAddressesAdapter);
            recyclerView_addresses.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext(), RecyclerView.VERTICAL, false));
            recyclerView_addresses.setItemAnimator(new DefaultItemAnimator());
        }catch (NullPointerException e){
            e.printStackTrace();
        }

        return view;
    }

    private NewSearchAdapter.NewSearchItems[] getNewSearchItems() {
        NewSearchAdapter.NewSearchItems[] arr = new NewSearchAdapter.NewSearchItems[]{
                new NewSearchAdapter.NewSearchItems(
                        R.drawable.ic_work,"Работа","Галковского, 223"
                ),
                new NewSearchAdapter.NewSearchItems(
                        R.drawable.icon_home,"Домой","Некрасова, 22"
                ),
                new NewSearchAdapter.NewSearchItems(
                        R.drawable.ic_tag,"Коста Хетагурова, 123","г. Владикавказ, республика Северная Осетия-Алания,\nРоссия"
                ),
                new NewSearchAdapter.NewSearchItems(
                        R.drawable.ic_clock,"Анечка","Августовских Событий 94"
                )
        };
        return arr;
    }

    private NewSearchAddressesAdapter.NewSearchAddressesItems[] getNewSearchAddressesItems() {
        NewSearchAddressesAdapter.NewSearchAddressesItems[] _arr = new NewSearchAddressesAdapter.NewSearchAddressesItems[]{
                new NewSearchAddressesAdapter.NewSearchAddressesItems(
                        "Августовских событий, 79","г. Владикавказ, республика Северная Осетия-Алания,\n Россия"
                ),
                new NewSearchAddressesAdapter.NewSearchAddressesItems(
                        "Мамсурова, 3","г. Владикавказ, республика Северная Осетия-Алания,\n Россия"
                ),
                new NewSearchAddressesAdapter.NewSearchAddressesItems(
                        "Леваневского, 3","г. Владикавказ, республика Северная Осетия-Алания,\n Россия"
                )
        };
        return _arr;
    }
}