package com.example.myapplication_1;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication_1.Fragments.AddPointFragment;
import com.example.myapplication_1.Fragments.AddressFragment;
import com.example.myapplication_1.Fragments.AlertFragment;
import com.example.myapplication_1.Fragments.CodeScreenFragment;
import com.example.myapplication_1.Fragments.DeployedMessagesFragment;
import com.example.myapplication_1.Fragments.OrderAcceptFragment;
import com.example.myapplication_1.Fragments.RatingFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        AddressFragment addressFragment = AddressFragment.getInstance(null);

        RatingFragment ratingFragment = RatingFragment.getInstance(null);

        AddPointFragment addPointFragment = AddPointFragment.getInstance(null);

        AlertFragment alertFragment = AlertFragment.getInstance(null);

        CodeScreenFragment codeScreenFragment = CodeScreenFragment.getInstance(null);

        DeployedMessagesFragment deployedMessagesFragment = DeployedMessagesFragment.getInstance(null);

        OrderAcceptFragment orderAcceptFragment = OrderAcceptFragment.getInstance(null);

        getSupportFragmentManager().beginTransaction().add(R.id.ll_main, ratingFragment, RatingFragment.TAG).hide(ratingFragment);

        getSupportFragmentManager().beginTransaction().add(R.id.ll_main, addressFragment, AddressFragment.TAG).hide(addressFragment);

        getSupportFragmentManager().beginTransaction().add(R.id.ll_main, addPointFragment, AddPointFragment.TAG).hide(addressFragment);

        getSupportFragmentManager().beginTransaction().add(R.id.ll_main, alertFragment, AlertFragment.TAG).hide(alertFragment);

        getSupportFragmentManager().beginTransaction().add(R.id.ll_main, codeScreenFragment, CodeScreenFragment.TAG).hide(codeScreenFragment);

        getSupportFragmentManager().beginTransaction().add(R.id.ll_main, deployedMessagesFragment, DeployedMessagesFragment.TAG).hide(deployedMessagesFragment);

        getSupportFragmentManager().beginTransaction().add(R.id.ll_main, orderAcceptFragment, OrderAcceptFragment.TAG).commit();

//        Bundle args = new Bundle();
//        args.putInt("key_rating_star", 5);
//        args.putInt("key_tips_farm", 60);
//        args.putString("key_praise_driver","Вежливый");
    }
}