package com.example.myapplication_1.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

import ru.osety.amironlibrary.DrawableUtils;

public class TravelStoryAdapter extends RecyclerView.Adapter<TravelStoryAdapter.ViewHolder> {

    private final TravelStoryCard[] travelStoryCards;
    private final LayoutInflater layoutInflater;
    private final Context context;

    public TravelStoryAdapter(TravelStoryAdapter.TravelStoryCard[] travelStoryCards, Context context) {
        this.travelStoryCards = travelStoryCards;
        this.context = context;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ViewGroup v = (ViewGroup) layoutInflater.inflate(R.layout.cell_travel_story, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final TravelStoryCard _item = travelStoryCards[i];

        try{
            TravelStoryAddressTitleAdapter travelStoryAddressTitleAdapter = new TravelStoryAddressTitleAdapter(_item.str_features, context);
            viewHolder.travel_story_rv.setAdapter(travelStoryAddressTitleAdapter);
            viewHolder.travel_story_rv.setLayoutManager(
                    new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
            viewHolder.travel_story_rv.setItemAnimator(new DefaultItemAnimator());
        }catch (NullPointerException e){
            e.printStackTrace();
        }

        viewHolder.date.setText( _item.getDate() );
        viewHolder.cost.setText( _item.getCost() );
        viewHolder.cv_item.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    _item.getCallBack().call(_item);
                } catch ( NullPointerException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return travelStoryCards.length;
    }

    public static class TravelStoryCard {

        public interface CallBack {
            void call(TravelStoryCard itemsMenu);
        }

        private int img;
        private String date;
        private CallBack callBack;
        private String cost;
        private String[] str_features;

        public TravelStoryCard(int img, String date, CallBack callBack,String cost, String[] str_features) {
            this.img = img;
            this.date = date;
            this.callBack = callBack;
            this.cost = cost;
            this.str_features = str_features;
        }
        public CallBack getCallBack() {
            return callBack;
        }
        public int getImg() {
            return img;
        }
        String getDate() {
            return date;
        }
        public String getCost() {
            return cost;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView date;
        private final CardView cv_item;
        private final TextView cost;
        private final RecyclerView travel_story_rv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cv_item = itemView.findViewById(R.id.ll_cell_travel_story_cv);
            travel_story_rv = itemView.findViewById(R.id.ll_cell_travel_story_recycler);
            date = itemView.findViewById(R.id.ll_cell_travel_story_date);
            cost = itemView.findViewById(R.id.ll_cell_travel_story_cost);
        }
    }
}