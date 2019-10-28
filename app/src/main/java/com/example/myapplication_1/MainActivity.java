package com.example.myapplication_1;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication_1.Fragments.AddressFragment;
import com.example.myapplication_1.Fragments.RatingFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        AddressFragment addressFragment = AddressFragment.getInstance(null);

        RatingFragment ratingFragment = RatingFragment.getInstance(null);

        getSupportFragmentManager().beginTransaction().add(R.id.ll_main, ratingFragment, RatingFragment.TAG).commit();

        getSupportFragmentManager().beginTransaction().add(R.id.ll_main, addressFragment, AddressFragment.TAG).hide(addressFragment);


        Bundle args = new Bundle();
        args.putInt("key_rating_star", 5);
        args.putInt("key_tips_farm", 60);
        args.putString("key_praise_driver","Вежливый");
    }
}