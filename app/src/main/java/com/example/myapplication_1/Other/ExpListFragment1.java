package com.example.myapplication_1.Other;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import androidx.fragment.app.Fragment;


import com.example.myapplication_1.R;

import java.util.ArrayList;
import java.util.List;

public class ExpListFragment1 extends Fragment {

    public static final String TAG = "FreeOrders13ExpListFragment";

    public static ExpListFragment1 getInstance(Bundle args) {

        ExpListFragment1 expListFragment1 = new ExpListFragment1();
        expListFragment1.setArguments(args);

        return expListFragment1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.expandalbe_list_view,
                container, false);

        final ExpandableListView listView = (ExpandableListView) view.findViewById(R.id.expListView);
        listView.setGroupIndicator(null);

        ArrayList<ArrayList<String>> groups = new ArrayList<ArrayList<String>>();
        ArrayList<String> children1 = new ArrayList<String>();
        children1.add("");
        groups.add(children1);

        final List list = new ArrayList();
        list.add("По возрастанию цены");
        list.add("По убыванию цены");
        list.add("Не выбрано");

//        final ExpListAdapter1 adapter = new ExpListAdapter1(getActivity(), groups, list);
    //    listView.setAdapter(adapter);
        return view;
    }
}