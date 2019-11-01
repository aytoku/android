package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication_1.R;

public class TravelStoryOneFragment extends Fragment {

    public static final String TAG = "TravelStoryOneFragment";

    public static TravelStoryOneFragment getInstance(Bundle args) {

        TravelStoryOneFragment f = new TravelStoryOneFragment();
        f.setArguments(args);

        return f;
    }

    ImageView button;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.travel_story_1,
                container, false);

        Bundle _args = new Bundle();
        final Fragment travelStoryOneFragment = TravelStoryFragment.getInstance(_args);


        button = view.findViewById(R.id.ll_travel_story_1_imageView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_travel_story_1_imageView, travelStoryOneFragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}