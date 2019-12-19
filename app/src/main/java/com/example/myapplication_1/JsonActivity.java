package com.example.myapplication_1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class JsonActivity  extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.json_parser);

 //       Gson gson = new Gson();
        JsonParser jsonParser = new JsonParser();
        String json = "[\\n" +
                "    {\\n" +
                "      \"firstname\": \"Gio\",\\n" +
                "      \"age\": 21,\\n" +
                "       \"mail\": \"seturidee@mail.ru\"\\n" +
                "    }]";
        JsonElement jsonElement = jsonParser.parse(json).getAsJsonArray();

    }
}
