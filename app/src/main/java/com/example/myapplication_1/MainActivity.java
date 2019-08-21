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
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.appcompat.app.AppCompatActivity;

    public class MainActivity extends AppCompatActivity {

        RecyclerView rv;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_main);

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

            //    RecyclerView recyclerViewMenu = (RecyclerView) getView().findViewById(R.id.gridViewMenu);

                AdapterGridViewMenu.ItemsMenu[] itemsMenu = getMenuItems();

                AdapterGridViewMenu adapterGridViewMenu = new AdapterGridViewMenu(itemsMenu, getBaseContext());//this;
                recyclerViewMenu.setAdapter( adapterGridViewMenu );
                recyclerViewMenu.setLayoutManager(
                        new GridLayoutManager( getBaseContext(),3, RecyclerView.VERTICAL, false ) );
                recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

            } catch ( NullPointerException e) {
                e.printStackTrace();
            }

        }

        private AdapterGridViewMenu.ItemsMenu[] getMenuItems() {

            AdapterGridViewMenu.ItemsMenu []_arr = new AdapterGridViewMenu.ItemsMenu{

            new AdapterGridViewMenu.ItemsMenu(getResources().getColor(R.color.my_gray),
                    R.drawable.icon_group_7,
                        getResources().getString(R.
                            string.options), new AdapterGridViewMenu.ItemsMenu.CallBack() {
                @Override
                public void call(AdapterGridViewMenu.ItemsMenu itemsMenu) {

                    try {

                        Bundle _args = new Bundle();
                        _args .putString(FragWebView.KEY_HREF, URLHelper.WVOptions);
                        FragWebView _f = FragWebView.getInstance( _args );

                        recoveryFragment( _f );

                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }

                }
            })}
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

                ViewGroup v = (ViewGroup) layoutInflater.inflate(R.layout.content_menu_item, viewGroup, false);
                return new ViewHolder(v);

            }

            @Override
            public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

                ItemsMenu _item = itemsMenu[i];

                Drawable ic_background_xml = context.getResources().getDrawable(R.drawable.icon_group_7);
                float _dens = context.getResources().getDisplayMetrics().density;

                Drawable ic_rout_color =
                        MyDrawableUtils.setTintDrawable(ic_background_xml, _item.getColorBackground());

                int _size = Math.round(_dens * 40);
                Drawable _def_draw = context.getResources().getDrawable(_item.getImgResId());
                Bitmap _bitmap = MyDrawableUtils.convertToBitmap(_def_draw, _size, _size);

                viewHolder.img.setBackground( ic_rout_color );
                viewHolder.img.setScaleType(ImageView.ScaleType.CENTER);
                viewHolder.img.setImageBitmap( _bitmap );
                viewHolder.title.setText( _item.getStr() );
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
                    public void call( ItemsMenu itemsMenu );
                }

                private @ColorInt int colorBackgroundInt;
                private int imgResId;
                private String str;
                private CallBack callBack;

                public ItemsMenu(int colorBackgroundRes, int imgResId, String str, CallBack callBack) {
                    this.colorBackgroundInt = colorBackgroundRes;
                    this.imgResId = imgResId;
                    this.str = str;
                    this.callBack = callBack;
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
                    time = itemView.findViewById(R.id.time)

                }
            }

        }
}

