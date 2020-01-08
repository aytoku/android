package com.example.myapplication_1.Fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
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

import com.example.myapplication_1.Adapters.RatingAdapter;
import com.example.myapplication_1.Adapters.RatingAdapterCard;
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

public class RatingFragment extends Fragment {


    public static final String TAG = "RatingFragment";

    public static RatingFragment getInstance(Bundle args) {

        RatingFragment f = new RatingFragment();
        f.setArguments(args);

        return f;
    }

    RecyclerView rv;
    RecyclerView rv1;
    RecyclerView.Adapter ratingAdapter;
    RecyclerView.Adapter ratingCardAdapter;
    private List<RatingAdapter.ItemsMenu> itemsMenuList;
    private List<RatingAdapterCard.ItemsMenu1> itemsMenuList1;
    private ImageView star1;
    private ImageView star2;
    private ImageView star3;
    private ImageView star4;
    private ImageView star5;
    private ImageView[] starArr;
    private Drawable imgStarGrey;
    private Drawable imgStarRed;
    private CardView button;
    private ImageView star;
    private String tips;
    private int praise;
    List<Integer> list = new ArrayList<Integer>();
    int e;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.rating,
                container, false);

        imgStarGrey = getResources().getDrawable(R.drawable.icon_star_grey);
        imgStarRed = getResources().getDrawable(R.drawable.red_star_shadow);
        button = view.findViewById(R.id.cl_rating_ll_rating1_cardButton);
        rv = view.findViewById(R.id.cl_rating_rl_rating_recycler1);
        rv1 = view.findViewById(R.id.cl_rating_rl_rating_recycler);

        starArr = new ImageView[]{
                star1 = view.findViewById(R.id.cl_rating_ll_rating_red_star1),
                star2 = view.findViewById(R.id.cl_rating_ll_rating_red_star2),
                star3 = view.findViewById(R.id.cl_rating_ll_rating_red_star3),
                star4 = view.findViewById(R.id.cl_rating_ll_rating_red_star4),
                star5 = view.findViewById(R.id.cl_rating_ll_rating_red_star5)
        };

        final RecyclerView recyclerViewMenu = rv;

        try {
            RatingAdapter.ItemsMenu[] itemsMenu = getMenuItems();
            itemsMenuList = new ArrayList<>(Arrays.asList(itemsMenu));
            ratingAdapter = new RatingAdapter(itemsMenuList, getActivity().getBaseContext());
            recyclerViewMenu.setAdapter(ratingAdapter);
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager(getActivity().getBaseContext(), RecyclerView.HORIZONTAL, false));
            recyclerViewMenu.setItemAnimator(new DefaultItemAnimator());

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }

        final RecyclerView recyclerViewMenu1 = rv1;

        try {
            RatingAdapterCard.ItemsMenu1[] itemsMenu1 = getMenuItems1();
            itemsMenuList1 = new ArrayList<>(Arrays.asList(itemsMenu1));
            ratingCardAdapter = new RatingAdapterCard(itemsMenuList1, getActivity().getBaseContext());
            recyclerViewMenu1.setAdapter(ratingCardAdapter);
            recyclerViewMenu1.setLayoutManager(
                    new LinearLayoutManager(getActivity().getBaseContext(), RecyclerView.HORIZONTAL, false));
            recyclerViewMenu1.setItemAnimator(new DefaultItemAnimator());

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }

        star1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allStarsGrey();
                if(view.getId()==R.id.cl_rating_ll_rating_red_star1){
                    star1.setImageDrawable(imgStarRed);
                }
            }
        });

        star2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allStarsGrey();
                if(view.getId()==R.id.cl_rating_ll_rating_red_star2){

                    star1.setImageDrawable(imgStarRed);
                    star2.setImageDrawable(imgStarRed);
                }
            }
        });

        star3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allStarsGrey();
                if(view.getId()==R.id.cl_rating_ll_rating_red_star3) {

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
                if(view.getId()==R.id.cl_rating_ll_rating_red_star4) {

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
                if(view.getId()==R.id.cl_rating_ll_rating_red_star5) {

                    star1.setImageDrawable(imgStarRed);
                    star2.setImageDrawable(imgStarRed);
                    star3.setImageDrawable(imgStarRed);
                    star4.setImageDrawable(imgStarRed);
                    star5.setImageDrawable(imgStarRed);
                }
            }
        });

        send();

        getTips();
        getData();
        getStepsPercent();

        return view;
    }

    public void allStarsGrey(){

        for (int i = 0; i <= starArr.length-1; i++){
            starArr[i].setImageDrawable(imgStarGrey);
            star = starArr[i];
        }
    }

    public void send(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(star);
                System.out.println(tips);
                System.out.println(praise);
            }
        });
    }

    public void getTips(){
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

                String features_uuid = "uu_id";
                String features_name = "Name";
                String features_comment = "com";
                String features_tag = "TAG";
                JsonArray features = result.getAsJsonArray("features");
                JsonObject features_jo;
                for(int i = 0; i < features.size(); i++){
                    features_jo = (JsonObject) features.get(i);
                    features_uuid = features_jo.get("uuid").getAsString();
                    features_name = features_jo.get("name").getAsString();
                    features_comment = features_jo.get("comment").getAsString();
                    features_tag = features_jo.get("tag").getAsString();
                }

                String services_uuid = "uu_id";
                String services_name = "Name";
                String services_comment = "com";
                String services_tag = "TAG";
                JsonArray services = result.getAsJsonArray("services");
                JsonObject services_jo;
                for(int i = 0; i < services.size(); i++){
                    services_jo = (JsonObject) services.get(i);
                    services_uuid = services_jo.get("uuid").getAsString();
                    services_name = services_jo.get("name").getAsString();
                    services_comment = services_jo.get("comment").getAsString();
                    services_tag = services_jo.get("tag").getAsString();
                }

                String reason_name = "r_name";
                String reason_title = "r_title";
                String reason_image = "r_image";
                JsonArray reasons_for_cancel = result.getAsJsonArray("reasons_for_cancel");
                JsonObject reasons_for_cancel_jo;
                for(int i = 0; i < reasons_for_cancel.size(); i++){
                    services_jo = (JsonObject) reasons_for_cancel.get(i);
                    reason_name = services_jo.get("reason_name").getAsString();
                    reason_title = services_jo.get("reason_title").getAsString();
                    reason_image = services_jo.get("reason_image").getAsString();
                }


                JsonArray tip_percent = result.getAsJsonArray("tip_percent");
                for (JsonElement i : tip_percent) {
                    e = i.getAsInt();
                    list.add(e);
                    ratingCardAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void progress(Integer... status) {
            }

            @Override
            public void cancel(JsonObject result, Throwable throwable) {
            }
        }).addRequestPropertyHead(_mapHead).query("https://client.apis.stage.faem.pro/api/v2/options", jsonObject.toString());
    }

    public void getStepsPercent(){
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

                String step_percent = "s_percent";
                String step_comment = "s_comment";
                JsonArray steps_with_comment = result.getAsJsonArray("steps_with_comment");
                JsonObject steps_with_comment_jo;
                for(int i = 0; i < steps_with_comment.size(); i++){
                    steps_with_comment_jo = (JsonObject) steps_with_comment.get(i);
                    step_percent = steps_with_comment_jo.get("step_percent").getAsString();
                    step_comment = steps_with_comment_jo.get("step_comment").getAsString();
                }
            }

            @Override
            public void progress(Integer... status) {
            }

            @Override
            public void cancel(JsonObject result, Throwable throwable) {
            }
        }).addRequestPropertyHead(_mapHead).query("https://crm.apis.stage.faem.pro/api/v2/increasedfare", jsonObject.toString());
    }

    public void getData(){
        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("order_uuid", "585f892b-dfa5-4d07-9bc7-546cc000fa34");
        jsonObject.addProperty("value",2);
        jsonObject.addProperty("tip",23);
        jsonObject.addProperty("comment","рулил ногами");
        Map<String, String> _mapHead = new ArrayMap<>();
        _mapHead.put("Accept-Charset", "UTF-8");
        _mapHead.put("Content-Type", "application/json;charset=" + "UTF-8");
        new QueryPost<JsonObject>(new QueryTemplate.CallBack<Integer, JsonObject, String>() {
            @Override
            public void asyncBefore() throws InterruptedException {
            }

            @Override
            public JsonObject async(String result) throws ClassCastException {
                try {
                    JsonParser jsonParser = new JsonParser();
                    return jsonParser.parse(result).getAsJsonObject();
                }catch (NullPointerException | JsonParseException e){
                    Log.e(TAG, "async" + e.getMessage());
                }
                return null;
            }

            @Override
            public void sync(JsonObject result) {
            }

            @Override
            public void progress(Integer... status) {
            }

            @Override
            public void cancel(JsonObject result, Throwable throwable) {
            }
        }).addRequestPropertyHead(_mapHead).query("https://client.apis.stage.faem.pro/api/v2/order/rating", jsonObject.toString());
    }

    private RatingAdapter.ItemsMenu[] getMenuItems() {

        RatingAdapter.ItemsMenu[] arr = new RatingAdapter.ItemsMenu[]{

                new RatingAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        R.mipmap.finger,
                        "Вежливость",
                        new RatingAdapter.ItemsMenu.CallBack() {
                            @Override
                            public void call(RatingAdapter.ItemsMenu itemsMenu) {
                                try{
                                    itemsMenu.getStr();
                                    praise = itemsMenu.getStr();

                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                ),

                new RatingAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        R.mipmap.face,
                        "Вежливость",
                        new RatingAdapter.ItemsMenu.CallBack() {
                            @Override
                            public void call(RatingAdapter.ItemsMenu itemsMenu) {
                                try{
                                    itemsMenu.getStr();
                                    praise = itemsMenu.getStr();

                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                ),

                new RatingAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        R.mipmap.handshake,
                        "Вежливость",
                        new RatingAdapter.ItemsMenu.CallBack() {
                            @Override
                            public void call(RatingAdapter.ItemsMenu itemsMenu) {
                                try{
                                    itemsMenu.getStr();
                                    praise = itemsMenu.getStr();

                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                ),

                new RatingAdapter.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        R.mipmap.handshake,
                        "Вежливость",
                        new RatingAdapter.ItemsMenu.CallBack() {
                            @Override
                            public void call(RatingAdapter.ItemsMenu itemsMenu) {
                                try{
                                    itemsMenu.getStr();
                                    praise = itemsMenu.getStr();

                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                )
        };
        return arr;
    }

    private RatingAdapterCard.ItemsMenu1[] getMenuItems1(){

        RatingAdapterCard.ItemsMenu1[] arr1 = new RatingAdapterCard.ItemsMenu1[]{

                new RatingAdapterCard.ItemsMenu1(
                        getResources().getColor(R.color.my_gray),
                        list,
                        new RatingAdapterCard.ItemsMenu1.CallBack(){
                            @Override
                            public void call(RatingAdapterCard.ItemsMenu1 itemsMenu) {
                                try{
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                ),

                new RatingAdapterCard.ItemsMenu1(
                        getResources().getColor(R.color.my_gray),
                        list,
                        new RatingAdapterCard.ItemsMenu1.CallBack(){
                            @Override
                            public void call(RatingAdapterCard.ItemsMenu1 itemsMenu) {
                                try{
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                ),

                new RatingAdapterCard.ItemsMenu1(
                        getResources().getColor(R.color.my_gray),
                        list,
                        new RatingAdapterCard.ItemsMenu1.CallBack(){
                            @Override
                            public void call(RatingAdapterCard.ItemsMenu1 itemsMenu) {
                                try{
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                ),

                new RatingAdapterCard.ItemsMenu1(
                        getResources().getColor(R.color.my_gray),
                        list,
                        new RatingAdapterCard.ItemsMenu1.CallBack(){
                            @Override
                            public void call(RatingAdapterCard.ItemsMenu1 itemsMenu) {
                                try{
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                )
        };
        return arr1;
    }
}