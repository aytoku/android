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

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeployedMessagesFragment extends Fragment {

    public static final String TAG = "DeployedMessagesFragment";
    private RecyclerView.Adapter deployedMessagesAdapter;
    private List<DeployedMessagesAdapter.DeployedMessagesItems> deployedMessagesItemsList;

    public static DeployedMessagesFragment getInstance(Bundle args) {

        DeployedMessagesFragment deployedMessagesFragment = new DeployedMessagesFragment();
        deployedMessagesFragment.setArguments(args);

        return deployedMessagesFragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.deployed_messages,
                container, false);

        RecyclerView deployedMessages_rv = view.findViewById(R.id.deployed_messages_recycler);

        final RecyclerView recyclerView = deployedMessages_rv;
        try {
            DeployedMessagesAdapter.DeployedMessagesItems[] deployedMessagesItems = getDeployedMessagesItems();
            deployedMessagesItemsList = new ArrayList<>(Arrays.asList(deployedMessagesItems));
            deployedMessagesAdapter = new DeployedMessagesAdapter(deployedMessagesItemsList, getActivity().getBaseContext());
            recyclerView.setAdapter(deployedMessagesAdapter);
            recyclerView.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ));
            recyclerView.setItemAnimator( new DefaultItemAnimator() );
        } catch ( NullPointerException e) {
            e.printStackTrace();
        }

        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder, @NotNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {

                int position = viewHolder.getAdapterPosition();
                deployedMessagesItemsList.remove(position);
                deployedMessagesAdapter.notifyDataSetChanged();
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(deployedMessages_rv);

        return view;
    }

    private DeployedMessagesAdapter.DeployedMessagesItems[] getDeployedMessagesItems() {

        DeployedMessagesAdapter.DeployedMessagesItems[] arr = new DeployedMessagesAdapter.DeployedMessagesItems[]{

                new DeployedMessagesAdapter.DeployedMessagesItems(
                        "Выполните еще три заказа и получите\n+30 к рейтингу"),

                new DeployedMessagesAdapter.DeployedMessagesItems(
                        "Выполните еще три заказа и получите\n+30 к рейтингу"),

                new DeployedMessagesAdapter.DeployedMessagesItems(
                        "Как настроение?"),

                new DeployedMessagesAdapter.DeployedMessagesItems(
                        "Выполните еще три заказа и получите\n+30 к рейтингу"),

                new DeployedMessagesAdapter.DeployedMessagesItems(
                        "Выполните еще три заказа и получите\n+30 к рейтингу")
        };
        return arr;
    }
}