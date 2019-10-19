package com.example.myapplication_1;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityPaymentPick extends AppCompatActivity {

    private RelativeLayout toggleChecked;
    private RelativeLayout toggleUnchecked;
    private ImageView imgChecked;
    private ImageView imgUnchecked;
    private Drawable imgToggleGrey;
    private Drawable imgToggleRed;
    boolean f = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.payment_pick);

        imgToggleGrey = getResources().getDrawable(R.drawable.togle_uncheked);
        imgToggleRed = getResources().getDrawable(R.drawable.toggle_checked);

        toggleChecked = findViewById(R.id.rl_payment_pick_rl_visa);
        toggleUnchecked = findViewById(R.id.rl_payment_pick_rl_ruble);

        imgChecked = findViewById(R.id.rl_payment_ready_toggleChecked);
        imgUnchecked = findViewById(R.id.rl_payment_ready_toggleUnchecked);

        toggleChecked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(f =!f){
                    imgChecked.setImageDrawable(imgToggleRed);
                    imgUnchecked.setImageDrawable(imgToggleGrey);
                }
            }
        });

        toggleUnchecked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(f =!f){
                    imgUnchecked.setImageDrawable(imgToggleRed);
                    imgChecked.setImageDrawable(imgToggleGrey);
                }
            }
        });
    }
}