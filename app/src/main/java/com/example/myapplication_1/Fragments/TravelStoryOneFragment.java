package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.CellTravelStoryOneAdapter;
import com.example.myapplication_1.Adapters.CellTravelStoryOneCardAdapter;
import com.example.myapplication_1.Alerts.TravelStoryOneAlert;
import com.example.myapplication_1.R;

public class TravelStoryOneFragment extends Fragment {

    public static final String TAG = "TravelStoryOneFragment";
    ImageView button;
    RecyclerView rv;
    RecyclerView rv1;
    LinearLayout linearLayout;

    public static TravelStoryOneFragment getInstance(Bundle args) {

        TravelStoryOneFragment f = new TravelStoryOneFragment();
        f.setArguments(args);

        return f;
    }

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

        linearLayout = view.findViewById(R.id.rl_travel_story_1_ll);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(view);
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        RecyclerView recyclerViewMenu = rv;

        try {

            CellTravelStoryOneCardAdapter.TravelStoryRow[] travelStoryRowItems = getTravelStoryRowItems();

            CellTravelStoryOneCardAdapter cellTravelStoryOneCardAdapter = new CellTravelStoryOneCardAdapter(travelStoryRowItems, getActivity().getBaseContext());
            recyclerViewMenu.setAdapter( cellTravelStoryOneCardAdapter );
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ) );
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }


        RecyclerView recyclerView = rv1;

        try {

            CellTravelStoryOneAdapter.PaymentDesc[] travelStoryItems = getCellTravelStoryItems();

            CellTravelStoryOneAdapter adapterGridViewMenu = new CellTravelStoryOneAdapter(travelStoryItems, getActivity().getBaseContext());
            recyclerView.setAdapter( adapterGridViewMenu );
            recyclerView.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ) );
            recyclerView.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void showDialog(View view){

        TravelStoryOneAlert travelStoryOneAlert = new TravelStoryOneAlert();
        travelStoryOneAlert.setCancelable(true);
        travelStoryOneAlert.show(getFragmentManager(), "DriverTipsFragment");
    }

    private CellTravelStoryOneCardAdapter.TravelStoryRow[] getTravelStoryRowItems() {

        CellTravelStoryOneCardAdapter.TravelStoryRow []_arr = new CellTravelStoryOneCardAdapter.TravelStoryRow[]{

                new CellTravelStoryOneCardAdapter.TravelStoryRow(
                        getResources().getColor(R.color.my_gray),
                        "Сегодня 10:10",
                        R.drawable.icon_ellipse_red,
                        new CellTravelStoryOneCardAdapter.TravelStoryRow.CallBack() {
                            @Override
                            public void call(CellTravelStoryOneCardAdapter.TravelStoryRow travelStoryRowItems) {

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

    private CellTravelStoryOneAdapter.PaymentDesc[] getCellTravelStoryItems() {

        CellTravelStoryOneAdapter.PaymentDesc []_arr1 = new CellTravelStoryOneAdapter.PaymentDesc[]{

                new CellTravelStoryOneAdapter.PaymentDesc(
                        "Ожидание",
                        "5 мин*3 \u20BD","15 \u20BD"),

                new CellTravelStoryOneAdapter.PaymentDesc(
                        "Дополнительные услуги",
                        "Детское кресло, пустой багаж","30 \u20BD")
        };
        return _arr1;
    }
}