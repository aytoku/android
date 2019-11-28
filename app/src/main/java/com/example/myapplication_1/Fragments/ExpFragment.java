package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import androidx.fragment.app.Fragment;

import com.example.myapplication_1.R;

import java.util.ArrayList;

public class ExpFragment extends Fragment {

    public static final String TAG = "ExpFragment";

    public static ExpFragment getInstance(Bundle args) {

        ExpFragment f = new ExpFragment();
        f.setArguments(args);

        return f;
    }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.expandalbe_list_view,
                container, false);

        // Находим наш list
        final ExpandableListView listView = (ExpandableListView)view.findViewById(R.id.expListView);
        listView.setGroupIndicator(null);

        //Создаем набор данных для адаптера
        ArrayList<ArrayList<String>> groups = new ArrayList<ArrayList<String>>();
        ArrayList<String> children1 = new ArrayList<String>();
        children1.add("");
        groups.add(children1);
        //Создаем адаптер и передаем context и список с данными
        final ExpListAdapter adapter = new ExpListAdapter(getActivity(), groups);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ExpandableListView.CHOICE_MODE_SINGLE);
        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                view.setSelected(true);
                return false;
            }
        });
            adapter.notifyDataSetChanged();

//            listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//                @Override
//                public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
//                    int index = expandableListView.getFlatListPosition(ExpandableListView.getPackedPositionChild(i,i1));
//                    expandableListView.setItemChecked(index, true);
//                    return false;
//                }
//            });

        return view;
    }
}