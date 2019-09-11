package com.example.myapplication_1;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

public class SplashActivity extends Activity {
    private TextView textView;
    private Handler handler;
    private long startTime, currentTime, finishedTime = 0L;
    private int duration = 22000 / 4;// 1 character is equal to 1 second. if want to
    // reduce. can use as divide
    // by 2,4,8
    private int endTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.test);
        textView = (TextView) findViewById(R.id.textView1);
        textView.setText("Loading.Please wait...");// length of string is 22
        handler = new Handler();
        startTime = Long.valueOf(System.currentTimeMillis());
        currentTime = startTime;

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                    currentTime = Long.valueOf(System.currentTimeMillis());

                    finishedTime = Long.valueOf(currentTime) - Long.valueOf(startTime);


                    if (finishedTime >= duration + 30) {
                        Toast.makeText(SplashActivity.this, "Move to next screen",
                                Toast.LENGTH_LONG).show();
                    } else {
                        endTime = (int) (finishedTime / 250);// divide this by
                        // 1000,500,250,125
                        Spannable spannableString = new SpannableString(textView
                                .getText());
                        spannableString.setSpan(new ForegroundColorSpan(
                                        Color.YELLOW), 0, endTime,
                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                        textView.setText(spannableString);
                        handler.postDelayed(this, 10);
                    }
                  }
        }, 10);
    }
}