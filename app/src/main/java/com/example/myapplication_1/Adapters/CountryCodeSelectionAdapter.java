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

    public class CountryCodeSelectionAdapter extends RecyclerView.Adapter<CountryCodeSelectionAdapter.ViewHolder> {

        private final CountryCodeItems[] countryCodeItems;
        private final LayoutInflater layoutInflater;
        private final Context context;

        public CountryCodeSelectionAdapter(CountryCodeSelectionAdapter.CountryCodeItems[] countryCodeItems, Context context) {
            this.countryCodeItems = countryCodeItems;
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
            final CountryCodeItems _item = countryCodeItems[i];
            Drawable ic_background_xml = context.getResources().getDrawable(R.mipmap.icon_car);
            float _dens = context.getResources().getDisplayMetrics().density;
            Drawable ic_rout_color = DrawableUtils.setTintDrawable(ic_background_xml, _item.getColorBackground());
            int _size = Math.round(_dens * 22);
            Drawable _def_draw = context.getResources().getDrawable(_item.getImg());
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
            return countryCodeItems.length;
        }

        public static class CountryCodeItems {
            public interface CallBack {
                void call(CountryCodeItems itemsMenu);
            }

            int colorBackgroundInt;
            private String letter;
            private int img;
            private String str;
            public CallBack callBack;
            private String code;

            public CountryCodeItems(int colorBackgroundRes, String letter, int img, String str, CallBack callBack, String code) {
                this.colorBackgroundInt = colorBackgroundRes;
                this.letter = letter;
                this.img = img;
                this.str = str;
                this.callBack = callBack;
                this.code = code;
            }

            String getLetter(){return letter;}
            public int getImg() {
                return img;
            }
            public String getStr() {
                return str;
            }
            String getTime() {
                return code;
            }
            int getColorBackground() {
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