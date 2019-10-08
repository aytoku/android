package com.example.myapplication_1;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.AdapterCreateOrder115;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivityCreateOrder115 extends AppCompatActivity {

    RecyclerView rv;
    RecyclerView.Adapter adapterGridViewMenu;
    private List<AdapterCreateOrder115.AdapterGridViewMenu.ItemsMenu> itemsMenuList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.create_order_1_1_5);

        rv = findViewById(R.id.ll_create_order_1_1_5_recycler);

        final RecyclerView recyclerViewMenu = rv;

        try {

            AdapterCreateOrder115.AdapterGridViewMenu.ItemsMenu[] itemsMenu = getMenuItems();
            itemsMenuList = Arrays.asList(itemsMenu);
            adapterGridViewMenu = new AdapterCreateOrder115.AdapterGridViewMenu(itemsMenu, getBaseContext());
            recyclerViewMenu.setAdapter(adapterGridViewMenu);
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getBaseContext(), RecyclerView.VERTICAL, false ));
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }

//        recyclerViewMenu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                RecyclerView.Adapter adapter;
//                adapter = adapterGridViewMenu;
//                adapter.notifyItemRangeRemoved();
//            }
//        });
        
//            itemsMenuList.clear();
//
//            itemsMenuList.add(new ItemsMenu(context.getResources().getColor(R.color.my_gray),
//                    R.drawable.ic_cross,
//                    "Максима Горького, 123",
//                    R.drawable.icon_three_lines));

        ItemTouchHelper.SimpleCallback helper = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN,0) {

            @Override
            public boolean onMove(@NotNull RecyclerView recyclerView, RecyclerView.ViewHolder dragged, RecyclerView.ViewHolder target) {

                int position_dragged = dragged.getAdapterPosition();
                int position_target = target.getAdapterPosition();

                Collections.swap(itemsMenuList, position_dragged, position_target);
                adapterGridViewMenu.notifyItemMoved(position_dragged, position_target);

                return true;
            }

            @Override
            public void onSwiped(@NotNull RecyclerView.ViewHolder viewHolder, int swipeDir) {

            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(helper);
        itemTouchHelper.attachToRecyclerView(rv);

       //  update(itemsMenuList);

       //  recyclerViewMenu.invalidate();
       //  adapterGridViewMenu.notifyDataSetChanged();
       //  recyclerViewMenu.getAdapter().notifyDataSetChanged();
       //  adapterGridViewMenu.notifyItemRangeRemoved(0, itemsMenuList.size());
    }
//    public void update(ArrayList<AdapterCreateOrder115.AdapterGridViewMenu.ItemsMenu> itemsMenu){
//        itemsMenuList.clear();
//        itemsMenuList.addAll(itemsMenu);
//        adapterGridViewMenu.notifyDataSetChanged();
//    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {

        return super.onCreateView(parent, name, context, attrs);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private AdapterCreateOrder115.AdapterGridViewMenu.ItemsMenu[] getMenuItems() {

       AdapterCreateOrder115.AdapterGridViewMenu.ItemsMenu[] arr = new AdapterCreateOrder115.AdapterGridViewMenu.ItemsMenu[]{

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
        return arr;
    }
}

