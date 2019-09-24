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

public class MainActivityWish extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    TextView textView;
    RecyclerView rv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.wishes);

        rv = findViewById(R.id.recycler_wishes);
        textView = (TextView) findViewById(R.id.ll_travel_cost_change_txtView);
        final SeekBar see = (SeekBar) findViewById(R.id.ll_travel_cost_change_seekBar);
        int b = 0;
        see.setOnSeekBarChangeListener(this);
        textView.setText("0");
    }
            @Override
            public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {}

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {}

            @Override
            public void onStopTrackingTouch(SeekBar see) {

                see.setMax(200);
                int[] arr = new int[]{0, 50, 75, 100, 150};
                int b = 0;
                int a = see.getProgress();
                if (a == arr[0]) {
                    b = 0;
                }
                {
                    if (a > arr[0] & a < arr[1]) {
                        b = 50;
                    }
                    {
                        if (a > arr[1] & a < arr[2]) {
                            b = 75;
                        }
                        {
                            if (a > arr[2] & a < arr[3]) {
                                b = 100;
                            }
                            {
                                if (a > arr[3] & a < arr[4]) {
                                    b = 150;
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
            AdapterWish.AdapterGridViewMenu.ItemsMenu[] itemsMenu = getMenuItems();//model_data

            AdapterWish.AdapterGridViewMenu adapterGridViewMenu = new AdapterWish.AdapterGridViewMenu(itemsMenu, getBaseContext());//this;
            recyclerViewMenu.setAdapter(adapterGridViewMenu);
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager(getBaseContext(), RecyclerView.VERTICAL, false));
            recyclerViewMenu.setItemAnimator(new DefaultItemAnimator());

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }


    private AdapterWish.AdapterGridViewMenu.ItemsMenu[] getMenuItems() {

        AdapterWish.AdapterGridViewMenu.ItemsMenu[] _arr = new AdapterWish.AdapterGridViewMenu.ItemsMenu[]{

                new AdapterWish.AdapterGridViewMenu.ItemsMenu(getResources().getColor(R.color.my_gray),
                        R.mipmap.ic_launcher_round,
                        "30 \u20BD",
                        "Детское кресло"),
                new AdapterWish.AdapterGridViewMenu.ItemsMenu(getResources().getColor(R.color.my_gray),
                        R.mipmap.ic_launcher_round,
                        "0 \u20BD",
                        "Курящий салон"),
                new AdapterWish.AdapterGridViewMenu.ItemsMenu(getResources().getColor(R.color.my_gray),
                        R.mipmap.ic_launcher_round,
                        "10 \u20BD",
                        "Некурящий салон")
        };
        return _arr;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {}
}
