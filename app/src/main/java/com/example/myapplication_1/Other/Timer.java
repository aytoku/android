package com.example.myapplication_1.Other;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.myapplication_1.R;

public class Timer extends Activity {

    private TextView textView;
    private ProgressBar progressBar;
    private Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer);


        textView = findViewById(R.id.textViewCounter);
        progressBar = findViewById(R.id.progress_bar);
        button = findViewById(R.id.timer_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CountDownTimer(6000, 1000) {
                    @Override
                    public void onTick(long l) {
                        textView.setText("" + l);
                        progressBar.setProgress((int)1/1000);
                    }

                    @Override
                    public void onFinish() {
                        textView.setText("_");
                    }
                }.start();
            }
        });
    }
}
