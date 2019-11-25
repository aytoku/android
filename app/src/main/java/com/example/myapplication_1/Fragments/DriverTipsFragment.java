package com.example.myapplication_1.Fragments;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;

import com.example.myapplication_1.R;

public class DriverTipsFragment extends DialogFragment {

    public static final String TAG = "DriverTipsFragment";

    public static DriverTipsFragment getInstance(Bundle args) {

        DriverTipsFragment f = new DriverTipsFragment();
        f.setArguments(args);

        return f;
    }

    CardView cardView;
    CardView cardView1;
    CardView cardView2;
    CardView cardView3;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.drivers_tips, null);


        Dialog dialog = new Dialog(getActivity());
        WindowManager.LayoutParams p = dialog.getWindow().getAttributes();
        p.width = ViewGroup.LayoutParams.MATCH_PARENT;
        dialog.getWindow().setAttributes(p);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(view);
        dialog.getWindow().setGravity(  Gravity.BOTTOM);


        cardView = view.findViewById(R.id.ll_cv);
        cardView1 = view.findViewById(R.id.ll_cv1);
        cardView2 = view.findViewById(R.id.ll_cv2);
        cardView3 = view.findViewById(R.id.ll_cv3);

        textView1 = view.findViewById(R.id.cv_rating_price);
        textView2 = view.findViewById(R.id.cv_rating_price1);
        textView3 = view.findViewById(R.id.cv_rating_price2);
        textView4 = view.findViewById(R.id.cv_rating_price3);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardView.setCardBackgroundColor(Color.parseColor("#FD6F6D"));
                textView1.setTextColor(Color.parseColor("#FFFFFF"));
                cardView1.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                cardView2.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                cardView3.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                textView2.setTextColor(Color.parseColor("#424242"));
                textView3.setTextColor(Color.parseColor("#424242"));
                textView4.setTextColor(Color.parseColor("#424242"));
            }
        });

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                textView1.setTextColor(Color.parseColor("#424242"));
                cardView1.setCardBackgroundColor(Color.parseColor("#FD6F6D"));
                cardView2.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                cardView3.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                textView2.setTextColor(Color.parseColor("#FFFFFF"));
                textView3.setTextColor(Color.parseColor("#424242"));
                textView4.setTextColor(Color.parseColor("#424242"));
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                textView1.setTextColor(Color.parseColor("#424242"));
                cardView1.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                cardView2.setCardBackgroundColor(Color.parseColor("#FD6F6D"));
                cardView3.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                textView2.setTextColor(Color.parseColor("#424242"));
                textView3.setTextColor(Color.parseColor("#FFFFFF"));
                textView4.setTextColor(Color.parseColor("#424242"));
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                textView1.setTextColor(Color.parseColor("#424242"));
                cardView1.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                cardView2.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                cardView3.setCardBackgroundColor(Color.parseColor("#FD6F6D"));
                textView2.setTextColor(Color.parseColor("#424242"));
                textView3.setTextColor(Color.parseColor("#424242"));
                textView4.setTextColor(Color.parseColor("#FFFFFF"));
            }
        });

        return dialog;
    }
}