package com.example.myapplication_1.Alerts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.myapplication_1.Fragments.SendTestFragment;
import com.example.myapplication_1.R;

public class DialogTestFragment extends DialogFragment {

    public static final String TAG = DialogTestFragment.class.getSimpleName();
    private EditText greetingsEditText;

    public static DialogTestFragment getInstance() {
        DialogTestFragment fragment = new DialogTestFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_test_fragment, container, false);

        greetingsEditText = view.findViewById(R.id.greetings_edit_text);
        Button button = view.findViewById(R.id.greet_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendGreeting();
            }
        });
        return view;
    }

    private void sendGreeting() {
        String message = greetingsEditText.getText().toString();
        if( message.isEmpty() ) {
            Toast.makeText(getContext(), "Enter a message", Toast.LENGTH_SHORT).show();
            return;
        }
        sendResult(message);
    }

    private void sendResult(String message) {
        if( getTargetFragment() == null ) {
            return;
        }
        Intent intent = SendTestFragment.newIntent(message);
        getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, intent);
        dismiss();
    }
}