package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.AdapterCreateOrder115;
import com.example.myapplication_1.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CreateOrder115Fragment extends Fragment {

    public static final String TAG = "CreateOrder115Fragment";
    RecyclerView rv;
    RecyclerView.Adapter createOrder115Adapter;
    private List<AdapterCreateOrder115.CreateOrderItems> itemsMenuList;

    public static CreateOrder115Fragment getInstance(Bundle args) {

        CreateOrder115Fragment f = new CreateOrder115Fragment();
        f.setArguments(args);

        return f;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.create_order_1_1_5,
                container, false);

        rv = view.findViewById(R.id.ll_create_order_1_1_5_recycler);

        Button button = view.findViewById(R.id.ll_create_order_1_1_5_add_stop);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onAddButtonClicked(view);
            }
        });

        final RecyclerView recyclerViewMenu = rv;

        try {

            AdapterCreateOrder115.CreateOrderItems[] itemsMenu = getCreateOrderItems();
            itemsMenuList = new ArrayList<>(Arrays.asList(itemsMenu));
            createOrder115Adapter = new AdapterCreateOrder115(itemsMenuList, getActivity().getBaseContext());
            recyclerViewMenu.setAdapter(createOrder115Adapter);
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ));
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }

        ItemTouchHelper.SimpleCallback helper = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN,0) {

            @Override
            public boolean onMove(@NotNull RecyclerView recyclerView, RecyclerView.ViewHolder dragged, RecyclerView.ViewHolder target) {

                int position_dragged = dragged.getAdapterPosition();
                int position_target = target.getAdapterPosition();

                Collections.swap(itemsMenuList, position_dragged, position_target);
                createOrder115Adapter.notifyItemMoved(position_dragged, position_target);

                return true;
            }

            @Override
            public void onSwiped(@NotNull RecyclerView.ViewHolder viewHolder, int swipeDir) {
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(helper);
        itemTouchHelper.attachToRecyclerView(rv);

        return view;
    }

    public void onAddButtonClicked(View view) {

        try {
            itemsMenuList.add(itemsMenuList.size(), new AdapterCreateOrder115.CreateOrderItems(
                    R.drawable.ic_cross,
                    "Максима Горького, 123",
                    R.drawable.icon_three_lines));
            createOrder115Adapter.notifyItemInserted(itemsMenuList.size()-1);
            createOrder115Adapter.notifyDataSetChanged();

        } catch(NumberFormatException e) {
            Toast.makeText(getActivity().getApplicationContext(), "The field is empty",
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    private AdapterCreateOrder115.CreateOrderItems[] getCreateOrderItems() {

        AdapterCreateOrder115.CreateOrderItems[] arr = new AdapterCreateOrder115.CreateOrderItems[]{

                new AdapterCreateOrder115.CreateOrderItems(
                        R.drawable.ic_cross,
                        "Максима Горького, 123",
                        R.drawable.icon_three_lines),

                new AdapterCreateOrder115.CreateOrderItems(
                        R.drawable.ic_cross,
                        "Коста, 222",
                        R.drawable.icon_three_lines),

                new AdapterCreateOrder115.CreateOrderItems(
                        R.drawable.ic_cross,
                        "Максима Горького, 23",
                        R.drawable.icon_three_lines)
        };
        return arr;
    }
}