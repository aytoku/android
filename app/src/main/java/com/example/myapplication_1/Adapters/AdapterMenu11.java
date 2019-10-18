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

public class AdapterMenu11 {

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

            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_menu_1_1, viewGroup, false);
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

            public ItemsMenu(int colorBackgroundRes, String title) {
                this.colorBackgroundInt = colorBackgroundRes;
                this.title = title;
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

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                title = itemView.findViewById(R.id.ll_cell_menu_1_1_title);
            }
        }
    }
}