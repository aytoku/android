package com.example.myapplication_1.Other;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.myapplication_1.R;

public class SloppyDrivingErrorExample extends Fragment {

    public static final String TAG = "SloppyDrivingErrorExample";
    private static final int REQUEST_CODE_DRIVER_TIPS = 101;
    private TextView textView;

    public static SloppyDrivingErrorExample getInstance(Bundle args) {

        SloppyDrivingErrorExample sloppyDrivingErrorExample = new SloppyDrivingErrorExample();
        sloppyDrivingErrorExample.setArguments(args);

        return sloppyDrivingErrorExample;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.sloppy_driving_error_example,
                container, false);

        textView = view.findViewById(R.id.sloppy_driving_error_title);

        Bundle bundle = getArguments();
        String message = bundle.getString("message");
        textView.setText(message);


        return view;
    }

//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (resultCode != Activity.RESULT_OK) {
//            return;
//        }
//        if (requestCode == REQUEST_CODE_DRIVER_TIPS) {
//            String messageDriver = data.getStringExtra("message");
//            textView.setText(messageDriver);
//        }
//    }
//
//    public static Intent newIntent(String message) {
//        Intent intent = new Intent();
//        intent.putExtra("message", message);
//        return intent;
//    }
}
