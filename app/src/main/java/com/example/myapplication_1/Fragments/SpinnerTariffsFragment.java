package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.CalculationCostAdapter;
import com.example.myapplication_1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpinnerTariffsFragment extends Fragment {

    public static final String TAG = "SpinnerTariffsFragment";
    private String[] choose = {"Эконом", "Стандарт", "Не эконом"};

    public static SpinnerTariffsFragment getInstance(Bundle args) {

        SpinnerTariffsFragment spinnerTariffsFragment = new SpinnerTariffsFragment();
        spinnerTariffsFragment.setArguments(args);

        return spinnerTariffsFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.tariffs,
                container, false);

        ImageButton imageButton = view.findViewById(R.id.rl_tariffs_button);
        Spinner spinner = view.findViewById(R.id.choose);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, choose);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Bundle bundle = new Bundle();
        final InformationFragment informationFragment = InformationFragment.getInstance(bundle);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, informationFragment);
                fragmentTransaction.commit();
            }
        });

        RecyclerView information_partners_rv = view.findViewById(R.id.rl_tariffs_recycler);

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