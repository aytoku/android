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

import com.example.myapplication_1.Adapters.FreeOrders13ExpListAdapter;
import com.example.myapplication_1.Alerts.TariffsPickAlert;
import com.example.myapplication_1.R;

import java.util.ArrayList;
import java.util.List;

public class FreeOrders13ExpListFragment extends Fragment {

    public static final String TAG = "FreeOrders13ExpListFragment";
    private static final int REQUEST_CODE_GET_SORT_FREE_ORDER = 101;
    List sort_list;
    TextView textView;

    public static FreeOrders13ExpListFragment getInstance(Bundle args) {

        FreeOrders13ExpListFragment freeOrders13ExpListFragment = new FreeOrders13ExpListFragment();
        freeOrders13ExpListFragment.setArguments(args);

        return freeOrders13ExpListFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.expandalbe_list_view,
                container, false);

        ExpandableListView listView = view.findViewById(R.id.expListView);
        listView.setGroupIndicator(null);

        ArrayList<ArrayList<String>> groups = new ArrayList<>();
        ArrayList<String> children1 = new ArrayList<>();
        children1.add("");
        groups.add(children1);

        sort_list = new ArrayList();
        sort_list.add("По возрастанию цены");
        sort_list.add("По убыванию цены");
        sort_list.add("Не выбрано");

        textView = view.findViewById(R.id.rl_free_orders_spinner_text);

        try {
            FreeOrders13ExpListAdapter freeOrders13ExpListAdapter = new FreeOrders13ExpListAdapter(getActivity(), groups, sort_list, getFreeOrders13List());
            listView.setAdapter(freeOrders13ExpListAdapter);
            freeOrders13ExpListAdapter.setActivityTextView(textView);

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
        tariffsPickAlert.setTargetFragment(FreeOrders13ExpListFragment.this, REQUEST_CODE_GET_SORT_FREE_ORDER);
        tariffsPickAlert.setCancelable(true);
        tariffsPickAlert.show(getFragmentManager(), "TariffsPickAlert");
    }

    private FreeOrders13ExpListAdapter.FreeOrders13List getFreeOrders13List(){
        FreeOrders13ExpListAdapter.FreeOrders13List itemsMenuList = new FreeOrders13ExpListAdapter.FreeOrders13List(
                new FreeOrders13ExpListAdapter.FreeOrders13List.CallBack() {
                    @Override
                    public void call(FreeOrders13ExpListAdapter.FreeOrders13List freeOrders13List) {
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