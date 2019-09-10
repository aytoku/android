package com.example.myapplication_1;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivityCodeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.code_screen);

    }
    public void onFocus(){

        final List<EditText> listEditText = new ArrayList<>();
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.ll_code_screen);
        linearLayout.getChildCount();
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            if (linearLayout.getChildAt(i) instanceof EditText) {
                EditText editText = (EditText) linearLayout.getChildAt(i);
                listEditText.add(editText);
            }
        }
        for (int j = 0; j < linearLayout.getChildCount(); j++) {
                listEditText.get(j).addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                        if (editable.length() > 0) {
                            listEditText.get(1).setFocusable(true);
                        }
                    }
                } );
            }
        }
    }
