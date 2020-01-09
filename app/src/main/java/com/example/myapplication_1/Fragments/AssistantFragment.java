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

import com.example.myapplication_1.Adapters.AssistantAdapter;
import com.example.myapplication_1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AssistantFragment extends Fragment {

    public static final String TAG = "AssistantFragment";

    public static AssistantFragment getInstance(Bundle args) {

        AssistantFragment f = new AssistantFragment();
        f.setArguments(args);

        return f;
    }

    RecyclerView.Adapter assistantAdapter;
    private List<AssistantAdapter.AssistantItems> itemsMenuList;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.assistant,
                container, false);

        RecyclerView rv = view.findViewById(R.id.assistant_recycler);

        final RecyclerView recyclerViewMenu = rv;

        try {

            AssistantAdapter.AssistantItems[] itemsMenu = getAssistantItems();
            itemsMenuList = new ArrayList<>(Arrays.asList(itemsMenu));
            assistantAdapter = new AssistantAdapter(itemsMenuList, getActivity().getBaseContext());
            recyclerViewMenu.setAdapter(assistantAdapter);
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
                assistantAdapter.notifyDataSetChanged();
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(rv);

        return view;
    }

    private AssistantAdapter.AssistantItems[] getAssistantItems() {

        AssistantAdapter.AssistantItems[] arr = new AssistantAdapter.AssistantItems[]{

                new AssistantAdapter.AssistantItems(
                        "Вы можете самостоятельно\nотрегулировать стоимоть"),

                new AssistantAdapter.AssistantItems(
                        "Тариф временно увеличен"),

                new AssistantAdapter.AssistantItems(
                        "Водитель подъехал")
        };
        return arr;
    }
}