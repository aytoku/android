package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.EmptyChatWithDriverAdapter;
import com.example.myapplication_1.R;

public class EmptyChatWithDriverFragment extends Fragment {

    public static final String TAG = "EmptyChatWithDriverFragment";

    public static EmptyChatWithDriverFragment getInstance(Bundle args) {

        EmptyChatWithDriverFragment f = new EmptyChatWithDriverFragment();
        f.setArguments(args);

        return f;
    }

    ImageButton androidImageButton;

    RecyclerView rv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.empty_chat_with_driver,
                container, false);
        androidImageButton = view.findViewById(R.id.img_cross_grey);

        rv = view.findViewById(R.id.rl_empty_chat_with_driver_recycler);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        RecyclerView recyclerViewMenu = rv;

        try {

            EmptyChatWithDriverAdapter.AdapterGridViewMenu.ItemsMenu[] itemsMenu = getMenuItems();

            EmptyChatWithDriverAdapter.AdapterGridViewMenu adapterGridViewMenu = new EmptyChatWithDriverAdapter.AdapterGridViewMenu(itemsMenu, getActivity().getBaseContext());
            recyclerViewMenu.setAdapter( adapterGridViewMenu );
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.HORIZONTAL, false ) );
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
    }

    private EmptyChatWithDriverAdapter.AdapterGridViewMenu.ItemsMenu[] getMenuItems() {

        EmptyChatWithDriverAdapter.AdapterGridViewMenu.ItemsMenu []_arr = new EmptyChatWithDriverAdapter.AdapterGridViewMenu.ItemsMenu[]{
                new EmptyChatWithDriverAdapter.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        new EmptyChatWithDriverAdapter.AdapterGridViewMenu.ItemsMenu.CallBack() {
                            @Override
                            public void call(EmptyChatWithDriverAdapter.AdapterGridViewMenu.ItemsMenu itemsMenu) {

                                try {

                                    Bundle _args = new Bundle();

                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, "Уже выхожу"),

                new EmptyChatWithDriverAdapter.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        new EmptyChatWithDriverAdapter.AdapterGridViewMenu.ItemsMenu.CallBack() {
                            @Override
                            public void call(EmptyChatWithDriverAdapter.AdapterGridViewMenu.ItemsMenu itemsMenu) {

                                try {

                                    Bundle _args = new Bundle();

                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, "Не вижу вас")
        };
        return _arr;
    }
}