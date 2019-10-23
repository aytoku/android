package com.example.myapplication_1;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityAddress extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.address_layout);

        AddressFragment addressFragment = AddressFragment.getInstance(null);

        getSupportFragmentManager().beginTransaction().add(R.id.ll_address_layout, addressFragment, AddressFragment.TAG).commit();
    }
}
