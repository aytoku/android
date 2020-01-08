package com.example.myapplication_1.Adapters;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

import java.util.List;

public class RatingAdapterCard extends RecyclerView.Adapter<RatingAdapterCard.ViewHolder> {

    private final LayoutInflater layoutInflater;
    private Context context;
    private List<Integer>list;
    private int selectItem = -1;

    public RatingAdapterCard(List<Integer> list, Context context) {
        this.list = list;
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

        final Integer _item = list.get(i);

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
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class TipsList {

        List<Integer> list;

        public TipsList(List<Integer> list) {
            this.list = list;
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