package com.example.myapplication_1.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
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

import ru.osety.amironlibrary.DrawableUtils;

    public class BlacklistPartnersAdapter extends RecyclerView.Adapter<BlacklistPartnersAdapter.ViewHolder> {

        private final ItemsMenu[] itemsMenu;
        private final LayoutInflater layoutInflater;
        private final Context context;
        private Drawable imgToggleGrey;
        private Drawable imgToggleRed;
        boolean f = true;

        public BlacklistPartnersAdapter(BlacklistPartnersAdapter.ItemsMenu[] itemsMenu, Context context) {
            this.itemsMenu = itemsMenu;
            this.context = context;

            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            imgToggleGrey = context.getResources().getDrawable(R.drawable.togle_uncheked);
            imgToggleRed = context.getResources().getDrawable(R.drawable.toggle_checked);
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            ViewGroup v = (ViewGroup) layoutInflater.inflate(R.layout.cell_blacklist_partner, viewGroup, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {

            final ItemsMenu _item = itemsMenu[i];

            float _dens = context.getResources().getDisplayMetrics().density;

            int _size = Math.round(_dens * 30);
            Drawable _def_draw = context.getResources().getDrawable(_item.getImgResId());
            Bitmap _bitmap = DrawableUtils.convertToBitmap(_def_draw, _size, _size);

            viewHolder.img.setScaleType(ImageView.ScaleType.CENTER);
            viewHolder.img.setImageBitmap( _bitmap );
            viewHolder.desc.setText( _item.getStr() );

            viewHolder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    viewHolder.img.setImageDrawable(imgToggleGrey);
                    viewHolder.desc.setTextColor(Color.parseColor("#424242"));
                    if(f =! f){
                        viewHolder.img.setImageDrawable(imgToggleRed);
                        viewHolder.desc.setTextColor(Color.parseColor("#FB2933"));
                    }
                }
            });

            viewHolder.desc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    viewHolder.img.setImageDrawable(imgToggleGrey);
                    viewHolder.desc.setTextColor(Color.parseColor("#424242"));
                    if(f =! f){
                        viewHolder.img.setImageDrawable(imgToggleRed);
                        viewHolder.desc.setTextColor(Color.parseColor("#FB2933"));
                    }
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
            private String desc;

            public ItemsMenu(int colorBackgroundRes,int imgResId,String desc) {
                this.colorBackgroundInt = colorBackgroundRes;
                this.imgResId = imgResId;
                this.desc = desc;
                this.imgResId = imgResId;
            }

            public int getImgResId() {
                return imgResId;
            }

            public String getStr() {
                return desc;
            }

            public int getColorBackground() {
                return colorBackgroundInt;
            }
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            private final ImageView img;
            private final TextView desc;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                img = itemView.findViewById(R.id.ll_cell_blacklist_partner_checkbox);
                desc = itemView.findViewById(R.id.ll_cell_blacklist_partner_desc);
            }
        }
    }