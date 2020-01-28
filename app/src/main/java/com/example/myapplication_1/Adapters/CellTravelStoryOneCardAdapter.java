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
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

import ru.osety.amironlibrary.DrawableUtils;

public class CellTravelStoryOneCardAdapter extends RecyclerView.Adapter<CellTravelStoryOneCardAdapter.ViewHolder> {

    private final TravelStoryRow[] travelStoryRows;
    private final LayoutInflater layoutInflater;
    private final Context context;

    public CellTravelStoryOneCardAdapter(CellTravelStoryOneCardAdapter.TravelStoryRow[] travelStoryRows, Context context) {
        this.travelStoryRows = travelStoryRows;
        this.context = context;

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
        final TravelStoryRow _item = travelStoryRows[i];
        float _dens = context.getResources().getDisplayMetrics().density;
        int _size = Math.round(_dens * 40);
        Drawable _def_draw = context.getResources().getDrawable(_item.getImg());
        Bitmap _bitmap = DrawableUtils.convertToBitmap(_def_draw, _size, _size);
        viewHolder.img.setScaleType(ImageView.ScaleType.CENTER);
        viewHolder.date.setText( _item.getDate() );
        viewHolder.address.setText( _item.getAddress() );
    }

    @Override
    public int getItemCount() {
        return travelStoryRows.length;
    }

    public static class TravelStoryRow {

        public interface CallBack {
            void call(TravelStoryRow itemsMenu);
        }

        private String date;
        private int img;
        private CallBack callBack;
        private String address;

        public TravelStoryRow(String date, int img, CallBack callBack,String address) {
            this.date = date;
            this.img = img;
            this.callBack = callBack;
            this.address = address;
        }

        public CallBack getCallBack() {
            return callBack;
        }
        public int getImg() {
            return img;
        }
        String getDate() {
            return date;
        }
        String getAddress() {
            return address;
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