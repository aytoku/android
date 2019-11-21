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
import com.example.myapplication_1.Adapters.DeployedMessagesAdapter;
import com.example.myapplication_1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChatWithDriverFragment extends Fragment {

    public static final String TAG = "ChatWithDriverFragment";

    public static ChatWithDriverFragment getInstance(Bundle args) {

        ChatWithDriverFragment f = new ChatWithDriverFragment();
        f.setArguments(args);

        return f;
    }

    ImageButton androidImageButton;

    RecyclerView rv;
    RecyclerView rv1;
    RecyclerView.Adapter adapterGridViewMenu;
    private List<DeployedMessagesAdapter.ItemsMenu> itemsMenuList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.empty_chat_with_driver,
                container, false);
        androidImageButton = view.findViewById(R.id.img_cross_grey);

        rv = view.findViewById(R.id.rl_empty_chat_with_driver_recycler);
        rv1 = view.findViewById(R.id.deployed_messages_recycler);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        RecyclerView recyclerViewMenu = rv;

        try {

            ChatWithDriverAdapter.ItemsMenu[] itemsMenu = getMenuItems();//model_data

            ChatWithDriverAdapter adapterGridViewMenu = new ChatWithDriverAdapter(itemsMenu, getActivity().getBaseContext());//this;
            recyclerViewMenu.setAdapter( adapterGridViewMenu );
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.HORIZONTAL, false ) );
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }

        RecyclerView recyclerView1 = rv1;

        try {

            DeployedMessagesAdapter.ItemsMenu[] itemsMenu = getMenuItems1();
            itemsMenuList = new ArrayList<>(Arrays.asList(itemsMenu));
            adapterGridViewMenu = new DeployedMessagesAdapter(itemsMenuList, getActivity().getBaseContext());
            recyclerView1.setAdapter(adapterGridViewMenu);
            recyclerView1.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ));
            recyclerView1.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
    }

    private ChatWithDriverAdapter.ItemsMenu[] getMenuItems() {

        ChatWithDriverAdapter.ItemsMenu []_arr = new ChatWithDriverAdapter.ItemsMenu[]{
                new ChatWithDriverAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray), "Уже выхожу"),

                new ChatWithDriverAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                       "Не вижу вас")
        };
        return _arr;
    }

    private DeployedMessagesAdapter.ItemsMenu[] getMenuItems1() {

        DeployedMessagesAdapter.ItemsMenu[] arr = new DeployedMessagesAdapter.ItemsMenu[]{

                new DeployedMessagesAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Выполните еще три заказа и получите\n+30 к рейтингу"),

                new DeployedMessagesAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Выполните еще три заказа и получите\n+30 к рейтингу"),

                new DeployedMessagesAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Как настроение?")
        };
        return arr;
    }
}