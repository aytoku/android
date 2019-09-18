package com.example.myapplication_1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import ru.osety.amironlibrary.DrawableUtils;

public class EarningsPageAdapter {

    public static class AdapterGridViewMenu extends RecyclerView.Adapter<AdapterGridViewMenu.ViewHolder> {

        private final ItemsMenu[] itemsMenu;
        private final LayoutInflater layoutInflater;
        private final Context context;
        private final Drawable draw;
        private final Drawable draw1;
        private final Drawable draw2;

        public AdapterGridViewMenu(AdapterGridViewMenu.ItemsMenu[] itemsMenu, Context context) {
            this.itemsMenu = itemsMenu;
            this.context = context;

            Drawable background_button = context.getResources().getDrawable(R.drawable.yellow_button);
            draw = DrawableUtils.setTintDrawable(background_button, Color.parseColor("#409AFF"));

            Drawable background_button1 = context.getResources().getDrawable(R.drawable.yellow_button);
            draw1 = DrawableUtils.setTintDrawable(background_button1, Color.parseColor("#2FBF52"));

            Drawable background_button2 = context.getResources().getDrawable(R.drawable.yellow_button);
            draw2 = DrawableUtils.setTintDrawable(background_button2, Color.parseColor("#F3B742"));

            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            ViewGroup v = (ViewGroup) layoutInflater.inflate(R.layout.cell_earnings_page_card, viewGroup, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

            final ItemsMenu _item = itemsMenu[i];

            float _dens = context.getResources().getDisplayMetrics().density;

            int _size = Math.round(_dens * 12);

            Drawable _def_draw = context.getResources().getDrawable(_item.getImgResId());
            Drawable _def_draw1 = context.getResources().getDrawable(_item.getImgArrow());
            Bitmap _bitmap = DrawableUtils.convertToBitmap(_def_draw, _size, _size);
            Bitmap _bitmap1 = DrawableUtils.convertToBitmap(_def_draw1, _size, _size);

            for(int j = 0; j < _item.str_features.length - 1; j++) {
                Button instance_button = (Button) layoutInflater.inflate(R.layout.ll_button, viewHolder.ll_features, false);
               // Button instance_button = (Button) instance_layout.findViewById(R.id.ll_button);
                instance_button.setText(_item.str_features[j]);
                instance_button.setBackground(getCurrentColorButton(_item.str_features[j]));
                instance_button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                viewHolder.ll_features.addView(instance_button, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            }

            viewHolder.img.setScaleType(ImageView.ScaleType.CENTER);
            viewHolder.img.setImageBitmap( _bitmap);
            viewHolder.cost.setText( _item.getStr());
            viewHolder.img.setImageBitmap(_bitmap);
            viewHolder.distance.setText( _item.getDistance());
            viewHolder.address_title.setText(_item.getAddress_title());
            viewHolder.img_arrow.setImageBitmap(_bitmap1);
            viewHolder.place.setText(_item.getPlace());
            viewHolder.cv_item.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    try {
                        _item.getCallBack().call(_item);

                    } catch ( NullPointerException e){
                        e.printStackTrace();
                    }
                }
            });
        }

        public Drawable getCurrentColorButton(String str){
            Drawable d_draw = null;
            if(str.equals("Загород")){
                d_draw = draw2;
            }
            else if(str.equals("Час-пик")){
                d_draw = draw;
            }else if(str.equals("Повышенный")){
                d_draw = draw1;
            }
            return d_draw;
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
            private String cost;
            private CallBack callBack;
            private String[] str_features;
            private int imgResId;
            private String distance;
            private String address_title;
            private int img_arrow;
            private String place;

            public ItemsMenu(int colorBackgroundRes, String cost, String[] str_features, CallBack callBack, int imgResId, String distance, String address_title, int img_arrow, String place) {
                this.colorBackgroundInt = colorBackgroundRes;
                this.cost = cost;
                this.callBack = callBack;
                this.str_features = str_features;
                this.imgResId = imgResId;
                this.distance = distance;
                this.address_title = address_title;
                this.img_arrow = img_arrow;
                this.place = place;
            }

            public CallBack getCallBack() {
                return callBack;
            }

            public int getImgResId() {
                return imgResId;
            }

            public int getImgArrow() {
                return img_arrow;
            }

            public String getStr() {
                return cost;
            }

            public String[] getStr_features(){return str_features;}

            public String getDistance() {
                return distance;
            }

            public String getAddress_title() {
                return address_title;
            }

            public String getPlace() {
                return place;
            }

            public int getColorBackground() {
                return colorBackgroundInt;
            }
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            private final CardView cv_item;
            private final TextView cost;
            private final LinearLayout ll_features;
            private final ImageView img;
            private final TextView distance;
            private final TextView address_title;
            private final ImageView img_arrow;
            private final TextView place;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                cv_item = itemView.findViewById(R.id.ll_earnings_page_card_cv);
                cost = itemView.findViewById(R.id.ll_earnings_page_card_cost);
                ll_features = itemView.findViewById(R.id.ll_earnings_page_card_linear);
                distance = itemView.findViewById(R.id.ll_earnings_page_card_distance);
                img = itemView.findViewById(R.id.ll_earnings_page_card_img_road);
                address_title = itemView.findViewById(R.id.ll_earnings_page_card_address_title);
                img_arrow = itemView.findViewById(R.id.ll_earnings_page_card_img_arrow);
                place = itemView.findViewById(R.id.ll_earnings_page_card_place);
            }
        }
    }
}
