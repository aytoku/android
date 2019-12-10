package com.example.myapplication_1.Fragments;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication_1.R;

import static android.app.Activity.RESULT_OK;

public class Auth111Fragment extends Fragment {

    public static final String TAG = "Auth111Fragment";

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

        return view;
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