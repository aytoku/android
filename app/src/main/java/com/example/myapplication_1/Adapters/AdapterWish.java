package com.example.myapplication_1.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

public class AdapterWish extends RecyclerView.Adapter<AdapterWish.ViewHolder> {

    private final WishItems[] itemsMenu;
    private final LayoutInflater layoutInflater;
    private final Context context;

    public AdapterWish(AdapterWish.WishItems[] itemsMenu, Context context) {
        this.itemsMenu = itemsMenu;
        this.context = context;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        ViewGroup v = (ViewGroup) layoutInflater.inflate(R.layout.cell_wishes_model, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        final WishItems _item = itemsMenu[i];

        viewHolder.desc.setText(_item.getStr());
        viewHolder.cost.setText(_item.getCost());
    }

    @Override
    public int getItemCount() {
        return itemsMenu.length;
    }

    public static class WishItems {

        private String cost;
        private String desc;

        public WishItems(String cost, String desc) {
            this.cost = cost;
            this.desc = desc;
        }

        public String getStr() {
            return desc;
        }

        public String getCost() {
            return cost;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView desc;
        private final TextView cost;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            desc = itemView.findViewById(R.id.desc);
            cost = itemView.findViewById(R.id.cost);
        }
    }
}