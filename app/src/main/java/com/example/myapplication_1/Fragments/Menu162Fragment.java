package com.example.myapplication_1.Fragments;

import android.app.Activity;
import android.content.Intent;
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
    private static final int REQUEST_CODE = 101;

    public static Menu162Fragment getInstance(Bundle args) {

        Menu162Fragment menu162Fragment = new Menu162Fragment();
        menu162Fragment.setArguments(args);

        return menu162Fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.menu_1_6_2,
                container, false);


        RecyclerView menu162_rv = view.findViewById(R.id.rl_menu_1_6_2_recycler);
        ImageButton imageButton = view.findViewById(R.id.rl_menu_1_6_2_button);
        Bundle bundle = new Bundle();
        final Fragment serviceFragment = ServiceFragment.getInstance(bundle);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, serviceFragment);
                fragmentTransaction.commit();
            }
        });

        try {
            AdapterMenu162.Menu162List[] menu162Lists = getMenu162ListItems();
            List<AdapterMenu162.Menu162List> itemsMenuList = new ArrayList<>(Arrays.asList(menu162Lists));
            RecyclerView.Adapter menu162Adapter = new AdapterMenu162(itemsMenuList, getActivity().getBaseContext());
            menu162_rv.setAdapter(menu162Adapter);
            menu162_rv.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ));
            menu162_rv.setItemAnimator( new DefaultItemAnimator() );
        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    private AdapterMenu162.Menu162List[] getMenu162ListItems() {
        AdapterMenu162.Menu162List[] arr = new AdapterMenu162.Menu162List[]{
                new AdapterMenu162.Menu162List(
                        "Большая стоимость",
                        R.drawable.icon_arrow_right,
                        new AdapterMenu162.Menu162List.CallBack(){
                            @Override
                            public void call(AdapterMenu162.Menu162List menu162Lists){
                                try {
                                    Bundle bundle = new Bundle();
                                    ProgramErrorTwoFragment programErrorTwoFragment = ProgramErrorTwoFragment.getInstance(bundle);
                                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                    fragmentTransaction.replace(R.id.rl_main, programErrorTwoFragment);
                                    fragmentTransaction.commit();
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }),

                new AdapterMenu162.Menu162List(
                        "Не дали сдачи",
                        R.drawable.icon_arrow_right,
                        new AdapterMenu162.Menu162List.CallBack(){
                            @Override
                            public void call(AdapterMenu162.Menu162List menu162Lists){
                                try {
                                    Bundle bundle = new Bundle();
                                    ProgramErrorTwoFragment programErrorTwoFragment = ProgramErrorTwoFragment.getInstance(bundle);
                                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                    fragmentTransaction.replace(R.id.rl_main, programErrorTwoFragment);
                                    fragmentTransaction.commit();
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }),

                new AdapterMenu162.Menu162List(
                        "Ошибка программы",
                        R.drawable.icon_arrow_right,
                        new AdapterMenu162.Menu162List.CallBack(){
                            @Override
                            public void call(AdapterMenu162.Menu162List menu162Lists){
                                try {
                                    Bundle bundle = new Bundle();
                                    ProgramErrorTwoFragment programErrorTwoFragment = ProgramErrorTwoFragment.getInstance(bundle);
                                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                    fragmentTransaction.replace(R.id.rl_main, programErrorTwoFragment);
                                    fragmentTransaction.commit();
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        })
        };
        return arr;
    }

    public void onActivityResult(int resultCode, int requestCode, Intent intent){
        if(resultCode != Activity.RESULT_OK){
            return;
        }
        if(requestCode == REQUEST_CODE){
            String message = intent.getStringExtra("message");
        }
    }
}