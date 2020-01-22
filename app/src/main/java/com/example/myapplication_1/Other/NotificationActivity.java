package com.example.myapplication_1.Other;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.myapplication_1.R;

public class NotificationActivity extends AppCompatActivity {

    private static final int NOTIFY_ID = 101;
    private static String CHANNEL_ID = "Cat channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.notification);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder =
                        new NotificationCompat.Builder(NotificationActivity.this, CHANNEL_ID)
                                .setSmallIcon(R.drawable.icon_cross)
                                .setContentTitle("Напоминание")
                                .setContentText("Пора покормить кота")
                                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                NotificationManagerCompat notificationManager =
                        NotificationManagerCompat.from(NotificationActivity.this);
                notificationManager.notify(NOTIFY_ID, builder.build());
            }
        });
    }
}