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

public class RatingTipsAdapter extends RecyclerView.Adapter<RatingTipsAdapter.ViewHolder>{

    private final LayoutInflater layoutInflater;
    private Context context;
    private List<Integer> tipsList;
    private int selectItem = -1;

    public RatingTipsAdapter(List<Integer> tipsList, Context context){
        this.tipsList = tipsList;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_rating_card, viewGroup, false);
        ViewHolder itemViewHolder = new ViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i){

        viewHolder.price.setText(String.valueOf(tipsList.get(i)));
        tipsList.get(i);

        if(selectItem == i){
            viewHolder.cardView.setCardBackgroundColor(Color.parseColor("#FC5C58"));
            viewHolder.price.setTextColor(Color.WHITE);
        }else{
            viewHolder.cardView.setCardBackgroundColor(Color.WHITE);
            viewHolder.price.setTextColor(Color.BLACK);
        }
        viewHolder.cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                notifyItemChanged(selectItem);
                selectItem = i;
                notifyItemChanged(i);
            }
        });
    }

    @Override
    public int getItemCount(){
        return tipsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private final CardView cardView;
        private final TextView price;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            cardView = itemView.findViewById(R.id.cv_rating);
            price = itemView.findViewById(R.id.cv_rating_price);
        }
    }
}