package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.DriverMessagesAdapter;
import com.example.myapplication_1.Adapters.EmptyChatWithDriverAdapter;
import com.example.myapplication_1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChatWithOperator extends Fragment {

    public static final String TAG = "ChatWithOperator";

    public static ChatWithOperator getInstance(Bundle args) {

        ChatWithOperator f = new ChatWithOperator();
        f.setArguments(args);

        return f;
    }

    ImageButton androidImageButton;

    RecyclerView rv;
    RecyclerView rv1;
    RecyclerView.Adapter adapterGridViewMenu;
    private List<DriverMessagesAdapter.ItemsMenu> itemsMenuList;
    private List<EmptyChatWithDriverAdapter.ItemsMenu> itemsMenuList1;
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.empty_chat_with_driver,
                container, false);
        androidImageButton = view.findViewById(R.id.img_cross_grey);

        rv = view.findViewById(R.id.rl_empty_chat_with_driver_recycler);
        rv1 = view.findViewById(R.id.deployed_messages_recycler);

        textView = view.findViewById(R.id.chat_with_operator_title);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        RecyclerView recyclerViewMenu = rv;

        try {

            EmptyChatWithDriverAdapter.ItemsMenu[] itemsMenu = getMenuItems();
            itemsMenuList1 = new ArrayList<>(Arrays.asList(itemsMenu));
            adapterGridViewMenu = new EmptyChatWithDriverAdapter(itemsMenuList1, getActivity().getBaseContext());
            recyclerViewMenu.setAdapter(adapterGridViewMenu);
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.HORIZONTAL, false ));
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }

        RecyclerView recyclerView1 = rv1;

        try {

            DriverMessagesAdapter.ItemsMenu[] itemsMenu = getMenuItems1();
            itemsMenuList = new ArrayList<>(Arrays.asList(itemsMenu));
            adapterGridViewMenu = new DriverMessagesAdapter(itemsMenuList, getActivity().getBaseContext());
            recyclerView1.setAdapter(adapterGridViewMenu);
            recyclerView1.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ));
            recyclerView1.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
    }

    private EmptyChatWithDriverAdapter.ItemsMenu[] getMenuItems() {

        EmptyChatWithDriverAdapter.ItemsMenu []_arr = new EmptyChatWithDriverAdapter.ItemsMenu[]{
                new EmptyChatWithDriverAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray), "Уже выхожу",
                        new EmptyChatWithDriverAdapter.ItemsMenu.CallBack() {
                            @Override
                            public void call(EmptyChatWithDriverAdapter.ItemsMenu itemsMenu) {
                                try{
                                    Bundle _args = new Bundle();

                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }),

                new EmptyChatWithDriverAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Не вижу вас",
                        new EmptyChatWithDriverAdapter.ItemsMenu.CallBack() {
                            @Override
                            public void call(EmptyChatWithDriverAdapter.ItemsMenu itemsMenu) {
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

    private DriverMessagesAdapter.ItemsMenu[] getMenuItems1() {

        DriverMessagesAdapter.ItemsMenu[] arr = new DriverMessagesAdapter.ItemsMenu[]{

                new DriverMessagesAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Выполните еще три заказа и получите\n+30 к рейтингу"),

                new DriverMessagesAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Выполните еще три заказа и получите\n+30 к рейтингу")
        };
        return arr;
    }
}