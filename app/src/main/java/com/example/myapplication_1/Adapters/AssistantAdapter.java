package com.example.myapplication_1.Adapters;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

import java.util.List;

public class AssistantAdapter {

    public static class AdapterGridViewMenu extends RecyclerView.Adapter<AdapterGridViewMenu.ViewHolder> {

        private final LayoutInflater layoutInflater;
        private Context context;
        private Drawable card;
        private Drawable card_gradient;
        LinearLayout.LayoutParams params;

        private List<ItemsMenu> itemsMenuList;

        public AdapterGridViewMenu(List<ItemsMenu> itemsMenuList, Context context) {
            this.itemsMenuList = itemsMenuList;
            this.context = context;

            card = context.getResources().getDrawable(R.drawable.ic_card_gradient);
            card_gradient = context.getResources().getDrawable(R.drawable.card_gradient_1);

            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_assistant, viewGroup, false);
            ViewHolder itemViewHolder = new ViewHolder(view);
            return itemViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

            final ItemsMenu _item = itemsMenuList.get(i);

            viewHolder.title.setText(_item.getTitle());

            if(i == 0){
                viewHolder.relativeLayout.setBackground(card);
            }else{
                viewHolder.relativeLayout.setBackground(card_gradient);
                viewHolder.imageView.setVisibility(View.GONE);
                params = (LinearLayout.LayoutParams)viewHolder.relativeLayout.getLayoutParams();
                params.weight = 160;
                params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                viewHolder.relativeLayout.setLayoutParams(params);
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

            public ItemsMenu(int colorBackgroundRes, String title) {
                this.colorBackgroundInt = colorBackgroundRes;
                this.title = title;
            }

            public String getTitle() {
                return title;
            }

            public int getColorBackground() {
                return colorBackgroundInt;
            }
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            private final TextView title;
            private final RelativeLayout relativeLayout;
            private final ImageView imageView;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                title = itemView.findViewById(R.id.rl_cell_assistant_title);
                relativeLayout = itemView.findViewById(R.id.rl_cell_assistant);
                imageView  = itemView.findViewById(R.id.rl_cell_assistant_button);
            }
        }
    }
}