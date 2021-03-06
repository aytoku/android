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

import com.example.myapplication_1.Adapters.MenuOneAdapter;
import com.example.myapplication_1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuOneFragment extends Fragment {

    public static final String TAG = "MenuOneFragment";

    public static MenuOneFragment getInstance(Bundle args) {

        MenuOneFragment menuOneFragment = new MenuOneFragment();
        menuOneFragment.setArguments(args);

        return menuOneFragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.menu_1,
                container, false);

        RecyclerView menuOne_rv = view.findViewById(R.id.ll_menu_1_recycler);
        try {
            MenuOneAdapter.ItemsMenu[] itemsMenu = getMenuItems();
            List<MenuOneAdapter.ItemsMenu> itemsMenuList = new ArrayList<>(Arrays.asList(itemsMenu));
            RecyclerView.Adapter menuOneAdapter = new MenuOneAdapter(itemsMenuList, getActivity().getBaseContext());
            menuOne_rv.setAdapter(menuOneAdapter);
            menuOne_rv.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ));
            menuOne_rv.setItemAnimator( new DefaultItemAnimator() );
        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
        return view;
    }

    private MenuOneAdapter.ItemsMenu[] getMenuItems() {
        MenuOneAdapter.ItemsMenu[] arr = new MenuOneAdapter.ItemsMenu[]{
                new MenuOneAdapter.ItemsMenu(
                        "Введите номер телефона",
                        new MenuOneAdapter.ItemsMenu.CallBack(){
                            @Override
                            public void call(MenuOneAdapter.ItemsMenu itemsMenu){
                                try {
                                    Bundle bundle = new Bundle();
                                    Auth111Fragment auth111Fragment = Auth111Fragment.getInstance(bundle);
                                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                    fragmentTransaction.replace(R.id.rl_main, auth111Fragment);
                                    fragmentTransaction.commit();
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }),

                new MenuOneAdapter.ItemsMenu(
                        "Способ оплаты",
                        new MenuOneAdapter.ItemsMenu.CallBack(){
                            @Override
                            public void call(MenuOneAdapter.ItemsMenu itemsMenu){
                                try {
                                    Bundle bundle = new Bundle();
                                    PaymentPickFragment paymentPickFragment = PaymentPickFragment.getInstance(bundle);
                                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                    fragmentTransaction.replace(R.id.rl_main, paymentPickFragment);
                                    fragmentTransaction.commit();
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }),


                new MenuOneAdapter.ItemsMenu(
                        "Настройки",
                        new MenuOneAdapter.ItemsMenu.CallBack(){
                            @Override
                            public void call(MenuOneAdapter.ItemsMenu itemsMenu){
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

                new MenuOneAdapter.ItemsMenu(
                        "Информация",
                        new MenuOneAdapter.ItemsMenu.CallBack(){
                            @Override
                            public void call(MenuOneAdapter.ItemsMenu itemsMenu){
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

                new MenuOneAdapter.ItemsMenu(
                        "Служба поддержки",
                        new MenuOneAdapter.ItemsMenu.CallBack(){
                            @Override
                            public void call(MenuOneAdapter.ItemsMenu itemsMenu){
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
}