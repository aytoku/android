package com.example.myapplication_1.Adapters;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

import java.util.List;

public class MenuOneAdapter extends RecyclerView.Adapter<MenuOneAdapter.ViewHolder> {

    private final LayoutInflater layoutInflater;
    private final Context context;
    LinearLayout.LayoutParams params;
    private List<ItemsMenu> itemsMenuList;

    public MenuOneAdapter(List<MenuOneAdapter.ItemsMenu> itemsMenuList, Context context) {
        this.itemsMenuList = itemsMenuList;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_menu_1, viewGroup, false);
        ViewHolder itemViewHolder = new ViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

        final ItemsMenu _item = itemsMenuList.get(i);
        if (i == 0) {

            viewHolder.title.setBackgroundColor(Color.parseColor("#FD6F6D"));
            viewHolder.title.setTextColor(Color.parseColor("#FFFFFF"));
            params = (LinearLayout.LayoutParams) viewHolder.title.getLayoutParams();
            params.height = 200;
        }

        viewHolder.title.setText(_item.getStr());
        viewHolder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    _item.getCallBack().call(_item);
                }catch (NullPointerException e){
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemsMenuList.size();
    }

    public static class ItemsMenu {

        public interface CallBack {
            void call(ItemsMenu itemsMenu);

        }

        private @ColorInt
        int colorBackgroundInt;
        private String title;
        private CallBack callBack;

        public ItemsMenu(int colorBackgroundRes, String title, CallBack callBack) {
            this.colorBackgroundInt = colorBackgroundRes;
            this.title = title;
            this.callBack = callBack;
        }

        public String getStr() {
            return title;
        }

        public int getColorBackground() {
            return colorBackgroundInt;
        }

        public CallBack getCallBack() {
            return callBack;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.ll_cell_menu_1_title);
            linearLayout = itemView.findViewById(R.id.ll_menu_1);
        }
    }
}