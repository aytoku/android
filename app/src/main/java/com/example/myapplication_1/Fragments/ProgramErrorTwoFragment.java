package com.example.myapplication_1.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication_1.R;

public class ProgramErrorTwoFragment extends Fragment {

    public static final String TAG = "ProgramErrorTwoFragment";
    private static final int REQUEST_CODE = 101;
    private TextView title;
    ImageButton imageButton;

    public static ProgramErrorTwoFragment getInstance(Bundle args) {

        ProgramErrorTwoFragment programErrorTwoFragment = new ProgramErrorTwoFragment();
        programErrorTwoFragment.setArguments(args);

        return programErrorTwoFragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.programm_error_2,
                container, false);

        title = view.findViewById(R.id.rl_program_error1_title);
        Bundle _args = new Bundle();
        final Fragment menu162Fragment = Menu162Fragment.getInstance(_args);

        imageButton = view.findViewById(R.id.rl_program_error1_img);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, menu162Fragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

    public void onActivityResult(int resultCode, int requestCode, Intent intent){
        if(resultCode!= Activity.RESULT_OK){
            return;
        }
        if(requestCode == REQUEST_CODE){
            String message = intent.getStringExtra("message");
            title.setText(message);
        }
    }

    public static Intent newIntent(String message){
        Intent intent = new Intent();
        intent.putExtra("message", message);
        return intent;
    }
}