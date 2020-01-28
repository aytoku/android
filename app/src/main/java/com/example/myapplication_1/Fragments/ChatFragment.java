package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.ChatAdapter;
import com.example.myapplication_1.R;

public class ChatFragment extends Fragment {

    public static final String TAG = "ChatFragment";
    private RecyclerView rv;

    public static ChatFragment getInstance(Bundle args) {

        ChatFragment chatFragment = new ChatFragment();
        chatFragment.setArguments(args);

        return chatFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.empty_chat_with_driver,
                container, false);

        rv = view.findViewById(R.id.rl_empty_chat_with_driver_recycler);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        RecyclerView recyclerView = rv;
        try {
            ChatAdapter.ChatItems[] chatItems = getChatItems();
            ChatAdapter chatAdapter = new ChatAdapter(chatItems, getActivity().getBaseContext());
            recyclerView.setAdapter( chatAdapter );
            recyclerView.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.HORIZONTAL, false ) );
            recyclerView.setItemAnimator( new DefaultItemAnimator() );
        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
    }

    private ChatAdapter.ChatItems[] getChatItems() {
        ChatAdapter.ChatItems []_arr = new ChatAdapter.ChatItems[]{
                new ChatAdapter.ChatItems(new ChatAdapter.ChatItems.CallBack() {
                    @Override
                    public void call(ChatAdapter.ChatItems itemsMenu) {
                        try {
                            Bundle _args = new Bundle();
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }
                    }
                }, "Уже выхожу"),

                new ChatAdapter.ChatItems(new ChatAdapter.ChatItems.CallBack() {
                    @Override
                    public void call(ChatAdapter.ChatItems itemsMenu) {
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