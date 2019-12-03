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

public class AdapterCellTextFeatures extends RecyclerView.Adapter<AdapterCellTextFeatures.ViewHolder>{

    private final String[] array;
    private final LayoutInflater layoutInflater;
    private final Context context;
    private final ImageView[] imageViewsArray = new ImageView[0];
    private final Drawable mini_ellipse_red;
    private final Drawable mini_ellipse_black;
    private final Drawable mini_ellipse_green;

    public AdapterCellTextFeatures(String[] array, Context context) {
        this.array = array;
        this.context = context;


        mini_ellipse_red = context.getResources().getDrawable(R.drawable.ic_mini_ellipse);
        mini_ellipse_black = context.getResources().getDrawable(R.drawable.ic_mini_ellipse_black);
        mini_ellipse_green = context.getResources().getDrawable(R.drawable.ic_mini_ellipse_green);

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public AdapterCellTextFeatures.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        ViewGroup v = (ViewGroup) layoutInflater.inflate(R.layout.cell_features_text, viewGroup, false);
        return new AdapterCellTextFeatures.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.textView.setText(array[i]);

        if(i == 0){
            viewHolder.textView.setTypeface(null, Typeface.BOLD);
            viewHolder.imageView.setImageDrawable(mini_ellipse_red);
        }else if(i == array.length-1){
            viewHolder.imageView.setImageDrawable(mini_ellipse_green);
        }else {
            viewHolder.imageView.setImageDrawable(mini_ellipse_black);
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
            textView = itemView.findViewById(R.id.rl_cell_features_text_title);
            imageView = itemView.findViewById(R.id.rl_cell_features_text_img);
        }
    }
}