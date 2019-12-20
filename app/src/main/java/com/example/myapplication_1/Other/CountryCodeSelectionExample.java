package com.example.myapplication_1.Other;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication_1.R;

public class CountryCodeSelectionExample extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.country_code_selection_example);

        onButtonClick();
    }

    public void onButtonClick() {

        TextView textView = findViewById(R.id.ll_cell_country_code_selection_ll_cell_country_code_selection1_georgia_number_code);
        String stringToPassBack = textView.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("keyName", stringToPassBack);
        setResult(RESULT_OK, intent);
        finish();
    }
}
