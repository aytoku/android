package com.example.myapplication_1.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

import ru.osety.amironlibrary.DrawableUtils;

    public class EarningsPageAdapter extends RecyclerView.Adapter<EarningsPageAdapter.ViewHolder> {

        private final EarningsPageItems[] earningsPageItems;
        private final LayoutInflater layoutInflater;
        private final Context context;

        public EarningsPageAdapter(EarningsPageAdapter.EarningsPageItems[] earningsPageItems, Context context) {
            this.earningsPageItems = earningsPageItems;
            this.context = context;

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

            final EarningsPageItems _item = earningsPageItems[i];

            float _dens = context.getResources().getDisplayMetrics().density;

            try {

                AdapterCellTextFeatures adapterCellTextFeatures = new AdapterCellTextFeatures(_item.str_features, context);
                viewHolder.rv_features.setAdapter(adapterCellTextFeatures);
                viewHolder.rv_features.setLayoutManager(
                        new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
                viewHolder.rv_features.setItemAnimator(new DefaultItemAnimator());

            } catch (NullPointerException e){
                e.printStackTrace();
            }

            try {

                AdapterCellFeatures adapterCellFeatures = new AdapterCellFeatures(_item.button_features, context);
                viewHolder.rv_button_features.setAdapter(adapterCellFeatures);
                viewHolder.rv_button_features.setLayoutManager(
                        new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
                viewHolder.rv_button_features.setItemAnimator(new DefaultItemAnimator());

            } catch (NullPointerException e){
                e.printStackTrace();
            }

            int _size = Math.round(_dens * 12);

            Drawable _def_draw1 = context.getResources().getDrawable(_item.getImgArrow());
            Bitmap _bitmap1 = DrawableUtils.convertToBitmap(_def_draw1, _size, _size);

            viewHolder.dist.setText( _item.getStr());
            viewHolder.distance.setText( _item.getDistance());
            viewHolder.cost.setText(_item.getAddress_title());
            viewHolder.img.setImageBitmap(_bitmap1);
            viewHolder.desc3.setText(_item.getPlace());
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

        @Override
        public int getItemCount() {
            return earningsPageItems.length;
        }

        public static class EarningsPageItems {

            public interface CallBack {
                void call(EarningsPageItems itemsMenu);
            }

            private String dist;
            private CallBack callBack;
            private String[] str_features;
            private String[] button_features;
            private int imageView;
            private String desc;
            private String distance;
            private String desc2;
            private String address_title;
            private int img_arrow;
            private String place;

            public EarningsPageItems(String dist, String[] str_features, String[] button_features, int imageView, CallBack callBack, String desc, String distance, String desc2, String address_title, int img_arrow, String place) {
                this.dist = dist;
                this.callBack = callBack;
                this.str_features = str_features;
                this.button_features = button_features;
                this.imageView = imageView;
                this.desc = desc;
                this.distance = distance;
                this.desc2 = desc2;
                this.address_title = address_title;
                this.img_arrow = img_arrow;
                this.place = place;
            }

            public CallBack getCallBack() {
                return callBack;
            }

            public int getImgArrow() {
                return img_arrow;
            }

            public String getStr() {
                return dist;
            }

            public String getDistance() {
                return distance;
            }

            public String getAddress_title() {
                return address_title;
            }

            public String getPlace() {
                return place;
            }
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            private final CardView cv_item;
            private final TextView dist;
            private final RecyclerView rv_features;
            private final RecyclerView rv_button_features;
            private final TextView distance;
            private final TextView desc;
            private final TextView desc2;
            private final TextView cost;
            private final ImageView img;
            private final TextView desc3;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                cv_item = itemView.findViewById(R.id.ll_earnings_page_card_cv);
                dist = itemView.findViewById(R.id.ll_earnings_page_card_dist);
                desc = itemView.findViewById(R.id.ll_earnings_page_card_desc);
                desc2 = itemView.findViewById(R.id.ll_earnings_page_card_desc1);
                rv_features = itemView.findViewById(R.id.ll_earnings_page_card_recycler);
                rv_button_features = itemView.findViewById(R.id.ll_earnings_page_card_recycler1);
                distance = itemView.findViewById(R.id.ll_earnings_page_card_distance);
                cost = itemView.findViewById(R.id.ll_earnings_page_card_cost);
                img = itemView.findViewById(R.id.ll_earnings_page_card_img);
                desc3 = itemView.findViewById(R.id.ll_earnings_page_card_desc2);
            }
        }
    }