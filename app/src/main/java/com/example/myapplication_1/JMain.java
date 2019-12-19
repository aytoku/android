package com.example.myapplication_1;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class JMain
{
    public static void main(String[] args) throws Exception
    {
        String json = "{'id': 1, "
                + "'firstName': 'Gio',"
                + "'email': 'seturidee@mail.ru'}";


//        JsonElement jsonElement = new JsonParser().parse(json);
//        JsonObject jsonObject = jsonElement.getAsJsonObject();

        JsonObject jsonObject = new Gson().fromJson(json,JsonObject.class);
        System.out.println(jsonObject.get("id"));
        System.out.println(jsonObject.get("firstName"));
        System.out.println(jsonObject.get("email"));
    }
}
