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

import com.example.myapplication_1.Adapters.TravelStoryAdapter;
import com.example.myapplication_1.R;

public class TravelStoryFragment extends Fragment {

    public static final String TAG = "TravelStoryFragment";

    public static TravelStoryFragment getInstance(Bundle args) {

        TravelStoryFragment f = new TravelStoryFragment();
        f.setArguments(args);

        return f;
    }

    ImageButton androidImageButton;

    RecyclerView rv;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.travel_story,
                container, false);

        rv = view.findViewById(R.id.recycler_travel_story);

        androidImageButton = view.findViewById(R.id.img_cross_grey);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        RecyclerView recyclerViewMenu = rv;

        try {

            TravelStoryAdapter.AdapterGridViewMenu.ItemsMenu[] itemsMenu = getMenuItems();

            TravelStoryAdapter.AdapterGridViewMenu adapterGridViewMenu = new TravelStoryAdapter.AdapterGridViewMenu(itemsMenu, getActivity().getBaseContext());
            recyclerViewMenu.setAdapter( adapterGridViewMenu );
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ) );
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
    }

    private TravelStoryAdapter.AdapterGridViewMenu.ItemsMenu[] getMenuItems() {

        TravelStoryAdapter.AdapterGridViewMenu.ItemsMenu []_arr = new TravelStoryAdapter.AdapterGridViewMenu.ItemsMenu[]{

                new TravelStoryAdapter.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        R.drawable.icon_ellipse_red,
                        "Сегодня 10:10",
                        new TravelStoryAdapter.AdapterGridViewMenu.ItemsMenu.CallBack() {
                            @Override
                            public void call(TravelStoryAdapter.AdapterGridViewMenu.ItemsMenu itemsMenu) {

                                try {

                                    Bundle _args = new Bundle();
                                    String cv_id =  itemsMenu.getUuid();
                                    _args.putString("uuid", cv_id);

                                    Fragment travelStoryFragment = TravelStoryOneFragment.getInstance(_args);

                                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                    fragmentTransaction.replace(R.id.ll_main, travelStoryFragment);
                                    fragmentTransaction.commit();

                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, "66 \u20BD")
        };
        return _arr;
    }
}