package com.example.myapplication_1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CountryCodeSelectionExample extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);


        setContentView(R.layout.country_code_selection_example);

        onButtonClick();
    }
    public void onButtonClick() {

        // get the text from the EditText
        TextView textView = findViewById(R.id.ll_cell_country_code_selection_ll_cell_country_code_selection1_georgia_number_code);
        String stringToPassBack = textView.getText().toString();

        // put the String to pass back into an Intent and close this activity
        Intent intent = new Intent();
        intent.putExtra("keyName", stringToPassBack);
        setResult(RESULT_OK, intent);
        finish();
    }
}
