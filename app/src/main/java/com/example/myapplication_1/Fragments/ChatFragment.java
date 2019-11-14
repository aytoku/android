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

import com.example.myapplication_1.Adapters.ChatAdapter;
import com.example.myapplication_1.R;

public class ChatFragment extends Fragment {

    public static final String TAG = "ChatFragment";

    public static ChatFragment getInstance(Bundle args) {

        ChatFragment f = new ChatFragment();
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

            ChatAdapter.ItemsMenu[] itemsMenu = getMenuItems();//model_data

            ChatAdapter adapterGridViewMenu = new ChatAdapter(itemsMenu, getActivity().getBaseContext());//this;
            recyclerViewMenu.setAdapter( adapterGridViewMenu );
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.HORIZONTAL, false ) );
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
    }

    private ChatAdapter.ItemsMenu[] getMenuItems() {

        ChatAdapter.ItemsMenu []_arr = new ChatAdapter.ItemsMenu[]{

                new ChatAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),new ChatAdapter.ItemsMenu.CallBack() {
                    @Override
                    public void call(ChatAdapter.ItemsMenu itemsMenu) {

                        try {

                            Bundle _args = new Bundle();

                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }
                    }
                }, "Уже выхожу"),

                new ChatAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),new ChatAdapter.ItemsMenu.CallBack() {
                    @Override
                    public void call(ChatAdapter.ItemsMenu itemsMenu) {

                        try {

                            Bundle _args = new Bundle();

                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }

                    }
                }, "Не вижу вас"),
        };
        return _arr;
    }
}