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

public class CellTravelStoryOneAdapter {

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

            ViewGroup v = (ViewGroup) layoutInflater.inflate(R.layout.cell_travel_story_1, viewGroup, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

            final ItemsMenu _item = itemsMenu[i];

            viewHolder.title.setText( _item.getTitle() );
            viewHolder.desc.setText( _item.getDesc() );
            viewHolder.cost.setText( _item.getCost() );
        }

        @Override
        public int getItemCount() {
            return itemsMenu.length;
        }

        public static class ItemsMenu {


            public interface CallBack {
                void call(ItemsMenu itemsMenu);
            }

            private @ColorInt
            int colorBackgroundInt;
            private String title;
            private String desc;
            private String cost;

            public ItemsMenu(int colorBackgroundRes, String title,String desc, String cost) {
                this.colorBackgroundInt = colorBackgroundRes;
                this.title = title;
                this.desc = desc;
                this.cost = cost;
            }

            public String getTitle() {
                return title;
            }

            public String getDesc() {
                return desc;
            }

            public String getCost() {
                return cost;
            }

            public int getColorBackground() {
                return colorBackgroundInt;
            }
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            private final TextView title;
            private final TextView desc;
            private final TextView cost;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                title = itemView.findViewById(R.id.ll_travel_story_1_expectation);
                desc = itemView.findViewById(R.id.ll_travel_story_1_expectation_desc);
                cost = itemView.findViewById(R.id.ll_travel_story_1_expectation_cost);
            }
        }
    }
}