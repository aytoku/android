//package com.example.myapplication_1.Other;
//
//import android.app.Activity;
//import android.content.Context;
//import android.database.DataSetObserver;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.BaseExpandableListAdapter;
//import android.widget.Spinner;
//
//import com.example.myapplication_1.R;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ExpListAdapter1 extends BaseExpandableListAdapter implements AdapterView.OnItemSelectedListener{
//
//    private Activity activity;
//    private ArrayList<ArrayList<String>> mGroups;
//    private Context mContext;
//    private List list;
//    private List list1;
//
//    public ExpListAdapter1(Activity activity, ArrayList<ArrayList<String>> groups, List list){
//        this.activity = activity;
//        mGroups = groups;
//        this.list = list;
//        this.list1 = list;
//    }
//
//    @Override
//    public int getGroupCount() {
//        return mGroups.size();
//    }
//
//    @Override
//    public int getChildrenCount(int groupPosition) {
//        return mGroups.get(groupPosition).size();
//    }
//
//    @Override
//    public Object getGroup(int groupPosition) {
//        return mGroups.get(groupPosition);
//    }
//
//    @Override
//    public Object getChild(int groupPosition, int childPosition) {
//        return mGroups.get(groupPosition).get(childPosition);
//    }
//
//    @Override
//    public long getGroupId(int groupPosition) { return groupPosition; }
//
//    @Override
//    public long getChildId(int groupPosition, int childPosition) { return childPosition; }
//
//    @Override
//    public boolean hasStableIds() { return true; }
//
//    @Override
//    public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
//                             ViewGroup parent) {
//
//        if (convertView == null) {
//            LayoutInflater inflater = (LayoutInflater) activity.getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = inflater.inflate(R.layout.group_view, null);
//        }
//
//        return convertView;
//    }
//
//    @Override
//    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
//                             View convertView, ViewGroup parent) {
//
//        if (convertView == null) {
//            LayoutInflater inflater = (LayoutInflater) activity.getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = inflater.inflate(R.layout.free_order_spinner, null);
//        }
//
//        Spinner spinner = (Spinner) convertView.findViewById(R.id.spinner);
//        spinner.setOnItemSelectedListener(this);
//        ArrayAdapter dataAdapter = new ArrayAdapter((activity), android.R.layout.simple_spinner_item, list);
//        dataAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
//        spinner.setAdapter(dataAdapter);
//
//
//        return convertView;
//    }
//
//    @Override
//    public void onItemSelected(AdapterView parent, View view, int position, long id) {
//        String item = parent.getItemAtPosition(position).toString();
//    }
//
//    public void onNothingSelected(AdapterView arg0) { }
//
//    @Override
//    public boolean isChildSelectable(int groupPosition, int childPosition) { return true; }
//
//    @Override
//    public void registerDataSetObserver(DataSetObserver observer) {
//        super.registerDataSetObserver(observer);
//    }
//}