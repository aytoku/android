package com.example.myapplication_1.Fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;

import com.example.myapplication_1.R;

public class PaymentPickFragment extends Fragment {

    public static final String TAG = "PaymentPickFragment";

    public static PaymentPickFragment getInstance(Bundle args) {

        PaymentPickFragment f = new PaymentPickFragment();
        f.setArguments(args);

        return f;
    }

    private ImageView imgChecked;
    private ImageView imgUnchecked;
    private Drawable imgToggleGrey;
    private Drawable imgToggleRed;
    boolean f = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.payment_pick,
                container, false);

        imgToggleGrey = getResources().getDrawable(R.drawable.togle_uncheked);
        imgToggleRed = getResources().getDrawable(R.drawable.toggle_checked);

        RelativeLayout toggleChecked = view.findViewById(R.id.rl_payment_pick_rl_visa);
        RelativeLayout toggleUnchecked = view.findViewById(R.id.rl_payment_pick_rl_ruble);

        imgChecked = view.findViewById(R.id.rl_payment_ready_toggleChecked);
        imgUnchecked = view.findViewById(R.id.rl_payment_ready_toggleUnchecked);

        toggleChecked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(f =!f){
                    imgChecked.setImageDrawable(imgToggleRed);
                    imgUnchecked.setImageDrawable(imgToggleGrey);
                }
            }
        });

        toggleUnchecked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(f =!f){
                    imgUnchecked.setImageDrawable(imgToggleRed);
                    imgChecked.setImageDrawable(imgToggleGrey);
                }
            }
        });

        return view;
    }
}