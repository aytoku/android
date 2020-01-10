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

import com.example.myapplication_1.ClassesForAdapters.PraiseList;
import com.example.myapplication_1.R;

import java.util.List;

import ru.osety.amironlibrary.DrawableUtils;

public  class RatingPraiseAdapter extends RecyclerView.Adapter<RatingPraiseAdapter.ViewHolder> {

    private final LayoutInflater layoutInflater;
    private final Context context;
    private List<PraiseList> praiseLists;
    private int selectItem = -1;
    private Drawable drawable;

    public RatingPraiseAdapter(List<PraiseList> praiseLists, Context context) {
        this.praiseLists = praiseLists;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        drawable = context.getResources().getDrawable(R.drawable.rating_background);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_rating, viewGroup, false);
        ViewHolder itemViewHolder = new ViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

        final PraiseList praiseList = praiseLists.get(i);

        float _dens = context.getResources().getDisplayMetrics().density;

        int _size = Math.round(_dens * 15);
        Drawable _def_draw = context.getResources().getDrawable(praiseList.getImage());
        Bitmap _bitmap = DrawableUtils.convertToBitmap(_def_draw, _size, _size);
        viewHolder.imageView.setImageBitmap( _bitmap );
        viewHolder.imageView.setScaleType(ImageView.ScaleType.CENTER);
        viewHolder.title.setText(praiseList.getTitle());

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
        viewHolder.title.setOnClickListener(new View.OnClickListener() {
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
        return praiseLists.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView title;
        private final LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ll_cell_rating_emoji);
            title = itemView.findViewById(R.id.ll_cell_rating_emoji_desc);
            linearLayout = itemView.findViewById(R.id.ll_cell_rating);
        }
    }
}