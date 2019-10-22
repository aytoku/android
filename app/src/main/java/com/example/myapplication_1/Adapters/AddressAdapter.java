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

import java.util.List;

import ru.osety.amironlibrary.DrawableUtils;

public class AddressAdapter {

    public static class AdapterGridViewMenu extends RecyclerView.Adapter<AdapterGridViewMenu.ViewHolder> {

        private final LayoutInflater layoutInflater;
        private final Context context;
        private List<ItemsMenu> itemsMenuList;

        public AdapterGridViewMenu(List<AdapterGridViewMenu.ItemsMenu> itemsMenuList, Context context) {
            this.itemsMenuList = itemsMenuList;
            this.context = context;
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_addresses, viewGroup, false);
            ViewHolder itemViewHolder = new ViewHolder(view);
            return itemViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

            final ItemsMenu _item = itemsMenuList.get(i);

            Drawable ic_background_xml = context.getResources().getDrawable(R.mipmap.icon_car);
            float _dens = context.getResources().getDisplayMetrics().density;

            Drawable ic_rout_color = DrawableUtils.setTintDrawable(ic_background_xml, _item.getColorBackground());

            int _size = Math.round(_dens * 20);
            Drawable _def_draw = context.getResources().getDrawable(_item.getImgResId());
            Bitmap _bitmap = DrawableUtils.convertToBitmap(_def_draw, _size, _size);

            viewHolder.title.setText(_item.getStr());

            viewHolder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemsMenuList.add(i, _item);
                    notifyItemInserted(i);
                    notifyDataSetChanged();
                }
            });
        }

        @Override
        public int getItemCount() {
            return itemsMenuList.size();
        }

        public static class ItemsMenu {

            private @ColorInt
            int colorBackgroundInt;
            private int imgResId;
            private String title;

            public ItemsMenu(int colorBackgroundRes, int imgResId, String title) {
                this.colorBackgroundInt = colorBackgroundRes;
                this.imgResId = imgResId;
                this.title = title;
            }

            public int getImgResId() {
                return imgResId;
            }

            public String getStr() {
                return title;
            }

            public int getColorBackground() {
                return colorBackgroundInt;
            }
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            private final ImageView img;
            private final TextView title;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                img = itemView.findViewById(R.id.ll_cell_address_button_plus1);
                title = itemView.findViewById(R.id.ll_cell_address_add_address_home);
            }
        }
    }
}