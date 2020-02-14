package com.example.myapplication_1.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

import ru.osety.amironlibrary.DrawableUtils;

public class BlacklistPartnersAdapter extends RecyclerView.Adapter<BlacklistPartnersAdapter.ViewHolder> {

    private final BlackListItems[] blackListItems;
    private final LayoutInflater layoutInflater;
    private final Context context;
    private Drawable imgToggleGrey;
    private Drawable imgToggleRed;

    public BlacklistPartnersAdapter(BlacklistPartnersAdapter.BlackListItems[] blackListItems, Context context) {
        this.blackListItems = blackListItems;
        this.context = context;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        imgToggleGrey = context.getResources().getDrawable(R.drawable.togle_uncheked);
        imgToggleRed = context.getResources().getDrawable(R.drawable.toggle_checked);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        ViewGroup v = (ViewGroup) layoutInflater.inflate(R.layout.cell_blacklist_partner, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

        final BlackListItems _item = blackListItems[i];

        float _dens = context.getResources().getDisplayMetrics().density;
        int _size = Math.round(_dens * 25);
        Drawable _def_draw = context.getResources().getDrawable(_item.getImg());
        Bitmap _bitmap = DrawableUtils.convertToBitmap(_def_draw, _size, _size);
        viewHolder.img.setScaleType(ImageView.ScaleType.CENTER);
        viewHolder.img.setImageBitmap(_bitmap);
        viewHolder.desc.setText(_item.getStr());
        viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _item.check =! _item.check;
                if(_item.check){
                    viewHolder.img.setImageDrawable(imgToggleRed);
                    viewHolder.desc.setTextColor(Color.parseColor("#FB2933"));
                }else {
                    viewHolder.img.setImageDrawable(imgToggleGrey);
                    viewHolder.desc.setTextColor(Color.parseColor("#424242"));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return blackListItems.length;
    }

    public static class BlackListItems {

        public interface CallBack {
            void call(BlackListItems itemsMenu);
        }

        private int img;
        private String desc;
        private boolean check;
        private CallBack callBack;

        public BlackListItems(int img,String desc, boolean check, CallBack callBack) {
            this.img = img;
            this.desc = desc;
            this.check = check;
            this.callBack = callBack;
        }

        public int getImg() {
            return img;
        }
        public String getStr() {
            return desc;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView desc;
        private final RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.ll_cell_blacklist_partner_checkbox);
            desc = itemView.findViewById(R.id.ll_cell_blacklist_partner_desc);
            relativeLayout = itemView.findViewById(R.id.ll_cell_blacklist_partner);
        }
    }
}