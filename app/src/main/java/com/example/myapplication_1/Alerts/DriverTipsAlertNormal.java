package com.example.myapplication_1.Alerts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.myapplication_1.Fragments.PaymentMethodFragment;
import com.example.myapplication_1.R;

public class DriverTipsAlertNormal extends DialogFragment {

    public static final String TAG = "DriverTipsAlertNormal";

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;

    public static DriverTipsAlertNormal getInstance(Bundle args) {

        DriverTipsAlertNormal f = new DriverTipsAlertNormal();
        f.setArguments(args);

        return f;
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

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = textView1.getText().toString();
                sendResult(message);
            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = textView2.getText().toString();
                sendResult(message);
            }
        });

        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = textView3.getText().toString();
                sendResult(message);
            }
        });

        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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