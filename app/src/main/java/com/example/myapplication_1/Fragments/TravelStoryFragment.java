package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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

    RecyclerView rv;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.travel_story,
                container, false);

        rv = view.findViewById(R.id.recycler_travel_story);
        ImageView imageView = view.findViewById(R.id.ll_travel_story_img);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle _args = new Bundle();
                Fragment menu11Fragment = Menu11Fragment.getInstance(_args);

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_main, menu11Fragment);
                fragmentTransaction.commit();

            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        RecyclerView recyclerViewMenu = rv;

        try {

            TravelStoryAdapter.TravelStoryCard[] itemsMenu = getMenuItems();

            TravelStoryAdapter adapterGridViewMenu = new TravelStoryAdapter(itemsMenu, getActivity().getBaseContext());
            recyclerViewMenu.setAdapter( adapterGridViewMenu );
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ) );
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
    }

    private TravelStoryAdapter.TravelStoryCard[] getMenuItems() {

        TravelStoryAdapter.TravelStoryCard []_arr = new TravelStoryAdapter.TravelStoryCard[]{

                new TravelStoryAdapter.TravelStoryCard(
                        getResources().getColor(R.color.my_gray),
                        R.drawable.icon_ellipse_red,
                        "Сегодня 10:10",
                        new TravelStoryAdapter.TravelStoryCard.CallBack() {
                            @Override
                            public void call(TravelStoryAdapter.TravelStoryCard itemsMenu) {

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