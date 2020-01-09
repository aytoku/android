package com.example.myapplication_1.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

import java.util.List;

public class AdapterCreateOrder115 extends RecyclerView.Adapter<AdapterCreateOrder115.ViewHolder> {

    private final LayoutInflater layoutInflater;
    private final Context context;

    private List<CreateOrderItems> itemsMenuList;

    public AdapterCreateOrder115(List<AdapterCreateOrder115.CreateOrderItems> itemsMenuList, Context context) {
        this.itemsMenuList = itemsMenuList;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_create_order_1_1_5, viewGroup, false);
        ViewHolder itemViewHolder = new ViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

        final CreateOrderItems _item = itemsMenuList.get(i);

        viewHolder.title.setText(_item.getStr());

        viewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemsMenuList.remove(i);
                notifyItemRemoved(i);
                notifyItemRangeChanged(i, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemsMenuList.size();
    }

    public static class CreateOrderItems {

        private int imgResId;
        private String title;
        private int imgResId1;

        public CreateOrderItems(int imgResId, String title, int imgResId1) {
            this.imgResId = imgResId;
            this.title = title;
            this.imgResId1 = imgResId1;
        }

        public int getImgResId() {
            return imgResId;
        }

        public String getStr() {
            return title;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView title;
        private final ImageView img1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.rl_cell_create_order_1_1_5_button_cross);
            title = itemView.findViewById(R.id.rl_cell_create_order_1_1_5_title);
            img1 = itemView.findViewById(R.id.rl_cell_create_order_1_1_5_button_line);
        }
    }
}