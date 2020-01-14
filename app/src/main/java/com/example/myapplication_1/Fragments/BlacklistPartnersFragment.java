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
    private RecyclerView black_list_rv;
    private boolean check = false;

    public static BlacklistPartnersFragment getInstance(Bundle args) {

        BlacklistPartnersFragment f = new BlacklistPartnersFragment();
        f.setArguments(args);

        return f;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.black_list_partner,
                container, false);

        black_list_rv = view.findViewById(R.id.ll_blackList_partner_recycler_partners);
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

        RecyclerView recyclerView = black_list_rv;

        try{
            BlacklistPartnersAdapter.BlackListItems[] blackListItems = getBlackListItems();
            BlacklistPartnersAdapter blacklistPartnersAdapter = new BlacklistPartnersAdapter(blackListItems, getActivity().getBaseContext());
            recyclerView.setAdapter( blacklistPartnersAdapter );
            recyclerView.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ) );
            recyclerView.setItemAnimator( new DefaultItemAnimator() );

        }catch ( NullPointerException e) {
            e.printStackTrace();
        }
    }

    private BlacklistPartnersAdapter.BlackListItems[] getBlackListItems() {

        BlacklistPartnersAdapter.BlackListItems []_arr = new BlacklistPartnersAdapter.BlackListItems[]{

                new BlacklistPartnersAdapter.BlackListItems(
                        R.drawable.togle_uncheked,
                        "Партнер 1", check,
                        new BlacklistPartnersAdapter.BlackListItems.CallBack() {
                            @Override
                            public void call(BlacklistPartnersAdapter.BlackListItems blackListItems) {
                                try{
                                    Bundle _args = new Bundle();

                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }),
                new BlacklistPartnersAdapter.BlackListItems(
                        R.drawable.togle_uncheked,
                        "Партнер 2", check,
                        new BlacklistPartnersAdapter.BlackListItems.CallBack() {
                            @Override
                            public void call(BlacklistPartnersAdapter.BlackListItems blackListItems) {
                                try{
                                    Bundle _args = new Bundle();

                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }),
                new BlacklistPartnersAdapter.BlackListItems(
                        R.drawable.togle_uncheked,
                        "Партнер 1", check,
                        new BlacklistPartnersAdapter.BlackListItems.CallBack() {
                            @Override
                            public void call(BlacklistPartnersAdapter.BlackListItems blackListItems) {
                                try{
                                    Bundle _args = new Bundle();

                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }),
                new BlacklistPartnersAdapter.BlackListItems(
                        R.drawable.togle_uncheked,
                        "Партнер 2", check,
                        new BlacklistPartnersAdapter.BlackListItems.CallBack() {
                            @Override
                            public void call(BlacklistPartnersAdapter.BlackListItems blackListItems) {
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