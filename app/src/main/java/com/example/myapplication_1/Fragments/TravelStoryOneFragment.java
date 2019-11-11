package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.CellTravelStoryOneAdapter;
import com.example.myapplication_1.Adapters.CellTravelStoryOneCardAdapter;
import com.example.myapplication_1.R;

public class TravelStoryOneFragment extends Fragment {

    public static final String TAG = "TravelStoryOneFragment";

    public static TravelStoryOneFragment getInstance(Bundle args) {

        TravelStoryOneFragment f = new TravelStoryOneFragment();
        f.setArguments(args);

        return f;
    }

    ImageView button;
    RecyclerView rv;
    RecyclerView rv1;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.travel_story_1, container, false);

        Bundle _args = new Bundle();
        final Fragment travelStoryOneFragment = TravelStoryFragment.getInstance(_args);

        button = view.findViewById(R.id.rl_travel_story_1_imageView);

        rv = view.findViewById(R.id.rl_travel_story_1_recycler_card);

        rv1 = view.findViewById(R.id.rl_travel_story_1_recycler);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_main, travelStoryOneFragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        RecyclerView recyclerViewMenu = rv;

        try {

            CellTravelStoryOneCardAdapter.AdapterTravelStoryOneCard.TravelStoryRow[] itemsMenu = getMenuItems();

            CellTravelStoryOneCardAdapter.AdapterTravelStoryOneCard adapterGridViewMenu = new CellTravelStoryOneCardAdapter.AdapterTravelStoryOneCard(itemsMenu, getActivity().getBaseContext());
            recyclerViewMenu.setAdapter( adapterGridViewMenu );
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ) );
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }


        RecyclerView recyclerView = rv1;

        try {

            CellTravelStoryOneAdapter.AdapterTravelStoryOne.PaymentDesc[] itemsMenu = getMenuItems1();

            CellTravelStoryOneAdapter.AdapterTravelStoryOne adapterGridViewMenu = new CellTravelStoryOneAdapter.AdapterTravelStoryOne(itemsMenu, getActivity().getBaseContext());
            recyclerView.setAdapter( adapterGridViewMenu );
            recyclerView.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ) );
            recyclerView.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
    }

    private CellTravelStoryOneCardAdapter.AdapterTravelStoryOneCard.TravelStoryRow[] getMenuItems() {

        CellTravelStoryOneCardAdapter.AdapterTravelStoryOneCard.TravelStoryRow []_arr = new CellTravelStoryOneCardAdapter.AdapterTravelStoryOneCard.TravelStoryRow[]{

                new CellTravelStoryOneCardAdapter.AdapterTravelStoryOneCard.TravelStoryRow(
                        getResources().getColor(R.color.my_gray),
                        "Сегодня 10:10",
                        R.drawable.icon_ellipse_red,
                        new CellTravelStoryOneCardAdapter.AdapterTravelStoryOneCard.TravelStoryRow.CallBack() {
                            @Override
                            public void call(CellTravelStoryOneCardAdapter.AdapterTravelStoryOneCard.TravelStoryRow itemsMenu) {

                                try {

                                    Bundle _args = new Bundle();

                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, "Максима Горького, 23")
        };
        return _arr;
    }

    private CellTravelStoryOneAdapter.AdapterTravelStoryOne.PaymentDesc[] getMenuItems1() {

        CellTravelStoryOneAdapter.AdapterTravelStoryOne.PaymentDesc []_arr1 = new CellTravelStoryOneAdapter.AdapterTravelStoryOne.PaymentDesc[]{

                new CellTravelStoryOneAdapter.AdapterTravelStoryOne.PaymentDesc(
                        getResources().getColor(R.color.my_gray),
                        "Ожидание",
                        "5 мин*3 \u20BD","15 \u20BD"),

                new CellTravelStoryOneAdapter.AdapterTravelStoryOne.PaymentDesc(
                        getResources().getColor(R.color.my_gray),
                        "Дополнительные услуги",
                        "Детское кресло, пустой багаж","30 \u20BD")
        };
        return _arr1;
    }
}