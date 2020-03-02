package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.PaymentMethodAdapter;
import com.example.myapplication_1.R;

import java.util.List;

public class NewCardFragment extends Fragment {

    public static final String TAG = "NewCardFragment";
    static final String KEY_CARD_NUMBER = "Key_card_number";
    static final String KEY_DATE = "Key_date";
    static final String KEY_CVV = "Key_cvv";
    private EditText card_number;
    private EditText validity;

    public static NewCardFragment getInstance(Bundle args) {

        NewCardFragment newCardFragment = new NewCardFragment();
        newCardFragment.setArguments(args);

        return newCardFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.new_card,
                container, false);

        ImageButton imageButton = view.findViewById(R.id.rl_new_card_img);
        card_number = view.findViewById(R.id.ll_new_card_card_number_field);
        validity = view.findViewById(R.id.ll_new_card_term_field);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                PaymentMethodFragment paymentMethodFragment = PaymentMethodFragment.getInstance(bundle);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, paymentMethodFragment);
                fragmentTransaction.commit();
            }
        });

        final int[] n = {0};
        final int[] n1 = {0};
        final int[] n2 = {0};

        card_number.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void afterTextChanged(Editable s) {
                int i = card_number.getText().toString().length();
                if (i < 5)
                    n[0] = 0;
                    if (i == 5 && n[0] < 6) {
                        n[0] = 6;
                        String ss = s.toString();
                        String first = ss.substring(0, ss.length() - 1);
                        String last = ss.substring(ss.length() - 1);
                        card_number.setText(first + " " + last);
                        card_number.setSelection(card_number.getText().length());
                }

                if (i < 10)
                    n1[0] = 0;
                    if (i == 10 && n1[0] < 10) {
                        n1[0] = 11;
                        String ss = s.toString();
                        String first = ss.substring(0, ss.length() - 1);
                        String last = ss.substring(ss.length() - 1);
                        card_number.setText(first + " " + last);
                        card_number.setSelection(card_number.getText().length());
                }

                if (i < 15)
                    n2[0] = 0;
                    if (i == 15 && n2[0] < 15) {
                        n2[0] = 16;
                        String ss = s.toString();
                        String first = ss.substring(0, ss.length() - 1);
                        String last = ss.substring(ss.length() - 1);
                        card_number.setText(first + " " + last);
                        card_number.setSelection(card_number.getText().length());
                }
            }
        });

        validity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void afterTextChanged(Editable s) {
                int i = validity.getText().toString().length();
                if (i < 3)
                    n[0] = 0;
                    if (i == 3 && n[0] < 3) {
                        n[0] = 4;
                        String ss = s.toString();
                        String first = ss.substring(0, ss.length() - 1);
                        String last = ss.substring(ss.length() - 1);
                        validity.setText(first + "/" + last);
                        validity.setSelection(validity.getText().length());
                }
            }
        });
        return view;
    }
}