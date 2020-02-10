package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.TripDetailsAdapter;
import com.example.myapplication_1.R;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ru.osety.amironlibrary.Query.QueryGet;
import ru.osety.amironlibrary.Query.QueryTemplate;

public class TripDetailsFragment extends Fragment {

    public static final String TAG = "TripDetailsFragment";
    private int street_index;
    List<String>list = new ArrayList<>();
    TripDetailsAdapter tripDetailsAdapter;

    public static TripDetailsFragment getInstance(Bundle args) {

        TripDetailsFragment tripDetailsFragment = new TripDetailsFragment();
        tripDetailsFragment.setArguments(args);

        return tripDetailsFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.trip_details,
                container, false);

        ImageButton button = view.findViewById(R.id.rl_order_details_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                MachinePurposeLowerPartFragment machinePurposeLowerPartFragment = MachinePurposeLowerPartFragment.getInstance(bundle);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, machinePurposeLowerPartFragment);
                fragmentTransaction.commit();
            }
        });

        final RecyclerView trip_details_title_rv = view.findViewById(R.id.ll_trip_details_title_recycler);
        try{
            TripDetailsAdapter.TripDetailsItems[] tripDetailsItems = getTripDetailsItems();
            tripDetailsAdapter = new TripDetailsAdapter(tripDetailsItems, getActivity().getApplicationContext());
            trip_details_title_rv.setAdapter( tripDetailsAdapter );
            trip_details_title_rv.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ) );
            trip_details_title_rv.setItemAnimator( new DefaultItemAnimator() );
        } catch ( NullPointerException e) {
            e.printStackTrace();
        }

   //     getData();

        return view;
    }

    private TripDetailsAdapter.TripDetailsItems[] getTripDetailsItems() {
        TripDetailsAdapter.TripDetailsItems[] arr = new TripDetailsAdapter.TripDetailsItems[]{
                new TripDetailsAdapter.TripDetailsItems(
                        "Водитель", new String[]{"Гаглоев Игорь Борисович", "Серый LADA 2114, A944 PK 15", "+7 (988) 839-57-11"}),
                new TripDetailsAdapter.TripDetailsItems(
                        "Поездка", new String[]{"улица Бзарова, 27/2", "улица Налалихина, 47"}),
                new TripDetailsAdapter.TripDetailsItems(
                        "Время", new String[]{"Сегодня в 22:26"}),
                new TripDetailsAdapter.TripDetailsItems(
                        "Стоимость", new String[]{"Эконом", "121 \u20BD"}),
                new TripDetailsAdapter.TripDetailsItems(
                        "Оплата", new String[]{"Visa 0729"}),
        };
        return arr;
    }

    private void getData(){
        final JsonObject jo = new JsonObject();
        Map<String, String> _mapHead = new ArrayMap<>();
        _mapHead.put("Accept-Charset", "UTF-8");
        _mapHead.put("Content-Type", "application/json;charset=" + "UTF-8");
        //_mapHead.put("Authorization", "Bearer" + TOKEN);
        new QueryGet<JsonObject>(new QueryTemplate.CallBack<Integer, JsonObject, String>() {
            @Override
            public void asyncBefore() throws InterruptedException {
            }

            @Override
            public JsonObject async(String result) throws ClassCastException {
                try {
                    result = "\"uuid\": \"9b637b25-93ff-4780-8c65-430302c52a78\",\n" +
                            "    \"comment\": \"Просит побыстрей\",\n" +
                            "    \"routes\": [\n" +
                            "        {\n" +
                            "            \"unrestricted_value\": \"Наш супермаркет Х.Мамсурова, Мамсурова Хаджи 42\",\n" +
                            "            \"value\": \"Наш супермаркет Х.Мамсурова\",\n" +
                            "            \"country\": \"\",\n" +
                            "            \"region\": \"\",\n" +
                            "            \"region_type\": \"\",\n" +
                            "            \"type\": \"\",\n" +
                            "            \"city\": \"Владикавказ\",\n" +
                            "            \"city_type\": \"\",\n" +
                            "            \"street\": \"Хаджи Мамсурова\",\n" +
                            "            \"street_type\": \"\",\n" +
                            "            \"street_with_type\": \"\",\n" +
                            "            \"house\": \"42\",\n" +
                            "            \"out_of_town\": false,\n" +
                            "            \"house_type\": \"\",\n" +
                            "            \"accuracy_level\": 0,\n" +
                            "\t\t\t\t\t\t\"comment\": \"к ржавой калитке\",\n" +
                            "            \"radius\": 10000,\n" +
                            "            \"lat\": 43.036274,\n" +
                            "            \"lon\": 44.655212\n" +
                            "        },\n" +
                            "        {\n" +
                            "            \"unrestricted_value\": \"Привоз , Академика Шегрена 40\",\n" +
                            "            \"value\": \"Привоз \",\n" +
                            "            \"country\": \"\",\n" +
                            "            \"region\": \"\",\n" +
                            "            \"region_type\": \"\",\n" +
                            "            \"type\": \"\",\n" +
                            "            \"city\": \"Владикавказ\",\n" +
                            "            \"city_type\": \"\",\n" +
                            "            \"street\": \"Академика Шегрена\",\n" +
                            "            \"street_type\": \"\",\n" +
                            "            \"street_with_type\": \"\",\n" +
                            "            \"house\": \"40\",\n" +
                            "            \"out_of_town\": false,\n" +
                            "\t\t\t\t\t\t\"comment\": \"к ржавой калитке\",\n" +
                            "            \"house_type\": \"\",\n" +
                            "            \"accuracy_level\": 0,\n" +
                            "            \"radius\": 10000,\n" +
                            "            \"lat\": 43.033966,\n" +
                            "            \"lon\": 44.6944\n" +
                            "        }\n" +
                            "    ]";
                }catch( NullPointerException | JsonParseException e){
                    Log.e(TAG, "async: " +e.getMessage());
                }
                JsonParser jsonParser = new JsonParser();
                return  jsonParser.parse(result).getAsJsonObject();
            }

            @Override
            public void sync(JsonObject result) {

//                JsonArray street = result.getAsJsonArray("value");
//                for(JsonElement i: street){
//                    street_index = i.getAsInt();
//                }

                String uuid = "uu_id";
                try {
                    uuid = result.get("uuid").getAsString();
                }catch (NullPointerException| JsonParseException e){
                    Log.e(TAG, "sync" + e.getMessage());
                }

                String comment = "com";
                try {
                    comment = result.get("comment").getAsString();
                }catch (NullPointerException| JsonParseException e){
                    Log.e(TAG, "sync" + e.getMessage());
                }
            }

            @Override
            public void progress(Integer... status) {}

            @Override
            public void cancel(JsonObject result, Throwable throwable) {}
        }).addRequestPropertyHead(_mapHead)
                .setAsyncThreadPool(true)
                    .query("https://client.apis.stage.faem.pro/api/v2/orders/order_uuid", jo.toString());
    }
}