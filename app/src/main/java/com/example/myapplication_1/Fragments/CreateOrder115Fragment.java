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
    private RecyclerView.Adapter createOrder115Adapter;
    private List<AdapterCreateOrder115.CreateOrderItems> createOrderItemsList;

    public static CreateOrder115Fragment getInstance(Bundle args) {

        CreateOrder115Fragment createOrder115Fragment = new CreateOrder115Fragment();
        createOrder115Fragment.setArguments(args);

        return createOrder115Fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.create_order_1_1_5,
                container, false);

        RecyclerView create_order_rv = view.findViewById(R.id.ll_create_order_1_1_5_recycler);
        Button button = view.findViewById(R.id.ll_create_order_1_1_5_add_stop);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAddButtonClicked(view);
            }
        });
        final RecyclerView recyclerView = create_order_rv;
        try {
            AdapterCreateOrder115.CreateOrderItems[] createOrderItems = getCreateOrderItems();
            createOrderItemsList = new ArrayList<>(Arrays.asList(createOrderItems));
            createOrder115Adapter = new AdapterCreateOrder115(createOrderItemsList, getActivity().getBaseContext());
            recyclerView.setAdapter(createOrder115Adapter);
            recyclerView.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ));
            recyclerView.setItemAnimator( new DefaultItemAnimator() );
        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
        ItemTouchHelper.SimpleCallback helper = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN,0) {

            @Override
            public boolean onMove(@NotNull RecyclerView recyclerView, RecyclerView.ViewHolder dragged, RecyclerView.ViewHolder target) {
                int position_dragged = dragged.getAdapterPosition();
                int position_target = target.getAdapterPosition();
                Collections.swap(createOrderItemsList, position_dragged, position_target);
                createOrder115Adapter.notifyItemMoved(position_dragged, position_target);

                return true;
            }

            @Override
            public void onSwiped(@NotNull RecyclerView.ViewHolder viewHolder, int swipeDir) {
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(helper);
        itemTouchHelper.attachToRecyclerView(create_order_rv);

        return view;
    }

    private void onAddButtonClicked(View view) {
        try {
            createOrderItemsList.add(createOrderItemsList.size(), new AdapterCreateOrder115.CreateOrderItems(
                    R.drawable.ic_cross,
                    "Максима Горького, 123"
            ));
            createOrder115Adapter.notifyItemInserted(createOrderItemsList.size()-1);
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
                        "Максима Горького, 123"
                ),

                new AdapterCreateOrder115.CreateOrderItems(
                        R.drawable.ic_cross,
                        "Коста, 222"
                ),

                new AdapterCreateOrder115.CreateOrderItems(
                        R.drawable.ic_cross,
                        "Максима Горького, 23"
                )
        };
        return arr;
    }
}