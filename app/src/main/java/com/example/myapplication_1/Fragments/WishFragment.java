package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.AdapterWish;
import com.example.myapplication_1.R;

public class WishFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {

    public static final String TAG = "WishFragment";

    public static WishFragment getInstance(Bundle args) {

        WishFragment f = new WishFragment();
        f.setArguments(args);

        return f;
    }

    TextView textView;
    TextView cost_desc;
    TextView desc;
    RecyclerView rv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.wishes,
                container, false);

        rv = view.findViewById(R.id.ll_recycler_wishes);
        textView = view.findViewById(R.id.ll_travel_cost_change_txtView);
        cost_desc = view.findViewById(R.id.ll_cell_travel_cost_description);
        desc = view.findViewById(R.id.desc);
        final SeekBar see = view.findViewById(R.id.ll_travel_cost_change_seekBar);
        see.setOnSeekBarChangeListener(this);
        textView.setText("0 \u20BD");
        cost_desc.setText("0 \u20BD");

        return view;
    }
            @Override
            public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {}

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {}

            @Override
            public void onStopTrackingTouch(SeekBar see) {

                see.setMax(150);
                int[] arr = new int[]{0, 50, 75, 100, 150};
                int b = 0;
                int a = see.getProgress();
                if (a == arr[0]) {
                    b = 0;
                    cost_desc.setText("0 \u20BD");
                }
                {
                    if (a > arr[0] & a < arr[1]) {
                        b = 50;
                        cost_desc.setText(arr[1] + "\u20BD");
                    }
                    {
                        if (a > arr[1] & a < arr[2]) {
                            b = 75;
                            cost_desc.setText(arr[2] + "\u20BD");
                        }
                        {
                            if (a > arr[2] & a < arr[3]) {
                                b = 100;
                                cost_desc.setText(arr[3] + "\u20BD");
                            }
                            {
                                if (a > arr[3] & a < arr[4]) {
                                    b = 150;
                                    cost_desc.setText(arr[4] + "\u20BD");
                                }
                            }
                        }
                    }
                }
                see.setProgress(b);
                textView.setText(String.valueOf(see.getProgress()));
            }


    @Override
    public void onStart() {
        super.onStart();

        RecyclerView recyclerViewMenu = rv;

        try {
            AdapterWish.ItemsMenu[] itemsMenu = getMenuItems();

            AdapterWish adapterWish = new AdapterWish(itemsMenu, getActivity().getBaseContext());
            recyclerViewMenu.setAdapter(adapterWish);
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager(getActivity().getBaseContext(), RecyclerView.VERTICAL, false));
            recyclerViewMenu.setItemAnimator(new DefaultItemAnimator());

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }


    private AdapterWish.ItemsMenu[] getMenuItems() {

        String[] cost_arr = new String[]{"30 \u20BD","0 \u20BD","10 \u20BD"};
        String[] desc_arr = new String[]{"Детское кресло", "Курящий салон", "Некурящий салон"};

        AdapterWish.ItemsMenu[] _arr = new AdapterWish.ItemsMenu[]{

                new AdapterWish.ItemsMenu(getResources().getColor(R.color.my_gray),
                        cost_arr[0],
                        desc_arr[0]),
                new AdapterWish.ItemsMenu(getResources().getColor(R.color.my_gray),
                        cost_arr[1],
                        desc_arr[1]),
                new AdapterWish.ItemsMenu(getResources().getColor(R.color.my_gray),
                        cost_arr[2],
                        desc_arr[2])
        };
        return _arr;
    }

    public void onPointerCaptureChanged(boolean hasCapture) {}
}