package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.DeployedMessagesAdapter;
import com.example.myapplication_1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeployedMessagesFragment extends Fragment {

    public static final String TAG = "DeployedMessagesFragment";

    public static DeployedMessagesFragment getInstance(Bundle args) {

        DeployedMessagesFragment f = new DeployedMessagesFragment();
        f.setArguments(args);

        return f;
    }

    RecyclerView rv;
    RecyclerView.Adapter adapterGridViewMenu;
    private List<DeployedMessagesAdapter.ItemsMenu> itemsMenuList;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.deployed_messages,
                container, false);

        rv = view.findViewById(R.id.deployed_messages_recycler);

        final RecyclerView recyclerViewMenu = rv;

        try {

            DeployedMessagesAdapter.ItemsMenu[] itemsMenu = getMenuItems();
            itemsMenuList = new ArrayList<>(Arrays.asList(itemsMenu));
            adapterGridViewMenu = new DeployedMessagesAdapter(itemsMenuList, getActivity().getBaseContext());
            recyclerViewMenu.setAdapter(adapterGridViewMenu);
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ));
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }

        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {

                int position = viewHolder.getAdapterPosition();
                itemsMenuList.remove(position);
                adapterGridViewMenu.notifyDataSetChanged();
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(rv);

        return view;
    }

    private DeployedMessagesAdapter.ItemsMenu[] getMenuItems() {

        DeployedMessagesAdapter.ItemsMenu[] arr = new DeployedMessagesAdapter.ItemsMenu[]{

                new DeployedMessagesAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Выполните еще три заказа и получите\n+30 к рейтингу"),

                new DeployedMessagesAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Выполните еще три заказа и получите\n+30 к рейтингу"),

                new DeployedMessagesAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Как настроение?"),

                new DeployedMessagesAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Выполните еще три заказа и получите\n+30 к рейтингу"),

                new DeployedMessagesAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Выполните еще три заказа и получите\n+30 к рейтингу")
        };
        return arr;
    }
}