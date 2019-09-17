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

public class SplashActivity extends Activity {

    private TextView textView;
    private Handler handler;
    private long startTime, currentTime, finishedTime = 0L;
    int dColor = Color.rgb(192, 192, 192);
    private int duration = 8000 / 4;
    private int endTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.test);
        textView = (TextView) findViewById(R.id.textView1);
        textView.setText("Загрузка");
        handler = new Handler();
        startTime = System.currentTimeMillis();
        currentTime = startTime;

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                currentTime = System.currentTimeMillis();
                finishedTime = currentTime - startTime;

                if (finishedTime >= duration + 30) {
                    startTime = System.currentTimeMillis();

                    if( dColor != Color.rgb(192, 192, 192)){

                        dColor = Color.rgb(192, 192, 192);
                    }
                    else{
                        dColor = Color.BLACK;
                    }
                    handler.postDelayed(this, 0);

                }
                else {
                    endTime = (int) (finishedTime / 225);
                    Spannable spannableString = new SpannableString(textView.getText());
                    spannableString.setSpan(new ForegroundColorSpan(
                                    dColor), 0, endTime,
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    textView.setText(spannableString);
                    handler.postDelayed(this, 0);
                }
            }
        }, 0);
    }
}