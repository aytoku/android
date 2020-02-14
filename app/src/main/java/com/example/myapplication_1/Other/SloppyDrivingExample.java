package com.example.myapplication_1.Other;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication_1.R;

public class SloppyDrivingExample extends Fragment {

    public static final String TAG = "SloppyDrivingExample";

    public static SloppyDrivingExample getInstance(Bundle args) {

        SloppyDrivingExample sloppyDrivingExample = new SloppyDrivingExample();
        sloppyDrivingExample.setArguments(args);

        return sloppyDrivingExample;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.sloppy_driving_example,
                container, false);
        final Bundle bundle = new Bundle();
        final SloppyDrivingErrorExample sloppyDrivingErrorExample = SloppyDrivingErrorExample.getInstance(bundle);

        final TextView textView = view.findViewById(R.id.sloppy_driving_title);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = textView.getText().toString();
                bundle.putString("message", message);
                sloppyDrivingErrorExample.setArguments(bundle);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, sloppyDrivingErrorExample);
                fragmentTransaction.commit();
            }
        });
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String message = textView.getText().toString();
//                sendResult(message);
//                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//                fragmentTransaction.replace(R.id.rl_main, sloppyDrivingErrorExample);
//                fragmentTransaction.commit();
//            }
//        });


        return view;
    }

//    private void sendResult(String message) {
//        if( getTargetFragment() == null ) {
//            return;
//        }
//        Intent intent = PaymentMethodFragment.newIntent(message);
//        getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, intent);
//    }
}