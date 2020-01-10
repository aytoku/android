package com.example.myapplication_1.Fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication_1.R;

import java.util.Objects;

public class SpinnerFragment extends Fragment {

    public static final String TAG = "SpinnerFragment";
    private String[] choose = {"Эконом", "Стандарт", "Не эконом"};
    private String[] choose_cities = {"Владикавказ", "Ногир", "Беслан"};
    ImageButton imageButton;
    private ImageView star1;
    private ImageView star2;
    private ImageView star3;
    private ImageView star4;
    private ImageView star5;
    private ImageView[] starArr;
    private Drawable imgStarGrey;
    private Drawable imgStarRed;

    public static SpinnerFragment getInstance(Bundle args) {

        SpinnerFragment f = new SpinnerFragment();
        f.setArguments(args);

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.information_partners,
                container, false);

        Spinner spinner = (Spinner) view.findViewById(R.id.choose);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Objects.requireNonNull(this.getActivity()), android.R.layout.simple_spinner_item, choose);

        Spinner spinner1 = (Spinner) view.findViewById(R.id.choose_cities);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, choose_cities);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner1.setAdapter(adapter1);


        imageButton = view.findViewById(R.id.rl_information_partners_button);

        imgStarGrey = getResources().getDrawable(R.drawable.icon_little_grey_star);
        imgStarRed = getResources().getDrawable(R.drawable.icon_little_red_star);

        starArr = new ImageView[]{
                star1 = view.findViewById(R.id.rl_information_partners_star1),
                star2 = view.findViewById(R.id.rl_information_partners_star2),
                star3 = view.findViewById(R.id.rl_information_partners_star3),
                star4 = view.findViewById(R.id.rl_information_partners_star4),
                star5 = view.findViewById(R.id.rl_information_partners_star5)
        };

        star1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allStarsGrey();
                if(view.getId()==R.id.rl_information_partners_star1){
                    star1.setImageDrawable(imgStarRed);
                }
            }
        });

        star2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                allStarsGrey();
                if(view.getId()==R.id.rl_information_partners_star2){
                    star1.setImageDrawable(imgStarRed);
                    star2.setImageDrawable(imgStarRed);
                }
            }
        });

        star3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                allStarsGrey();
                if(view.getId()==R.id.rl_information_partners_star3) {
                    star1.setImageDrawable(imgStarRed);
                    star2.setImageDrawable(imgStarRed);
                    star3.setImageDrawable(imgStarRed);
                }
            }
        });

        star4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                allStarsGrey();
                if(view.getId()==R.id.rl_information_partners_star4) {
                    star1.setImageDrawable(imgStarRed);
                    star2.setImageDrawable(imgStarRed);
                    star3.setImageDrawable(imgStarRed);
                    star4.setImageDrawable(imgStarRed);
                }
            }
        });

        star5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                allStarsGrey();
                if(view.getId()==R.id.rl_information_partners_star5) {
                    star1.setImageDrawable(imgStarRed);
                    star2.setImageDrawable(imgStarRed);
                    star3.setImageDrawable(imgStarRed);
                    star4.setImageDrawable(imgStarRed);
                    star5.setImageDrawable(imgStarRed);
                }
            }
        });

        Bundle _args = new Bundle();
        final Fragment partnersFragment = PartnersFragment.getInstance(_args);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ll_main, partnersFragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

    public void allStarsGrey(){

        for (int i = 0; i <= starArr.length-1; i++){
            starArr[i].setImageDrawable(imgStarGrey);
        }
    }
}