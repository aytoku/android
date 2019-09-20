package com.example.myapplication_1.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

import ru.osety.amironlibrary.DrawableUtils;

public class AdapterCellFeatures  extends RecyclerView.Adapter<AdapterCellFeatures.ViewHolder>{

        private final String[] array;
        private final LayoutInflater layoutInflater;
        private final Context context;
        private final Drawable draw;
        private final Drawable draw1;
        private final Drawable draw2;
        private final Drawable draw3;

        public AdapterCellFeatures(String[] array, Context context) {
           this.array = array;
            this.context = context;

            Drawable background_button = context.getResources().getDrawable(R.drawable.yellow_button);
            draw = DrawableUtils.setTintDrawable(background_button, Color.parseColor("#409AFF"));

            Drawable background_button1 = context.getResources().getDrawable(R.drawable.yellow_button);
            draw1 = DrawableUtils.setTintDrawable(background_button1, Color.parseColor("#2FBF52"));

            Drawable background_button2 = context.getResources().getDrawable(R.drawable.yellow_button);
            draw2 = DrawableUtils.setTintDrawable(background_button2, Color.parseColor("#F3B742"));

            Drawable background_button3 = context.getResources().getDrawable(R.drawable.yellow_button);
            draw3 = DrawableUtils.setTintDrawable(background_button3, Color.parseColor("#F3F3F3"));

            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            ViewGroup v = (ViewGroup) layoutInflater.inflate(R.layout.ll_button, viewGroup, false);
            return new AdapterCellFeatures.ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull AdapterCellFeatures.ViewHolder viewHolder, int i) {

            float _dens = context.getResources().getDisplayMetrics().density;

            int _size = Math.round(_dens * 12);

                viewHolder.button.setText(array[i]);
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
            } else if (str.equals("Детское кресло")){
                d_draw = draw3;
            }
            return d_draw;
        }

        @Override
        public int getItemCount() {
            return array.length;
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            private final Button button;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                button = itemView.findViewById(R.id.ll_button);
            }
        }
}

