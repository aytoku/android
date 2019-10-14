package com.example.myapplication_1;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.MachinePurposeAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivityMachinePurpose extends AppCompatActivity {

    RecyclerView rv;
    RecyclerView.Adapter adapterGridViewMenu;
    private List<MachinePurposeAdapter.AdapterGridViewMenu.ItemsMenu> itemsMenuList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.machine_purpose_recycler);

        rv = findViewById(R.id.ll_machine_purpose_recycler_rv);

        final RecyclerView recyclerViewMenu = rv;

        try {

            MachinePurposeAdapter.AdapterGridViewMenu.ItemsMenu[] itemsMenu = getMenuItems();
            itemsMenuList = new ArrayList<>(Arrays.asList(itemsMenu));
            adapterGridViewMenu = new MachinePurposeAdapter.AdapterGridViewMenu(itemsMenuList, getBaseContext());
            recyclerViewMenu.setAdapter(adapterGridViewMenu);
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getBaseContext(), RecyclerView.VERTICAL, false ));
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {

        return super.onCreateView(parent, name, context, attrs);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private MachinePurposeAdapter.AdapterGridViewMenu.ItemsMenu[] getMenuItems() {

        MachinePurposeAdapter.AdapterGridViewMenu.ItemsMenu[] arr = new MachinePurposeAdapter.AdapterGridViewMenu.ItemsMenu[]{

                new MachinePurposeAdapter.AdapterGridViewMenu.ItemsMenu(getResources().getColor(R.color.my_gray),

                        R.drawable.icon_grey_plus,
                        "Добавить остановку",
                        R.drawable.icon_arrow_right)
        };
        return arr;
    }
}

