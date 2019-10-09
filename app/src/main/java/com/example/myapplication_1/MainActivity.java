package com.example.myapplication_1;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.MainActivityAdapter;

    public class MainActivity extends AppCompatActivity {

        ImageButton androidImageButton;

        RecyclerView rv;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
             androidImageButton = (ImageButton) findViewById(R.id.img_cross_grey);

                setContentView(R.layout.main_recycler);

                rv = (RecyclerView) findViewById(R.id.recycler);
        }

        @Override
        public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {

            return super.onCreateView(parent, name, context, attrs);
        }

        @Override
        protected void onStart() {
            super.onStart();

            RecyclerView recyclerViewMenu = rv;

            try {

                MainActivityAdapter.AdapterGridViewMenu.ItemsMenu[] itemsMenu = getMenuItems();//model_data

                MainActivityAdapter.AdapterGridViewMenu adapterGridViewMenu = new MainActivityAdapter.AdapterGridViewMenu(itemsMenu, getBaseContext());//this;
                recyclerViewMenu.setAdapter( adapterGridViewMenu );
                recyclerViewMenu.setLayoutManager(
                        new LinearLayoutManager( getBaseContext(), RecyclerView.HORIZONTAL, false ) );
                recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

            } catch ( NullPointerException e) {
                e.printStackTrace();
            }
        }

        private MainActivityAdapter.AdapterGridViewMenu.ItemsMenu[] getMenuItems() {

            MainActivityAdapter.AdapterGridViewMenu.ItemsMenu []_arr = new MainActivityAdapter.AdapterGridViewMenu.ItemsMenu[]{

            new MainActivityAdapter.AdapterGridViewMenu.ItemsMenu(
                    getResources().getColor(R.color.my_gray),
                    R.mipmap.yellow_car,
                        "Эконом",
                    new MainActivityAdapter.AdapterGridViewMenu.ItemsMenu.CallBack() {
                @Override
                public void call(MainActivityAdapter.AdapterGridViewMenu.ItemsMenu itemsMenu) {

                    try {

                        Bundle _args = new Bundle();

                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
            }, "48 \u20BD"),
                    new MainActivityAdapter.AdapterGridViewMenu.ItemsMenu(
                            getResources().getColor(R.color.my_gray),
                            R.mipmap.red_car,
                            "Стандарт",
                            new MainActivityAdapter.AdapterGridViewMenu.ItemsMenu.CallBack() {
                                @Override
                                public void call(MainActivityAdapter.AdapterGridViewMenu.ItemsMenu itemsMenu) {

                                    try {

                                        Bundle _args = new Bundle();

                                    } catch (NullPointerException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }, "78 \u20BD"),
                    new MainActivityAdapter.AdapterGridViewMenu.ItemsMenu(
                            getResources().getColor(R.color.my_gray),
                            R.mipmap.grey_car,
                            "Комфорт",
                            new MainActivityAdapter.AdapterGridViewMenu.ItemsMenu.CallBack() {
                                @Override
                                public void call(MainActivityAdapter.AdapterGridViewMenu.ItemsMenu itemsMenu) {

                                    try {

                                        Bundle _args = new Bundle();

                                    } catch (NullPointerException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }, "130 \u20BD"),
                    new MainActivityAdapter.AdapterGridViewMenu.ItemsMenu(
                            getResources().getColor(R.color.my_gray),
                            R.mipmap.load,
                            "Грузовое",
                            new MainActivityAdapter.AdapterGridViewMenu.ItemsMenu.CallBack() {
                                @Override
                                public void call(MainActivityAdapter.AdapterGridViewMenu.ItemsMenu itemsMenu) {

                                    try {

                                        Bundle _args = new Bundle();

                                    } catch (NullPointerException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }, "500 \u20BD"),
                    new MainActivityAdapter.AdapterGridViewMenu.ItemsMenu(
                            getResources().getColor(R.color.my_gray),
                            R.mipmap.receive,
                            "Доставка",
                            new MainActivityAdapter.AdapterGridViewMenu.ItemsMenu.CallBack() {
                                @Override
                                public void call(MainActivityAdapter.AdapterGridViewMenu.ItemsMenu itemsMenu) {

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

