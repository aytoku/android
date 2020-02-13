package com.example.myapplication_1.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.AdapterMenu11;
import com.example.myapplication_1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu11Fragment extends Fragment {

    public static final String TAG = "Menu11Fragment";
    private static final int REQUEST_CODE = 101;
    private TextView title;

    public static Menu11Fragment getInstance(Bundle args) {

        Menu11Fragment menu11Fragment = new Menu11Fragment();
        menu11Fragment.setArguments(args);

        return menu11Fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.menu_1_1,
                container, false);

        RecyclerView menu11_rv = view.findViewById(R.id.rl_menu_1_1_recycler);
        title = view.findViewById(R.id.rl_menu_1_1_title);
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                Auth111Fragment auth111Fragment = Auth111Fragment.getInstance(bundle);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, auth111Fragment);
                fragmentTransaction.commit();
            }
        });
        try {
            AdapterMenu11.MenuList[] menuLists = getMenuListItems();
            List<AdapterMenu11.MenuList> itemsMenuList = new ArrayList<>(Arrays.asList(menuLists));
            RecyclerView.Adapter menu11Adapter = new AdapterMenu11(itemsMenuList, getActivity().getBaseContext());
            menu11_rv.setAdapter(menu11Adapter);
            menu11_rv.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ));
            menu11_rv.setItemAnimator( new DefaultItemAnimator() );
        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
        return view;
    }

    private AdapterMenu11.MenuList[] getMenuListItems() {
        AdapterMenu11.MenuList[] arr = new AdapterMenu11.MenuList[]{
                new AdapterMenu11.MenuList(
                        "Способы оплаты",
                        new AdapterMenu11.MenuList.CallBack(){
                            @Override
                            public void call(AdapterMenu11.MenuList menuList){
                                try {
                                    Bundle bundle = new Bundle();
                                    PaymentMethodFragment paymentMethodFragment = PaymentMethodFragment.getInstance(bundle);
                                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                    fragmentTransaction.replace(R.id.rl_main, paymentMethodFragment);
                                    fragmentTransaction.commit();
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }),

                new AdapterMenu11.MenuList(
                        "История поездок",
                        new AdapterMenu11.MenuList.CallBack(){
                            @Override
                            public void call(AdapterMenu11.MenuList menuList){
                                try {
                                    Bundle bundle = new Bundle();
                                    TravelStoryFragment travelStoryFragment = TravelStoryFragment.getInstance(bundle);
                                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                    fragmentTransaction.replace(R.id.rl_main, travelStoryFragment);
                                    fragmentTransaction.commit();
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }),

                new AdapterMenu11.MenuList(
                        "Мои адреса",
                        new AdapterMenu11.MenuList.CallBack(){
                            @Override
                            public void call(AdapterMenu11.MenuList menuList){
                                try {
                                    Bundle bundle = new Bundle();
                                    AddressFragment addressFragment = AddressFragment.getInstance(bundle);
                                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                    fragmentTransaction.replace(R.id.rl_main, addressFragment);
                                    fragmentTransaction.commit();
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }),

                new AdapterMenu11.MenuList(
                        "Настройки",
                        new AdapterMenu11.MenuList.CallBack(){
                            @Override
                            public void call(AdapterMenu11.MenuList menuList){
                                try {
                                    Bundle bundle = new Bundle();
                                    SettingsFragment settingsFragment = SettingsFragment.getInstance(bundle);
                                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                    fragmentTransaction.replace(R.id.rl_main, settingsFragment);
                                    fragmentTransaction.commit();
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }),

                new AdapterMenu11.MenuList(
                        "Информация",
                        new AdapterMenu11.MenuList.CallBack(){
                            @Override
                            public void call(AdapterMenu11.MenuList menuList){
                                try {
                                    Bundle bundle = new Bundle();
                                    InformationFragment informationFragment = InformationFragment.getInstance(bundle);
                                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                    fragmentTransaction.replace(R.id.rl_main, informationFragment);
                                    fragmentTransaction.commit();
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }),

                new AdapterMenu11.MenuList(
                        "Служба поддержки",
                        new AdapterMenu11.MenuList.CallBack(){
                            @Override
                            public void call(AdapterMenu11.MenuList menuList){
                                try {
                                    Bundle bundle = new Bundle();
                                    ServiceFragment serviceFragment = ServiceFragment.getInstance(bundle);
                                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                    fragmentTransaction.replace(R.id.rl_main, serviceFragment);
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
            String phone_number = intent.getStringExtra("phone_number");
            title.setText(phone_number);
        }
    }

    private void sendResult(String phone_number){
        if(getTargetFragment()== null){
            return;
        }
        Intent intent = Auth111Fragment.newIntent(phone_number);
        getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, intent);
    }
}