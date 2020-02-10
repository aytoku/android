package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication_1.R;

public class MachinePurposeLowerPartFragment extends Fragment {

    public static final String TAG = "MachinePurposeLowerPartFragment";
    RelativeLayout relativeLayout;

    public static MachinePurposeLowerPartFragment getInstance(Bundle args) {

        MachinePurposeLowerPartFragment machinePurposeLowerPartFragment = new MachinePurposeLowerPartFragment();
        machinePurposeLowerPartFragment.setArguments(args);

        return machinePurposeLowerPartFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.cell_machine_purpose_lower_part,
                container, false);

        relativeLayout = view.findViewById(R.id.rl_cell_machine_purpose_lower_part);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                TripDetailsFragment tripDetailsFragment = TripDetailsFragment.getInstance(bundle);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, tripDetailsFragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}
