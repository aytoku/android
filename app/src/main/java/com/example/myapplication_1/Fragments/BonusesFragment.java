package com.example.myapplication_1.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication_1.Alerts.DriverTipsAlertNormal;
import com.example.myapplication_1.Alerts.PromoCodeAlert;
import com.example.myapplication_1.R;

public class BonusesFragment extends Fragment {

    public static final String TAG = "BonusesFragment";
    private static final int REQUEST_CODE_DRIVER_TIPS = 101;
    private TextView textView;

    public static BonusesFragment getInstance(Bundle args) {

        BonusesFragment bonusesFragment = new BonusesFragment();
        bonusesFragment.setArguments(args);

        return bonusesFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.bonuses,
                container, false);

        ImageView imageView = view.findViewById(R.id.rl_bonuses_img);
        RelativeLayout relativeLayout = view.findViewById(R.id.rl_enter_code);
        textView = view.findViewById(R.id.rl_bonuses_bonus);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                Menu11Fragment menu11Fragment = Menu11Fragment.getInstance(bundle);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, menu11Fragment);
                fragmentTransaction.commit();
            }
        });

        Bundle bundle = getArguments();
        String message = bundle.getString("message");
        int color = bundle.getInt(String.valueOf(Color.parseColor("#FD6F6D")));
        textView.setText(message);

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(view);
            }
        });

        return view;
    }

    private void showDialog(View view){
        PromoCodeAlert promoCodeAlert = PromoCodeAlert.getInstance(null);
        promoCodeAlert.setTargetFragment(BonusesFragment.this, REQUEST_CODE_DRIVER_TIPS);
        promoCodeAlert.show(getFragmentManager(), DriverTipsAlertNormal.TAG);
    }
}
