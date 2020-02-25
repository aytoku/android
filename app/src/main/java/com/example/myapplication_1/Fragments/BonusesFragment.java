package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication_1.R;

public class BonusesFragment extends Fragment {

    public static final String TAG = "BonusesFragment";
    private ImageView imageView;
    private RelativeLayout relativeLayout;

    public static BonusesFragment getInstance(Bundle args) {

        BonusesFragment bonusesFragment = new BonusesFragment();
        bonusesFragment.setArguments(args);

        return bonusesFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.bonuses,
                container, false);

        imageView = view.findViewById(R.id.rl_bonuses_img);
        relativeLayout = view.findViewById(R.id.rl_enter_code);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                Menu11Fragment menu11Fragment = Menu11Fragment.getInstance(bundle);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, menu11Fragment);
                fragmentTransaction.commit();
            }
        });

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return view;
    }
}
