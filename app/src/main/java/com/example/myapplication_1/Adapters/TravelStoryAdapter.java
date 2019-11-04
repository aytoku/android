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

public class TravelStoryAdapter {

    public static class AdapterTravelStory extends RecyclerView.Adapter<AdapterTravelStory.ViewHolder> {

        private final TravelStoryCard[] itemsMenu;
        private final LayoutInflater layoutInflater;
        private final Context context;

        public AdapterTravelStory(AdapterTravelStory.TravelStoryCard[] itemsMenu, Context context) {
            this.itemsMenu = itemsMenu;
            this.context = context;

            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            ViewGroup v = (ViewGroup) layoutInflater.inflate(R.layout.cell_travel_story, viewGroup, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

            final TravelStoryCard _item = itemsMenu[i];

            float _dens = context.getResources().getDisplayMetrics().density;

            int _size = Math.round(_dens * 40);
            Drawable _def_draw = context.getResources().getDrawable(_item.getImgResId());
            Bitmap _bitmap = DrawableUtils.convertToBitmap(_def_draw, _size, _size);

            viewHolder.img.setScaleType(ImageView.ScaleType.CENTER);
            viewHolder.date.setText( _item.getDate() );
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

        public static class TravelStoryCard {

            public interface CallBack {
                void call(TravelStoryCard itemsMenu);
            }

            private @ColorInt
            int colorBackgroundInt;
            private int imgResId;
            private String date;
            private CallBack callBack;
            private String cost;
            private CardView cv_item;
            private String uuid;

            public TravelStoryCard(int colorBackgroundRes, int imgResId, String date, CallBack callBack,String cost) {
                this.colorBackgroundInt = colorBackgroundRes;
                this.imgResId = imgResId;
                this.date = date;
                this.callBack = callBack;
                this.cost = cost;
            }
            public String getUuid(){ return uuid ;}

            public void setUuid (String uuid){
                this.uuid = uuid;
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

            public CardView getCv_item(){return cv_item;}

            public String getCost() {
                return cost;
            }

            public int getColorBackground() {
                return colorBackgroundInt;
            }
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            private final ImageView img;
            private final TextView date;
            private final CardView cv_item;
            private final TextView cost;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                cv_item = itemView.findViewById(R.id.cv_item);
                img = itemView.findViewById(R.id.ellipse_red);
                date = itemView.findViewById(R.id.date);
                cost = itemView.findViewById(R.id.cost);
            }
        }
    }
}