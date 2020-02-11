package com.example.myapplication_1.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

import java.util.List;

public class AdapterMenu11 extends RecyclerView.Adapter<AdapterMenu11.ViewHolder> {

    private final LayoutInflater layoutInflater;
    private final Context context;

    private List<MenuList> itemsMenuList;

    public AdapterMenu11(List<AdapterMenu11.MenuList> itemsMenuList, Context context) {
        this.itemsMenuList = itemsMenuList;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_menu_1_1, viewGroup, false);
        ViewHolder itemViewHolder = new ViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        final MenuList menuListItem = itemsMenuList.get(i);
        viewHolder.title.setText(menuListItem.getStr());
        viewHolder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    menuListItem.getCallBack().call(menuListItem);
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemsMenuList.size();
    }

    public static class MenuList {

        public interface CallBack {
            void call(MenuList menuList);
        }

        private String title;
        private CallBack callBack;

        public MenuList(String title, CallBack callBack) {
            this.title = title;
            this.callBack = callBack;
        }

        public String getStr() {
            return title;
        }

        public CallBack getCallBack() {
            return callBack;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.ll_cell_menu_1_1_title);
        }
    }
}