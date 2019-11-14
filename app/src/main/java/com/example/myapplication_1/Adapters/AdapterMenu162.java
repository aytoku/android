package com.example.myapplication_1.Adapters;


import android.content.Context;
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

    public class AdapterMenu162 extends RecyclerView.Adapter<AdapterMenu162.ViewHolder> {

        private final LayoutInflater layoutInflater;
        private final Context context;

        private List<ItemsMenu> itemsMenuList;

        public AdapterMenu162(List<AdapterMenu162.ItemsMenu> itemsMenuList, Context context) {
            this.itemsMenuList = itemsMenuList;
            this.context = context;
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_menu_1_6_2, viewGroup, false);
            ViewHolder itemViewHolder = new ViewHolder(view);
            return itemViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

            final ItemsMenu _item = itemsMenuList.get(i);

            viewHolder.title.setText(_item.getStr());
        }

        @Override
        public int getItemCount() {
            return itemsMenuList.size();
        }

        public static class ItemsMenu {

            private @ColorInt
            int colorBackgroundInt;
            private String title;
            private int imageButton;

            public ItemsMenu(int colorBackgroundRes, String title, int imageButton) {
                this.colorBackgroundInt = colorBackgroundRes;
                this.title = title;
                this.imageButton = imageButton;
            }

            public String getStr() {
                return title;
            }

            public int getColorBackground() {
                return colorBackgroundInt;
            }
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            private final TextView title;
            private final ImageView imageButton;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                title = itemView.findViewById(R.id.rl_cell_menu_1_6_2_title);
                imageButton = itemView.findViewById(R.id.rl_cell_menu_1_6_2_img_arrow);
            }
        }
    }