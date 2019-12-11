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
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

import ru.osety.amironlibrary.DrawableUtils;

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.ViewHolder> {

    private final ItemsMenu[] itemsMenu;
    private final LayoutInflater layoutInflater;
    private final Context context;

    public MainActivityAdapter(MainActivityAdapter.ItemsMenu[] itemsMenu, Context context) {
        this.itemsMenu = itemsMenu;
        this.context = context;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        ViewGroup v = (ViewGroup) layoutInflater.inflate(R.layout.activity_main, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        final ItemsMenu _item = itemsMenu[i];

        float _dens = context.getResources().getDisplayMetrics().density;

        int _size = Math.round(_dens * 40);
        Drawable _def_draw = context.getResources().getDrawable(_item.getImgResId());
        Bitmap _bitmap = DrawableUtils.convertToBitmap(_def_draw, _size, _size);

        viewHolder.img.setScaleType(ImageView.ScaleType.CENTER);
        viewHolder.title.setText( _item.getDate() );
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
        return itemsMenu.length;
    }

    public static class ItemsMenu {

        public interface CallBack {
            void call(ItemsMenu itemsMenu);
        }

        private @ColorInt
        int colorBackgroundInt;
        private int imgResId;
        private String title;
        private CallBack callBack;
        private String cost;

        public ItemsMenu(int colorBackgroundRes, int imgResId, String title, CallBack callBack,String cost) {
            this.colorBackgroundInt = colorBackgroundRes;
            this.imgResId = imgResId;
            this.title = title;
            this.callBack = callBack;
            this.cost = cost;
        }

        public CallBack getCallBack() {
            return callBack;
        }

        public int getImgResId() {
            return imgResId;
        }

        public String getDate() {
            return title;
        }

        public String getCost() {
            return cost;
        }

        public int getColorBackground() {
            return colorBackgroundInt;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView title;
        private final CardView cv_item;
        private final TextView cost;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cv_item = itemView.findViewById(R.id.cv_item);
            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
            cost = itemView.findViewById(R.id.cost);

        }
    }
}