package com.example.myapplication_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication_1.Fragments.MachinePurposeTwoFragment;

public class TripDetailsFragment extends AppCompatActivity {

    ImageButton button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.trip_details);

        button = findViewById(R.id.rl_order_details_button);
        addListener();
    }

    public void addListener(){

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TripDetailsFragment.this, MachinePurposeTwoFragment.class );
                startActivity(intent);
            }
        });
    }
}
