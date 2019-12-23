package com.example.myapplication_1.JSON;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ru.osety.amironlibrary.Query.QueryPost;
import ru.osety.amironlibrary.Query.QueryTemplate;

public class Authorization extends AppCompatActivity {

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

}