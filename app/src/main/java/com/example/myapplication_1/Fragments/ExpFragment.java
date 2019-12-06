package com.example.myapplication_1.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import com.example.myapplication_1.Alerts.TariffsPickAlert;
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

    private static final int TARGET_FRAGMENT_REQUEST_CODE = 1;
    private static final String EXTRA_GREETING_MESSAGE = "message";

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

        final Spinner spinner = (Spinner) view.findViewById(R.id.spinner);

        final ExpListAdapter adapter = new ExpListAdapter(getActivity(), groups, list, getFragmentManager());
        listView.setAdapter(adapter);


        TariffsPickAlert tariffsPickAlert = new TariffsPickAlert();
        tariffsPickAlert.setTargetFragment(ExpFragment.this, TARGET_FRAGMENT_REQUEST_CODE);
        tariffsPickAlert.show(getFragmentManager(), TariffsPickAlert.TAG);

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
        intent.putExtra(EXTRA_GREETING_MESSAGE, message);
        return intent;
    }



//    private ExpListAdapter.ItemsMenuList getMenuItemsList(){
//
//        ExpListAdapter.ItemsMenuList itemsMenuList = new ExpListAdapter.ItemsMenuList(
//                new ExpListAdapter.ItemsMenuList.CallBack() {
//                    @Override
//                    public void call(ExpListAdapter.ItemsMenuList itemsMenuList) {
//                        try{
//                        }catch (NullPointerException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
//            return itemsMenuList;
//    }
}