package com.example.myapplication_1;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ru.osety.amironlibrary.Query.QueryPost;
import ru.osety.amironlibrary.Query.QueryTemplate;

public class JsonActivity  extends AppCompatActivity {

    protected void main(String[] args){

        final String json_authorization = "{\n" +
                "  \"device_id\": \"ffewqewe\",\n" +
                "  \"phone\": \"+79998887766\"\n" +
                "}";

        new QueryPost<JsonObject>(new QueryTemplate.CallBack<Integer, JsonObject, String>() {
            @Override
            public void asyncBefore() throws InterruptedException {

            }

            @Override
            public JsonObject async(String result) throws ClassCastException {
                JsonParser jsonParser = new JsonParser();
                JsonElement jsonElement = jsonParser.parse(json_authorization).getAsJsonObject();
                JsonObject jsonObject = jsonElement.getAsJsonObject();
               // String firstName = jsonObject.get("firstName").getAsString();

                return jsonObject;
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
        }).query("https://crm.apis.stage.faem.pro/api/v2", json_authorization.toString());
    }
}

//        JsonParser jsonParser = new JsonParser();
//        String json = "[\\n" +
//                "    {\\n" +
//                "      \"firstName\": \"Gio\",\\n" +
//                "      \"age\": 21,\\n" +
//                "       \"mail\": \"seturidee@mail.ru\"\\n" +
//                "    }]";
//        JsonElement jsonElement = jsonParser.parse(json).getAsJsonArray();
//        JsonObject jsonObject = jsonElement.getAsJsonObject();
//        String firstName = jsonObject.get("firstName").getAsString();
//        System.out.println(firstName);