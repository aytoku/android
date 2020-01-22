package com.example.myapplication_1.Other;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication_1.Adapters.MyListAdapter;
import com.example.myapplication_1.R;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ActivityExample extends AppCompatActivity implements View.OnClickListener {

    private LinkedHashMap<String, HeaderInfo> mySection = new LinkedHashMap<>();
    private ArrayList<HeaderInfo> SectionList = new ArrayList<>();

    private MyListAdapter listAdapter;
    private ExpandableListView expandableListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_example);

        Spinner spinner = (Spinner) findViewById(R.id.department);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.dept_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        AddProduct();

        expandableListView = (ExpandableListView) findViewById(R.id.myList);
        listAdapter = new MyListAdapter(ActivityExample.this, SectionList);
        expandableListView.setAdapter(listAdapter);
        expandAll();

        Button add = (Button) findViewById(R.id.add);
        add.setOnClickListener(this);

        expandableListView.setOnChildClickListener(myListItemClicked);
        expandableListView.setOnGroupClickListener(myListGroupClicked);
    }

    public void onClick(View v) {

        if (v.getId() == R.id.add) {
            Spinner spinner = (Spinner) findViewById(R.id.department);
            String department = spinner.getSelectedItem().toString();
            EditText editText = (EditText) findViewById(R.id.product);
            String product = editText.getText().toString();
            editText.setText("");
            int groupPosition = addProduct(department, product);
            listAdapter.notifyDataSetChanged();

            collapseAll();
            expandableListView.expandGroup(groupPosition);
            expandableListView.setSelectedGroup(groupPosition);
        }
    }
    private void expandAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++){
            expandableListView.expandGroup(i);
        }
    }
    private void collapseAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++){
            expandableListView.collapseGroup(i);
        }
    }
    private void AddProduct(){

        addProduct("Vegetable","Potato");
        addProduct("Vegetable","Cabbage");
        addProduct("Vegetable","Onion");

        addProduct("Fruits","Apple");
        addProduct("Fruits","Orange");
    }

    private ExpandableListView.OnChildClickListener myListItemClicked =  new ExpandableListView.OnChildClickListener() {

        public boolean onChildClick(ExpandableListView parent, View v,
                                    int groupPosition, int childPosition, long id) {

            HeaderInfo headerInfo = SectionList.get(groupPosition);
            DetailInfo detailInfo =  headerInfo.getProductList().get(childPosition);
            Toast.makeText(getBaseContext(), "Clicked on Detail " + headerInfo.getName()
                    + "/" + detailInfo.getName(), Toast.LENGTH_LONG).show();
            return false;
        }
    };
    private ExpandableListView.OnGroupClickListener myListGroupClicked =  new ExpandableListView.OnGroupClickListener() {

        public boolean onGroupClick(ExpandableListView parent, View v,
                                    int groupPosition, long id) {

            HeaderInfo headerInfo = SectionList.get(groupPosition);
            Toast.makeText(getBaseContext(), "Child on Header " + headerInfo.getName(),
                    Toast.LENGTH_LONG).show();

            return false;
        }
    };

    private int addProduct(String department, String product){

        int groupPosition = 0;

        HeaderInfo headerInfo = mySection.get(department);
        if(headerInfo == null){
            headerInfo = new HeaderInfo();
            headerInfo.setName(department);
            mySection.put(department, headerInfo);
            SectionList.add(headerInfo);
        }

        ArrayList<DetailInfo> productList = headerInfo.getProductList();
        int listSize = productList.size();
        listSize++;

        DetailInfo detailInfo = new DetailInfo();
        detailInfo.setSequence(String.valueOf(listSize));
        detailInfo.setName(product);
        productList.add(detailInfo);
        headerInfo.setProductList(productList);

        groupPosition = SectionList.indexOf(headerInfo);
        return groupPosition;
    }
}