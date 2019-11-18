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

    public class CountryCodeSelectionAdapter extends RecyclerView.Adapter<CountryCodeSelectionAdapter.ViewHolder> {

        private final ItemsMenu[] itemsMenu;
        private final LayoutInflater layoutInflater;
        private final Context context;

        public CountryCodeSelectionAdapter(CountryCodeSelectionAdapter.ItemsMenu[] itemsMenu, Context context) {
            this.itemsMenu = itemsMenu;
            this.context = context;

            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            ViewGroup v = (ViewGroup) layoutInflater.inflate(R.layout.cell_country_code_selection, viewGroup, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

            final ItemsMenu _item = itemsMenu[i];

            Drawable ic_background_xml = context.getResources().getDrawable(R.mipmap.icon_car);
            float _dens = context.getResources().getDisplayMetrics().density;

            Drawable ic_rout_color = DrawableUtils.setTintDrawable(ic_background_xml, _item.getColorBackground());

            int _size = Math.round(_dens * 22);
            Drawable _def_draw = context.getResources().getDrawable(_item.getImgResId());
            Bitmap _bitmap = DrawableUtils.convertToBitmap(_def_draw, _size, _size);

            viewHolder.img.setBackground( ic_rout_color );
            viewHolder.img.setScaleType(ImageView.ScaleType.CENTER);
            viewHolder.img.setImageBitmap( _bitmap );
            viewHolder.letter.setText( _item.getLetter() );
            viewHolder.title.setText( _item.getStr() );
            viewHolder.code.setText( _item.getTime() );

            viewHolder.img.getRootView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    _item.callBack.call(_item);
                }
            });

            viewHolder.title.getRootView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    _item.callBack.call(_item);
                }
            });

            viewHolder.code.getRootView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    _item.callBack.call(_item);
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
            private String letter;
            private int imgResId;
            private String str;
            public CallBack callBack;
            private String code;

            public ItemsMenu(int colorBackgroundRes, String letter, int imgResId, String str, CallBack callBack, String code) {
                this.colorBackgroundInt = colorBackgroundRes;
                this.letter = letter;
                this.imgResId = imgResId;
                this.str = str;
                this.callBack = callBack;
                this.code = code;
            }

            public String getLetter(){return letter;}

            public int getImgResId() {
                return imgResId;
            }

            public String getStr() {
                return str;
            }

            public String getTime() {
                return code;
            }

            public int getColorBackground() {
                return colorBackgroundInt;
            }
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            private final TextView letter;
            private final ImageView img;
            private final TextView title;
            private final TextView code;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                letter = itemView.findViewById(R.id.ll_cell_country_code_selection_letter);
                img = itemView.findViewById(R.id.ll_cell_country_code_selection_ll_cell_country_code_selection1_img_georgia);
                title = itemView.findViewById(R.id.ll_cell_country_code_selection_ll_cell_country_code_selection1_country_georgia);
                code = itemView.findViewById(R.id.ll_cell_country_code_selection_ll_cell_country_code_selection1_georgia_number_code);
            }
        }
    }