package com.example.myapplication_1.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

import java.util.List;

public class DriverMessagesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final LayoutInflater layoutInflater;
    private Context context;
    private Drawable card_draw;
    private Drawable card;
    private Drawable card_grey;

    private List<DriverMessagesAdapter.ItemsMenu> itemsMenuList;

    public DriverMessagesAdapter(List<DriverMessagesAdapter.ItemsMenu> itemsMenuList, Context context) {
        this.itemsMenuList = itemsMenuList;
        this.context = context;

        card_draw = context.getResources().getDrawable(R.drawable.chat_draw);
        card = context.getResources().getDrawable(R.drawable.ic_chat_card);
        card_grey = context.getResources().getDrawable(R.drawable.chat_grey_draw);

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int typeInt) {

        ViewGroup v = (ViewGroup) layoutInflater.inflate(R.layout.cell_messages, viewGroup, false);
        return new DriverMessagesAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int i) {

        final ItemsMenu _item = itemsMenuList.get(i);

        LinearLayout.LayoutParams params;
        if(i == 0){
            ((ViewHolder)viewHolder).relativeLayout.setBackground(card);
            ((ViewHolder)viewHolder).linearLayout.setPadding(100,0,0,0);
        }else{
            ((ViewHolder)viewHolder).relativeLayout.setBackground(card_draw);
            params = (LinearLayout.LayoutParams)((ViewHolder) viewHolder).relativeLayout.getLayoutParams();
            params.height = 200;
            params.width = 900;
            ((ViewHolder)viewHolder).linearLayout.setPadding(90,20,0,0);
            ((ViewHolder)viewHolder).title.setTextColor(Color.WHITE);
        }
        if(i == 2){
            ((ViewHolder)viewHolder).relativeLayout.setBackground(card_grey);
            params = (LinearLayout.LayoutParams)((ViewHolder) viewHolder).relativeLayout.getLayoutParams();
            params.height = 200;
            params.width = 900;
            ((ViewHolder)viewHolder).linearLayout.setPadding(20,25,10,15);
            ((ViewHolder)viewHolder).title.setTextColor(Color.BLACK);
        }

        if(i == 3){
            ((ViewHolder)viewHolder).relativeLayout.setBackground(card);
            ((ViewHolder)viewHolder).linearLayout.setPadding(100,0,0,0);
            params = (LinearLayout.LayoutParams)((ViewHolder) viewHolder).relativeLayout.getLayoutParams();
            params.height = 200;
            params.width = 920;
        }
    }

    @Override
    public int getItemCount() {
        return itemsMenuList.size();
    }

    public static class ItemsMenu {

        private String title;

        public ItemsMenu(String title) {
            this.title = title;

        }

        public String getTitle() {
            return title;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final RelativeLayout relativeLayout;
        private final ImageView imageView;
        private final  LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.rl_cell_deployed_messages_title);
            relativeLayout = itemView.findViewById(R.id.rl_cell_deployed_messages);
            imageView = itemView.findViewById(R.id.rl_cell_deployed_messages_button);
            linearLayout = itemView.findViewById(R.id.ll_cell_messages);
        }
    }
}