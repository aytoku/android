package com.example.myapplication_1.Fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
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
    private RecyclerView rv;
    private RecyclerView rv1;
    private Drawable micro;
    private Drawable arrow;
    private EditText editText;
    private ImageView imageView;

    public static ChatWithOperator getInstance(Bundle args) {

        ChatWithOperator chatWithOperator = new ChatWithOperator();
        chatWithOperator.setArguments(args);

        return chatWithOperator;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.chat_with_operator,
                container, false);

        rv = view.findViewById(R.id.rl_empty_chat_with_driver_recycler);
        rv1 = view.findViewById(R.id.deployed_messages_recycler);
        TextView textView = view.findViewById(R.id.ll_chat_with_operator_title);
        editText = view.findViewById(R.id.ll_driver_chat_text);
        imageView = view.findViewById(R.id.ll_chat_with_operator_img);
        micro = getResources().getDrawable(R.drawable.ic_chat_micro);
        arrow = getResources().getDrawable(R.drawable.ic_chat_arrow);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle _args = new Bundle();
                EmptyChatWithDriverFragment emptyChatWithDriverFragment = EmptyChatWithDriverFragment.getInstance(_args);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, emptyChatWithDriverFragment);
                fragmentTransaction.commit();
            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editText.length()>0){
                    imageView.setImageDrawable(arrow);
                }else{
                    imageView.setImageDrawable(micro);
                }
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        RecyclerView recyclerViewMenu = rv;
        RecyclerView.Adapter adapterGridViewMenu;
        try {
            EmptyChatWithDriverAdapter.ItemsMenu[] itemsMenu = getMenuItems();
            List<EmptyChatWithDriverAdapter.ItemsMenu> itemsMenuList1 = new ArrayList<>(Arrays.asList(itemsMenu));
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
            List<DriverMessagesAdapter.ItemsMenu> itemsMenuList = new ArrayList<>(Arrays.asList(itemsMenu));
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
                new EmptyChatWithDriverAdapter.ItemsMenu( "Уже выхожу",
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
                        "Выполните еще три заказа и получите\n+30 к рейтингу"),

                new DriverMessagesAdapter.ItemsMenu(
                        "Выполните еще три заказа и получите\n+30 к рейтингу")
        };
        return arr;
    }
}