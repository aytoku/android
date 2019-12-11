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

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

import java.util.List;

import ru.osety.amironlibrary.DrawableUtils;

public  class RatingAdapter extends RecyclerView.Adapter<RatingAdapter.ViewHolder> {

    private final LayoutInflater layoutInflater;
    private final Context context;
    private List<ItemsMenu> itemsMenuList;
    private int selectItem = -1;
    private Drawable drawable;

    public RatingAdapter(List<RatingAdapter.ItemsMenu> itemsMenuList, Context context) {
        this.itemsMenuList = itemsMenuList;
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

        final ItemsMenu _item = itemsMenuList.get(i);


        float _dens = context.getResources().getDisplayMetrics().density;

        int _size = Math.round(_dens * 15);
        Drawable _def_draw = context.getResources().getDrawable(_item.getStr());
        Bitmap _bitmap = DrawableUtils.convertToBitmap(_def_draw, _size, _size);
        viewHolder.emoji1.setImageBitmap( _bitmap );
        viewHolder.emoji1.setScaleType(ImageView.ScaleType.CENTER);
        viewHolder.emoji2.setText(_item.getStr1());

        if(selectItem == i){
            viewHolder.linearLayout.setBackground(drawable);
        } else{
            viewHolder.linearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }

        viewHolder.emoji1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                notifyItemChanged(selectItem);
                selectItem = i;
                notifyItemChanged(i);
                _item.callBack.call(_item);
            }
        });
        viewHolder.emoji2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                notifyItemChanged(selectItem);
                selectItem = i;
                notifyItemChanged(i);
                _item.callBack.call(_item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemsMenuList.size();
    }

    public static class ItemsMenu {

        public interface CallBack {
            void call(ItemsMenu itemsMenu);
        }

        private @ColorInt
        int colorBackgroundInt;
        private int emoji1;
        private String emoji2;
        private CallBack callBack;

        public ItemsMenu(int colorBackgroundRes, int emoji1, String emoji2, CallBack callBack) {
            this.colorBackgroundInt = colorBackgroundRes;
            this.emoji1 = emoji1;
            this.emoji2 = emoji2;
            this.callBack = callBack;
        }

        public int getStr() {
            return emoji1;
        }

        public String getStr1() {
            return emoji2;
        }

        public int getColorBackground() {
            return colorBackgroundInt;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView emoji1;
        private final TextView emoji2;
        private final LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            emoji1 = itemView.findViewById(R.id.ll_cell_rating_emoji);
            emoji2 = itemView.findViewById(R.id.ll_cell_rating_emoji_desc);
            linearLayout = itemView.findViewById(R.id.ll_cell_rating);
        }
    }
}