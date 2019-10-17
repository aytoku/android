package com.example.myapplication_1;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.ChatAdapter;

public class MainActivityChat extends AppCompatActivity {

    ImageButton androidImageButton;

    RecyclerView rv;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        androidImageButton = (ImageButton) findViewById(R.id.img_cross_grey);

        setContentView(R.layout.empty_chat_with_driver);

        rv = (RecyclerView) findViewById(R.id.rl_empty_chat_with_driver_recycler);

    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {



        return super.onCreateView(parent, name, context, attrs);
    }

    @Override
    protected void onStart() {
        super.onStart();

        RecyclerView recyclerViewMenu = rv;

        try {

            ChatAdapter.AdapterGridViewMenu.ItemsMenu[] itemsMenu = getMenuItems();//model_data

            ChatAdapter.AdapterGridViewMenu adapterGridViewMenu = new ChatAdapter.AdapterGridViewMenu(itemsMenu, getBaseContext());//this;
            recyclerViewMenu.setAdapter( adapterGridViewMenu );
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getBaseContext(), RecyclerView.HORIZONTAL, false ) );
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }

    }

    private ChatAdapter.AdapterGridViewMenu.ItemsMenu[] getMenuItems() {

        ChatAdapter.AdapterGridViewMenu.ItemsMenu []_arr = new ChatAdapter.AdapterGridViewMenu.ItemsMenu[]{

                new ChatAdapter.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),new ChatAdapter.AdapterGridViewMenu.ItemsMenu.CallBack() {
                    @Override
                    public void call(ChatAdapter.AdapterGridViewMenu.ItemsMenu itemsMenu) {

                        try {

                            Bundle _args = new Bundle();

                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }

                    }
                },
                        "Уже выхожу"),

                new ChatAdapter.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),new ChatAdapter.AdapterGridViewMenu.ItemsMenu.CallBack() {
                    @Override
                    public void call(ChatAdapter.AdapterGridViewMenu.ItemsMenu itemsMenu) {

                        try {

                            Bundle _args = new Bundle();

                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }

                    }
                },
                        "Не вижу вас"),
        };
        return _arr;

    }
}

