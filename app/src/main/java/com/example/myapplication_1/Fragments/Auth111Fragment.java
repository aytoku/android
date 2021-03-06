package com.example.myapplication_1.Fragments;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.ArrayMap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication_1.R;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import java.util.Map;

import ru.osety.amironlibrary.Query.QueryPost;
import ru.osety.amironlibrary.Query.QueryTemplate;

import static android.app.Activity.RESULT_OK;

public class Auth111Fragment extends Fragment {

    public static final String TAG = "Auth111Fragment";
    private EditText editText;
    private TextView button;
    private static final int SECOND_ACTIVITY_REQUEST_CODE = 1;

    public static Auth111Fragment getInstance(Bundle args) {

        Auth111Fragment auth111Fragment = new Auth111Fragment();
        auth111Fragment.setArguments(args);

        return auth111Fragment;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.auth_1_1_1,
                container, false);

        button = view.findViewById(R.id.cl_auth_1_1_1_button1);
        TextView agreement = view.findViewById(R.id.cl_auth_1_1_1_desc);
        agreement.setText(Html.fromHtml("Нажимая кнопку 'Далее', вы принимаете условия\n<u>пользовательского соглашения</u> и <u>политики\nконфиденцальности</u>"));
        editText = view.findViewById(R.id.cl_auth_1_1_1_editTextNumber);
        ImageButton imageButton = view.findViewById(R.id.cl_auth_1_1_1_image_button);
        final TextView country_code = view.findViewById(R.id.cl_auth_1_1_1_button);

        final int[] len = {0};
        final int[] len1 = {0};
        final int[] len2 = {0};
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                int i = editText.getText().toString().length();

                if (i < 4)
                    len[0] = 0;
                if (i == 4 && len[0] < 5) {
                    len[0] = 5;
                    String ss = s.toString();
                    String first = ss.substring(0, ss.length() - 1);
                    String last = ss.substring(ss.length() - 1);
                    editText.setText(first + " " + last);
                    editText.setSelection(editText.getText().length());
                }
                if (i < 8)
                    len1[0] = 0;
                if (i == 8 && len1[0] < 9) {
                    len1[0] = 9;
                    String ss = s.toString();
                    String first = ss.substring(0, ss.length() - 1);
                    String last = ss.substring(ss.length() - 1);
                    editText.setText(first + "-" + last);
                    editText.setSelection(editText.getText().length());
                }
                if (i < 11)
                    len2[0] = 0;
                if (i == 11 && len2[0] < 12) {
                    len2[0] = 12;
                    String ss = s.toString();
                    String first = ss.substring(0, ss.length() - 1);
                    String last = ss.substring(ss.length() - 1);
                    editText.setText(first + "-" + last);
                    editText.setSelection(editText.getText().length());
                }
                if(editText.length()>0){
                    button.setBackgroundDrawable(getResources().getDrawable(R.drawable.myredbutton));
                }else{
                    button.setBackgroundDrawable(getResources().getDrawable(R.drawable.mybuttongrey));
                }
            }
        });
        agreement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebViewFragment webViewFragment = WebViewFragment.getInstance(null);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, webViewFragment);
                fragmentTransaction.commit();
            }
        });
        Bundle bundle1 = new Bundle();
        final CountryCodeSelectionFragment countryCodeSelectionFragment = CountryCodeSelectionFragment.getInstance(bundle1);
        final Menu11Fragment menu11Fragment = Menu11Fragment.getInstance(bundle1);
        country_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, countryCodeSelectionFragment);
                fragmentTransaction.commit();

                Bundle bundle = getArguments();
                String message = bundle.getString("message");
                country_code.setText(message);
            }
        });


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, menu11Fragment);
                fragmentTransaction.commit();
            }
        });
        sendNumber();
        return view;
    }

    private void sendNumber(){
        JsonObject jo = new JsonObject();
        jo.addProperty("device_id", "ffewqewe");
        jo.addProperty("phone", "+79998887766");
        Map<String, String> _mapHead = new ArrayMap<>();
        _mapHead.put("Accept-Charset", "UTF-8");
        _mapHead.put("Content-Type", "application/json;charset=" + "UTF-8");

        new QueryPost<JsonObject>(new QueryTemplate.CallBack<Integer, JsonObject, String>() {
            @Override
            public void asyncBefore() throws InterruptedException {}

            @Override
            public JsonObject async(String result) throws ClassCastException {
                try{
                    JsonParser jsonParser = new JsonParser();
                    return  jsonParser.parse(result).getAsJsonObject();
                }catch( NullPointerException | JsonParseException e){
                    Log.e(TAG, "async: " +e.getMessage());
                }
                return null;
            }

            @Override
            public void sync(JsonObject result) {
                int code = -1;
                try {
                   code = result.get("code").getAsInt();
                }catch (NullPointerException | JsonParseException e){
                    Log.e(TAG, "sync: " +e.getMessage());
                }
                if(code == 200){
                    int next_request_time = -1;
                    try {
                        next_request_time = result.get("next_request_time").getAsInt();
                    }catch (NullPointerException | JsonParseException e){
                        Log.e(TAG, "sync: " +e.getMessage());
                    }
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Bundle bundle = new Bundle();
                            final Menu11Fragment menu11Fragment = Menu11Fragment.getInstance(bundle);
                            String message = editText.getText().toString();
                            bundle.putString("message", message);
                            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.rl_main, menu11Fragment);
                            fragmentTransaction.commit();
                        }
                    });
                }else{
                    String message = "message";
                    try {
                        message = result.get("message").getAsString();
                    }catch (NullPointerException | JsonParseException e){
                        Log.e(TAG, "sync: " +e.getMessage());
                    }
                        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void progress(Integer... status) {}

            @Override
            public void cancel(JsonObject result, Throwable throwable) {}
        }).addRequestPropertyHead(_mapHead)
                .setAsyncThreadPool(true)
                    .query("https://client.apis.stage.faem.pro/api/v2/auth/new", jo.toString());
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String returnString = data.getStringExtra("keyName");
                TextView textView = getView().findViewById(R.id.cl_auth_1_1_1_button);
                textView.setText(returnString);
            }
        }
    }
    static Intent newIntent(String phone_number){
        Intent intent = new Intent();
        intent.putExtra("phone_number", phone_number);
        return intent;
    }
}