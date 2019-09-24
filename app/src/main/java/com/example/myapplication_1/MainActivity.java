package com.example.myapplication_1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ru.osety.amironlibrary.DrawableUtils;

    public class MainActivity extends AppCompatActivity {

        ImageButton androidImageButton;

        RecyclerView rv;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
             androidImageButton = (ImageButton) findViewById(R.id.img_cross_grey);

                setContentView(R.layout.main_recycler);

                rv = (RecyclerView) findViewById(R.id.recycler);
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
                        new LinearLayoutManager( getBaseContext(), RecyclerView.HORIZONTAL, false ) );
                recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

            } catch ( NullPointerException e) {
                e.printStackTrace();
            }
        }

        private AdapterGridViewMenu.ItemsMenu[] getMenuItems() {

            AdapterGridViewMenu.ItemsMenu []_arr = new AdapterGridViewMenu.ItemsMenu[]{

            new AdapterGridViewMenu.ItemsMenu(
                    getResources().getColor(R.color.my_gray),
                    R.mipmap.red_car,
                        "Эконом",
                    new AdapterGridViewMenu.ItemsMenu.CallBack() {
                @Override
                public void call(AdapterGridViewMenu.ItemsMenu itemsMenu) {

                    try {

                        Bundle _args = new Bundle();

                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
            }, "5 мин"),
                    new AdapterGridViewMenu.ItemsMenu(
                            getResources().getColor(R.color.my_gray),
                            R.mipmap.yellow_car,
                            "Стандарт",
                            new AdapterGridViewMenu.ItemsMenu.CallBack() {
                                @Override
                                public void call(AdapterGridViewMenu.ItemsMenu itemsMenu) {

                                    try {

                                        Bundle _args = new Bundle();

                                    } catch (NullPointerException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }, "2 мин"),
                    new AdapterGridViewMenu.ItemsMenu(
                            getResources().getColor(R.color.my_gray),
                            R.mipmap.grey_car,
                            "Комфорт",
                            new AdapterGridViewMenu.ItemsMenu.CallBack() {
                                @Override
                                public void call(AdapterGridViewMenu.ItemsMenu itemsMenu) {

                                    try {

                                        Bundle _args = new Bundle();

                                    } catch (NullPointerException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }, "8 мин"),
                    new AdapterGridViewMenu.ItemsMenu(
                            getResources().getColor(R.color.my_gray),
                            R.mipmap.minivan,
                            "Минивен",
                            new AdapterGridViewMenu.ItemsMenu.CallBack() {
                                @Override
                                public void call(AdapterGridViewMenu.ItemsMenu itemsMenu) {

                                    try {

                                        Bundle _args = new Bundle();

                                    } catch (NullPointerException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }, "15 мин")
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

                ViewGroup v = (ViewGroup) layoutInflater.inflate(R.layout.activity_main, viewGroup, false);
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

                viewHolder.img.setBackground( ic_rout_color );
                viewHolder.img.setScaleType(ImageView.ScaleType.CENTER);
                viewHolder.img.setImageBitmap( _bitmap );
                viewHolder.title.setText( _item.getStr() );
                viewHolder.time.setText( _item.getTime() );
                viewHolder.cv_item.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        try {

                            _item.getCallBack().call(_item);

                        } catch ( NullPointerException e) {
                            e.printStackTrace();
                        }

                    }
                });
            }

            @Override
            public int getItemCount() {
                return itemsMenu.length;
            }

            public static class ItemsMenu {

                public interface CallBack {
                    void call(ItemsMenu itemsMenu);
                }

                private @ColorInt int colorBackgroundInt;
                private int imgResId;
                private String str;
                private CallBack callBack;
                private String time;

                public ItemsMenu(int colorBackgroundRes, int imgResId, String str, CallBack callBack,String time) {
                    this.colorBackgroundInt = colorBackgroundRes;
                    this.imgResId = imgResId;
                    this.str = str;
                    this.callBack = callBack;
                    this.time = time;
                }

                public CallBack getCallBack() {
                    return callBack;
                }

                public int getImgResId() {
                    return imgResId;
                }

                public String getStr() {
                    return str;
                }

                public String getTime() {
                    return time;
                }

                public int getColorBackground() {
                    return colorBackgroundInt;
                }
            }

            class ViewHolder extends RecyclerView.ViewHolder {

                private final ImageView img;
                private final TextView title;
                private final CardView cv_item;
                private final TextView time;

                public ViewHolder(@NonNull View itemView) {
                    super(itemView);
                    cv_item = itemView.findViewById(R.id.cv_item);
                    img = itemView.findViewById(R.id.img);
                    title = itemView.findViewById(R.id.title);
                    time = itemView.findViewById(R.id.time);

                }
            }
        }
}

