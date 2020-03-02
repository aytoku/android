package com.example.myapplication_1.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

public class TravelStoryAddressTitleAdapter extends RecyclerView.Adapter<TravelStoryAddressTitleAdapter.ViewHolder>{

    private final String[] array;
    private final LayoutInflater layoutInflater;
    private final Context context;
    private final Drawable ellipse_red;
    private final Drawable ellipse_black;
    private final Drawable ellipse_green;

    TravelStoryAddressTitleAdapter(String[] array, Context context) {
        this.array = array;
        this.context = context;

        ellipse_red = context.getResources().getDrawable(R.drawable.ic_mini_ellipse);
        ellipse_black = context.getResources().getDrawable(R.drawable.ic_mini_ellipse_black);
        ellipse_green = context.getResources().getDrawable(R.drawable.ic_mini_ellipse_green);

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public TravelStoryAddressTitleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ViewGroup v = (ViewGroup) layoutInflater.inflate(R.layout.cell_travel_story_address_title, viewGroup, false);
        return new TravelStoryAddressTitleAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TravelStoryAddressTitleAdapter.ViewHolder viewHolder, int i) {

        viewHolder.textView.setText(array[i]);

        if(i == 0) {
            viewHolder.imageView.setImageDrawable(ellipse_red);
        } else if(i == array.length-1) {
            viewHolder.imageView.setImageDrawable(ellipse_green);
        } else {
            viewHolder.imageView.setImageDrawable(ellipse_black);
        }
    }

    @Override
    public int getItemCount() {
        return array.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.rl_cell_travel_story_address_title_title);
            imageView = itemView.findViewById(R.id.rl_cell_travel_story_address_title_img);
        }
    }
}
