package com.example.myapplication_1.Alerts;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication_1.Fragments.BonusesFragment;
import com.example.myapplication_1.R;

public class PromoCodeAlert extends DialogFragment{

    public static final String TAG = "PromoCodeAlert";

    private EditText editText;

    public static PromoCodeAlert getInstance(Bundle args) {

        PromoCodeAlert promoCodeAlert = new PromoCodeAlert();
        promoCodeAlert.setArguments(args);

        return promoCodeAlert;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setStyle(DialogFragment.STYLE_NORMAL, R.style.AppTheme_NoActionBar);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        Log.i(TAG, "onCreateView: start");
        try {
            getDialog().getWindow().setBackgroundDrawableResource(android.R.drawable.screen_background_dark_transparent);
        } catch (NullPointerException npe) {
            Log.e(TAG, "onCreateView: " + npe.getMessage());
        }

        View view = inflater.inflate(R.layout.promo_code, container, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        editText = view.findViewById(R.id.rl_promo_code_edit_text);
        Button button = view.findViewById(R.id.rl_promo_code_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = editText.getText().toString();
                Bundle _args = new Bundle();
                BonusesFragment bonusesFragment = BonusesFragment.getInstance(_args);
                _args.putString("message", message);
                bonusesFragment.setArguments(_args);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main,bonusesFragment);
                fragmentTransaction.commit();
                dismiss();
            }
        });

        return view;
    }
}