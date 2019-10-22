package com.example.myapplication_1.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

import java.util.List;

public class RatingAdapter{

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

            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_rating, viewGroup, false);
            ViewHolder itemViewHolder = new ViewHolder(view);
            return itemViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

            final ItemsMenu _item = itemsMenuList.get(i);

            viewHolder.emoji1.setText(_item.getStr());

            viewHolder.emoji2.setText(_item.getStr1());
        }

        @Override
        public int getItemCount() {
            return itemsMenuList.size();
        }

        public static class ItemsMenu {

            private @ColorInt
            int colorBackgroundInt;
            private String emoji1;
            private String emoji2;

            public ItemsMenu(int colorBackgroundRes, String emoji1, String emoji2) {
                this.colorBackgroundInt = colorBackgroundRes;
                this.emoji1 = emoji1;
                this.emoji2 = emoji2;
            }

            public String getStr() {
                return emoji1;
            }

            public String getStr1() {
                return emoji2;
            }

            public int getColorBackground() {
                return colorBackgroundInt;
            }
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            private final TextView emoji1;
            private final TextView emoji2;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                emoji1 = itemView.findViewById(R.id.ll_cell_rating_emoji);
                emoji2 = itemView.findViewById(R.id.ll_cell_rating_emoji_desc);
            }
        }
    }
}