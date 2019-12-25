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
    //private static final int NOTIFY_ID = 101;
    //private static String CHANNEL_ID = "Channel_id";
    TextView agreement;
    TextView alert;
    TextView country_code;

    public static Auth111Fragment getInstance(Bundle args) {

        Auth111Fragment f = new Auth111Fragment();
        f.setArguments(args);

        return f;
    }

    EditText editText;
    TextView button;
    private static final int SECOND_ACTIVITY_REQUEST_CODE = 1;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.auth_1_1_1,
                container, false);

        button = view.findViewById(R.id.cl_auth_1_1_1_button1);

        TextView textView = view.findViewById(R.id.cl_auth_1_1_1_button);
        agreement = view.findViewById(R.id.cl_auth_1_1_1_desc);
        agreement.setText(Html.fromHtml("Нажимая кнопку 'Далее', вы принимаете условия\n<u>пользовательского соглашения</u> и <u>политики\nконфиденцальности</u>"));

        alert = view.findViewById(R.id.cl_auth_1_1_1_text_alert);
        country_code = view.findViewById(R.id.text_number);

        editText = view.findViewById(R.id.cl_auth_1_1_1_editTextNumber);

        ImageButton imageButton = view.findViewById(R.id.cl_auth_1_1_1_image_button);

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

//                if(i > 6){
//                    alert.setText("Указан неверный номер");
//                    editText.setTextColor(Color.parseColor("#EE4D3F"));
//                    country_code.setTextColor(Color.parseColor("#EE4D3F"));
//                    alert.setTextColor(Color.parseColor("#EE4D3F"));
//                }else {
//                    alert.setVisibility(View.GONE);
//                    editText.setTextColor(Color.parseColor("#000000"));
//                    country_code.setTextColor(Color.parseColor("#000000"));
//                    alert.setTextColor(Color.parseColor("#000000"));
//                }

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
                fragmentTransaction.replace(R.id.ll_main, webViewFragment);
                fragmentTransaction.commit();
            }
        });


        Bundle _args = new Bundle();
        final Fragment countryCodeSelectionFragment = CountryCodeSelectionFragment.getInstance(_args);
        final Fragment menuOneFragment = MenuOneFragment.getInstance(_args);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_main, countryCodeSelectionFragment);
                fragmentTransaction.commit();
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_main, menuOneFragment);
                fragmentTransaction.commit();
            }
        });

        sendNumber();

        return view;
    }

    public void sendNumber(){
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
                            final CodeScreenFragment codeScreenFragment = new CodeScreenFragment();
                            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.ll_main, codeScreenFragment);
                            fragmentTransaction.commit();

//                            NotificationCompat.Builder builder =
//                                    new NotificationCompat.Builder(getActivity(), CHANNEL_ID)
//                                            .setContentText("1080")
//                                            .setPriority(NotificationCompat.PRIORITY_DEFAULT);
//
//                            NotificationManagerCompat notificationManager =
//                                    NotificationManagerCompat.from(getActivity());
//                            notificationManager.notify(NOTIFY_ID, builder.build());
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
        }).addRequestPropertyHead(_mapHead).query("https://client.apis.stage.faem.pro/api/v2" + "/auth/new", jo.toString());
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
}