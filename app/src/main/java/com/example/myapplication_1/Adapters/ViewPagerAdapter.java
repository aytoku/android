package com.example.myapplication_1.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication_1.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<Bitmap> images = new ArrayList<>();
    private List<String> strings_title = new ArrayList<>();
    private List<String> strings_desc = new ArrayList<>();
    private Button button;

    public ViewPagerAdapter(Context context) throws IOException {
        this.context = context;

        InputStream in = context.getAssets().open("img/scene1.png");
        images.add(BitmapFactory.decodeStream(in));
        strings_title.add("Самообучающаяся система");
        strings_desc.add("нейронная сеть подбирает\nлучшие условия работы на основе\nваших данных");

        InputStream in1 = context.getAssets().open("img/scene2.png");
        images.add(BitmapFactory.decodeStream(in1));
        strings_title.add("Распределние заказов");
        strings_desc.add("новейший алгоритм распределения\nна основе предпочтений клиентов\nи водителей");

        InputStream in2 = context.getAssets().open("img/scene3.png");
        images.add(BitmapFactory.decodeStream(in2));
        strings_title.add("Добро пожаловать!");
    }

    @Override
    public int getCount(){
        return images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object){
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_layout, null);
        if (position == 0){

            view.setBackground(context.getResources().getDrawable(R.drawable.gradient_blue));
        }else if (position == 1){

            view.setBackground(context.getResources().getDrawable(R.drawable.gradient_green));
        }else{

            view.setBackground(context.getResources().getDrawable(R.drawable.gradient_red));
        }
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textView_title = view.findViewById(R.id.title_slider);
        TextView textView_desc = view.findViewById(R.id.description_slider);
        Button button = view.findViewById(R.id.slider_button);
        if(position == 2){
            button.setVisibility(view.VISIBLE);
        }else{
            button.setVisibility(view.GONE);
        }
        imageView.setImageBitmap(images.get(position));
        textView_title.setText(strings_title.get(position));

        if(position < 2){
            textView_desc.setText(strings_desc.get(position));
        }

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);
    }
}