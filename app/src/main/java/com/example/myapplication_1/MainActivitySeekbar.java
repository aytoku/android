package com.example.myapplication_1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class MainActivitySeekbar extends Activity implements SeekBar.OnSeekBarChangeListener{
    TextView m;
    int b = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seek);

        final SeekBar see = (SeekBar)findViewById(R.id.seekBar);
        see.setOnSeekBarChangeListener(this);
        m = (TextView)findViewById(R.id.txtView);
        m.setText("0");

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