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

import ru.osety.amironlibrary.DrawableUtils;

public class CellTravelStoryOneCardAdapter {

    public static class AdapterTravelStoryOneCard extends RecyclerView.Adapter<AdapterTravelStoryOneCard.ViewHolder> {

        private final TravelStoryRow[] itemsMenu;
        private final LayoutInflater layoutInflater;
        private final Context context;
        private final Drawable drawable;

        public AdapterTravelStoryOneCard(AdapterTravelStoryOneCard.TravelStoryRow[] itemsMenu, Context context) {
            this.itemsMenu = itemsMenu;
            this.context = context;

            drawable = context.getResources().getDrawable(R.drawable.button_grey_story);

            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            ViewGroup v = (ViewGroup) layoutInflater.inflate(R.layout.cell_travel_story_1_card, viewGroup, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

            final TravelStoryRow _item = itemsMenu[i];

            float _dens = context.getResources().getDisplayMetrics().density;

            int _size = Math.round(_dens * 40);
            Drawable _def_draw = context.getResources().getDrawable(_item.getImgResId());
            Bitmap _bitmap = DrawableUtils.convertToBitmap(_def_draw, _size, _size);

            viewHolder.img.setScaleType(ImageView.ScaleType.CENTER);
            viewHolder.date.setText( _item.getDate() );
            viewHolder.address.setText( _item.getAddress() );
        }

        @Override
        public int getItemCount() {
            return itemsMenu.length;
        }

        public static class TravelStoryRow {


            public interface CallBack {
                void call(TravelStoryRow itemsMenu);
            }

            private @ColorInt
            int colorBackgroundInt;
            private String date;
            private int imgResId;
            private CallBack callBack;
            private String address;

            public TravelStoryRow(int colorBackgroundRes, String date, int imgResId, CallBack callBack,String address) {
                this.colorBackgroundInt = colorBackgroundRes;
                this.date = date;
                this.imgResId = imgResId;
                this.callBack = callBack;
                this.address = address;
            }

            public CallBack getCallBack() {
                return callBack;
            }

            public int getImgResId() {
                return imgResId;
            }

            public String getDate() {
                return date;
            }

            public String getAddress() {
                return address;
            }

            public int getColorBackground() {
                return colorBackgroundInt;
            }
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            private final TextView date;
            private final ImageView img;
            private final TextView address;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                date = itemView.findViewById(R.id.ll_travel_story_1_date);
                img = itemView.findViewById(R.id.ll_travel_story_1_img_red_circle);
                address = itemView.findViewById(R.id.ll_travel_story_1_address_title);
            }
        }
    }
}