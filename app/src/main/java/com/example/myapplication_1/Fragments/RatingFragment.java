package com.example.myapplication_1.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.ArrayMap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.RatingPraiseAdapter;
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
import ru.osety.amironlibrary.Query.QueryPost;
import ru.osety.amironlibrary.Query.QueryTemplate;

public class RatingFragment extends Fragment{

    public static final String TAG = "RatingFragment";
    private static final int REQUEST_CODE_TOKEN = 101;
    private static final String ACCESS_TOKEN = "pk.eyJ1IjoiZmFlbXRheGkiLCJhIjoiY2pyYXNqZ3RhMHQxNTQ5bjBxMWlvcWF6eSJ9.ISSgNBMdG7idL3ljb2ILTg";
    private RecyclerView.Adapter ratingTipsAdapter;
    private RecyclerView.Adapter ratingPraiseAdapter;
    private ImageView star1;
    private ImageView star2;
    private ImageView star3;
    private ImageView star4;
    private ImageView star5;
    private Drawable imgStarGrey;
    private Drawable imgStarRed;
    List<Integer> list = new ArrayList<>();
    private int tip_index;
    private static final String TOKEN = "Token";
    private List<ImageView> starList;
    int selectItem = 0;

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

        imgStarGrey = getResources().getDrawable(R.drawable.icon_star_grey);
        imgStarRed = getResources().getDrawable(R.drawable.red_star_shadow);
        RecyclerView tips_rv = view.findViewById(R.id.rl_rating_tips_recycler);
        RecyclerView praise_rv = view.findViewById(R.id.rl_rating_praise_recycler);
        CardView button = view.findViewById(R.id.ll_rating_cardButton);
        LinearLayout address = view.findViewById(R.id.rl_rating_ll_rating_address);

        starList = new ArrayList<>();
        starList.add(star1 = view.findViewById(R.id.ll_rating_star_image1));
        starList.add(star2 = view.findViewById(R.id.ll_rating_star_image2));
        starList.add(star3 = view.findViewById(R.id.ll_rating_star_image3));
        starList.add(star4 = view.findViewById(R.id.ll_rating_star_image4));
        starList.add(star5 = view.findViewById(R.id.ll_rating_star_image5));

        address.setVisibility(View.GONE);

        final RecyclerView praiseRecyclerView = praise_rv;
        try {
            RatingPraiseAdapter.RatingPraiseItems[] ratingPraiseItems = getRatingPraiseItems();
            List<RatingPraiseAdapter.RatingPraiseItems> ratingPraiseItemsList = new ArrayList<>(Arrays.asList(ratingPraiseItems));
            ratingPraiseAdapter = new RatingPraiseAdapter(ratingPraiseItemsList, getActivity().getBaseContext());
            praiseRecyclerView.setAdapter(ratingPraiseAdapter);
            praiseRecyclerView.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.HORIZONTAL, false ));
            praiseRecyclerView.setItemAnimator( new DefaultItemAnimator() );
        } catch ( NullPointerException e) {
            e.printStackTrace();
        }

        final RecyclerView tipsRecyclerView = tips_rv;
        try {
            ratingTipsAdapter = new RatingTipsAdapter(list, getActivity().getBaseContext());
            tipsRecyclerView.setAdapter(ratingTipsAdapter);
            tipsRecyclerView.setLayoutManager(
                    new LinearLayoutManager(getActivity().getBaseContext(), RecyclerView.HORIZONTAL, false));
            tipsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        } catch ( NullPointerException e) {
            Log.e(TAG, "onCreateView" +e.getMessage());
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((RatingTipsAdapter)ratingTipsAdapter).getSelectedItem();
                ((RatingPraiseAdapter)ratingPraiseAdapter).getSelectedItem();
//                for (int i=0;i<starList.size();i++){
//                    final int finalI = i;
//                    starList.get(i).setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            starList.get(finalI);
//                        }
//                    });
//                }
                Log.d(TAG, "onCreateView");
            }
        });

        star1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allStarsGrey();
                if(view.getId()==R.id.ll_rating_star_image1){
                    star1.setImageDrawable(imgStarRed);
                    selectItem = 0;
                }
            }
        });
        star2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allStarsGrey();
                if(view.getId()==R.id.ll_rating_star_image2){
                    star1.setImageDrawable(imgStarRed);
                    star2.setImageDrawable(imgStarRed);
                }
            }
        });
        star3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allStarsGrey();
                if(view.getId()==R.id.ll_rating_star_image3){
                    star1.setImageDrawable(imgStarRed);
                    star2.setImageDrawable(imgStarRed);
                    star3.setImageDrawable(imgStarRed);
                }
            }
        });
        star4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allStarsGrey();
                if(view.getId()==R.id.ll_rating_star_image4){
                    star1.setImageDrawable(imgStarRed);
                    star2.setImageDrawable(imgStarRed);
                    star3.setImageDrawable(imgStarRed);
                    star4.setImageDrawable(imgStarRed);
                }
            }
        });
        star5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allStarsGrey();
                if(view.getId()==R.id.ll_rating_star_image5){
                    star1.setImageDrawable(imgStarRed);
                    star2.setImageDrawable(imgStarRed);
                    star3.setImageDrawable(imgStarRed);
                    star4.setImageDrawable(imgStarRed);
                    star5.setImageDrawable(imgStarRed);
                }
            }
        });
       getTips();
       return view;
    }

    public  int getSelectedItem(){
        for (int i =0; i <= starList.size(); i++) {
            
        }
        return 1;
    }

    private void allStarsGrey(){
        for (int i = 0; i <= starList.size()-1; i++){
            starList.get(i).setImageDrawable(imgStarGrey);
        }
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
                    list.add(tip_index);
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

    private void postData(){
        final JsonObject jo = new JsonObject();
        jo.addProperty("order_uuid", "585f892b-dfa5-4d07-9bc7-546cc000fa34");
        jo.addProperty("value", String.valueOf(starList.get(1)));
        jo.addProperty("tip", list.get(4));
        Map<String, String> _mapHead = new ArrayMap<>();
        _mapHead.put("Accept-Charset", "UTF-8");
        _mapHead.put("Content-Type", "application/json;charset=" + "UTF-8");
        _mapHead.put("Authorization", "Bearer " + ACCESS_TOKEN);

        new QueryPost<JsonObject>(new QueryTemplate.CallBack<Integer, JsonObject, String>(){
            @Override
            public void asyncBefore() throws InterruptedException{}

            @Override
            public JsonObject async(String result) throws ClassCastException{
                try{
                    JsonParser jsonParser = new JsonParser();
                    return  jsonParser.parse(result).getAsJsonObject();
                }catch ( NullPointerException | JsonParseException e){
                    Log.e(TAG, "async: " +e.getMessage());
                }
                return null;
            }

            @Override
            public void sync(JsonObject result) {}

            @Override
            public void progress(Integer... status) {}

            @Override
            public void cancel(JsonObject result, Throwable throwable) {}
        }).addRequestPropertyHead(_mapHead)
                .setAsyncThreadPool(true)
                    .query("https://client.apis.stage.faem.pro/api/v2/order/rating", jo.toString());
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

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode != Activity.RESULT_OK){
            return;
        }
        if(requestCode == REQUEST_CODE_TOKEN){
            String new_token = data.getStringExtra("token");
            Context context = getActivity().getApplicationContext();
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            sharedPreferences.getString(TOKEN, new_token);
        }
    }

    static Intent newIntent(String new_token){
        Intent intent = new Intent();
        intent.putExtra("token", new_token);
        return intent;
    }
}