package com.example.myapplication_1.Alerts;

import android.app.Activity;
import android.content.Intent;
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

import com.example.myapplication_1.Adapters.DriverTipsAdapter;
import com.example.myapplication_1.Fragments.FreeOrders13ExpListFragment;
import com.example.myapplication_1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DriverTipsAlert extends DialogFragment {

    public static final String TAG = "DriverTipsFragment";

    public static DriverTipsAlert getInstance(Bundle args) {

        DriverTipsAlert driverTipsAlert = new DriverTipsAlert();
        driverTipsAlert.setArguments(args);

        return driverTipsAlert;
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
            getDialog().getWindow().setBackgroundDrawableResource( android.R.drawable.screen_background_dark_transparent );
        } catch ( NullPointerException npe) {
            Log.e(TAG, "onCreateView: " + npe.getMessage() );
        }
        View view = inflater.inflate(R.layout.drivers_tips, container,false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        RecyclerView driverTips_rv = view.findViewById(R.id.ll_driver_tips_recycler);

        final RecyclerView recyclerView = driverTips_rv;
        try {
            DriverTipsAdapter.DriverTipsItems[] driverTipsItems = getDriverTipsItems();
            List<DriverTipsAdapter.DriverTipsItems> driverTipsItemsList = new ArrayList<>(Arrays.asList(driverTipsItems));
            RecyclerView.Adapter driverTipsAdapter = new DriverTipsAdapter(driverTipsItemsList, getActivity().getBaseContext());
            recyclerView.setAdapter(driverTipsAdapter);
            recyclerView.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.HORIZONTAL, false ));
            recyclerView.setItemAnimator( new DefaultItemAnimator() );
        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
        return view;
    }

    private void sendResult(String message){
        if (getTargetFragment() == null){ return; }
        Intent intent = FreeOrders13ExpListFragment.newIntent(message);
        getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, intent);
        dismiss();
    }

    private DriverTipsAdapter.DriverTipsItems[] getDriverTipsItems() {
        DriverTipsAdapter.DriverTipsItems[] arr = new DriverTipsAdapter.DriverTipsItems[]{
                new DriverTipsAdapter.DriverTipsItems(
                        "0%",
                        new DriverTipsAdapter.DriverTipsItems.CallBack(){
                            @Override
                            public void call(DriverTipsAdapter.DriverTipsItems driverTipsItems){
                                try {
                                    Bundle bundle = new Bundle();
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }),

                new DriverTipsAdapter.DriverTipsItems(
                        "5%",
                        new DriverTipsAdapter.DriverTipsItems.CallBack(){
                            @Override
                            public void call(DriverTipsAdapter.DriverTipsItems driverTipsItems){
                                try {
                                    Bundle bundle = new Bundle();
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }),

                new DriverTipsAdapter.DriverTipsItems(
                        "10%",
                        new DriverTipsAdapter.DriverTipsItems.CallBack(){
                            @Override
                            public void call(DriverTipsAdapter.DriverTipsItems driverTipsItems){
                                try {
                                    Bundle bundle = new Bundle();
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }),

                new DriverTipsAdapter.DriverTipsItems(
                        "15%",
                        new DriverTipsAdapter.DriverTipsItems.CallBack(){
                            @Override
                            public void call(DriverTipsAdapter.DriverTipsItems driverTipsItems){
                                try {
                                    Bundle bundle = new Bundle();
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }),

                new DriverTipsAdapter.DriverTipsItems(
                        "20%",
                        new DriverTipsAdapter.DriverTipsItems.CallBack(){
                            @Override
                            public void call(DriverTipsAdapter.DriverTipsItems driverTipsItems){
                                try {
                                    Bundle bundle = new Bundle();
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        })
        };
        return arr;
    }
}