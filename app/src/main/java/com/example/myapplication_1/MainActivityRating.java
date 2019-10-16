package com.example.myapplication_1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.RatingAdapter;
import com.example.myapplication_1.Adapters.RatingAdapterCard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivityRating extends AppCompatActivity {

    RecyclerView rv;
    RecyclerView rv1;
    RecyclerView.Adapter adapterGridViewMenu;
    RecyclerView.Adapter adapterGridViewMenu1;
    private List<RatingAdapter.AdapterGridViewMenu.ItemsMenu> itemsMenuList;
    private List<RatingAdapterCard.AdapterGridViewMenu.ItemsMenu1> itemsMenuList1;
    private ImageView star1;
    private ImageView star2;
    private ImageView star3;
    private ImageView star4;
    private ImageView star5;
    private boolean isRed = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.rating);

        final Drawable imgStarGrey = getResources().getDrawable(R.drawable.icon_star_grey);
        final Drawable imgStarRed = getResources().getDrawable(R.drawable.red_star_shadow);

        rv = findViewById(R.id.cl_rating_rl_rating_recycler1);

        rv1 = findViewById(R.id.cl_rating_rl_rating_recycler);

        star1 = findViewById(R.id.cl_rating_ll_rating_red_star1);
        star2 = findViewById(R.id.cl_rating_ll_rating_red_star2);
        star3 = findViewById(R.id.cl_rating_ll_rating_red_star3);
        star4 = findViewById(R.id.cl_rating_ll_rating_red_star4);
        star5 = findViewById(R.id.cl_rating_ll_rating_red_star5);

        final RecyclerView recyclerViewMenu = rv;

        try {

            RatingAdapter.AdapterGridViewMenu.ItemsMenu[] itemsMenu = getMenuItems();
            itemsMenuList = new ArrayList<>(Arrays.asList(itemsMenu));
            adapterGridViewMenu = new RatingAdapter.AdapterGridViewMenu(itemsMenuList, getBaseContext());
            recyclerViewMenu.setAdapter(adapterGridViewMenu);
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getBaseContext(), RecyclerView.HORIZONTAL, false ));
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }

        final RecyclerView recyclerViewMenu1 = rv1;

        try {

            RatingAdapterCard.AdapterGridViewMenu.ItemsMenu1[] itemsMenu1 = getMenuItems1();
            itemsMenuList1 = new ArrayList<>(Arrays.asList(itemsMenu1));
            adapterGridViewMenu1 = new RatingAdapterCard.AdapterGridViewMenu(itemsMenuList1, getBaseContext());
            recyclerViewMenu1.setAdapter(adapterGridViewMenu1);
            recyclerViewMenu1.setLayoutManager(
                    new LinearLayoutManager( getBaseContext(), RecyclerView.HORIZONTAL, false ));
            recyclerViewMenu1.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }

        star1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isRed = !isRed){

                    star1.setImageDrawable(imgStarRed);
                }else{
                    star1.setImageDrawable(imgStarGrey);
                }

            }
        });

        star2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isRed =! isRed){

                star1.setImageDrawable(imgStarRed);
                star2.setImageDrawable(imgStarRed);

                }else{

                    star2.setImageDrawable(imgStarGrey);
                }
            }
        });

        star3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isRed =! isRed) {

                    star1.setImageDrawable(imgStarRed);
                    star2.setImageDrawable(imgStarRed);
                    star3.setImageDrawable(imgStarRed);

                }else{

                    star3.setImageDrawable(imgStarGrey);
                }
            }
        });

        star4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isRed =! isRed) {

                    star1.setImageDrawable(imgStarRed);
                    star2.setImageDrawable(imgStarRed);
                    star3.setImageDrawable(imgStarRed);
                    star4.setImageDrawable(imgStarRed);
                }else{

                    star4.setImageDrawable(imgStarGrey);
                }
            }
        });

        star5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isRed =! isRed) {

                    star1.setImageDrawable(imgStarRed);
                    star2.setImageDrawable(imgStarRed);
                    star3.setImageDrawable(imgStarRed);
                    star4.setImageDrawable(imgStarRed);
                    star5.setImageDrawable(imgStarRed);
                }else{

                    star5.setImageDrawable(imgStarGrey);
                }
            }
        });
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {

        return super.onCreateView(parent, name, context, attrs);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    private RatingAdapter.AdapterGridViewMenu.ItemsMenu[] getMenuItems() {

        RatingAdapter.AdapterGridViewMenu.ItemsMenu[] arr = new RatingAdapter.AdapterGridViewMenu.ItemsMenu[]{

                new RatingAdapter.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "\uD83D\uDC4F",
                        "Вежливость"),

                new RatingAdapter.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "\uD83D\uDC4F",
                        "Вежливость"),

                new RatingAdapter.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "\uD83D\uDC4F",
                        "Вежливость"),

                new RatingAdapter.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "\uD83D\uDC4F",
                        "Вежливость")
        };
        return arr;
    }

    private RatingAdapterCard.AdapterGridViewMenu.ItemsMenu1[] getMenuItems1(){



        RatingAdapterCard.AdapterGridViewMenu.ItemsMenu1[] arr1 = new RatingAdapterCard.AdapterGridViewMenu.ItemsMenu1[]{

                new RatingAdapterCard.AdapterGridViewMenu.ItemsMenu1(
                        getResources().getColor(R.color.my_gray),
                        "10 \u20BD"),

                new RatingAdapterCard.AdapterGridViewMenu.ItemsMenu1(
                        getResources().getColor(R.color.my_gray),
                        "20 \u20BD"),


                new RatingAdapterCard.AdapterGridViewMenu.ItemsMenu1(
                        getResources().getColor(R.color.my_gray),
                        "40 \u20BD"),

                new RatingAdapterCard.AdapterGridViewMenu.ItemsMenu1(
                        getResources().getColor(R.color.my_gray),
                        "60 \u20BD"),

                new RatingAdapterCard.AdapterGridViewMenu.ItemsMenu1(
                        getResources().getColor(R.color.my_gray),
                        "80 \u20BD"),
        };

        return arr1;
    }
}

