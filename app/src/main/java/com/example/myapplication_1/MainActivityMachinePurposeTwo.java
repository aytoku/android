package com.example.myapplication_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityMachinePurposeTwo extends AppCompatActivity {

    ImageButton button;
    ImageButton button1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);


        setContentView(R.layout.cell_machine_purpose2);

        button = findViewById(R.id.ll_machine_purpose2_img_button);

        button1 = findViewById(R.id.ll_machine_purpose2_img_button2);

        addListener();
        addListener2();
    }

    public void addListener(){

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityMachinePurposeTwo.this, MainActivityPaymentChange.class );
                startActivity(intent);
            }
        });
    }

    public void addListener2(){

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityMachinePurposeTwo.this, MainActivityTripDetails.class );
                startActivity(intent);
            }
        });
    }

}
