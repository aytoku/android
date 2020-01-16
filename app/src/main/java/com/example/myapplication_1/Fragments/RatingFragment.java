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

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.auth0.android.jwt.Claim;
import com.auth0.android.jwt.JWT;
import com.example.myapplication_1.Adapters.RatingPraiseAdapter;
import com.example.myapplication_1.Adapters.RatingTipsAdapter;
import com.example.myapplication_1.ClassesForAdapters.PraiseList;
import com.example.myapplication_1.R;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ru.osety.amironlibrary.Query.QueryGet;
import ru.osety.amironlibrary.Query.QueryPost;
import ru.osety.amironlibrary.Query.QueryTemplate;

public class RatingFragment extends Fragment{

    public static final String TAG = "RatingFragment";
    private static final int REQUEST_CODE_TOKEN = 101;
    private RecyclerView.Adapter ratingTipsAdapter;
    private ImageView star1;
    private ImageView star2;
    private ImageView star3;
    private ImageView star4;
    private ImageView star5;
    private ImageView[] starArr;
    private Drawable imgStarGrey;
    private Drawable imgStarRed;
    List<Integer> list = new ArrayList<>();
    private List<PraiseList>praiseLists = new ArrayList<>();
    private int tip_index;
    //private String token;
    private static final String TOKEN = "Token";

    public static RatingFragment getInstance(Bundle args) {

        RatingFragment f = new RatingFragment();
        f.setArguments(args);
        return f;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.rating,
                container, false);

        imgStarGrey = getResources().getDrawable(R.drawable.icon_star_grey);
        imgStarRed = getResources().getDrawable(R.drawable.red_star_shadow);
        RecyclerView tips_rv = view.findViewById(R.id.cl_rating_rl_rating_recycler);
        RecyclerView praise_rv = view.findViewById(R.id.cl_rating_rl_rating_recycler1);
        CardView button = view.findViewById(R.id.ll_rating_cardButton);

        starArr = new ImageView[]{
                star1 = view.findViewById(R.id.ll_rating_red_star1),
                star2 = view.findViewById(R.id.ll_rating_red_star2),
                star3 = view.findViewById(R.id.ll_rating_red_star3),
                star4 = view.findViewById(R.id.ll_rating_red_star4),
                star5 = view.findViewById(R.id.ll_rating_red_star5)
        };

        final RecyclerView praiseRecyclerView = praise_rv;

