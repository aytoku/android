package com.example.myapplication_1.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication_1.Alerts.DialogTestFragment;
import com.example.myapplication_1.R;

public class SendTestFragment extends Fragment {
    public static final String TAG = SendTestFragment.class.getSimpleName();
    private static final int TARGET_FRAGMENT_REQUEST_CODE = 1;
    private static final String EXTRA_GREETING_MESSAGE = "message";

    TextView showGreetingsTextView;

    public static SendTestFragment getInstance() {
        SendTestFragment fragment = new SendTestFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.send_test_fragment, container, false);

        Button button = view.findViewById(R.id.show_dialog_fragment_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
        showGreetingsTextView = view.findViewById(R.id.show_greetings_text_view);

        return view;
    }
    protected void showDialog() {
        DialogTestFragment dialogTestFragment = DialogTestFragment.getInstance();
        dialogTestFragment.show(getFragmentManager(), DialogTestFragment.TAG);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if( resultCode != Activity.RESULT_OK ) {
            return;
        }
        if( requestCode == TARGET_FRAGMENT_REQUEST_CODE ) {
            String greeting = data.getStringExtra(EXTRA_GREETING_MESSAGE);
            showGreetingsTextView.setText(greeting);
        }
    }

    public static Intent newIntent(String message) {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_GREETING_MESSAGE, message);
        return intent;
    }

}
