package com.example.myapplication_1.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

import java.util.List;

public class Order115Adapter extends RecyclerView.Adapter<Order115Adapter.ViewHolder> {

    private final LayoutInflater layoutInflater;
    private final Context context;
    private List<Order115Items> order115ItemsList;

    public Order115Adapter(List<Order115Adapter.Order115Items> order115ItemsList, Context context) {
        this.order115ItemsList = order115ItemsList;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_order_1_1_5, viewGroup, false);
        ViewHolder itemViewHolder = new ViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        final Order115Items _item = order115ItemsList.get(i);
        viewHolder.image.setText(_item.getImg());
        viewHolder.desc.setText(_item.getStr());
    }

    @Override
    public int getItemCount() {
        return order115ItemsList.size();
    }

    public static class Order115Items {
        private String img;
        private String desc;

        public Order115Items(String img, String desc) {
            this.img = img;
            this.desc = desc;
        }

        String getImg() {
            return img;
        }
        public String getStr() {
            return desc;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView image;
        private final TextView desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.rl_cell_order_1_1_5_image);
            desc = itemView.findViewById(R.id.rl_cell_order_1_1_5_desc);
        }
    }
}