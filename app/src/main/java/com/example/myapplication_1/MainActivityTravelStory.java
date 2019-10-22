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

import com.example.myapplication_1.Adapters.TravelStoryAdapter;

public class MainActivityTravelStory extends AppCompatActivity {

    ImageButton androidImageButton;

    RecyclerView rv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        androidImageButton = (ImageButton) findViewById(R.id.img_cross_grey);


        setContentView(R.layout.travel_story);

        rv = (RecyclerView) findViewById(R.id.recycler_travel_story);

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

            TravelStoryAdapter.AdapterGridViewMenu.ItemsMenu[] itemsMenu = getMenuItems();//model_data

            TravelStoryAdapter.AdapterGridViewMenu adapterGridViewMenu = new TravelStoryAdapter.AdapterGridViewMenu(itemsMenu, getBaseContext());//this;
            recyclerViewMenu.setAdapter( adapterGridViewMenu );
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getBaseContext(), RecyclerView.VERTICAL, false ) );
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }

    }

    private TravelStoryAdapter.AdapterGridViewMenu.ItemsMenu[] getMenuItems() {

        TravelStoryAdapter.AdapterGridViewMenu.ItemsMenu []_arr = new TravelStoryAdapter.AdapterGridViewMenu.ItemsMenu[]{

                new TravelStoryAdapter.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        R.drawable.icon_ellipse_red,
                        "Сегодня 10:10",
                        new TravelStoryAdapter.AdapterGridViewMenu.ItemsMenu.CallBack() {
                            @Override
                            public void call(TravelStoryAdapter.AdapterGridViewMenu.ItemsMenu itemsMenu) {

                                try {

                                    Bundle _args = new Bundle();

                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, "66 \u20BD")
        };
        return _arr;

    }



}

