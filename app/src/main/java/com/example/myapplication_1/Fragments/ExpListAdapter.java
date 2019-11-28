package com.example.myapplication_1.Fragments;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myapplication_1.R;

import java.util.ArrayList;
import java.util.List;

public class ExpListAdapter extends BaseExpandableListAdapter implements AdapterView.OnItemSelectedListener{

    private final Activity activity;
    private ArrayList<ArrayList<String>> mGroups;
    private Context mContext;

    public ExpListAdapter(Activity activity, ArrayList<ArrayList<String>> groups){
        this.activity = activity;
        mGroups = groups;
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

        if(isExpanded){

        }else{

        }

        TextView textGroup = (TextView) convertView.findViewById(R.id.textGroup);
        ImageView imageView = convertView.findViewById(R.id.imageView);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                             View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) activity.getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.free_order_spinner, null);
        }

        Spinner spinner = (Spinner) convertView.findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        List list = new ArrayList();
        list.add("По возрастанию цены");
        list.add("По убыванию цены");
        list.add("Не выбрано");
        ArrayAdapter dataAdapter = new ArrayAdapter((activity), android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner.setAdapter(dataAdapter);


        Spinner spinner1 = (Spinner) convertView.findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(this);
        List list1 = new ArrayList();
        list1.add("По возрастанию цены");
        list1.add("По убыванию цены");
        list1.add("Не выбрано");
        ArrayAdapter dataAdapter1 = new ArrayAdapter((activity), android.R.layout.simple_spinner_item, list1);
        dataAdapter1.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner1.setAdapter(dataAdapter1);

        return convertView;
    }

    @Override
    public void onItemSelected(AdapterView parent, View view, int position, long id) {
        // getting selected item
        String item = parent.getItemAtPosition(position).toString();
    }

    public void onNothingSelected(AdapterView arg0) { }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) { return true; }
}