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

import com.example.myapplication_1.Adapters.ChatWithDriverAdapter;
import com.example.myapplication_1.R;

public class ChatWithDriverFragment extends Fragment {

    public static final String TAG = "ChatWithDriverFragment";

    public static ChatWithDriverFragment getInstance(Bundle args) {

        ChatWithDriverFragment f = new ChatWithDriverFragment();
        f.setArguments(args);

        return f;
    }

    ImageButton androidImageButton;

    RecyclerView rv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.chat_with_driver,
                container, false);
        androidImageButton = view.findViewById(R.id.img_cross_grey);

        rv = view.findViewById(R.id.rl_chat_with_driver_recycler);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        RecyclerView recyclerViewMenu = rv;

        try {

            ChatWithDriverAdapter.AdapterGridViewMenu.ItemsMenu[] itemsMenu = getMenuItems();//model_data

            ChatWithDriverAdapter.AdapterGridViewMenu adapterGridViewMenu = new ChatWithDriverAdapter.AdapterGridViewMenu(itemsMenu, getActivity().getBaseContext());//this;
            recyclerViewMenu.setAdapter( adapterGridViewMenu );
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.HORIZONTAL, false ) );
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
    }

    private ChatWithDriverAdapter.AdapterGridViewMenu.ItemsMenu[] getMenuItems() {

        ChatWithDriverAdapter.AdapterGridViewMenu.ItemsMenu []_arr = new ChatWithDriverAdapter.AdapterGridViewMenu.ItemsMenu[]{
                new ChatWithDriverAdapter.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        new ChatWithDriverAdapter.AdapterGridViewMenu.ItemsMenu.CallBack() {
                            @Override
                            public void call(ChatWithDriverAdapter.AdapterGridViewMenu.ItemsMenu itemsMenu) {

                                try {

                                    Bundle _args = new Bundle();

                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, "Уже выхожу"),

                new ChatWithDriverAdapter.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        new ChatWithDriverAdapter.AdapterGridViewMenu.ItemsMenu.CallBack() {
                            @Override
                            public void call(ChatWithDriverAdapter.AdapterGridViewMenu.ItemsMenu itemsMenu) {

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