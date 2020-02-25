package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.RatingPraiseAdapter;
import com.example.myapplication_1.Adapters.RatingStarAdapter;
import com.example.myapplication_1.Adapters.RatingTipsAdapter;
import com.example.myapplication_1.R;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import ru.osety.amironlibrary.Query.QueryGet;
import ru.osety.amironlibrary.Query.QueryTemplate;

public class RatingFragment extends Fragment{

    public static final String TAG = "RatingFragment";
    private RecyclerView.Adapter ratingTipsAdapter;
    private RecyclerView.Adapter ratingPraiseAdapter;
    private RecyclerView.Adapter ratingStarAdapter;
    private List<Integer> tips_list = new ArrayList<>();
    private int tip_index;

    public static RatingFragment getInstance(Bundle args) {

        RatingFragment ratingFragment = new RatingFragment();
        ratingFragment.setArguments(args);
        return ratingFragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.rating,
                container, false);

        RecyclerView tips_rv = view.findViewById(R.id.rl_rating_tips_recycler);
        RecyclerView praise_rv = view.findViewById(R.id.rl_rating_praise_recycler);
        RecyclerView star_rv = view.findViewById(R.id.rl_rating_star_recycler);
        CardView button = view.findViewById(R.id.ll_rating_cardButton);
        LinearLayout address = view.findViewById(R.id.rl_rating_ll_rating_address);

        address.setVisibility(View.GONE);

        try {
            RatingStarAdapter.RatingStarItems[] ratingStarItems = getRatingStarItems();
            List<RatingStarAdapter.RatingStarItems> ratingStarItemsList = new ArrayList<>(Arrays.asList(ratingStarItems));
            ratingStarAdapter = new RatingStarAdapter(ratingStarItemsList, getActivity().getBaseContext());
            star_rv.setAdapter(ratingStarAdapter);
            star_rv.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.HORIZONTAL, false ));
            star_rv.setItemAnimator( new DefaultItemAnimator() );
        } catch ( NullPointerException e) {
            e.printStackTrace();
        }

        try {
            RatingPraiseAdapter.RatingPraiseItems[] ratingPraiseItems = getRatingPraiseItems();
            List<RatingPraiseAdapter.RatingPraiseItems> ratingPraiseItemsList = new ArrayList<>(Arrays.asList(ratingPraiseItems));
            ratingPraiseAdapter = new RatingPraiseAdapter(ratingPraiseItemsList, getActivity().getBaseContext());
            praise_rv.setAdapter(ratingPraiseAdapter);
            praise_rv.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.HORIZONTAL, false ));
            praise_rv.setItemAnimator( new DefaultItemAnimator() );
        } catch ( NullPointerException e) {
            e.printStackTrace();
        }

        try {
            ratingTipsAdapter = new RatingTipsAdapter(tips_list, getActivity().getBaseContext());
            tips_rv.setAdapter(ratingTipsAdapter);
            tips_rv.setLayoutManager(
                    new LinearLayoutManager(getActivity().getBaseContext(), RecyclerView.HORIZONTAL, false));
            tips_rv.setItemAnimator(new DefaultItemAnimator());
        } catch ( NullPointerException e) {
            Log.e(TAG, "onCreateView" +e.getMessage());
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((RatingStarAdapter)ratingStarAdapter).getSelectedItem();
                ((RatingTipsAdapter)ratingTipsAdapter).getSelectedItem();
                ((RatingPraiseAdapter)ratingPraiseAdapter).getSelectedItem();
                Log.d(TAG, "onCreateView");
            }
        });

        getTips();

        return view;
    }

    private RatingStarAdapter.RatingStarItems[] getRatingStarItems() {
        RatingStarAdapter.RatingStarItems[] arr = new RatingStarAdapter.RatingStarItems[]{
                new RatingStarAdapter.RatingStarItems(
                        R.drawable.icon_star_grey),

                new RatingStarAdapter.RatingStarItems(
                        R.drawable.icon_star_grey),

                new RatingStarAdapter.RatingStarItems(
                        R.drawable.icon_star_grey),

                new RatingStarAdapter.RatingStarItems(
                        R.drawable.icon_star_grey),

                new RatingStarAdapter.RatingStarItems(
                        R.drawable.icon_star_grey)
        };
        return arr;
    }

    private void getTips(){
        final JsonObject jsonObject = new JsonObject();
        Map<String, String>_mapHead = new ArrayMap<>();
        _mapHead.put("Accept-Charset", "UTF-8");
        _mapHead.put("Content-Type", "application/json;charset=" + "UTF-8");

        new QueryGet<JsonObject>(new QueryTemplate.CallBack<Integer, JsonObject, String>() {
            @Override
            public void asyncBefore() throws InterruptedException {
            }

            @Override
            public JsonObject async(String result) throws ClassCastException {
                try{
                    JsonParser jsonParser = new JsonParser();
                    return  jsonParser.parse(result).getAsJsonObject();
                }catch(NullPointerException | JsonParseException e){
                    Log.e(TAG, "async: " +e.getMessage());
                }
                return null;
            }

            @Override
            public void sync(JsonObject result){
                JsonArray tip_percent = result.getAsJsonArray("tip_percent");
                for (JsonElement i : tip_percent){
                    tip_index = i.getAsInt();
                    tips_list.add(tip_index);
                    ratingTipsAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void progress(Integer... status){}

            @Override
            public void cancel(JsonObject result, Throwable throwable){}
        }).addRequestPropertyHead(_mapHead)
                .setAsyncThreadPool(true)
                .query("https://client.apis.stage.faem.pro/api/v2/options", jsonObject.toString());
    }

    private RatingPraiseAdapter.RatingPraiseItems[] getRatingPraiseItems() {
        RatingPraiseAdapter.RatingPraiseItems[] arr = new RatingPraiseAdapter.RatingPraiseItems[]{
                new RatingPraiseAdapter.RatingPraiseItems(
                        R.mipmap.finger,"Вежливость"),

                new RatingPraiseAdapter.RatingPraiseItems(
                        R.mipmap.face,"Вежливость"),

                new RatingPraiseAdapter.RatingPraiseItems(
                        R.mipmap.handshake,"Вежливость"),

                new RatingPraiseAdapter.RatingPraiseItems(
                        R.mipmap.handshake,"Вежливость")
        };
        return arr;
    }
}