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
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.CalculationCostAdapter;
import com.example.myapplication_1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

        SpinnerFragment spinnerFragment = new SpinnerFragment();
        spinnerFragment.setArguments(args);

        return spinnerFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.information_partners,
                container, false);

        Spinner spinner = view.findViewById(R.id.choose);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Objects.requireNonNull(this.getActivity()), android.R.layout.simple_spinner_item, choose);
        Spinner spinner1 = view.findViewById(R.id.choose_cities);
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

        Bundle bundle = new Bundle();
        final PartnersFragment partnersFragment = PartnersFragment.getInstance(bundle);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, partnersFragment);
                fragmentTransaction.commit();
            }
        });

        RecyclerView information_partners_rv = view.findViewById(R.id.ll_information_partners_recycler);

        try {
            CalculationCostAdapter.CalculationCostItems[] calculationCostItems = getCalculationItems();
            List<CalculationCostAdapter.CalculationCostItems> calculationCostItemsList = new ArrayList<>(Arrays.asList(calculationCostItems));
            RecyclerView.Adapter calculationCostAdapter = new CalculationCostAdapter(calculationCostItemsList, getActivity().getBaseContext());
            information_partners_rv.setAdapter(calculationCostAdapter);
            information_partners_rv.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ));
            information_partners_rv.setItemAnimator( new DefaultItemAnimator() );
        } catch ( NullPointerException e) {
            e.printStackTrace();
        }

        return view;
    }

    private void allStarsGrey(){
        for (int i = 0; i <= starArr.length-1; i++){
            starArr[i].setImageDrawable(imgStarGrey);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    private CalculationCostAdapter.CalculationCostItems[] getCalculationItems() {
        CalculationCostAdapter.CalculationCostItems[] arr = new CalculationCostAdapter.CalculationCostItems[]{
                new CalculationCostAdapter.CalculationCostItems(
                        "",
                        "39 руб"
                ),
                new CalculationCostAdapter.CalculationCostItems(
                        "Бесплатное ожидание",
                        "3 мин"
                ),
                new CalculationCostAdapter.CalculationCostItems(
                        "Платное ожидание",
                        "4 руб/мин"
                ),
                new CalculationCostAdapter.CalculationCostItems(
                        "Стоимость по городу",
                        "4 руб/мин"
                ),
                new CalculationCostAdapter.CalculationCostItems(
                        "Стоимость загород",
                        "4 руб/мин"
                )
        };
        return arr;
    }
}