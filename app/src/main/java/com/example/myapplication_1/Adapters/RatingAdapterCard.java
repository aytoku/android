package com.example.myapplication_1.Adapters;


import android.content.Context;
import android.graphics.Color;
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

    public class RatingAdapterCard extends RecyclerView.Adapter<RatingAdapterCard.ViewHolder> {

        private final LayoutInflater layoutInflater;
        private Context context;
        private List<ItemsMenu1> itemsMenuList1;
        private int selectItem = -1;

        public RatingAdapterCard(List<RatingAdapterCard.ItemsMenu1> itemsMenuList1, Context context) {
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

            viewHolder.price.setText(_item.getStr());

            if(selectItem == i){
                viewHolder.cardView.setCardBackgroundColor(Color.parseColor("#F3F3F3"));

            }else{
                viewHolder.cardView.setCardBackgroundColor(Color.WHITE);
            }

            viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    notifyItemChanged(selectItem);
                    selectItem = i;
                    notifyItemChanged(i);
                    _item.callBack.call(_item);
                }
            });
        }

        @Override
        public int getItemCount() {
            return itemsMenuList1.size();
        }

        public static class ItemsMenu1 {

            public interface CallBack {
                void call(ItemsMenu1 itemsMenu);
            }

            private @ColorInt
            int colorBackgroundInt;
            private String price;
            private CallBack callBack;

            public ItemsMenu1(int colorBackgroundRes, String price, CallBack callBack) {
                this.colorBackgroundInt = colorBackgroundRes;
                this.price = price;
                this.callBack = callBack;
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
                cardView = itemView.findViewById(R.id.cv_rating);
                price = itemView.findViewById(R.id.cv_rating_price);
            }
        }
    }