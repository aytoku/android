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

        MenuOneFragment f = new MenuOneFragment();
        f.setArguments(args);

        return f;
    }

    RecyclerView rv;
    RecyclerView.Adapter adapterGridViewMenu;
    private List<MenuOneAdapter.ItemsMenu> itemsMenuList;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.menu_1,
                container, false);

        rv = view.findViewById(R.id.ll_menu_1_recycler);
        final RecyclerView recyclerViewMenu = rv;

        try {

            MenuOneAdapter.ItemsMenu[] itemsMenu = getMenuItems();
            itemsMenuList = new ArrayList<>(Arrays.asList(itemsMenu));
            adapterGridViewMenu = new MenuOneAdapter(itemsMenuList, getActivity().getBaseContext());
            recyclerViewMenu.setAdapter(adapterGridViewMenu);
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ));
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
        return view;
    }

    private MenuOneAdapter.ItemsMenu[] getMenuItems() {

        MenuOneAdapter.ItemsMenu[] arr = new MenuOneAdapter.ItemsMenu[]{

                new MenuOneAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Введите номер телефона",
                        new MenuOneAdapter.ItemsMenu.CallBack(){
                            @Override
                            public void call(MenuOneAdapter.ItemsMenu itemsMenu){
                                try {
                                    Bundle _args = new Bundle();
                                    Fragment auth111Fragment = Auth111Fragment.getInstance(_args);

                                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                    fragmentTransaction.replace(R.id.ll_main, auth111Fragment);
                                    fragmentTransaction.commit();
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }),

                new MenuOneAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Способ оплаты",
                        new MenuOneAdapter.ItemsMenu.CallBack(){
                            @Override
                            public void call(MenuOneAdapter.ItemsMenu itemsMenu){
                                try {
                                    Bundle _args = new Bundle();
                                    Fragment paymentPickFragment = PaymentPickFragment.getInstance(_args);

                                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                    fragmentTransaction.replace(R.id.ll_main, paymentPickFragment);
                                    fragmentTransaction.commit();
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }),


                new MenuOneAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Настройки",
                        new MenuOneAdapter.ItemsMenu.CallBack(){
                            @Override
                            public void call(MenuOneAdapter.ItemsMenu itemsMenu){
                                try {
                                    Bundle _args = new Bundle();
                                    Fragment settingsFragment = SettingsFragment.getInstance(_args);

                                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                    fragmentTransaction.replace(R.id.ll_main, settingsFragment);
                                    fragmentTransaction.commit();
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }),

                new MenuOneAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Информация",
                        new MenuOneAdapter.ItemsMenu.CallBack(){
                            @Override
                            public void call(MenuOneAdapter.ItemsMenu itemsMenu){
                                try {
                                    Bundle _args = new Bundle();
                                    Fragment informationFragment = InformationFragment.getInstance(_args);

                                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                    fragmentTransaction.replace(R.id.ll_main, informationFragment);
                                    fragmentTransaction.commit();
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }),

                new MenuOneAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Служба поддержки",
                        new MenuOneAdapter.ItemsMenu.CallBack(){
                            @Override
                            public void call(MenuOneAdapter.ItemsMenu itemsMenu){
                                try {
                                    Bundle _args = new Bundle();
                                    Fragment serviceFragment = ServiceFragment.getInstance(_args);

                                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                    fragmentTransaction.replace(R.id.ll_main, serviceFragment);
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