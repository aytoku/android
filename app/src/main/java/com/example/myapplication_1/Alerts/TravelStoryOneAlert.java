package com.example.myapplication_1.Alerts;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.myapplication_1.R;

public class TravelStoryOneAlert extends DialogFragment {

    public static final String TAG = "TravelStoryOneAlert";

    public static TravelStoryOneAlert getInstance(Bundle args) {

        TravelStoryOneAlert travelStoryOneAlert = new TravelStoryOneAlert();
        travelStoryOneAlert.setArguments(args);

        return travelStoryOneAlert;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setStyle(DialogFragment.STYLE_NORMAL, R.style.AppTheme_NoActionBar);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        Log.i(TAG, "onCreateView: start");
        try {
            getDialog().getWindow().setBackgroundDrawableResource(android.R.drawable.screen_background_dark_transparent);
        } catch (NullPointerException npe) {
            Log.e(TAG, "onCreateView: " + npe.getMessage());
        }

        View view = inflater.inflate(R.layout.travel_story_1_alert, container,false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        TextView close = view.findViewById(R.id.rl_travel_story_1_alert_close_title);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });
        TextView delete = view.findViewById(R.id.rl_travel_story_1_alert_delete_title);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });
        return view;
    }
}