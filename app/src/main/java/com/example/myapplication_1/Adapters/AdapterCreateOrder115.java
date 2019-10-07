package com.example.myapplication_1.Adapters;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

import java.util.Arrays;
import java.util.List;

import ru.osety.amironlibrary.DrawableUtils;

public class AdapterCreateOrder115 {

    public static class AdapterGridViewMenu extends RecyclerView.Adapter<AdapterGridViewMenu.ViewHolder> {

        private final ItemsMenu[] itemsMenu;
        private final LayoutInflater layoutInflater;
        private final Context context;

        private List<ItemsMenu> itemsMenuList;

        public AdapterGridViewMenu(AdapterGridViewMenu.ItemsMenu[] itemsMenu, Context context) {
            this.itemsMenu = itemsMenu;
            this.context = context;

            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_create_order_1_1_5, viewGroup, false);
            ViewHolder itemViewHolder = new ViewHolder(view);
            return itemViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

            final ItemsMenu _item = itemsMenu[i];

            Drawable ic_background_xml = context.getResources().getDrawable(R.mipmap.icon_car);
            float _dens = context.getResources().getDisplayMetrics().density;

            Drawable ic_rout_color = DrawableUtils.setTintDrawable(ic_background_xml, _item.getColorBackground());

            int _size = Math.round(_dens * 40);
            Drawable _def_draw = context.getResources().getDrawable(_item.getImgResId());
            Bitmap _bitmap = DrawableUtils.convertToBitmap(_def_draw, _size, _size);

            viewHolder.title.setText(_item.getStr());


            final int currentPosition = i;
            itemsMenuList = Arrays.asList(itemsMenu);

            viewHolder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    notifyItemRemoved(i);
                    notifyItemRangeChanged(currentPosition, 1);
                }
            });
        }

        @Override
        public int getItemCount() {
            return itemsMenu.length;
        }

        public static class ItemsMenu {

            private @ColorInt
            int colorBackgroundInt;
            private int imgResId;
            private String title;
            private int imgResId1;

            public ItemsMenu(int colorBackgroundRes, int imgResId, String title, int imgResId1) {
                this.colorBackgroundInt = colorBackgroundRes;
                this.imgResId = imgResId;
                this.title = title;
                this.imgResId1 = imgResId1;
            }

            public int getImgResId() {
                return imgResId;
            }

            public String getStr() {
                return title;
            }

            public int getImgResId1() {
                return imgResId1;
            }

            public int getColorBackground() {
                return colorBackgroundInt;
            }
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            private final ImageView img;
            private final TextView title;
            private final ImageView img1;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                img = itemView.findViewById(R.id.rl_cell_create_order_1_1_5_button_cross);
                title = itemView.findViewById(R.id.rl_cell_create_order_1_1_5_title);
                img1 = itemView.findViewById(R.id.rl_cell_create_order_1_1_5_button_line);
            }
        }
    }
}