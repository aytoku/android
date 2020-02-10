package com.example.myapplication_1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import java.util.Date;

public class IsMoonTime extends Fragment {

    public static final String TAG = "IsMoonTime";

    public static IsMoonTime getInstance(Bundle args) {

        IsMoonTime isMoonTime = new IsMoonTime();
        isMoonTime.setArguments(args);

        return isMoonTime;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.is_moon_time,
                container, false);

        isMoonTime();

        return view;
    }

    private boolean isMoonTime() {
        Date date = new Date();
        int current_date = date.getHours();
        if(current_date > 19 || current_date < 6){
            return true;
        }
        return  false;
    }
}
