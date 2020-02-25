package com.example.myapplication_1.Alerts;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;

import com.example.myapplication_1.Fragments.PaymentMethodFragment;
import com.example.myapplication_1.R;

public class DriverTipsAlertNormal extends DialogFragment {

    public static final String TAG = "DriverTipsAlertNormal";

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private CardView cardView;
    private CardView cardView1;
    private CardView cardView2;
    private CardView cardView3;


    public static DriverTipsAlertNormal getInstance(Bundle args) {

        DriverTipsAlertNormal driverTipsAlertNormal = new DriverTipsAlertNormal();
        driverTipsAlertNormal.setArguments(args);

        return driverTipsAlertNormal;
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

        View view = inflater.inflate(R.layout.driver_tips_normal, container, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        textView1 = view.findViewById(R.id.ll_driver_tips_normal_txt1);
        textView2 = view.findViewById(R.id.ll_driver_tips_normal_txt2);
        textView3 = view.findViewById(R.id.ll_driver_tips_normal_txt3);
        textView4 = view.findViewById(R.id.ll_driver_tips_normal_txt4);

        cardView = view.findViewById(R.id.ll_driver_tips_normal_cv1);
        cardView1 = view.findViewById(R.id.ll_driver_tips_normal_cv2);
        cardView2 = view.findViewById(R.id.ll_driver_tips_normal_cv3);
        cardView3 = view.findViewById(R.id.ll_driver_tips_normal_cv4);

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardView.setCardBackgroundColor(Color.parseColor("#FD6F6D"));
                textView1.setBackgroundColor(Color.WHITE);
                String message = textView1.getText().toString();
                sendResult(message);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardView1.setCardBackgroundColor(Color.parseColor("#FD6F6D"));
                textView2.setBackgroundColor(Color.WHITE);
                String message = textView2.getText().toString();
                sendResult(message);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardView2.setCardBackgroundColor(Color.parseColor("#FD6F6D"));
                textView3.setBackgroundColor(Color.WHITE);
                String message = textView3.getText().toString();
                sendResult(message);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardView3.setCardBackgroundColor(Color.parseColor("#FD6F6D"));
                textView4.setBackgroundColor(Color.WHITE);
                String message = textView4.getText().toString();
                sendResult(message);
            }
        });
        return view;
    }

    private void sendResult(String message) {
        if( getTargetFragment() == null ) {
            return;
        }
        Intent intent = PaymentMethodFragment.newIntent(message);
        getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, intent);
        dismiss();
    }
}