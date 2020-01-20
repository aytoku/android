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

import com.example.myapplication_1.Adapters.TariffsPickAdapter;
import com.example.myapplication_1.Fragments.FreeOrders13ExpListFragment;
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

        RecyclerView tariffsPickAlert_rv = view.findViewById(R.id.ll_tariffs_pick_recycler);

        final RecyclerView recyclerView = tariffsPickAlert_rv;

        try{
            TariffsPickAdapter.TariffsPickItems[] tariffsPickItems = getTariffsPickItems();
            List<TariffsPickAdapter.TariffsPickItems> itemsMenuList = new ArrayList<>(Arrays.asList(tariffsPickItems));
            RecyclerView.Adapter adapterGridViewMenu = new TariffsPickAdapter(itemsMenuList, getActivity().getBaseContext());
            recyclerView.setAdapter(adapterGridViewMenu);
            recyclerView.setLayoutManager(
                    new LinearLayoutManager(getActivity().getBaseContext(), RecyclerView.VERTICAL, false));
            recyclerView.setItemAnimator(new DefaultItemAnimator());

        }catch (NullPointerException e){
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

    private TariffsPickAdapter.TariffsPickItems[] getTariffsPickItems() {

        boolean check = false;
        TariffsPickAdapter.TariffsPickItems[] arr = new TariffsPickAdapter.TariffsPickItems[]{

                new TariffsPickAdapter.TariffsPickItems(
                        "Эконом",
                        new TariffsPickAdapter.TariffsPickItems.CallBack() {
                            @Override
                            public void call(TariffsPickAdapter.TariffsPickItems tariffsPickItems) {
                            }
                        },R.drawable.ic_empty_switch, check),

                new TariffsPickAdapter.TariffsPickItems(
                        "Стандарт",
                        new TariffsPickAdapter.TariffsPickItems.CallBack() {
                            @Override
                            public void call(TariffsPickAdapter.TariffsPickItems tariffsPickItems) {
                            }
                        },R.drawable.ic_empty_switch, check),

                new TariffsPickAdapter.TariffsPickItems(
                        "Комфорт",
                        new TariffsPickAdapter.TariffsPickItems.CallBack() {
                            @Override
                            public void call(TariffsPickAdapter.TariffsPickItems tariffsPickItems) {
                            }
                        },R.drawable.ic_empty_switch, check),

                new TariffsPickAdapter.TariffsPickItems(
                        "Доставка",
                        new TariffsPickAdapter.TariffsPickItems.CallBack() {
                            @Override
                            public void call(TariffsPickAdapter.TariffsPickItems tariffsPickItems) {
                            }
                        },R.drawable.ic_empty_switch, check),

                new TariffsPickAdapter.TariffsPickItems(
                        "Грузовое",
                        new TariffsPickAdapter.TariffsPickItems.CallBack() {
                            @Override
                            public void call(TariffsPickAdapter.TariffsPickItems tariffsPickItems) {
                            }
                        },R.drawable.ic_empty_switch, check)
        };
        return arr;
    }
}