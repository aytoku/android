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

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AssistantFragment extends Fragment {

    public static final String TAG = "AssistantFragment";
    private RecyclerView.Adapter assistantAdapter;
    private List<AssistantAdapter.AssistantItems> assistantItemsList;

    public static AssistantFragment getInstance(Bundle args) {

        AssistantFragment assistantFragment = new AssistantFragment();
        assistantFragment.setArguments(args);

        return assistantFragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.assistant,
                container, false);

        RecyclerView assistant_rv = view.findViewById(R.id.assistant_recycler);

        try{
            AssistantAdapter.AssistantItems[] assistantItems = getAssistantItems();
            assistantItemsList = new ArrayList<>(Arrays.asList(assistantItems));
            assistantAdapter = new AssistantAdapter(assistantItemsList, getActivity().getBaseContext());
            assistant_rv.setAdapter(assistantAdapter);
            assistant_rv.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ));
            assistant_rv.setItemAnimator( new DefaultItemAnimator() );
        }catch( NullPointerException e){
            e.printStackTrace();
        }

        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder, @NotNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir){
                int position = viewHolder.getAdapterPosition();
                assistantItemsList.remove(position);
                assistantAdapter.notifyDataSetChanged();
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(assistant_rv);

        return view;
    }

    private AssistantAdapter.AssistantItems[] getAssistantItems(){
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