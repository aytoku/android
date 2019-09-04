package com.example.myapplication_1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ru.osety.amironlibrary.DrawableUtils;

public class MainActivityWish extends AppCompatActivity {

    TextView textView;
    SeekBar seekBar;

    RecyclerView rv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.wishes);

        rv = findViewById(R.id.recycler_wishes);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        textView = (TextView) findViewById(R.id.txtView);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                textView.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

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


        RecyclerView recyclerViewMenu = rv;

        try {
            AdapterGridViewMenu.ItemsMenu[] itemsMenu = getMenuItems();//model_data

            AdapterGridViewMenu adapterGridViewMenu = new AdapterGridViewMenu(itemsMenu, getBaseContext());//this;
            recyclerViewMenu.setAdapter( adapterGridViewMenu );
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getBaseContext(), RecyclerView.VERTICAL, false ) );
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

            } catch ( NullPointerException e) {
                e.printStackTrace();
        }
    }



    private AdapterGridViewMenu.ItemsMenu[] getMenuItems() {

        AdapterGridViewMenu.ItemsMenu []_arr = new AdapterGridViewMenu.ItemsMenu[]{

                new AdapterGridViewMenu.ItemsMenu(getResources().getColor(R.color.my_gray),
                        R.mipmap.ic_launcher_round,
                        "30 \u20BD",
                         "Детское кресло"),
                new AdapterGridViewMenu.ItemsMenu(getResources().getColor(R.color.my_gray),
                        R.mipmap.ic_launcher_round,
                        "0 \u20BD",
                         "Курящий салон"),
                new AdapterGridViewMenu.ItemsMenu(getResources().getColor(R.color.my_gray),
                        R.mipmap.ic_launcher_round,
                        "10 \u20BD",
                        "Некурящий салон"),
                new AdapterGridViewMenu.ItemsMenu(getResources().getColor(R.color.my_gray),
                        R.mipmap.ic_launcher_round,
                        "10 \u20BD",
                        "Пустой багажник")
        };
        return _arr;
    }


    public static class AdapterGridViewMenu extends RecyclerView.Adapter<AdapterGridViewMenu.ViewHolder> {

        private final ItemsMenu[] itemsMenu;
        private final LayoutInflater layoutInflater;
        private final Context context;

        public AdapterGridViewMenu(AdapterGridViewMenu.ItemsMenu[] itemsMenu, Context context) {
            this.itemsMenu = itemsMenu;
            this.context = context;

            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            ViewGroup v = (ViewGroup) layoutInflater.inflate(R.layout.cell_wishes_model, viewGroup, false);
            return new ViewHolder(v);

        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

            final ItemsMenu _item = itemsMenu[i];

            Drawable ic_background_xml = context.getResources().getDrawable(R.mipmap.icon_car);
            float _dens = context.getResources().getDisplayMetrics().density;

            Drawable ic_rout_color = DrawableUtils.setTintDrawable(ic_background_xml, _item.getColorBackground());

            int _size = Math.round(_dens * 40);
            Drawable _def_draw = context.getResources().getDrawable(_item.getImgResId());
            Bitmap _bitmap = DrawableUtils.convertToBitmap(_def_draw, _size, _size);

          //  viewHolder.img.setBackground( ic_rout_color );
            //viewHolder.img.setScaleType(ImageView.ScaleType.CENTER);
            //viewHolder.img.setImageBitmap( _bitmap );
            viewHolder.desc.setText( _item.getStr() );
            viewHolder.cost.setText(_item.getCost());
        }

        @Override
        public int getItemCount() {
            return itemsMenu.length;
        }

        public static class ItemsMenu {


            private @ColorInt int colorBackgroundInt;
            private int imgResId;
            private String cost;
            private String desc;

            public ItemsMenu(int colorBackgroundRes, int imgResId, String cost,String desc) {
                this.colorBackgroundInt = colorBackgroundRes;
                this.imgResId = imgResId;
                this.cost = cost;
                this.desc = desc;
            }

            public int getImgResId() {
                return imgResId;
            }

            public String getStr() {
                return desc;
            }

            public String getCost() {
                return cost;
            }

            public int getColorBackground() {
                return colorBackgroundInt;
            }
        }


        class ViewHolder extends RecyclerView.ViewHolder {

            private final ImageView img;
            private final TextView desc;
            private final TextView cost;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                img = itemView.findViewById(R.id.img);
                desc = itemView.findViewById(R.id.desc);
                cost = itemView.findViewById(R.id.cost);
            }
        }
    }
}