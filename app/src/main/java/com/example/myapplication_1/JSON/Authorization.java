package com.example.myapplication_1.JSON;

import android.util.ArrayMap;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import java.util.Map;

import ru.osety.amironlibrary.Query.QueryGet;
import ru.osety.amironlibrary.Query.QueryPost;
import ru.osety.amironlibrary.Query.QueryTemplate;

public class Authorization extends AppCompatActivity {

    public static final String TAG = "Authorization";

    protected void main(String[] args){


        JsonObject jo2 = new JsonObject();

        new QueryPost<JsonObject>(new QueryTemplate.CallBack<Integer, JsonObject, String>() {
            @Override
            public void asyncBefore() throws InterruptedException {

            }

            @Override
            public JsonObject async(String result) throws ClassCastException {
                JsonParser jsonParser = new JsonParser();
                JsonObject jsonObject = jsonParser.parse(result).getAsJsonObject();

                return jsonObject;
            }

            @Override
            public void sync(JsonObject result) {
                String refresh = result.get("refresh").getAsString();
            }

            @Override
            public void progress(Integer... status) {

            }

            @Override
            public void cancel(JsonObject result, Throwable throwable) {

            }
        }).query("https://crm.apis.stage.faem.pro/api/v2" + "/auth/refresh", jo2.toString());
    }


    public void getStepsPercent(){
        final JsonObject jsonObject = new JsonObject();
        Map<String, String> _mapHead = new ArrayMap<>();
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


//                String features_uuid = "uu_id";
//                String features_name = "Name";
//                String features_comment = "com";
//                String features_tag = "TAG";
//                JsonArray features = result.getAsJsonArray("features");
//                JsonObject features_jo;
//                for(int i = 0; i < features.size(); i++){
//                    features_jo = (JsonObject) features.get(i);
//                    features_uuid = features_jo.get("uuid").getAsString();
//                    features_name = features_jo.get("name").getAsString();
//                    features_comment = features_jo.get("comment").getAsString();
//                    features_tag = features_jo.get("tag").getAsString();
//                }
}