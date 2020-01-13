package com.example.myapplication_1.Alerts;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.PaymentChangeAdapter;
import com.example.myapplication_1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PaymentChangeAlert extends DialogFragment {

    public static final String TAG = "PaymentChangeAlert";

    public static PaymentChangeAlert getInstance(Bundle args) {

        PaymentChangeAlert f = new PaymentChangeAlert();
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

        View view = inflater.inflate(R.layout.payment_change, container, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        RecyclerView payment_change_rv = view.findViewById(R.id.rl_cell_payment_change_recycler);

        final RecyclerView recyclerView = payment_change_rv;

        try {

            PaymentChangeAdapter.PaymentChangeItems[] paymentChangeItems = getPaymentChangeItems();
            List<PaymentChangeAdapter.PaymentChangeItems> paymentChangeItemsList = new ArrayList<>(Arrays.asList(paymentChangeItems));
            RecyclerView.Adapter adapterGridViewMenu = new PaymentChangeAdapter(paymentChangeItemsList, getActivity().getBaseContext());
            recyclerView.setAdapter(adapterGridViewMenu);
            recyclerView.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ));
            recyclerView.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }

        return view;
    }

    private PaymentChangeAdapter.PaymentChangeItems[] getPaymentChangeItems() {

        PaymentChangeAdapter.PaymentChangeItems[] arr = new PaymentChangeAdapter.PaymentChangeItems[]{

                new PaymentChangeAdapter.PaymentChangeItems(
                        R.mipmap.icon_sber,"Sberbank", R.drawable.togle_uncheked,
                        new PaymentChangeAdapter.PaymentChangeItems.CallBack(){
                            @Override
                            public void call(PaymentChangeAdapter.PaymentChangeItems paymentChangeItems){
                                try {
                                    Bundle _args = new Bundle();
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }),

                new PaymentChangeAdapter.PaymentChangeItems(
                        R.mipmap.icon_sber,"Sberbank", R.drawable.togle_uncheked,
                        new PaymentChangeAdapter.PaymentChangeItems.CallBack(){
                            @Override
                            public void call(PaymentChangeAdapter.PaymentChangeItems paymentChangeItems){
                                try {
                                    Bundle _args = new Bundle();
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        })
        };
        return arr;
    }
}