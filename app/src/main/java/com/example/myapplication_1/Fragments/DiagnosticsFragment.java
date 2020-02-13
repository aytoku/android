package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.DiagnosticsAdapter;
import com.example.myapplication_1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagnosticsFragment extends Fragment {

    public static final String TAG = "DiagnosticsFragment";

    public static DiagnosticsFragment getInstance(Bundle args) {

        DiagnosticsFragment diagnosticsFragment = new DiagnosticsFragment();
        diagnosticsFragment.setArguments(args);

        return diagnosticsFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.diagnostics,
                container, false);

        RecyclerView diagnostics_rv = view.findViewById(R.id.ll_diagnostics_recycler);

        try {
            DiagnosticsAdapter.DiagnosticsItems[] diagnosticsItems = getDiagnosticsItems();
            List<DiagnosticsAdapter.DiagnosticsItems> diagnosticsItemsList = new ArrayList<>(Arrays.asList(diagnosticsItems));
            RecyclerView.Adapter diagnosticsAdapter = new DiagnosticsAdapter(diagnosticsItemsList, getActivity().getBaseContext());
            diagnostics_rv.setAdapter(diagnosticsAdapter);
            diagnostics_rv.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext(), RecyclerView.VERTICAL, false));
            diagnostics_rv.setItemAnimator(new DefaultItemAnimator());
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        return view;
    }

    private DiagnosticsAdapter.DiagnosticsItems[] getDiagnosticsItems() {
        DiagnosticsAdapter.DiagnosticsItems[] arr = new DiagnosticsAdapter.DiagnosticsItems[]{
                new DiagnosticsAdapter.DiagnosticsItems(
                        R.drawable.ic_close_button,"Нет доступа к GPS","Для начала работы GPS должен быть...", R.drawable.ic_arrow_black_right
                ),
                new DiagnosticsAdapter.DiagnosticsItems(
                        R.drawable.ic_close_button,"Пройдите фотосмотр","Не прйденно", R.drawable.ic_arrow_black_right
                ),
                new DiagnosticsAdapter.DiagnosticsItems(
                        R.drawable.ic_close_button,"Оновите В/У","Истекает срок В/У", R.drawable.ic_arrow_black_right
                )
        };
        return arr;
    }
}