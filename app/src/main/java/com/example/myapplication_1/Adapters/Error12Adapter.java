package com.example.myapplication_1.Adapters;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

import java.util.List;

import ru.osety.amironlibrary.DrawableUtils;

public  class Error12Adapter extends RecyclerView.Adapter<Error12Adapter.ViewHolder> {

    private final LayoutInflater layoutInflater;
    private final Context context;
    private List<Error12Adapter.ItemsMenu> itemsMenuList;
    private int selectItem = -1;
    private Drawable drawable;

    public Error12Adapter(List<Error12Adapter.ItemsMenu> itemsMenuList, Context context) {
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
        Drawable _def_draw = context.getResources().getDrawable(_item.getImgResId());
        Bitmap _bitmap = DrawableUtils.convertToBitmap(_def_draw, _size, _size);
        viewHolder.img.setImageBitmap( _bitmap );


        viewHolder.img.setScaleType(ImageView.ScaleType.CENTER);

        viewHolder.title.setText(_item.getStr());
        viewHolder.desc.setText(_item.getStr1());
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
        private String title;
        private String desc;
        private int img;
        private int img1;

        public ItemsMenu(int colorBackgroundRes, int img, String title, String desc, int img1) {
            this.colorBackgroundInt = colorBackgroundRes;
            this.img = img;
            this.title = title;
            this.desc = desc;
            this.img1 = img1;
        }

        public int getImgResId() {
            return img;
        }

        public String getStr() {
            return title;
        }

        public String getStr1() {
            return desc;
        }

        public int getColorBackground() {
            return colorBackgroundInt;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final TextView desc;
        private final ImageView img;
        private final ImageView img1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.rl_cell_error_1_2_title);
            desc = itemView.findViewById(R.id.rl_cell_error_1_2_desc);
            img = itemView.findViewById(R.id.rl_cell_error_1_2_image);
            img1 = itemView.findViewById(R.id.rl_cell_error_1_2_image1);
        }
    }
}