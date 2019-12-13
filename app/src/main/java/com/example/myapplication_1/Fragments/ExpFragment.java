package com.example.myapplication_1.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.myapplication_1.Adapters.ExpListAdapter;
import com.example.myapplication_1.Alerts.TariffsPickAlert;
import com.example.myapplication_1.R;

import java.util.ArrayList;
import java.util.List;

public class ExpFragment extends Fragment {

    public static final String TAG = "ExpFragment";
    private static final int REQUEST_CODE_GET_SORT_FREE_ORDER = 101;
    ExpListAdapter adapter;
    ExpandableListView listView;
    ArrayList<ArrayList<String>> groups;
    List list;
    TextView textView;

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

        listView = view.findViewById(R.id.expListView);
        listView.setGroupIndicator(null);

        groups = new ArrayList<>();
        ArrayList<String> children1 = new ArrayList<>();
        children1.add("");
        groups.add(children1);

        list = new ArrayList();
        list.add("По возрастанию цены");
        list.add("По убыванию цены");
        list.add("Не выбрано");

        textView = view.findViewById(R.id.rl_free_orders_spinner_text);

        try {
            adapter = new ExpListAdapter(getActivity(), groups, list, getMenuItemsList());
            listView.setAdapter(adapter);
            adapter.setActivityTextView(textView);

        }catch ( NullPointerException e){
            e.printStackTrace();
        }

        return view;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode, data);
        if (requestCode != REQUEST_CODE_GET_SORT_FREE_ORDER){
            if(resultCode == Activity.RESULT_OK){
                String message = data.getStringExtra("message");
                textView.setText(message);
                //Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static Intent newIntent(String message) {
        Intent intent = new Intent();
        intent.putExtra("message", message);
        return intent;
    }

    private void showDialog() {
        TariffsPickAlert tariffsPickAlert = TariffsPickAlert.getInstance(null);
        tariffsPickAlert.setTargetFragment(ExpFragment.this, REQUEST_CODE_GET_SORT_FREE_ORDER);
        tariffsPickAlert.setCancelable(true);
        tariffsPickAlert.show(getFragmentManager(), "TariffsPickAlert");
    }


    private ExpListAdapter.ItemsMenuList getMenuItemsList(){

        ExpListAdapter.ItemsMenuList itemsMenuList = new ExpListAdapter.ItemsMenuList(
                new ExpListAdapter.ItemsMenuList.CallBack() {
                    @Override
                    public void call(ExpListAdapter.ItemsMenuList itemsMenuList) {
                        try{
                            showDialog();
                        }catch (NullPointerException e) {
                            e.printStackTrace();
                        }
                    }
                });
        return itemsMenuList;
    }
}