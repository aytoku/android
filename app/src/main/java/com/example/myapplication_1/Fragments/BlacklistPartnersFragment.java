package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.BlacklistPartnersAdapter;
import com.example.myapplication_1.R;

public class BlacklistPartnersFragment extends Fragment {

    public static final String TAG = "BlacklistPartnersFragment";

    public static BlacklistPartnersFragment getInstance(Bundle args) {

        BlacklistPartnersFragment f = new BlacklistPartnersFragment();
        f.setArguments(args);

        return f;
    }

    RecyclerView rv;
    boolean check = false;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.black_list_partner,
                container, false);

        rv = view.findViewById(R.id.ll_blackList_partner_recycler_partners);
        ImageButton imageButton = view.findViewById(R.id.ll_blackList_partner_rl_blackList_partner_img);
        TextView textView = view.findViewById(R.id.ll_blackList_partner_rl_blackList_partner_ready);

        Bundle _args = new Bundle();
        final Fragment partnersFragment = PartnersFragment.getInstance(_args);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_main, partnersFragment);
                fragmentTransaction.commit();
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_main, partnersFragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        RecyclerView recyclerViewMenu = rv;

        try{
            BlacklistPartnersAdapter.ItemsMenu[] itemsMenu = getMenuItems();
            BlacklistPartnersAdapter adapterGridViewMenu = new BlacklistPartnersAdapter(itemsMenu, getActivity().getBaseContext());
            recyclerViewMenu.setAdapter( adapterGridViewMenu );
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ) );
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        }catch ( NullPointerException e) {
            e.printStackTrace();
        }
    }

    private BlacklistPartnersAdapter.ItemsMenu[] getMenuItems() {

        BlacklistPartnersAdapter.ItemsMenu []_arr = new BlacklistPartnersAdapter.ItemsMenu[]{

                new BlacklistPartnersAdapter.ItemsMenu(getResources().getColor(R.color.my_gray),
                        R.drawable.togle_uncheked,
                        "Партнер 1", check,
                        new BlacklistPartnersAdapter.ItemsMenu.CallBack() {
                            @Override
                            public void call(BlacklistPartnersAdapter.ItemsMenu itemsMenu) {
                                try{
                                    Bundle _args = new Bundle();

                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }),
                new BlacklistPartnersAdapter.ItemsMenu(getResources().getColor(R.color.my_gray),
                        R.drawable.togle_uncheked,
                        "Партнер 2", check,
                        new BlacklistPartnersAdapter.ItemsMenu.CallBack() {
                            @Override
                            public void call(BlacklistPartnersAdapter.ItemsMenu itemsMenu) {
                                try{
                                    Bundle _args = new Bundle();

                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }),
                new BlacklistPartnersAdapter.ItemsMenu(getResources().getColor(R.color.my_gray),
                        R.drawable.togle_uncheked,
                        "Партнер 1", check,
                        new BlacklistPartnersAdapter.ItemsMenu.CallBack() {
                            @Override
                            public void call(BlacklistPartnersAdapter.ItemsMenu itemsMenu) {
                                try{
                                    Bundle _args = new Bundle();

                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }),
                new BlacklistPartnersAdapter.ItemsMenu(getResources().getColor(R.color.my_gray),
                        R.drawable.togle_uncheked,
                        "Партнер 2", check,
                        new BlacklistPartnersAdapter.ItemsMenu.CallBack() {
                            @Override
                            public void call(BlacklistPartnersAdapter.ItemsMenu itemsMenu) {
                                try{
                                    Bundle _args = new Bundle();

                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        })
        };
        return _arr;
    }
}