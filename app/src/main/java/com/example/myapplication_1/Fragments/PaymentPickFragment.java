package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.PaymentPickAdapter;
import com.example.myapplication_1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PaymentPickFragment extends Fragment {

    RecyclerView rv;
    RecyclerView.Adapter paymentMethodAdapter;
    private List<PaymentPickAdapter.PaymentPickItems> itemsMenuList;

    public static final String TAG = "PaymentPickFragment";

    public static PaymentPickFragment getInstance(Bundle args) {

        PaymentPickFragment f = new PaymentPickFragment();
        f.setArguments(args);

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.payment_pick,
                container, false);

        TextView textView = view.findViewById(R.id.rl_payment_pick_ready);

        rv = view.findViewById(R.id.rl_payment_pick_recycler);
        final RecyclerView recyclerViewMenu = rv;

        try {
            PaymentPickAdapter.PaymentPickItems[] paymentPickItems = getMenuItems();
            itemsMenuList = new ArrayList<>(Arrays.asList(paymentPickItems));
            paymentMethodAdapter = new PaymentPickAdapter(itemsMenuList, getActivity().getBaseContext());
            recyclerViewMenu.setAdapter(paymentMethodAdapter);
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ));
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle _args = new Bundle();
                Fragment paymentMethodFragment = PaymentMethodFragment.getInstance(_args);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_main, paymentMethodFragment);
                fragmentTransaction.commit();
            }
        });


        return view;
    }

    private PaymentPickAdapter.PaymentPickItems[] getMenuItems() {

        PaymentPickAdapter.PaymentPickItems[] arr = new PaymentPickAdapter.PaymentPickItems[]{

                new PaymentPickAdapter.PaymentPickItems(
                        R.mipmap.icon_sber,"Sberbank", R.drawable.togle_uncheked,
                        new PaymentPickAdapter.PaymentPickItems.CallBack(){
                            @Override
                            public void call(PaymentPickAdapter.PaymentPickItems paymentPickItems){
                                try {
                                    Bundle _args = new Bundle();
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }),

                new PaymentPickAdapter.PaymentPickItems(
                        R.mipmap.icon_sber,"Sberbank", R.drawable.togle_uncheked,
                        new PaymentPickAdapter.PaymentPickItems.CallBack(){
                            @Override
                            public void call(PaymentPickAdapter.PaymentPickItems paymentPickItems){
                                try {
                                    Bundle _args = new Bundle();
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }),

                new PaymentPickAdapter.PaymentPickItems(
                        R.mipmap.icon_sber,"Sberbank", R.drawable.togle_uncheked,
                        new PaymentPickAdapter.PaymentPickItems.CallBack(){
                            @Override
                            public void call(PaymentPickAdapter.PaymentPickItems paymentPickItems){
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