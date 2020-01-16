package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    public static Menu11Fragment getInstance(Bundle args) {

        Menu11Fragment f = new Menu11Fragment();
        f.setArguments(args);

        return f;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.menu_1_1,
                container, false);

        RecyclerView menu11_rv = view.findViewById(R.id.rl_menu_1_1_recycler);
        final RecyclerView recyclerViewMenu = menu11_rv;

        try {

            AdapterMenu11.MenuList[] menuLists = getMenuListItems();
            List<AdapterMenu11.MenuList> itemsMenuList = new ArrayList<>(Arrays.asList(menuLists));
            RecyclerView.Adapter menu11Adapter = new AdapterMenu11(itemsMenuList, getActivity().getBaseContext());
            recyclerViewMenu.setAdapter(menu11Adapter);
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ));
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }

        return view;
    }

    private AdapterMenu11.MenuList[] getMenuListItems() {

        AdapterMenu11.MenuList[] arr = new AdapterMenu11.MenuList[]{

                new AdapterMenu11.MenuList(
                        "+7 963 377 88 44",
                        new AdapterMenu11.MenuList.CallBack(){
                            @Override
                            public void call(AdapterMenu11.MenuList menuList){
                                try {
                                    Bundle _args = new Bundle();
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }),

                new AdapterMenu11.MenuList(
                        "Способы оплаты",
                        new AdapterMenu11.MenuList.CallBack(){
                            @Override
                            public void call(AdapterMenu11.MenuList menuList){
                                try {
                                    Bundle _args = new Bundle();
                                    Fragment paymentMethodFragment = PaymentMethodFragment.getInstance(_args);

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
                                    Bundle _args = new Bundle();
                                    Fragment travelStoryFragment = TravelStoryFragment.getInstance(_args);

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
                                    Bundle _args = new Bundle();
                                    Fragment addressFragment = AddressFragment.getInstance(_args);

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
                                    Bundle _args = new Bundle();
                                    Fragment settingsFragment = SettingsFragment.getInstance(_args);

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
                                    Bundle _args = new Bundle();
                                    Fragment informationFragment = InformationFragment.getInstance(_args);

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
                                    Bundle _args = new Bundle();
                                    Fragment serviceFragment = ServiceFragment.getInstance(_args);

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
}