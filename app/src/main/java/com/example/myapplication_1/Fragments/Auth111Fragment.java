package com.example.myapplication_1.Fragments;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication_1.MainActivityCountryCodeSelection;
import com.example.myapplication_1.R;

public class Auth111Fragment extends AppCompatActivity {

    TextView textView;
    EditText editText;
    TextView button;
    private static final int SECOND_ACTIVITY_REQUEST_CODE = 1;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.auth_1_1_1);

        button = findViewById(R.id.cl_auth_1_1_1_button1);

        textView = findViewById(R.id.cl_auth_1_1_1_button);

        editText = findViewById(R.id.cl_auth_1_1_1_editTextNumber);

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

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Auth111Fragment.this, MainActivityCountryCodeSelection.class);
                startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {

                String returnString = data.getStringExtra("keyName");

                TextView textView = findViewById(R.id.cl_auth_1_1_1_button);
                textView.setText(returnString);
            }
        }
    }
}
