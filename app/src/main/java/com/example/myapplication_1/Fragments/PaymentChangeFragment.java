package com.example.myapplication_1.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication_1.R;

public class PaymentChangeFragment extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.payment_change);

        button = findViewById(R.id.ll_payment_change_button);

        addListener();
    }

    public void addListener(){

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentChangeFragment.this, MachinePurposeTwoFragment.class );
                startActivity(intent);
            }
        });
    }
}
