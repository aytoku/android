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
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.TariffsPickAdapter;
import com.example.myapplication_1.Fragments.ExpFragment;
import com.example.myapplication_1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TariffsPickAlert extends DialogFragment {

    public static final String TAG = "TariffsPickAlert";

    public static TariffsPickAlert getInstance(Bundle args) {

        TariffsPickAlert f = new TariffsPickAlert();
        f.setArguments(args);

        return f;
    }

    TextView button;
    boolean check = false;
    //ExpListAdapter expListAdapter;

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

        View view = inflater.inflate(R.layout.tarrifs_pick, container,false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        RecyclerView rv = view.findViewById(R.id.ll_tariffs_pick_recycler);
        button = view.findViewById(R.id.ll_tariffs_pick_button_accept);

        final RecyclerView recyclerViewMenu = rv;

        try{
            TariffsPickAdapter.ItemsMenu[] itemsMenu = getMenuItems();
            List<TariffsPickAdapter.ItemsMenu> itemsMenuList = new ArrayList<>(Arrays.asList(itemsMenu));
            RecyclerView.Adapter adapterGridViewMenu = new TariffsPickAdapter(itemsMenuList, getActivity().getBaseContext());
            recyclerViewMenu.setAdapter(adapterGridViewMenu);
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager(getActivity().getBaseContext(), RecyclerView.VERTICAL, false));
            recyclerViewMenu.setItemAnimator(new DefaultItemAnimator());

        }catch (NullPointerException e){
            e.printStackTrace();
        }

        return view;
    }

    private void sendResult(String message){
//        ExpFragment expFragment = ExpFragment.getInstance(null);
//        if(getTargetFragment()!=null){
//            expFragment.onActivityResult(getTargetRequestCode(),message,null);
//        }
        if (getTargetFragment() == null){ return; }

        Intent intent = ExpFragment.newIntent(message);
        getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, intent);
        dismiss();
    }

    private TariffsPickAdapter.ItemsMenu[] getMenuItems() {

        TariffsPickAdapter.ItemsMenu[] arr = new TariffsPickAdapter.ItemsMenu[]{

                new TariffsPickAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Эконом",
                        new TariffsPickAdapter.ItemsMenu.CallBack() {
                            @Override
                            public void call(TariffsPickAdapter.ItemsMenu itemsMenu) {
                                try {
                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        },R.drawable.ic_empty_switch, check),

                new TariffsPickAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Стандарт",
                        new TariffsPickAdapter.ItemsMenu.CallBack() {
                            @Override
                            public void call(TariffsPickAdapter.ItemsMenu itemsMenu) {
                                try {
                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        },R.drawable.ic_empty_switch, check),

                new TariffsPickAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Комфорт",
                        new TariffsPickAdapter.ItemsMenu.CallBack() {
                            @Override
                            public void call(TariffsPickAdapter.ItemsMenu itemsMenu) {
                                try {
                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        },R.drawable.ic_empty_switch, check),

                new TariffsPickAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Доставка",
                        new TariffsPickAdapter.ItemsMenu.CallBack() {
                            @Override
                            public void call(TariffsPickAdapter.ItemsMenu itemsMenu) {
                                try {
                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        },R.drawable.ic_empty_switch, check),

                new TariffsPickAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Грузовое",
                        new TariffsPickAdapter.ItemsMenu.CallBack() {
                            @Override
                            public void call(TariffsPickAdapter.ItemsMenu itemsMenu) {
                                try {
                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        },R.drawable.ic_empty_switch, check)
        };
        return arr;
    }
}