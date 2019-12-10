package com.example.myapplication_1.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import androidx.fragment.app.Fragment;

import com.example.myapplication_1.Adapters.ExpListAdapter;
import com.example.myapplication_1.R;

import java.util.ArrayList;
import java.util.List;

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

        try {
            ExpListAdapter.ItemsMenuList itemsMenuList = getMenuItemsList();

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }

        final ExpandableListView listView = view.findViewById(R.id.expListView);
        listView.setGroupIndicator(null);

        ArrayList<ArrayList<String>> groups = new ArrayList<>();
        ArrayList<String> children1 = new ArrayList<>();
        children1.add("");
        groups.add(children1);

        final List list = new ArrayList();
        list.add("По возрастанию цены");
        list.add("По убыванию цены");
        list.add("Не выбрано");

        final ExpListAdapter adapter = new ExpListAdapter(getActivity(), groups, list, getFragmentManager());
        listView.setAdapter(adapter);

//        DialogFragment dialogFragment = new TariffsPickAlert();
//        dialogFragment.setTargetFragment(this, 1);
//        dialogFragment.show(getFragmentManager(),"TariffsPickAlert");

        return view;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode, data);
        if(resultCode == Activity.RESULT_OK){
            getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, data);
        }
    }

    public static Intent newIntent(String message) {
        Intent intent = new Intent();
        intent.putExtra("", message);
        return intent;
    }

    private ExpListAdapter.ItemsMenuList getMenuItemsList(){

        ExpListAdapter.ItemsMenuList itemsMenuList = new ExpListAdapter.ItemsMenuList(
                new ExpListAdapter.ItemsMenuList.CallBack() {
                    @Override
                    public void call(ExpListAdapter.ItemsMenuList itemsMenuList) {
                        try{

                        }catch (NullPointerException e) {
                            e.printStackTrace();
                        }
                    }
                });
            return itemsMenuList;
    }
}