        try {
            RecyclerView.Adapter ratingPraiseAdapter = new RatingPraiseAdapter(praiseLists, getActivity().getBaseContext());
            praiseRecyclerView.setAdapter(ratingPraiseAdapter);
            praiseRecyclerView.setLayoutManager(
                    new LinearLayoutManager(getActivity().getBaseContext(), RecyclerView.HORIZONTAL, false));
            praiseRecyclerView.setItemAnimator(new DefaultItemAnimator());

        } catch ( NullPointerException e) {
            Log.e(TAG, "onCreateView" +e.getMessage());
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

        star1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allStarsGrey();
                if(view.getId()==R.id.ll_rating_red_star1){
                    star1.setImageDrawable(imgStarRed);
                }
            }
        });

        star2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allStarsGrey();
                if(view.getId()==R.id.ll_rating_red_star2){
                    star1.setImageDrawable(imgStarRed);
                    star2.setImageDrawable(imgStarRed);
                }
            }
        });

        star3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allStarsGrey();
                if(view.getId()==R.id.ll_rating_red_star3){
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
                if(view.getId()==R.id.ll_rating_red_star4){
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
                if(view.getId()==R.id.ll_rating_red_star5){
                    star1.setImageDrawable(imgStarRed);
                    star2.setImageDrawable(imgStarRed);
                    star3.setImageDrawable(imgStarRed);
                    star4.setImageDrawable(imgStarRed);
                    star5.setImageDrawable(imgStarRed);
                }
            }
        });

        praiseLists.add(new PraiseList(R.mipmap.finger,"Вежливость"));
        praiseLists.add(new PraiseList(R.mipmap.face,"Вежливость"));
        praiseLists.add(new PraiseList(R.mipmap.handshake,"Вежливость"));
        praiseLists.add(new PraiseList(R.mipmap.handshake,"Вежливость"));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postData();
            }
        });
        getTips();

        return view;
    }

    private void allStarsGrey(){
        for (int i = 0; i <= starArr.length-1; i++){
            starArr[i].setImageDrawable(imgStarGrey);
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
                try {
                    JsonParser jsonParser = new JsonParser();
                    return  jsonParser.parse(result).getAsJsonObject();

                } catch ( NullPointerException | JsonParseException e) {
                    Log.e(TAG, "async: " +e.getMessage());
                }
                return null;
            }

            @Override
            public void sync(JsonObject result) {

                JsonArray tip_percent = result.getAsJsonArray("tip_percent");
                for (JsonElement i : tip_percent) {
                    tip_index = i.getAsInt();
                    list.add(tip_index);
                    ratingTipsAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void progress(Integer... status) {
            }

            @Override
            public void cancel(JsonObject result, Throwable throwable) {
            }
        }).addRequestPropertyHead(_mapHead)
            .setAsyncThreadPool(true)
                .query("https://client.apis.stage.faem.pro/api/v2/options", jsonObject.toString());
    }

    private void postData(){
        final JsonObject jo = new JsonObject();
        Map<String, String> _mapHead = new ArrayMap<>();
        _mapHead.put("Accept-Charset", "UTF-8");
        _mapHead.put("Content-Type", "application/json;charset=" + "UTF-8");

        new QueryPost<JsonObject>(new QueryTemplate.CallBack<Integer, JsonObject, String>() {
            @Override
            public void asyncBefore() throws InterruptedException {}

            @Override
            public JsonObject async(String result) throws ClassCastException {

                try {
                    JsonParser jsonParser = new JsonParser();
                    return  jsonParser.parse(result).getAsJsonObject();

                } catch ( NullPointerException | JsonParseException e) {
                    Log.e(TAG, "async: " +e.getMessage());
                }
                return null;
            }

            @Override
            public void sync(JsonObject result) {
                String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOjIsImNsaWVudF91dWlkIjoiNDMxYjNjNmQtZjdkNS00YjQ5LThlYzEtZTE0NjE1ZTVjZjAzIiwiZGV2aWNlX2lkIjoiZmZld3Fld2UiLCJwaG9uZSI6Iis3OTk5ODh3ODc3NjYiLCJleHAiOjE1Njc1MDI3OTAsImlhdCI6MTU2NzQ5NTU5MH0.nRqqasRhnkYjbmy-qadzXEs47SUzeb4R8yjfgmwIF7Y";
                Context context = getActivity().getApplicationContext();
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                sharedPreferences.getString(TOKEN, token);
                JWT jwt = new JWT(token);
                Claim claim = jwt.getClaim("uu_id");
                String s = claim.asString();
                String uuid = "uu_id";
                try {
                    uuid = result.get("uuid").getAsString();
                } catch ( NullPointerException | JsonParseException e) {
                    Log.e(TAG, "sync: " +e.getMessage());
                }

                int value = 0;
                try {
                    value = result.get("value").getAsInt();
                } catch ( NullPointerException | JsonParseException e) {
                    Log.e(TAG, "sync: " +e.getMessage());
                }

                int tip = 0;
                try {
                    tip = result.get("tip").getAsInt();
                } catch ( NullPointerException | JsonParseException e) {
                    Log.e(TAG, "sync: " +e.getMessage());
                }

                String comment = "com";
                try {
                    comment = result.get("comment").getAsString();
                } catch ( NullPointerException | JsonParseException e) {
                    Log.e(TAG, "sync: " +e.getMessage());
                }
            }

            @Override
            public void progress(Integer... status) {}

            @Override
            public void cancel(JsonObject result, Throwable throwable) {}
        }).addRequestPropertyHead(_mapHead)
                .setAsyncThreadPool(true)
                    .query("https://client.apis.stage.faem.pro/api/v2"+"/order/rating", jo.toString());
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