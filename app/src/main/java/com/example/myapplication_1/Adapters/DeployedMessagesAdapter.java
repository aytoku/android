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

public class DeployedMessagesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final LayoutInflater layoutInflater;
    private Context context;
    private Drawable card_draw;
    private Drawable card;
    private ImageView imageView;

    private List<DeployedMessagesAdapter.ItemsMenu> itemsMenuList;

    public DeployedMessagesAdapter(List<DeployedMessagesAdapter.ItemsMenu> itemsMenuList, Context context) {
        this.itemsMenuList = itemsMenuList;
        this.context = context;

        card_draw = context.getResources().getDrawable(R.drawable.ic_card_grey_rect);
        card = context.getResources().getDrawable(R.drawable.ic_card);

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getItemViewType(int position) {

        if (position >= 0 && position != 2) {
            return 0;
        }

        else if(position == 2){
            return 1;
        }

        else if(position == itemsMenuList.size()-1){
            return 2;
        }
        return position;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int typeInt) {

        RecyclerView.ViewHolder itemViewHolder;

        if (typeInt == 0) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_deployed_messages, viewGroup, false);
            itemViewHolder = new ViewHolder(view);
        }

        else if(typeInt == 1){
            View view1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_deployed_messages_2, viewGroup, false);
            itemViewHolder = new ViewHolder1(view1);
        }

        else{
            View view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_deployed_messages3, viewGroup, false);
            itemViewHolder = new ViewHolder2(view2);
        }
        return (RecyclerView.ViewHolder) itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {

        final ItemsMenu _item = itemsMenuList.get(i);

        if (i >=0 && i!=2) {
            if (i == 0) {
                viewHolder = (ViewHolder) viewHolder;
                ((ViewHolder) viewHolder).relativeLayout.setBackground(card);
                ((ViewHolder) viewHolder).title.setText(_item.getTitle());
                ((ViewHolder) viewHolder).desc.setText(_item.getDesc());
            }

            else {
                ((ViewHolder) viewHolder).relativeLayout.setBackground(card_draw);
                ((ViewHolder) viewHolder).imageView.setVisibility(View.GONE);
            }
        }

        else if(i == 2){
            if (viewHolder instanceof ViewHolder1)
                viewHolder = (ViewHolder1) viewHolder;
        }

        else if(i == itemsMenuList.size()-1){
            if(viewHolder instanceof ViewHolder2)
               viewHolder = (ViewHolder2)viewHolder;
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

        public String getDesc() { return desc; }

        public int getColorBackground() {
            return colorBackgroundInt;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final TextView desc;
        private final RelativeLayout relativeLayout;
        private final ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.rl_cell_deployed_messages_title);
            desc = itemView.findViewById(R.id.rl_cell_deployed_messages_desc);
            relativeLayout = itemView.findViewById(R.id.rl_cell_deployed_messages);
            imageView = itemView.findViewById(R.id.rl_cell_deployed_messages_button);
        }
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {

        private final TextView textView;
        private final ImageView imageView;
        private final TextView textView1;
        private final TextView textView2;
        private final TextView textView3;

        ViewHolder1(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.ll_cell_deployed_messages_2_title1);
            imageView = itemView.findViewById(R.id.ll_cell_deployed_messages_2_img);
            textView1 = itemView.findViewById(R.id.ll_cell_deployed_messages_2_title2);
            textView2 = itemView.findViewById(R.id.rl_cell_deployed_messages2_title);
            textView3 = itemView.findViewById(R.id.rl_cell_deployed_messages2_desc);
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView txtView;

        ViewHolder2(@NonNull View itemView) {
            super(itemView);
            txtView = itemView.findViewById(R.id.ll_cell_deployed_messages3_title);
            img = itemView.findViewById(R.id.ll_cell_deployed_messages3_img);
        }
    }
}