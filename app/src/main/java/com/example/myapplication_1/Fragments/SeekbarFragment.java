package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.myapplication_1.R;

public class SeekbarFragment extends Fragment implements SeekBar.OnSeekBarChangeListener{

    public static final String TAG = "SeekbarFragment";
    private TextView m;
    private int b = 0;

    public static SeekbarFragment getInstance(Bundle args) {

        SeekbarFragment seekbarFragment = new SeekbarFragment();
        seekbarFragment.setArguments(args);

        return seekbarFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.cell_travels_cost_change,
                container, false);

        final SeekBar see = view.findViewById(R.id.ll_travel_cost_change_seekBar);
        see.setOnSeekBarChangeListener(this);
        m = view.findViewById(R.id.ll_travel_cost_change_txtView);
        m.setText("0");

        return view;
    }

    @Override
    public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
    }

    @Override
    public void onStartTrackingTouch(SeekBar arg0) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar see) {
        see.setMax(200);

        int[] arr = new int[]{0,50,75,100, 150};

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
            m.setText(String.valueOf(see.getProgress()));
    }
}