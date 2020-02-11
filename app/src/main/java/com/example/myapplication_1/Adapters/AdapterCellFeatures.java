package com.example.myapplication_1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

public class AdapterCellFeatures  extends RecyclerView.Adapter<AdapterCellFeatures.ViewHolder>{

    private final String[] array;
    private final LayoutInflater layoutInflater;
    private final Context context;

    AdapterCellFeatures(String[] array, Context context) {
        this.array = array;
        this.context = context;

//        Drawable background_button = context.getResources().getDrawable(R.drawable.yellow_button);
//        draw = DrawableUtils.setTintDrawable(background_button, Color.parseColor("#409AFF"));

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ViewGroup v = (ViewGroup) layoutInflater.inflate(R.layout.button_feature, viewGroup, false);
        return new AdapterCellFeatures.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCellFeatures.ViewHolder viewHolder, int i) {
        viewHolder.button.setText(array[i]);
       // viewHolder.button.setBackground(getCurrentColorButton(array[i]));
    }

//    public Drawable getCurrentColorButton(String str){
//        Drawable d_draw = null;
//        if(str.equals("Загород")){
//            d_draw = draw2;
//        }
//        else if(str.equals("Час-пик")){
//            d_draw = draw;
//        }else if(str.equals("Повышенный")){
//            d_draw = draw1;
//        } else if (str.equals("Детское кресло")){
//            d_draw = draw3;
//        }
//        return d_draw;
//    }

    @Override
    public int getItemCount() {
        return array.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView button;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.rl_button_feature_btn);
        }
    }
}