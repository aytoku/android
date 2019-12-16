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
    RecyclerView rv;
    RecyclerView.Adapter paymentMethodAdapter;
    private List<PaymentMethodAdapter.ItemsMenu> itemsMenuList;

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
            PaymentMethodAdapter.ItemsMenu[] itemsMenu = getMenuItems();
            itemsMenuList = new ArrayList<>(Arrays.asList(itemsMenu));
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
            String messageCard = data.getStringExtra("message");
//            try {
//                itemsMenuList.add(itemsMenuList.size(), new PaymentMethodAdapter.ItemsMenu( getResources().getColor(R.color.my_gray),
//                        R.mipmap.icon_sber,messageCard, R.drawable.togle_uncheked,
//                        new PaymentMethodAdapter.ItemsMenu.CallBack(){
//                            @Override
//                            public void call(PaymentMethodAdapter.ItemsMenu itemsMenu){
//                                try {
//                                    Bundle _args = new Bundle();
//                                }catch (NullPointerException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                        })
//                );
//                paymentMethodAdapter.notifyItemInserted(itemsMenuList.size() - 1);
//                paymentMethodAdapter.notifyDataSetChanged();
//            } catch (NumberFormatException e) {
//                Toast.makeText(getActivity().getApplicationContext(), "The field is empty",
//                        Toast.LENGTH_SHORT).show();
//            }
        }
    }

    public static Intent newIntent(String message) {
        Intent intent = new Intent();
        intent.putExtra("message", message);
        return intent;
    }

//    public static Intent newIntent1(int img, String message, int img1) {
//        Intent intent = new Intent();
//        intent.putExtra("message", message);
//        return intent;
//    }

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

    private PaymentMethodAdapter.ItemsMenu[] getMenuItems() {

        PaymentMethodAdapter.ItemsMenu[] arr = new PaymentMethodAdapter.ItemsMenu[]{

                new PaymentMethodAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        R.mipmap.icon_sber,"Sberbank", R.drawable.togle_uncheked,
                        new PaymentMethodAdapter.ItemsMenu.CallBack(){
                            @Override
                            public void call(PaymentMethodAdapter.ItemsMenu itemsMenu){
                                try {
                                    Bundle _args = new Bundle();
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }),

                new PaymentMethodAdapter.ItemsMenu(
                getResources().getColor(R.color.my_gray),
                R.mipmap.icon_sber,"Sberbank", R.drawable.togle_uncheked,
                new PaymentMethodAdapter.ItemsMenu.CallBack(){
                    @Override
                    public void call(PaymentMethodAdapter.ItemsMenu itemsMenu){
                        try {
                            Bundle _args = new Bundle();
                        }catch (NullPointerException e) {
                            e.printStackTrace();
                        }
                    }
                }),

                new PaymentMethodAdapter.ItemsMenu(
                getResources().getColor(R.color.my_gray),
                R.mipmap.icon_sber,"Sberbank", R.drawable.togle_uncheked,
                new PaymentMethodAdapter.ItemsMenu.CallBack(){
                    @Override
                    public void call(PaymentMethodAdapter.ItemsMenu itemsMenu){
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