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

import com.example.myapplication_1.Adapters.DriverTipsAdapter;
import com.example.myapplication_1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DriverTipsAlert extends DialogFragment {

    public static final String TAG = "DriverTipsFragment";

    public static DriverTipsAlert getInstance(Bundle args) {

        DriverTipsAlert f = new DriverTipsAlert();
        f.setArguments(args);

        return f;
    }

    RecyclerView rv;
    RecyclerView.Adapter adapterGridViewMenu;
    private List<DriverTipsAdapter.ItemsMenu> itemsMenuList;

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

        rv = view.findViewById(R.id.ll_driver_tips_recycler);

        final RecyclerView recyclerViewMenu = rv;

        try {

            DriverTipsAdapter.ItemsMenu[] itemsMenu = getMenuItems();
            itemsMenuList = new ArrayList<>(Arrays.asList(itemsMenu));
            adapterGridViewMenu = new DriverTipsAdapter(itemsMenuList, getActivity().getBaseContext());
            recyclerViewMenu.setAdapter(adapterGridViewMenu);
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.HORIZONTAL, false ));
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
        return view;
    }

    private DriverTipsAdapter.ItemsMenu[] getMenuItems() {

        DriverTipsAdapter.ItemsMenu[] arr = new DriverTipsAdapter.ItemsMenu[]{

                new DriverTipsAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "0%",
                        new DriverTipsAdapter.ItemsMenu.CallBack(){
                            @Override
                            public void call(DriverTipsAdapter.ItemsMenu itemsMenu){
                                try {
                                    Bundle _args = new Bundle();
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }),

                new DriverTipsAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "5%",
                        new DriverTipsAdapter.ItemsMenu.CallBack(){
                            @Override
                            public void call(DriverTipsAdapter.ItemsMenu itemsMenu){
                                try {
                                    Bundle _args = new Bundle();
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }),

                new DriverTipsAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "10%",
                        new DriverTipsAdapter.ItemsMenu.CallBack(){
                            @Override
                            public void call(DriverTipsAdapter.ItemsMenu itemsMenu){
                                try {
                                    Bundle _args = new Bundle();
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }),

                new DriverTipsAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "15%",
                        new DriverTipsAdapter.ItemsMenu.CallBack(){
                            @Override
                            public void call(DriverTipsAdapter.ItemsMenu itemsMenu){
                                try {
                                    Bundle _args = new Bundle();
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }),

                new DriverTipsAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "20%",
                        new DriverTipsAdapter.ItemsMenu.CallBack(){
                            @Override
                            public void call(DriverTipsAdapter.ItemsMenu itemsMenu){
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