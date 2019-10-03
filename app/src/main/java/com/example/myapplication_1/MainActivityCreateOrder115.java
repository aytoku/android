package com.example.myapplication_1;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.AdapterCreateOrder115;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivityCreateOrder115 extends AppCompatActivity {

    ImageButton androidImageButton;

    RecyclerView rv;
    RecyclerView.Adapter mAdapter;

    List<String> myDataset = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.create_order_1_1_5);

        rv = (RecyclerView) findViewById(R.id.ll_create_order_1_1_5_recycler);

        for (int i=0;i<20;i++){
            
        }

        ItemTouchHelper.SimpleCallback helper = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN,0) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder dragged, RecyclerView.ViewHolder target) {

                int position_dragged = dragged.getAdapterPosition();
                int position_target = target.getAdapterPosition();

                Collections.swap(myDataset, position_dragged, position_target);
                mAdapter.notifyItemMoved(position_dragged, position_target);

                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {

            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(helper);
        itemTouchHelper.attachToRecyclerView(rv);
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

            AdapterCreateOrder115.AdapterGridViewMenu.ItemsMenu[] itemsMenu = getMenuItems();//model_data

            AdapterCreateOrder115.AdapterGridViewMenu adapterGridViewMenu = new AdapterCreateOrder115.AdapterGridViewMenu(itemsMenu, getBaseContext());//this;
            recyclerViewMenu.setAdapter( adapterGridViewMenu );
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getBaseContext(), RecyclerView.VERTICAL, false ) );
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
    }


    private AdapterCreateOrder115.AdapterGridViewMenu.ItemsMenu[] getMenuItems() {

        AdapterCreateOrder115.AdapterGridViewMenu.ItemsMenu []_arr = new AdapterCreateOrder115.AdapterGridViewMenu.ItemsMenu[]{

                new AdapterCreateOrder115.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        R.drawable.ic_cross,
                        "Максима Горького, 123",
                         R.drawable.icon_three_lines),


                new AdapterCreateOrder115.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        R.drawable.ic_cross,
                        "Коста, 222",
                        R.drawable.icon_three_lines),


                new AdapterCreateOrder115.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        R.drawable.ic_cross,
                        "Максима Горького, 23",
                        R.drawable.icon_three_lines)
        };
        return _arr;
    }
}

