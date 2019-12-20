package com.example.myapplication_1;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonActivity  extends AppCompatActivity {

    protected void main(String[] args){

        JsonParser jsonParser = new JsonParser();
        String json = "[\\n" +
                "    {\\n" +
                "      \"firstName\": \"Gio\",\\n" +
                "      \"age\": 21,\\n" +
                "       \"mail\": \"seturidee@mail.ru\"\\n" +
                "    }]";
        JsonElement jsonElement = jsonParser.parse(json).getAsJsonArray();
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String firstName = jsonObject.get("firstName").getAsString();
        System.out.println(firstName);
    }
}