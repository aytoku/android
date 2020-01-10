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

        viewHolder.emoji.setText(_item.getEmoji());
        viewHolder.desc.setText(_item.getStr());
    }

    @Override
    public int getItemCount() {
        return order115ItemsList.size();
    }

    public static class Order115Items {

        private String emoji;
        private String desc;

        public Order115Items(String emoji, String desc) {
            this.emoji = emoji;
            this.desc = desc;
        }

        public String getEmoji() {
            return emoji;
        }

        public String getStr() {
            return desc;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView emoji;
        private final TextView desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            emoji = itemView.findViewById(R.id.ll_cell_order_1_1_5_emoji);
            desc = itemView.findViewById(R.id.ll_cell_order_1_1_5_desc);
        }
    }
}