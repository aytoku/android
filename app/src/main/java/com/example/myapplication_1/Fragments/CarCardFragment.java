package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.MainActivityAdapter;
import com.example.myapplication_1.R;

public class CarCardFragment extends Fragment {

    public static final String TAG = "CarCardFragment";
    ImageButton androidImageButton;
    RecyclerView rv;

    public static CarCardFragment getInstance(Bundle args) {

        CarCardFragment f = new CarCardFragment();
        f.setArguments(args);

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.main_recycler,
                container, false);

        androidImageButton = view.findViewById(R.id.img_cross_grey);

        rv = view.findViewById(R.id.recycler);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        RecyclerView recyclerViewMenu = rv;

        try {

            MainActivityAdapter.ItemsMenu[] itemsMenu = getMenuItems();//model_data

            MainActivityAdapter adapterGridViewMenu = new MainActivityAdapter(itemsMenu, getActivity().getBaseContext());//this;
            recyclerViewMenu.setAdapter( adapterGridViewMenu );
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.HORIZONTAL, false ) );
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
    }

    private MainActivityAdapter.ItemsMenu[] getMenuItems() {

        MainActivityAdapter.ItemsMenu []_arr = new MainActivityAdapter.ItemsMenu[]{

                new MainActivityAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        R.mipmap.yellow_car,
                        "Эконом",
                        new MainActivityAdapter.ItemsMenu.CallBack() {
                            @Override
                            public void call(MainActivityAdapter.ItemsMenu itemsMenu) {

                                try {

                                    Bundle _args = new Bundle();

                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, "48 \u20BD"),

                new MainActivityAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        R.mipmap.red_car,
                        "Стандарт",
                        new MainActivityAdapter.ItemsMenu.CallBack() {
                            @Override
                            public void call(MainActivityAdapter.ItemsMenu itemsMenu) {

                                try {

                                    Bundle _args = new Bundle();

                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, "78 \u20BD"),
                new MainActivityAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        R.mipmap.grey_car,
                        "Комфорт",
                        new MainActivityAdapter.ItemsMenu.CallBack() {
                            @Override
                            public void call(MainActivityAdapter.ItemsMenu itemsMenu) {

                                try {

                                    Bundle _args = new Bundle();

                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, "130 \u20BD"),

                new MainActivityAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        R.mipmap.load,
                        "Грузовое",
                        new MainActivityAdapter.ItemsMenu.CallBack() {
                            @Override
                            public void call(MainActivityAdapter.ItemsMenu itemsMenu) {

                                try {

                                    Bundle _args = new Bundle();

                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, "500 \u20BD"),

                new MainActivityAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        R.mipmap.receive,
                        "Доставка",
                        new MainActivityAdapter.ItemsMenu.CallBack() {
                            @Override
                            public void call(MainActivityAdapter.ItemsMenu itemsMenu) {

                                try {

                                    Bundle _args = new Bundle();

                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, "120 \u20BD")
        };
        return _arr;
    }
}