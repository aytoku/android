package com.example.myapplication_1.Adapters;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

import java.util.List;

import ru.osety.amironlibrary.DrawableUtils;

public class RatingAdapterCard{

    public static class AdapterGridViewMenu extends RecyclerView.Adapter<AdapterGridViewMenu.ViewHolder> {

        private final LayoutInflater layoutInflater;
        private final Context context;

        private List<ItemsMenu1> itemsMenuList1;



        public AdapterGridViewMenu(List<AdapterGridViewMenu.ItemsMenu1> itemsMenuList1, Context context) {
            this.itemsMenuList1 = itemsMenuList1;
            this.context = context;
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_rating_card, viewGroup, false);
            ViewHolder itemViewHolder = new ViewHolder(view);
            return itemViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

            final ItemsMenu1 _item = itemsMenuList1.get(i);

            Drawable ic_background_xml = context.getResources().getDrawable(R.mipmap.icon_car);
            float _dens = context.getResources().getDisplayMetrics().density;

            Drawable ic_rout_color = DrawableUtils.setTintDrawable(ic_background_xml, _item.getColorBackground());

            int _size = Math.round(_dens * 40);

            viewHolder.price.setText(_item.getStr());
        }

        @Override
        public int getItemCount() {
            return itemsMenuList1.size();
        }

        public static class ItemsMenu1 {

            private @ColorInt
            int colorBackgroundInt;
            private String price;

            public ItemsMenu1(int colorBackgroundRes, String price) {
                this.colorBackgroundInt = colorBackgroundRes;
                this.price = price;
            }

            public String getStr() {
                return price;
            }


            public int getColorBackground() {
                return colorBackgroundInt;
            }
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            private final CardView cardView;
            private final TextView price;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                cardView = itemView.findViewById(R.id.ll_cell_rating_ll_cell_rating_cv_rating);
                price = itemView.findViewById(R.id.ll_cell_rating_ll_cell_rating_cv_rating3_ll_rating_price1);
            }
        }
    }
}