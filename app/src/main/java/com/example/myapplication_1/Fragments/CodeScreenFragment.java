package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.myapplication_1.R;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import ru.osety.amironlibrary.Query.QueryPost;
import ru.osety.amironlibrary.Query.QueryTemplate;

public class CodeScreenFragment extends Fragment {

    public static final String TAG = "CodeScreenFragment";

    public static CodeScreenFragment getInstance(Bundle args) {

        CodeScreenFragment f = new CodeScreenFragment();
        f.setArguments(args);

        return f;
    }

    EditText code_field1;
    EditText code_field2;
    EditText code_field3;
    EditText code_field4;
    TextView button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.code,
                container, false);

        code_field1 = view.findViewById(R.id.ll_code_screen1);
        code_field2 = view.findViewById(R.id.ll_code_screen2);
        code_field3 = view.findViewById(R.id.ll_code_screen3);
        code_field4 = view.findViewById(R.id.ll_code_screen4);


        code_field1.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()>1 &&  start==0){
                    code_field1.setText(s.subSequence(before, before+1));
                }
                if(s.length()>1 && start == 1){
                    code_field1.setText(s.subSequence(before+1,before+2));
                }
                else{
                    code_field2.requestFocus();
                }
           }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void afterTextChanged(final Editable s) {
                if(code_field1.length()>0){
                    button.setBackgroundDrawable(getResources().getDrawable(R.drawable.myredbutton));
                }else{
                    button.setBackgroundDrawable(getResources().getDrawable(R.drawable.mybuttongrey));
                }
            }
        });

        code_field2.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count) {

                if(s.length()>1 &&  start==0){
                    code_field2.setText(s.subSequence(before, before+1));
                }
                else if(s.length()>1 && start == 1){
                    code_field2.setText(s.subSequence(before+1,before+2));
                } else {
                    code_field3.requestFocus();
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void afterTextChanged(Editable s) {
                if(code_field2.length()>0){
                    button.setBackgroundDrawable(getResources().getDrawable(R.drawable.myredbutton));
                }else{
                    button.setBackgroundDrawable(getResources().getDrawable(R.drawable.mybuttongrey));
                }
            }
        });

        code_field2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if(keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_UP) {

                    code_field1.requestFocus();
                }
                return false;
            }
        });

        code_field3.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count) {
                if(s.length()>1 &&  start==0){
                    code_field3.setText(s.subSequence(before, before+1));
                }
               else if(s.length()>1 && start == 1){
                    code_field3.setText(s.subSequence(before+1,before+2));
                }
               else {
                    code_field4.requestFocus();
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void afterTextChanged(Editable s) {
                if(code_field3.length()>0){
                    button.setBackgroundDrawable(getResources().getDrawable(R.drawable.myredbutton));
                }else{
                    button.setBackgroundDrawable(getResources().getDrawable(R.drawable.mybuttongrey));
                }
            }
        });

        code_field3.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if(keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_UP) {

                    code_field2.requestFocus();
                }
                return false;
            }
        });

        code_field4.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count) {
                if(s.length()>1 &&  start==0){
                    code_field4.setText(s.subSequence(before, before+1));
                }
                else if(s.length()>1 && start == 1){
                    code_field4.setText(s.subSequence(before+1,before+2));
                }else{
                    code_field4.requestFocus();
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void afterTextChanged(Editable s) {
                if(code_field4.length()>0){
                    button.setBackgroundDrawable(getResources().getDrawable(R.drawable.myredbutton));
                }else{
                    button.setBackgroundDrawable(getResources().getDrawable(R.drawable.mybuttongrey));
                }
            }
        });

        code_field4.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if(keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_UP) {

                    code_field3.requestFocus();
                }
                return false;
            }
        });

        button = view.findViewById(R.id.cl_code_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendCode();
            }
        });

    return view;

    }

    public void sendCode(){
        JsonObject jo = new JsonObject();
        jo.addProperty("device_id", "ffewqewe");
        jo.addProperty("code", "1080");

        new QueryPost<JsonObject>(new QueryTemplate.CallBack<Integer, JsonObject, String>() {
            @Override
            public void asyncBefore() throws InterruptedException {

            }

            @Override
            public JsonObject async(String result) throws ClassCastException {
                try {

                    JsonParser jsonParser = new JsonParser();
                    JsonObject jsonObject = jsonParser.parse(result).getAsJsonObject();

                    return  jsonObject;
                } catch ( NullPointerException | JsonParseException e) {
                    Log.e(TAG, "async: " +e.getMessage());
                }
                return null;
            }

            @Override
            public void sync(JsonObject result) {


                int client_id = 0;
                try {
                    client_id = result.get("client_id").getAsInt();
                }catch ( NullPointerException | JsonParseException e) {
                    Log.e(TAG, "async: " +e.getMessage());
                }

                String token = "";
                try {
                    token = result.get("token").getAsString();
                }catch ( NullPointerException | JsonParseException e) {
                    Log.e(TAG, "async: " +e.getMessage());
                }

                String client_uuid = "";
                try {
                    client_uuid = result.get("client_uuid").getAsString();
                }catch ( NullPointerException | JsonParseException e) {
                    Log.e(TAG, "async: " +e.getMessage());
                }

                String refresh_token = "";
                try {
                    refresh_token = result.get("refresh_token").getAsString();
                }catch ( NullPointerException | JsonParseException e) {
                    Log.e(TAG, "async: " +e.getMessage());
                }

                String refresh_expiration = "";
                try {
                    refresh_expiration = result.get("refresh_expiration").getAsString();
                }catch ( NullPointerException | JsonParseException e) {
                    Log.e(TAG, "async: " +e.getMessage());
                }
            }

            @Override
            public void progress(Integer... status) {}

            @Override
            public void cancel(JsonObject result, Throwable throwable) {}
        }).query("https://crm.apis.stage.faem.pro/api/v2" + "/auth/verification", jo.toString());
    }
}
