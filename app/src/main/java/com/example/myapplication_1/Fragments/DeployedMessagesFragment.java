package com.example.myapplication_1.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.DeployedMessagesAdapter;
import com.example.myapplication_1.R;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import ru.osety.amironlibrary.Query.QueryPost;
import ru.osety.amironlibrary.Query.QueryTemplate;

public class DeployedMessagesFragment extends Fragment {

    public static final String TAG = "DeployedMessagesFragment";
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkcml2ZXJfaWQiOjAsImRyaXZlcl91dWlkIjoiYWIyNzc1MWUtYzI0Yi00NGNkLTkxZDItYmE3ZjBjNTQ0YzFjIiwiZGV2aWNlX2lkIjoiMzU4NDMwMTc3MzY1NjQiLCJwaG9uZSI6Iis3OTA2NDk0NTM2NSIsImV4cCI6MTU4MDE4NjAxNiwiaWF0IjoxNTgwMTE0MDE2fQ.qLggDus1ViBl3N38IMXWPB4y5smd9h8ylBfTU0yoFuk";
    private RecyclerView.Adapter deployedMessagesAdapter;
    private List<DeployedMessagesAdapter.DeployedMessagesItems> deployedMessagesItemsList;
    private List<String> list = new ArrayList<>();
    private int index;

    public static DeployedMessagesFragment getInstance(Bundle args) {

        DeployedMessagesFragment deployedMessagesFragment = new DeployedMessagesFragment();
        deployedMessagesFragment.setArguments(args);

        return deployedMessagesFragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.deployed_messages,
                container, false);

        RecyclerView deployedMessages_rv = view.findViewById(R.id.deployed_messages_recycler);

        final RecyclerView recyclerView = deployedMessages_rv;
        try {
            DeployedMessagesAdapter.DeployedMessagesItems[] deployedMessagesItems = getDeployedMessagesItems();
            deployedMessagesItemsList = new ArrayList<>(Arrays.asList(deployedMessagesItems));
            deployedMessagesAdapter = new DeployedMessagesAdapter(deployedMessagesItemsList, getActivity().getBaseContext());
            recyclerView.setAdapter(deployedMessagesAdapter);
            recyclerView.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ));
            recyclerView.setItemAnimator( new DefaultItemAnimator() );
        } catch ( NullPointerException e) {
            e.printStackTrace();
        }

        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder, @NotNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                int position = viewHolder.getAdapterPosition();
                deployedMessagesItemsList.remove(position);
                deployedMessagesAdapter.notifyDataSetChanged();
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(deployedMessages_rv);

        long created_at_unix = 1575376152;
        long current_date = new Date().getTime();
        long dif = current_date - created_at_unix;
        Date date = new Date(dif * 1000L);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT-4"));
        String s = simpleDateFormat.format(date);
        System.out.println(s);

        getText();
        return view;
    }

    private DeployedMessagesAdapter.DeployedMessagesItems[] getDeployedMessagesItems() {

        DeployedMessagesAdapter.DeployedMessagesItems[] arr = new DeployedMessagesAdapter.DeployedMessagesItems[]{

                new DeployedMessagesAdapter.DeployedMessagesItems(
                        "Выполните еще три заказа и получите\n+30 к рейтингу"),

                new DeployedMessagesAdapter.DeployedMessagesItems(
                        "Выполните еще три заказа и получите\n+30 к рейтингу"),

                new DeployedMessagesAdapter.DeployedMessagesItems(
                        "Как настроение?"),

                new DeployedMessagesAdapter.DeployedMessagesItems(
                        "Выполните еще три заказа и получите\n+30 к рейтингу"),

                new DeployedMessagesAdapter.DeployedMessagesItems(
                        "Выполните еще три заказа и получите\n+30 к рейтингу")
        };
        return arr;
    }

    private void getText(){
        final JsonObject jo = new JsonObject();
        Map<String, String> _mapHead = new ArrayMap<>();
        _mapHead.put("Accept-Charset", "UTF-8");
        _mapHead.put("Content-Type", "application/json;charset=" + "UTF-8");
        _mapHead.put("Authorization", "Bearer" + TOKEN);
        new QueryPost<JsonObject>(new QueryTemplate.CallBack<Integer, JsonObject, String>() {
            @Override
            public void asyncBefore() throws InterruptedException {}

            @SuppressLint("LongLogTag")
            @Override
            public JsonObject async(String result) throws ClassCastException {
                try {
                    result =
                            "  {\n" +
                            "    \"uuid\": \"bd8f7c60-80a4-4cc6-a6bf-a004b0b247dc\",\n" +
                            "    \"message\": \"Тест. Только для рафа\",\n" +
                            "    \"ack\": true,\n" +
                            "    \"order_uuid\": \"\",\n" +
                            "    \"driver_uuid\": \"96751bdf-9024-45da-82c5-a51f47b9efdb\",\n" +
                            "    \"created_at_unix\": 1575376152,\n" +
                            "    \"tag\": \"\"\n" +
                            "  }";
                    JsonParser jsonParser = new JsonParser();
                    return  jsonParser.parse(result).getAsJsonObject();
                }catch( NullPointerException | JsonParseException e){
                    Log.e(TAG, "async: " +e.getMessage());
                }
                return null;
            }

            @SuppressLint("LongLogTag")
            @Override
            public void sync(JsonObject result) {
                String message = "message";
                try {
                    message = result.get("message").getAsString();
                }catch (NullPointerException|JsonParseException e){
                    Log.e(TAG, "sync" + e.getMessage());
                }
                JsonArray tip_percent = result.getAsJsonArray("");
                for (JsonElement i : tip_percent){
                    index = i.getAsInt();
                    list.add(String.valueOf(index));
                    deployedMessagesAdapter.notifyDataSetChanged();
                }
                long created_at_unix = 0;
                try {
                    created_at_unix = result.get("created_at_unix").getAsLong();
                    long current_date = new Date().getTime();
                    long dif = current_date - created_at_unix;
                    Date date = new Date(dif * 1000L);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT-4"));
                    String s = simpleDateFormat.format(date);
                }catch (NullPointerException|JsonParseException e){
                    Log.e(TAG, "sync" + e.getMessage());
                }
            }

            @Override
            public void progress(Integer... status) {}

            @Override
            public void cancel(JsonObject result, Throwable throwable) {}
        }).addRequestPropertyHead(_mapHead)
                .setAsyncThreadPool(true)
                    .query("https://driver.apis.stage.faem.pro/api/v2/alerts/history", jo.toString());
    }
}