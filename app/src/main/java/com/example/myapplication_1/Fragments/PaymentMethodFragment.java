package com.example.myapplication_1.Fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Alerts.DriverTipsAlert;
import com.example.myapplication_1.R;

public class PaymentMethodFragment extends Fragment {

    ImageButton androidImageButton;

    RecyclerView rv;
    public static final String TAG = "PaymentMethodFragment";

    public static PaymentMethodFragment getInstance(Bundle args) {

        PaymentMethodFragment f = new PaymentMethodFragment();
        f.setArguments(args);

        return f;
    }

    ImageButton imageButton;
    private ImageView imgChecked;
    private ImageView imgUnchecked;
    private ImageView imgUnchecked1;
    private Drawable imgToggleGrey;
    private Drawable imgToggleRed;
    private LinearLayout linearLayout;
    private RelativeLayout relativeLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.payment_method,
                container, false);

        imageButton = view.findViewById(R.id.rl_payment_method_button_strelka);

        imgToggleGrey = getResources().getDrawable(R.drawable.togle_uncheked);
        imgToggleRed = getResources().getDrawable(R.drawable.toggle_checked);

        LinearLayout toggleChecked = view.findViewById(R.id.ll_payment_method1);
        LinearLayout toggleUnchecked = view.findViewById(R.id.ll_payment_method2);
        LinearLayout toggleUnchecked1 = view.findViewById(R.id.ll_payment_method3);

        imgChecked = view.findViewById(R.id.ll_payment_method_checkBox);
        imgUnchecked = view.findViewById(R.id.ll_payment_method_checkBox1);
        imgUnchecked1 = view.findViewById(R.id.ll_payment_method_checkBox2);

        relativeLayout = view.findViewById(R.id.rl_payment_method);
        linearLayout = view.findViewById(R.id.ll_payment_method4);

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDialog(view);
            }
        });

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle _args = new Bundle();
                Fragment newCardFragment = NewCardFragment.getInstance(_args);

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_main, newCardFragment);
                fragmentTransaction.commit();

            }
        });

        toggleChecked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    imgChecked.setImageDrawable(imgToggleRed);
                    imgUnchecked.setImageDrawable(imgToggleGrey);
                    imgUnchecked1.setImageDrawable(imgToggleGrey);

            }
        });

        toggleUnchecked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    imgUnchecked.setImageDrawable(imgToggleRed);
                    imgChecked.setImageDrawable(imgToggleGrey);
                    imgUnchecked1.setImageDrawable(imgToggleGrey);
            }
        });

        toggleUnchecked1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    imgUnchecked1.setImageDrawable(imgToggleRed);
                    imgChecked.setImageDrawable(imgToggleGrey);
                    imgUnchecked.setImageDrawable(imgToggleGrey);
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle _args = new Bundle();
                Fragment menu11Fragment = Menu11Fragment.getInstance(_args);

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_main, menu11Fragment);
                fragmentTransaction.commit();
            }
        });

        androidImageButton = view.findViewById(R.id.img_cross_grey);

        return view;
    }

    public void showDialog(View view){

        DriverTipsAlert driverTipsAlert = new DriverTipsAlert();
        driverTipsAlert.setCancelable(true);
        driverTipsAlert.show(getFragmentManager(), "DriverTipsFragment");
    }
}