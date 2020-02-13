package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.CalculationCostAdapter;
import com.example.myapplication_1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InformationPartnersFragment extends Fragment {

    public static final String TAG = "InformationPartnersFragment";

    public static InformationPartnersFragment getInstance(Bundle args) {

        InformationPartnersFragment informationPartnersFragment = new InformationPartnersFragment();
        informationPartnersFragment.setArguments(args);

        return informationPartnersFragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.information_partners,
                container, false);

        RecyclerView information_partners_rv = view.findViewById(R.id.ll_information_partners_recycler);

        try {
            CalculationCostAdapter.CalculationCostItems[] calculationCostItems = getCalculationItems();
            List<CalculationCostAdapter.CalculationCostItems> calculationCostItemsList = new ArrayList<>(Arrays.asList(calculationCostItems));
            RecyclerView.Adapter calculationCostAdapter = new CalculationCostAdapter(calculationCostItemsList, getActivity().getBaseContext());
            information_partners_rv.setAdapter(calculationCostAdapter);
            information_partners_rv.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ));
            information_partners_rv.setItemAnimator( new DefaultItemAnimator() );
        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    private CalculationCostAdapter.CalculationCostItems[] getCalculationItems() {
        CalculationCostAdapter.CalculationCostItems[] arr = new CalculationCostAdapter.CalculationCostItems[]{
                new CalculationCostAdapter.CalculationCostItems(
                        "",
                        "39 руб"
                ),
                new CalculationCostAdapter.CalculationCostItems(
                        "Бесплатное ожидание",
                        "3 мин"
                ),
                new CalculationCostAdapter.CalculationCostItems(
                        "Платное ожидание",
                        "4 руб/мин"
                ),
                new CalculationCostAdapter.CalculationCostItems(
                        "Стоимость по городу",
                        "4 руб/мин"
                ),
                new CalculationCostAdapter.CalculationCostItems(
                        "Стоимость загород",
                        "4 руб/мин"
                )
        };
        return arr;
    }
}