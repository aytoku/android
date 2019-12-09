package com.example.myapplication_1.Fragments;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;

import com.example.myapplication_1.Alerts.TariffsPickAlert;
import com.example.myapplication_1.R;

import java.util.ArrayList;
import java.util.List;

public class ExpListAdapter extends BaseExpandableListAdapter implements AdapterView.OnItemSelectedListener{

    private Activity activity;
    private ArrayList<ArrayList<String>> mGroups;
    private Context mContext;
    private List list;
    private FragmentManager fragmentManager;

    public ExpListAdapter(Activity activity, ArrayList<ArrayList<String>> groups, List list, FragmentManager fragmentManager){
        this.activity = activity;
        mGroups = groups;
        this.list = list;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public int getGroupCount() {
        return mGroups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mGroups.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mGroups.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mGroups.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) { return groupPosition; }

    @Override
    public long getChildId(int groupPosition, int childPosition) { return childPosition; }

    @Override
    public boolean hasStableIds() { return true; }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
                             ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) activity.getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.group_view, null);
        }

        TextView textGroup = convertView.findViewById(R.id.textGroup);
        ImageView imageView = convertView.findViewById(R.id.imageView);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild,
                             View convertView, ViewGroup parent) {


        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) activity.getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.free_order_spinner, null);
        }

        final Spinner spinner = (Spinner) convertView.findViewById(R.id.spinner);
        ArrayAdapter dataAdapter = new ArrayAdapter((activity), android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner.setAdapter(dataAdapter);
        spinner.setSelection(spinner.getFirstVisiblePosition());

        final TextView textView = convertView.findViewById(R.id.rl_free_orders_spinner_text);

        ImageView imageView = convertView.findViewById(R.id.rl_free_orders_spinner_img);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(view);
            }
        });

        return convertView;
    }

    private void showDialog(View view) {
        TariffsPickAlert tariffsPickAlert = new TariffsPickAlert();
        tariffsPickAlert.setCancelable(true);
        tariffsPickAlert.show(fragmentManager, "TariffsPickAlert");
    }

    @Override
    public void onItemSelected(AdapterView parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
    }

    public void onNothingSelected(AdapterView arg0) { }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) { return true; }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        super.registerDataSetObserver(observer);
    }

    public static class ItemsMenuList {

        public interface CallBack {
            void call(ItemsMenuList itemsMenuList);
        }

        private ItemsMenuList.CallBack callBack;
        ItemsMenuList(ItemsMenuList.CallBack callBack) {
            this.callBack = callBack;
        }
        public  CallBack getCallBack(){return callBack;}
    }
}