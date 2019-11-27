package com.example.myapplication_1.Fragments;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myapplication_1.Adapters.CustomSpinnerAdapter;
import com.example.myapplication_1.R;

import java.util.ArrayList;
import java.util.Objects;

public class ExpListAdapter extends BaseExpandableListAdapter{

    private final Activity activity;
    private ArrayList<ArrayList<String>> mGroups;
    private Context mContext;
    private String[] choose = {"По возрастанию цены", "По убыванию цены", "Не выбрано"};
    private int selectItem = -1;
    private int[] images = {R.drawable.ic_circle_in_circle, R.drawable.ic_circle_in_cricle_grey, R.drawable.ic_circle_in_cricle_grey};

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
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
                             ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) activity.getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.group_view, null);
        }

        if (isExpanded){
            //Изменяем что-нибудь, если текущая Group раскрыта
        }
        else{
            //Изменяем что-нибудь, если текущая Group скрыта
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
            convertView = inflater.inflate(R.layout.driver_spinner, null);
        }

        Spinner spinner = (Spinner) convertView.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Objects.requireNonNull(activity), android.R.layout.simple_spinner_item, choose);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        CustomSpinnerAdapter customAdapter=new CustomSpinnerAdapter(activity.getApplicationContext(),images,choose);
        spinner.setAdapter(customAdapter);

        return convertView;
    }


    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}