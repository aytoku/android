package com.example.myapplication_1.Fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.RatingAdapter;
import com.example.myapplication_1.Adapters.RatingAdapterCard;
import com.example.myapplication_1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RatingFragment extends Fragment {


    public static final String TAG = "RatingFragment";

    public static RatingFragment getInstance(Bundle args) {

        RatingFragment f = new RatingFragment();
        f.setArguments(args);

        return f;
    }

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
    private ImageView[] starArr;
    private Drawable imgStarGrey;
    private Drawable imgStarRed;
    private CardView button;
    private ImageView star;
    private String tips;
    private int praice;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.rating,
                container, false);

        imgStarGrey = getResources().getDrawable(R.drawable.icon_star_grey);
        imgStarRed = getResources().getDrawable(R.drawable.red_star_shadow);

        rv = view.findViewById(R.id.cl_rating_rl_rating_recycler1);

        rv1 = view.findViewById(R.id.cl_rating_rl_rating_recycler);

        starArr = new ImageView[]{
                star1 = view.findViewById(R.id.cl_rating_ll_rating_red_star1),
                star2 = view.findViewById(R.id.cl_rating_ll_rating_red_star2),
                star3 = view.findViewById(R.id.cl_rating_ll_rating_red_star3),
                star4 = view.findViewById(R.id.cl_rating_ll_rating_red_star4),
                star5 = view.findViewById(R.id.cl_rating_ll_rating_red_star5)
        };

        button = view.findViewById(R.id.cl_rating_ll_rating1_cardButton);

        final RecyclerView recyclerViewMenu = rv;

        try {

            RatingAdapter.AdapterGridViewMenu.ItemsMenu[] itemsMenu = getMenuItems();
            itemsMenuList = new ArrayList<>(Arrays.asList(itemsMenu));
            adapterGridViewMenu = new RatingAdapter.AdapterGridViewMenu(itemsMenuList, getActivity().getBaseContext());
            recyclerViewMenu.setAdapter(adapterGridViewMenu);
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.HORIZONTAL, false ));
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }

        final RecyclerView recyclerViewMenu1 = rv1;

        try {

            RatingAdapterCard.AdapterGridViewMenu.ItemsMenu1[] itemsMenu1 = getMenuItems1();
            itemsMenuList1 = new ArrayList<>(Arrays.asList(itemsMenu1));
            adapterGridViewMenu1 = new RatingAdapterCard.AdapterGridViewMenu(itemsMenuList1, getActivity().getBaseContext());
            recyclerViewMenu1.setAdapter(adapterGridViewMenu1);
            recyclerViewMenu1.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.HORIZONTAL, false ));
            recyclerViewMenu1.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }

        star1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                allStarsGrey();
                if(view.getId()==R.id.cl_rating_ll_rating_red_star1){
                    star1.setImageDrawable(imgStarRed);
                }

            }
        });

        star2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                allStarsGrey();
                if(view.getId()==R.id.cl_rating_ll_rating_red_star2){

                    star1.setImageDrawable(imgStarRed);
                    star2.setImageDrawable(imgStarRed);

                }
            }
        });

        star3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                allStarsGrey();
                if(view.getId()==R.id.cl_rating_ll_rating_red_star3) {

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
                if(view.getId()==R.id.cl_rating_ll_rating_red_star4) {

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
                if(view.getId()==R.id.cl_rating_ll_rating_red_star5) {

                    star1.setImageDrawable(imgStarRed);
                    star2.setImageDrawable(imgStarRed);
                    star3.setImageDrawable(imgStarRed);
                    star4.setImageDrawable(imgStarRed);
                    star5.setImageDrawable(imgStarRed);
                }
            }
        });

        send();
        return view;
    }

    public void allStarsGrey(){

        for (int i = 0; i <= starArr.length-1; i++){
            starArr[i].setImageDrawable(imgStarGrey);
            star = starArr[i];
        }
    }

    public void send(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(star);
                System.out.println(tips);
                System.out.println(praice);
            }
        });
    }

    private RatingAdapter.AdapterGridViewMenu.ItemsMenu[] getMenuItems() {

        RatingAdapter.AdapterGridViewMenu.ItemsMenu[] arr = new RatingAdapter.AdapterGridViewMenu.ItemsMenu[]{

                new RatingAdapter.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        R.mipmap.finger,
                        "Вежливость",
                        new RatingAdapter.AdapterGridViewMenu.ItemsMenu.CallBack() {
                            @Override
                            public void call(RatingAdapter.AdapterGridViewMenu.ItemsMenu itemsMenu) {
                                try{
                                    itemsMenu.getStr();
                                    praice = itemsMenu.getStr();

                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                ),

                new RatingAdapter.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        R.mipmap.face,
                        "Вежливость",
                        new RatingAdapter.AdapterGridViewMenu.ItemsMenu.CallBack() {
                            @Override
                            public void call(RatingAdapter.AdapterGridViewMenu.ItemsMenu itemsMenu) {
                                try{
                                    itemsMenu.getStr();
                                    praice = itemsMenu.getStr();

                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                ),

                new RatingAdapter.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        R.mipmap.handshake,
                        "Вежливость",
                        new RatingAdapter.AdapterGridViewMenu.ItemsMenu.CallBack() {
                            @Override
                            public void call(RatingAdapter.AdapterGridViewMenu.ItemsMenu itemsMenu) {
                                try{
                                    itemsMenu.getStr();
                                    praice = itemsMenu.getStr();

                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                ),

                new RatingAdapter.AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        R.mipmap.handshake,
                        "Вежливость",
                        new RatingAdapter.AdapterGridViewMenu.ItemsMenu.CallBack() {
                            @Override
                            public void call(RatingAdapter.AdapterGridViewMenu.ItemsMenu itemsMenu) {
                                try{
                                    itemsMenu.getStr();
                                    praice = itemsMenu.getStr();

                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                )
        };
        return arr;
    }

    private RatingAdapterCard.AdapterGridViewMenu.ItemsMenu1[] getMenuItems1(){

        RatingAdapterCard.AdapterGridViewMenu.ItemsMenu1[] arr1 = new RatingAdapterCard.AdapterGridViewMenu.ItemsMenu1[]{

                new RatingAdapterCard.AdapterGridViewMenu.ItemsMenu1(
                        getResources().getColor(R.color.my_gray),
                        "10 \u20BD",
                        new RatingAdapterCard.AdapterGridViewMenu.ItemsMenu1.CallBack(){
                            @Override
                            public void call(RatingAdapterCard.AdapterGridViewMenu.ItemsMenu1 itemsMenu) {
                                try{

                                    itemsMenu.getStr();
                                    tips = itemsMenu.getStr();

                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                ),

                new RatingAdapterCard.AdapterGridViewMenu.ItemsMenu1(
                        getResources().getColor(R.color.my_gray),
                        "20 \u20BD",
                        new RatingAdapterCard.AdapterGridViewMenu.ItemsMenu1.CallBack(){
                            @Override
                            public void call(RatingAdapterCard.AdapterGridViewMenu.ItemsMenu1 itemsMenu) {
                                try{

                                    itemsMenu.getStr();
                                    tips = itemsMenu.getStr();

                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                ),

                new RatingAdapterCard.AdapterGridViewMenu.ItemsMenu1(
                        getResources().getColor(R.color.my_gray),
                        "30 \u20BD",
                        new RatingAdapterCard.AdapterGridViewMenu.ItemsMenu1.CallBack(){
                            @Override
                            public void call(RatingAdapterCard.AdapterGridViewMenu.ItemsMenu1 itemsMenu) {
                                try{

                                    itemsMenu.getStr();
                                    tips = itemsMenu.getStr();

                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                ),

                new RatingAdapterCard.AdapterGridViewMenu.ItemsMenu1(
                        getResources().getColor(R.color.my_gray),
                        "40 \u20BD",
                        new RatingAdapterCard.AdapterGridViewMenu.ItemsMenu1.CallBack(){
                            @Override
                            public void call(RatingAdapterCard.AdapterGridViewMenu.ItemsMenu1 itemsMenu) {
                                try{

                                    itemsMenu.getStr();
                                    tips = itemsMenu.getStr();

                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                )
        };
        return arr1;
    }
}