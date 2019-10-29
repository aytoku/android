package com.example.myapplication_1.Adapters;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

import java.util.List;

public class DeployedMessagesAdapter {

    public static class AdapterGridViewMenu extends RecyclerView.Adapter<AdapterGridViewMenu.ViewHolder> {

        private final LayoutInflater layoutInflater;
        private Context context;
            private Drawable card_draw;
            private Drawable card;

        private List<ItemsMenu> itemsMenuList;

        public AdapterGridViewMenu(List<AdapterGridViewMenu.ItemsMenu> itemsMenuList, Context context) {
            this.itemsMenuList = itemsMenuList;
            this.context = context;

            card_draw = context.getResources().getDrawable(R.drawable.card_draw);
            card = context.getResources().getDrawable(R.drawable.ic_card);

            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_deployed_messages, viewGroup, false);
            ViewHolder itemViewHolder = new ViewHolder(view);
            return itemViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

            final ItemsMenu _item = itemsMenuList.get(i);

            viewHolder.title.setText(_item.getTitle());

            viewHolder.desc.setText(_item.getDesc());

            if(i == 0){
                viewHolder.relativeLayout.setBackground(card);
            }else{
                viewHolder.relativeLayout.setBackground(card_draw);
            }
        }

        @Override
        public int getItemCount() {
            return itemsMenuList.size();
        }

        public static class ItemsMenu {

            private @ColorInt
            int colorBackgroundInt;
            private String title;
            private String desc;

            public ItemsMenu(int colorBackgroundRes, String title, String desc) {
                this.colorBackgroundInt = colorBackgroundRes;
                this.title = title;
                this.desc = desc;
            }

            public String getTitle() {
                return title;
            }

            public String getDesc(){ return  desc; }

            public int getColorBackground() {
                return colorBackgroundInt;
            }
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            private final TextView title;
            private final TextView desc;
            private final RelativeLayout relativeLayout;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                title = itemView.findViewById(R.id.rl_cell_deployed_messages_title);
                desc = itemView.findViewById(R.id.rl_cell_deployed_messages_desc);
                relativeLayout = itemView.findViewById(R.id.rl_cell_deployed_messages);
            }
        }
    }
}