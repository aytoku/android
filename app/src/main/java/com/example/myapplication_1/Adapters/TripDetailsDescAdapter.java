package com.example.myapplication_1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

public class TripDetailsDescAdapter extends RecyclerView.Adapter<TripDetailsDescAdapter.ViewHolder> {

    private final LayoutInflater layoutInflater;
    private final Context context;
    private final String[] array;

    public TripDetailsDescAdapter(final String[] array, Context context) {
        this.array = array;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_trip_details_desc, viewGroup, false);
        ViewHolder itemViewHolder = new ViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        viewHolder.title.setText(array[i]);
    }

    @Override
    public int getItemCount() {
        return array.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.ll_cell_trip_details_desc_title);
        }
    }
}