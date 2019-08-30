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
import android.widget.Toast;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ru.osety.amironlibrary.DrawableUtils;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityTravelStory extends AppCompatActivity {

    ImageButton androidImageButton;

    RecyclerView rv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        androidImageButton = (ImageButton) findViewById(R.id.img_cross_grey);


        setContentView(R.layout.travel_story);

        rv = (RecyclerView) findViewById(R.id.recycler_travel_story);

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

                new AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        R.drawable.icon_ellipse_red,
                        "Сегодня 10:10",
                        new AdapterGridViewMenu.ItemsMenu.CallBack() {
                            @Override
                            public void call(AdapterGridViewMenu.ItemsMenu itemsMenu) {

                                try {

                                    Bundle _args = new Bundle();

                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, "66 \u20BD"),

                new AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        R.drawable.icon_ellipse_red,
                        "Сегодня 10:10",
                        new AdapterGridViewMenu.ItemsMenu.CallBack() {
                            @Override
                            public void call(AdapterGridViewMenu.ItemsMenu itemsMenu) {

                                try {

                                    Bundle _args = new Bundle();

                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, "66 \u20BD"),

                new AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        R.drawable.icon_ellipse_red,
                        "Сегодня 10:10",
                        new AdapterGridViewMenu.ItemsMenu.CallBack() {
                            @Override
                            public void call(AdapterGridViewMenu.ItemsMenu itemsMenu) {

                                try {

                                    Bundle _args = new Bundle();

                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, "66 \u20BD"),

                new AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        R.drawable.icon_ellipse_red,
                        "Сегодня 10:10",
                        new AdapterGridViewMenu.ItemsMenu.CallBack() {
                            @Override
                            public void call(AdapterGridViewMenu.ItemsMenu itemsMenu) {

                                try {

                                    Bundle _args = new Bundle();

                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, "66 \u20BD")
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

            ViewGroup v = (ViewGroup) layoutInflater.inflate(R.layout.cell_travel_story, viewGroup, false);
            return new ViewHolder(v);

        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

            final ItemsMenu _item = itemsMenu[i];

            float _dens = context.getResources().getDisplayMetrics().density;


            int _size = Math.round(_dens * 40);
            Drawable _def_draw = context.getResources().getDrawable(_item.getImgResId());
            Bitmap _bitmap = DrawableUtils.convertToBitmap(_def_draw, _size, _size);

            viewHolder.img.setScaleType(ImageView.ScaleType.CENTER);
            viewHolder.date.setText( _item.getDate() );
            viewHolder.cost.setText( _item.getCost() );
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
            private String date;
            private CallBack callBack;
            private String cost;

            public ItemsMenu(int colorBackgroundRes, int imgResId, String date, CallBack callBack,String cost) {
                this.colorBackgroundInt = colorBackgroundRes;
                this.imgResId = imgResId;
                this.date = date;
                this.callBack = callBack;
                this.cost = cost;
            }

            public CallBack getCallBack() {
                return callBack;
            }

            public int getImgResId() {
                return imgResId;
            }

            public String getDate() {
                return date;
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
            private final TextView date;
            private final CardView cv_item;
            private final TextView cost;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                cv_item = itemView.findViewById(R.id.cv_item);
                img = itemView.findViewById(R.id.elisple_red);
                date = itemView.findViewById(R.id.date);
                cost = itemView.findViewById(R.id.cost);

            }
        }

    }
}

