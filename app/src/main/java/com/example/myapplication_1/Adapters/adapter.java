package com.example.myapplication_1.Adapters;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

import java.util.List;

public class adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final LayoutInflater layoutInflater;
    private Context context;
    private Drawable card_draw;
    private Drawable card;

    private List<ItemsMenu> itemsMenuList;

    public adapter(List<adapter.ItemsMenu> itemsMenuList, Context context) {
        this.itemsMenuList = itemsMenuList;
        this.context = context;

        card_draw = context.getResources().getDrawable(R.drawable.ic_card_grey_rect);
        card = context.getResources().getDrawable(R.drawable.ic_card);

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        RecyclerView.ViewHolder itemViewHolder;

        if(i >= 0 && i!= 2) {

            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_deployed_messages, viewGroup, false);
            itemViewHolder = new ViewHolder(view);

        } else {
            View view1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_deployed_messages_2, viewGroup, false);
            itemViewHolder = new ViewHolder1(view1);
        }
        return (RecyclerView.ViewHolder)itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {

        final ItemsMenu _item = itemsMenuList.get(i);

        if(i == 2){
            if(viewHolder instanceof ViewHolder1)

                viewHolder = (ViewHolder1)viewHolder;

        } else {
            if (i == 0) {
                viewHolder = (ViewHolder)viewHolder;
                ((ViewHolder) viewHolder).relativeLayout.setBackground(card);
                ((ViewHolder) viewHolder).title.setText(_item.getTitle());
            } else {
                ((ViewHolder) viewHolder).relativeLayout.setBackground(card_draw);
                ((ViewHolder) viewHolder).imageView.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return itemsMenuList.size();
    }

    public static class ItemsMenu {

        private @ColorInt
        int colorBackgroundInt;
        private String title;
        private String desc;

        public ItemsMenu(int colorBackgroundRes, String title, String desc) {
            this.colorBackgroundInt = colorBackgroundRes;
            this.title = title;
            this.desc = desc;
        }

        public String getTitle() {
            return title;
        }

        public String getDesc(){ return  desc; }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final RelativeLayout relativeLayout;
        private final ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.rl_cell_deployed_messages_title);
            relativeLayout = itemView.findViewById(R.id.rl_cell_deployed_messages);
            imageView  = itemView.findViewById(R.id.rl_cell_deployed_messages_button);
        }
    }

    class  ViewHolder1 extends RecyclerView.ViewHolder{

        private final TextView textView;
        private final ImageView imageView;
        private final TextView textView1;

        ViewHolder1(@NonNull View itemView){
            super(itemView);
            textView = itemView.findViewById(R.id.ll_cell_deployed_messages_2_title1);
            imageView = itemView.findViewById(R.id.ll_cell_deployed_messages_2_img);
            textView1 = itemView.findViewById(R.id.ll_cell_deployed_messages_2_title2);
        }
    }
}