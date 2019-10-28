package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.myapplication_1.R;

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

    return view;

    }
}
