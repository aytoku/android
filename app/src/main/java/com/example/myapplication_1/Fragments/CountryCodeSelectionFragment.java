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

    public static CountryCodeSelectionFragment getInstance(Bundle args) {

        CountryCodeSelectionFragment f = new CountryCodeSelectionFragment();
        f.setArguments(args);

        return f;
    }

    RecyclerView rv;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.country_code_selection,
                container, false);

        rv = view.findViewById(R.id.rl_country_code_selection_recycler);

        ImageButton imageButton = view.findViewById(R.id.rl_cell_country_code_selection_button);

        Bundle _args = new Bundle();
        final Fragment auth111Fragment = Auth111Fragment.getInstance(_args);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_main, auth111Fragment);
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

            CountryCodeSelectionAdapter.ItemsMenu[] itemsMenu = getMenuItems();

            CountryCodeSelectionAdapter adapterGridViewMenu = new CountryCodeSelectionAdapter(itemsMenu, getActivity().getBaseContext());
            recyclerViewMenu.setAdapter( adapterGridViewMenu );
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ) );
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
    }

    private CountryCodeSelectionAdapter.ItemsMenu[] getMenuItems() {

        CountryCodeSelectionAdapter.ItemsMenu []_arr = new CountryCodeSelectionAdapter.ItemsMenu[]{

                new CountryCodeSelectionAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Г",
                        R.mipmap.georgia,
                        "Грузия",
                        new CountryCodeSelectionAdapter.ItemsMenu.CallBack() {
                            @Override
                            public void call(CountryCodeSelectionAdapter.ItemsMenu itemsMenu) {

                                try{

                                    Bundle _args = new Bundle();
                                    Fragment auth111Fragment = Auth111Fragment.getInstance(_args);
                                    auth111Fragment.setArguments(_args);
                                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                                    transaction.replace(R.id.ll_main, auth111Fragment).commit();
                                    getActivity().getIntent().getExtras().get("+995");

                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        },"+995"),

                new CountryCodeSelectionAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),"Р",
                        R.mipmap.russia,
                        "Россия",
                        new CountryCodeSelectionAdapter.ItemsMenu.CallBack() {
                            @Override
                            public void call(CountryCodeSelectionAdapter.ItemsMenu itemsMenu) {

                                try{

                                    Bundle _args = new Bundle();
                                    Fragment auth111Fragment = Auth111Fragment.getInstance(_args);
                                    auth111Fragment.setArguments(_args);
                                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                                    transaction.replace(R.id.ll_main, auth111Fragment).commit();
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