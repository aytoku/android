package com.example.myapplication_1.Adapters;

import android.content.Context;
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

public class DriverMessagesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final LayoutInflater layoutInflater;
    private Context context;

    private List<DriverMessagesAdapter.ItemsMenu> itemsMenuList;

    public DriverMessagesAdapter(List<DriverMessagesAdapter.ItemsMenu> itemsMenuList, Context context) {
        this.itemsMenuList = itemsMenuList;
        this.context = context;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int typeInt) {

        ViewGroup v = (ViewGroup) layoutInflater.inflate(R.layout.cell_messages, viewGroup, false);
        return new DriverMessagesAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {

        final ItemsMenu _item = itemsMenuList.get(i);

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
}