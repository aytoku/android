package com.example.myapplication_1.Fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.DriverTipsAdapter;
import com.example.myapplication_1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DriverTipsFragment extends DialogFragment {

    public static final String TAG = "DriverTipsFragment";

    public static DriverTipsFragment getInstance(Bundle args) {

        DriverTipsFragment f = new DriverTipsFragment();
        f.setArguments(args);

        return f;
    }

    RecyclerView rv;
    RecyclerView.Adapter adapterGridViewMenu;
    private List<DriverTipsAdapter.ItemsMenu> itemsMenuList;

    public Dialog onCreateDialog(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.drivers_tips, null);


        Dialog dialog = new Dialog(getActivity());
        WindowManager.LayoutParams p = dialog.getWindow().getAttributes();
        p.width = ViewGroup.LayoutParams.MATCH_PARENT;
        dialog.getWindow().setAttributes(p);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(view);
        dialog.getWindow().setGravity(Gravity.BOTTOM);


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
        return dialog;
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
                        })
        };
        return arr;
    }
}