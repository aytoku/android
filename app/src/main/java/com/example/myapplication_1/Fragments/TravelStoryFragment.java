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
    private RecyclerView travelStory_rv;

    public static TravelStoryFragment getInstance(Bundle args) {

        TravelStoryFragment travelStoryFragment = new TravelStoryFragment();
        travelStoryFragment.setArguments(args);

        return travelStoryFragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.travel_story,
                container, false);

        travelStory_rv = view.findViewById(R.id.recycler_travel_story);
        ImageView imageView = view.findViewById(R.id.ll_travel_story_img);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle _args = new Bundle();
                Menu11Fragment menu11Fragment = Menu11Fragment.getInstance(_args);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, menu11Fragment);
                fragmentTransaction.commit();
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        RecyclerView recyclerView = travelStory_rv;
        try {
            TravelStoryAdapter.TravelStoryCard[] travelStoryCardItems = getTravelStoryCardItems();
            TravelStoryAdapter travelStoryAdapter = new TravelStoryAdapter(travelStoryCardItems, getActivity().getBaseContext());
            recyclerView.setAdapter( travelStoryAdapter );
            recyclerView.setLayoutManager(
                    new LinearLayoutManager(getActivity().getBaseContext(), RecyclerView.VERTICAL, false));
            recyclerView.setItemAnimator( new DefaultItemAnimator() );
        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
    }

    private TravelStoryAdapter.TravelStoryCard[] getTravelStoryCardItems() {

        TravelStoryAdapter.TravelStoryCard []_arr = new TravelStoryAdapter.TravelStoryCard[]{

                new TravelStoryAdapter.TravelStoryCard(
                        R.drawable.icon_ellipse_red,
                        "Сегодня 10:10",
                        new TravelStoryAdapter.TravelStoryCard.CallBack() {
                            @Override
                            public void call(TravelStoryAdapter.TravelStoryCard travelStoryCardItems) {
                                try {
                                    Bundle bundle = new Bundle();
                                    String cv_id =  travelStoryCardItems.getUuid();
                                    bundle.putString("uuid", cv_id);
                                    TravelStoryOneFragment travelStoryOneFragment = TravelStoryOneFragment.getInstance(bundle);
                                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                    fragmentTransaction.replace(R.id.rl_main, travelStoryOneFragment);
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