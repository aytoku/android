package com.example.myapplication_1.Adapters;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

import java.util.List;

import ru.osety.amironlibrary.DrawableUtils;

public  class RatingPraiseAdapter extends RecyclerView.Adapter<RatingPraiseAdapter.ViewHolder> {

    private final LayoutInflater layoutInflater;
    private final Context context;
    private List<RatingPraiseAdapter.RatingPraiseItems> ratingPraiseItemsList;
    private int selectItem = -1;
    private Drawable drawable;

    public RatingPraiseAdapter(List<RatingPraiseAdapter.RatingPraiseItems> ratingPraiseItemsList, Context context) {
        this.ratingPraiseItemsList = ratingPraiseItemsList;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        drawable = context.getResources().getDrawable(R.drawable.rating_background);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_rating_praise, viewGroup, false);
        ViewHolder itemViewHolder = new ViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        final RatingPraiseItems ratingPraiseItems = ratingPraiseItemsList.get(i);
        float _dens = context.getResources().getDisplayMetrics().density;
        int _size = Math.round(_dens * 15);
        Drawable _def_draw = context.getResources().getDrawable(ratingPraiseItems.getImg());
        Bitmap _bitmap = DrawableUtils.convertToBitmap(_def_draw, _size, _size);
        viewHolder.imageView.setImageBitmap( _bitmap );
        viewHolder.imageView.setScaleType(ImageView.ScaleType.CENTER);
        viewHolder.title.setText(ratingPraiseItems.getStr());
        if(selectItem == i){
            viewHolder.linearLayout.setBackground(drawable);
        } else{
            viewHolder.linearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
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
        return ratingPraiseItemsList.size();
    }

    public static class RatingPraiseItems {
        private int img;
        private String desc;

        public RatingPraiseItems(int img,String desc) {
            this.img = img;
            this.desc = desc;
        }

        public int getImg() {
            return img;
        }
        public String getStr() {
            return desc;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final TextView title;
        private final LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ll_cell_rating_praise_img);
            title = itemView.findViewById(R.id.ll_cell_rating_praise_desc);
            linearLayout = itemView.findViewById(R.id.ll_cell_rating_praise);
        }
    }

    public RatingPraiseItems getSelectItem(){
        ratingPraiseItemsList.get(selectItem);
        return ratingPraiseItemsList.get(selectItem);
    }
}