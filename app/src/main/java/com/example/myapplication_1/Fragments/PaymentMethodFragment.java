package com.example.myapplication_1.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.PaymentMethodAdapter;
import com.example.myapplication_1.Alerts.DriverTipsAlertNormal;
import com.example.myapplication_1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PaymentMethodFragment extends Fragment {

    private static final int REQUEST_CODE_DRIVER_TIPS = 101;
    private static final int REQUEST_CODE_NEW_CARD = 102;
    TextView textView;
    TextView edit;
    RecyclerView rv;
    RecyclerView.Adapter paymentMethodAdapter;
    private List<PaymentMethodAdapter.PaymentMethodItems> itemsMenuList;

    public static final String TAG = "PaymentMethodFragment";

    public static PaymentMethodFragment getInstance(Bundle args) {

        PaymentMethodFragment f = new PaymentMethodFragment();
        f.setArguments(args);

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.payment_method,
                container, false);

        ImageButton imageButton = view.findViewById(R.id.rl_payment_method_button_strelka);

        rv = view.findViewById(R.id.ll_payment_method_recycler);
        final RecyclerView recyclerViewMenu = rv;

        try {
            PaymentMethodAdapter.PaymentMethodItems[] paymentMethodItems = getPaymentMethodItems();
            itemsMenuList = new ArrayList<>(Arrays.asList(paymentMethodItems));
            paymentMethodAdapter = new PaymentMethodAdapter(itemsMenuList, getActivity().getBaseContext());
            recyclerViewMenu.setAdapter(paymentMethodAdapter);
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ));
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }

        RelativeLayout relativeLayout = view.findViewById(R.id.rl_payment_method);
        LinearLayout linearLayout = view.findViewById(R.id.ll_payment_method4);

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(view);
            }
        });

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNewCardFragment(view);
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

        textView = view.findViewById(R.id.ll_payment_method_percents);
        edit = view.findViewById(R.id.rl_payment_method_edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle _args = new Bundle();
                PaymentPickFragment paymentPickFragment = PaymentPickFragment.getInstance(_args);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_main, paymentPickFragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        if (requestCode == REQUEST_CODE_DRIVER_TIPS) {
            String messageDriver = data.getStringExtra("message");
            textView.setText(messageDriver);
        }

        if(requestCode == REQUEST_CODE_NEW_CARD){

            Bundle bundle = data.getExtras();
            String card_number = bundle.getString(NewCardFragment.KEY_CARD_NUMBER,"card_number");
            String date = bundle.getString(NewCardFragment.KEY_DATE,"date");
            String cvv = bundle.getString(NewCardFragment.KEY_CVV,"cvv");

            try{
                itemsMenuList.add(itemsMenuList.size(), new PaymentMethodAdapter.PaymentMethodItems(
                        R.mipmap.icon_sber, card_number, date, cvv, R.drawable.togle_uncheked,
                        new PaymentMethodAdapter.PaymentMethodItems.CallBack(){
                            @Override
                            public void call(PaymentMethodAdapter.PaymentMethodItems itemsMenu){
                                try {
                                    Bundle _args = new Bundle();
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        })
                );
                paymentMethodAdapter.notifyItemInserted(itemsMenuList.size() - 1);
                paymentMethodAdapter.notifyDataSetChanged();
            }catch (NumberFormatException e) {
                Toast.makeText(getActivity().getApplicationContext(), "The field is empty",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static Intent newIntent(String message) {
        Intent intent = new Intent();
        intent.putExtra("message", message);
        return intent;
    }

    public static Intent newIntent1(Bundle bundle){
        Intent intent = new Intent();
        intent.putExtras(bundle);
        return intent;
    }

    public void showDialog(View view){
        DriverTipsAlertNormal driverTipsAlertNormal = DriverTipsAlertNormal.getInstance(null);
        driverTipsAlertNormal.setTargetFragment(PaymentMethodFragment.this, REQUEST_CODE_DRIVER_TIPS);
        driverTipsAlertNormal.show(getFragmentManager(), DriverTipsAlertNormal.TAG);
    }

    public void showNewCardFragment(View view){
        NewCardFragment newCardFragment = NewCardFragment.getInstance(null);
        newCardFragment.setTargetFragment(PaymentMethodFragment.this, REQUEST_CODE_NEW_CARD);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.ll_main, newCardFragment);
        fragmentTransaction.commit();
    }

    private PaymentMethodAdapter.PaymentMethodItems[] getPaymentMethodItems() {

        PaymentMethodAdapter.PaymentMethodItems[] arr = new PaymentMethodAdapter.PaymentMethodItems[]{

                new PaymentMethodAdapter.PaymentMethodItems(
                            R.mipmap.icon_sber,"Sberbank","","", R.drawable.togle_uncheked,
                                new PaymentMethodAdapter.PaymentMethodItems.CallBack(){
                                    @Override
                                    public void call(PaymentMethodAdapter.PaymentMethodItems paymentMethodItems){
                                        try {
                                            Bundle _args = new Bundle();
                                        }catch (NullPointerException e) {
                                            e.printStackTrace();
                                        }
                                    }
                        }),

                new PaymentMethodAdapter.PaymentMethodItems(
                         R.mipmap.icon_sber,"Sberbank","","", R.drawable.togle_uncheked,
                             new PaymentMethodAdapter.PaymentMethodItems.CallBack(){
                                @Override
                                public void call(PaymentMethodAdapter.PaymentMethodItems paymentMethodItems){
                                    try {
                                        Bundle _args = new Bundle();
                                    }catch (NullPointerException e) {
                                        e.printStackTrace();
                                    }
                            }
                }),

                new PaymentMethodAdapter.PaymentMethodItems(
                      R.mipmap.icon_sber,"Sberbank","","", R.drawable.togle_uncheked,
                         new PaymentMethodAdapter.PaymentMethodItems.CallBack(){
                            @Override
                            public void call(PaymentMethodAdapter.PaymentMethodItems paymentMethodItems){
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