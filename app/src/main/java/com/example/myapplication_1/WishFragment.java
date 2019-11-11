package com.example.myapplication_1;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.AdapterWish;

public class WishFragment extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    TextView textView;
    TextView cost_desc;
    TextView desc;
    RecyclerView rv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.wishes);

        rv = findViewById(R.id.ll_recycler_wishes);
        textView = findViewById(R.id.ll_travel_cost_change_txtView);
        cost_desc = findViewById(R.id.ll_cell_travel_cost_description);
        desc = findViewById(R.id.desc);
        final SeekBar see = findViewById(R.id.ll_travel_cost_change_seekBar);
        see.setOnSeekBarChangeListener(this);
        textView.setText("0 \u20BD");
        cost_desc.setText("0 \u20BD");
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
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {

        return super.onCreateView(parent, name, context, attrs);
    }

    @Override
    protected void onStart() {
        super.onStart();

        RecyclerView recyclerViewMenu = rv;

        try {
            AdapterWish.AdapterGridViewMenu.ItemsMenu[] itemsMenu = getMenuItems();

            AdapterWish.AdapterGridViewMenu adapterGridViewMenu = new AdapterWish.AdapterGridViewMenu(itemsMenu, getBaseContext());
            recyclerViewMenu.setAdapter(adapterGridViewMenu);
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager(getBaseContext(), RecyclerView.VERTICAL, false));
            recyclerViewMenu.setItemAnimator(new DefaultItemAnimator());

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }


    private AdapterWish.AdapterGridViewMenu.ItemsMenu[] getMenuItems() {

        String[] cost_arr = new String[]{"30 \u20BD","0 \u20BD","10 \u20BD"};
        String[] desc_arr = new String[]{"Детское кресло", "Курящий салон", "Некурящий салон"};

        AdapterWish.AdapterGridViewMenu.ItemsMenu[] _arr = new AdapterWish.AdapterGridViewMenu.ItemsMenu[]{

                new AdapterWish.AdapterGridViewMenu.ItemsMenu(getResources().getColor(R.color.my_gray),
                        cost_arr[0],
                        desc_arr[0]),
                new AdapterWish.AdapterGridViewMenu.ItemsMenu(getResources().getColor(R.color.my_gray),
                        cost_arr[1],
                        desc_arr[1]),
                new AdapterWish.AdapterGridViewMenu.ItemsMenu(getResources().getColor(R.color.my_gray),
                        cost_arr[2],
                        desc_arr[2])
        };
        return _arr;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {}
}
