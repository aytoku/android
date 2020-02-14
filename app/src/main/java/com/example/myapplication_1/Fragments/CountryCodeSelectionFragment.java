package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.CountryCodeSelectionAdapter;
import com.example.myapplication_1.R;

public class CountryCodeSelectionFragment extends Fragment {

    public static final String TAG = "CountryCodeSelectionFragment";
    private RecyclerView countryCodeSelection_rv;

    public static CountryCodeSelectionFragment getInstance(Bundle args) {

        CountryCodeSelectionFragment countryCodeSelectionFragment = new CountryCodeSelectionFragment();
        countryCodeSelectionFragment.setArguments(args);

        return countryCodeSelectionFragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.country_code_selection,
                container, false);

        countryCodeSelection_rv = view.findViewById(R.id.rl_country_code_selection_recycler);
        ImageButton imageButton = view.findViewById(R.id.rl_cell_country_code_selection_button);

        Bundle bundle = new Bundle();
        final Fragment auth111Fragment = Auth111Fragment.getInstance(bundle);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, auth111Fragment);
                fragmentTransaction.commit();
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        RecyclerView recyclerView = countryCodeSelection_rv;
        try {
            CountryCodeSelectionAdapter.CountryCodeItems[] countryCodeItems = getCountryCodeItems();
            CountryCodeSelectionAdapter countryCodeSelectionAdapter = new CountryCodeSelectionAdapter(countryCodeItems, getActivity().getBaseContext());
            recyclerView.setAdapter( countryCodeSelectionAdapter );
            recyclerView.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ) );
            recyclerView.setItemAnimator( new DefaultItemAnimator() );
        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
    }

    private CountryCodeSelectionAdapter.CountryCodeItems[] getCountryCodeItems() {
        CountryCodeSelectionAdapter.CountryCodeItems []_arr = new CountryCodeSelectionAdapter.CountryCodeItems[]{
                new CountryCodeSelectionAdapter.CountryCodeItems(
                        getResources().getColor(R.color.my_gray),
                        "Г",
                        R.mipmap.georgia,
                        "Грузия",
                        new CountryCodeSelectionAdapter.CountryCodeItems.CallBack() {
                            @Override
                            public void call(CountryCodeSelectionAdapter.CountryCodeItems countryCodeItems) {
                                try{
                                    Bundle bundle = new Bundle();
                                    Auth111Fragment auth111Fragment = Auth111Fragment.getInstance(bundle);
                                    String message = "Грузия +995";
                                    bundle.putString("message", message);
                                    auth111Fragment.setArguments(bundle);
                                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                                    transaction.replace(R.id.rl_main, auth111Fragment).commit();
                                    getActivity().getIntent().getExtras().get("+995");
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        },"+995"),

                new CountryCodeSelectionAdapter.CountryCodeItems(
                        getResources().getColor(R.color.my_gray),"Р",
                        R.mipmap.russia,
                        "Россия",
                        new CountryCodeSelectionAdapter.CountryCodeItems.CallBack() {
                            @Override
                            public void call(CountryCodeSelectionAdapter.CountryCodeItems countryCodeItems) {
                                try{
                                    Bundle bundle = new Bundle();
                                    Auth111Fragment auth111Fragment = Auth111Fragment.getInstance(bundle);
                                    auth111Fragment.setArguments(bundle);
                                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                                    transaction.replace(R.id.rl_main, auth111Fragment).commit();
                                    getActivity().getIntent().getExtras().get("+7");
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, "+7")
        };
        return _arr;
    }
}