package com.example.myapplication_1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

public class TripDetailsAdapter extends RecyclerView.Adapter<TripDetailsAdapter.ViewHolder> {

    private final TripDetailsItems[] tripDetailsItems;
    private final LayoutInflater layoutInflater;
    private final Context context;

    public TripDetailsAdapter(TripDetailsItems[] tripDetailsItems, Context context) {
        this.tripDetailsItems = tripDetailsItems;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ViewGroup v = (ViewGroup) layoutInflater.inflate(R.layout.cell_trip_details_title, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final TripDetailsItems _trip_details_item = tripDetailsItems[i];
        viewHolder.title.setText(_trip_details_item.getStr());
        try{
            TripDetailsDescAdapter tripDetailsBaseAdapter = new TripDetailsDescAdapter(_trip_details_item.desc_arr, context);
            viewHolder.trip_details_desc_rv.setAdapter(tripDetailsBaseAdapter);
            viewHolder.trip_details_desc_rv.setLayoutManager(
                    new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
            viewHolder.trip_details_desc_rv.setItemAnimator(new DefaultItemAnimator());
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return tripDetailsItems.length;
    }

    public static class TripDetailsItems {

        private String title;
        private String[] desc_arr;

        public TripDetailsItems(String title, String[] desc_arr) {
            this.desc_arr = desc_arr;
            this.title = title;
        }

        public String getStr() {
            return title;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final RecyclerView trip_details_desc_rv;
        private final TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            trip_details_desc_rv = itemView.findViewById(R.id.ll_cell_trip_details_recycler);
            title = itemView.findViewById(R.id.ll_cell_trip_details_title);
        }
    }
}