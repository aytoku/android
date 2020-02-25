package com.example.myapplication_1.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

import java.util.List;

import ru.osety.amironlibrary.DrawableUtils;

public  class RatingStarAdapter extends RecyclerView.Adapter<RatingStarAdapter.ViewHolder> {

    private final LayoutInflater layoutInflater;
    private final Context context;
    private List<RatingStarItems> ratingStarItemsList;
    private int selectedItem = -1;
    private Drawable starRed;
    private Drawable starGray;

    public RatingStarAdapter(List<RatingStarAdapter.RatingStarItems> ratingStarItemsList, Context context) {
        this.ratingStarItemsList = ratingStarItemsList;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        starRed = context.getResources().getDrawable(R.drawable.red_star_shadow);
        starGray = context.getResources().getDrawable(R.drawable.icon_star_grey);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_rating_stars, viewGroup, false);
        ViewHolder itemViewHolder = new ViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        final RatingStarItems ratingStarItems = ratingStarItemsList.get(i);
        float _dens = context.getResources().getDisplayMetrics().density;
        int _size = Math.round(_dens * 20);
        Drawable _def_draw = context.getResources().getDrawable(ratingStarItems.getImg());
        Bitmap _bitmap = DrawableUtils.convertToBitmap(_def_draw, _size, _size);
        if(selectedItem >= i){
            viewHolder.imageView.setImageDrawable(starRed);
        } else{
            viewHolder.imageView.setImageDrawable(starGray);
        }
        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notifyItemRangeChanged(0,ratingStarItemsList.size());
                notifyItemChanged(selectedItem);
                selectedItem = i;
                notifyItemChanged(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ratingStarItemsList.size();
    }

    public static class RatingStarItems {
        private int img;

        public RatingStarItems(int img) {
            this.img = img;
        }

        public int getImg() {
            return img;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ll_cell_rating_stars_img);
        }
    }

    public RatingStarItems getSelectedItem(){
        ratingStarItemsList.get(selectedItem);
        return ratingStarItemsList.get(selectedItem);
    }
}