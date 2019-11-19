package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.AdapterMenu162;
import com.example.myapplication_1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu162Fragment extends Fragment {

    public static final String TAG = "Menu162Fragment";

    public static Menu162Fragment getInstance(Bundle args) {

        Menu162Fragment f = new Menu162Fragment();
        f.setArguments(args);

        return f;
    }

    RecyclerView rv;
    RecyclerView.Adapter adapterGridViewMenu;
    ImageButton imageButton;
    private List<AdapterMenu162.ItemsMenu> itemsMenuList;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.menu_1_6_2,
                container, false);


        rv = view.findViewById(R.id.rl_menu_1_6_2_recycler);
        imageButton = view.findViewById(R.id.rl_menu_1_6_2_button);

        Bundle _args = new Bundle();
        final Fragment serviceFragment = ServiceFragment.getInstance(_args);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_main, serviceFragment);
                fragmentTransaction.commit();
            }
        });

        final RecyclerView recyclerViewMenu = rv;

        try {

            AdapterMenu162.ItemsMenu[] itemsMenu = getMenuItems();
            itemsMenuList = new ArrayList<>(Arrays.asList(itemsMenu));
            adapterGridViewMenu = new AdapterMenu162(itemsMenuList, getActivity().getBaseContext());
            recyclerViewMenu.setAdapter(adapterGridViewMenu);
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ));
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    private AdapterMenu162.ItemsMenu[] getMenuItems() {

        AdapterMenu162.ItemsMenu[] arr = new AdapterMenu162.ItemsMenu[]{

                new AdapterMenu162.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Большая стоимость",
                        R.drawable.icon_arrow_right,
                        new AdapterMenu162.ItemsMenu.CallBack(){
                            @Override
                            public void call(AdapterMenu162.ItemsMenu itemsMenu){
                                try {
                                    Bundle _args = new Bundle();
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }),

                new AdapterMenu162.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Не дали сдачи",
                        R.drawable.icon_arrow_right,
                        new AdapterMenu162.ItemsMenu.CallBack(){
                            @Override
                            public void call(AdapterMenu162.ItemsMenu itemsMenu){
                                try {
                                    Bundle _args = new Bundle();
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }),

                new AdapterMenu162.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Ошибка программы",
                        R.drawable.icon_arrow_right,
                        new AdapterMenu162.ItemsMenu.CallBack(){
                            @Override
                            public void call(AdapterMenu162.ItemsMenu itemsMenu){
                                try {
                                    Bundle _args = new Bundle();
                                    Fragment programErrorTwoFragment = ProgramErrorTwoFragment.getInstance(_args);

                                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                    fragmentTransaction.replace(R.id.ll_main, programErrorTwoFragment);
                                    fragmentTransaction.commit();
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        })
        };
        return arr;
    }
}