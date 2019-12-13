package com.example.myapplication_1.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication_1.Adapters.PaymentMethodAdapter;
import com.example.myapplication_1.R;

public class NewCardFragment extends Fragment {

    public static final String TAG = "NewCardFragment";
    CardView cardView;

    public static NewCardFragment getInstance(Bundle args) {

        NewCardFragment f = new NewCardFragment();
        f.setArguments(args);

        return f;
    }

    EditText editText;
    EditText editText1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.new_card,
                container, false);

        ImageButton imageButton = view.findViewById(R.id.rl_new_card_button);
        editText = view.findViewById(R.id.ll_new_card_card_number_field);
        editText1 = view.findViewById(R.id.ll_new_card_term_field);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle _args = new Bundle();
                Fragment paymentMethodFragment = PaymentMethodFragment.getInstance(_args);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_main, paymentMethodFragment);
                fragmentTransaction.commit();
            }
        });

        final int[] len = {0};
        final int[] len1 = {0};
        final int[] len2 = {0};

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                int i = editText.getText().toString().length();
                if (i < 5)
                    len[0] = 0;
                if (i == 5 && len[0] < 6) {
                    len[0] = 6;
                    String ss = s.toString();
                    String first = ss.substring(0, ss.length() - 1);
                    String last = ss.substring(ss.length() - 1);
                    editText.setText(first + " " + last);
                    editText.setSelection(editText.getText().length());
                }

                if (i < 10)
                    len1[0] = 0;
                if (i == 10 && len1[0] < 10) {
                    len1[0] = 11;
                    String ss = s.toString();
                    String first = ss.substring(0, ss.length() - 1);
                    String last = ss.substring(ss.length() - 1);
                    editText.setText(first + " " + last);
                    editText.setSelection(editText.getText().length());
                }

                if (i < 15)
                    len2[0] = 0;
                if (i == 15 && len2[0] < 15) {
                    len2[0] = 16;
                    String ss = s.toString();
                    String first = ss.substring(0, ss.length() - 1);
                    String last = ss.substring(ss.length() - 1);
                    editText.setText(first + " " + last);
                    editText.setSelection(editText.getText().length());
                }
            }
        });

        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void afterTextChanged(Editable s) {
                int i = editText1.getText().toString().length();
                if (i < 3)
                    len[0] = 0;
                if (i == 3 && len[0] < 3) {
                    len[0] = 4;
                    String ss = s.toString();
                    String first = ss.substring(0, ss.length() - 1);
                    String last = ss.substring(ss.length() - 1);
                    editText1.setText(first + "/" + last);
                    editText1.setSelection(editText1.getText().length());
                }
            }
        });

        cardView = view.findViewById(R.id.ll_new_card_cardButton);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = editText.getText().toString();
                sendResult(message);
            }
        });

        return view;
    }

    private void sendResult(String message) {

        if( getTargetFragment() == null ) {
            return;
        }
        Intent intent = PaymentMethodFragment.newIntent(message);
        getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, intent);
    }

    public static class ItemsMenu extends PaymentMethodAdapter.ItemsMenu {
        String title;

        public ItemsMenu(String title){
            this.title = title;
        }
    }
}