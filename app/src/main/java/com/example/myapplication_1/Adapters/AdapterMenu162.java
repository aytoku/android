package com.example.myapplication_1.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

import java.util.List;

public class AdapterMenu162 extends RecyclerView.Adapter<AdapterMenu162.ViewHolder> {

    private final LayoutInflater layoutInflater;
    private final Context context;
    private List<Menu162List> itemsMenuList;

    public AdapterMenu162(List<AdapterMenu162.Menu162List> itemsMenuList, Context context) {
        this.itemsMenuList = itemsMenuList;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_menu_1_6_2, viewGroup, false);
        ViewHolder itemViewHolder = new ViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

        final Menu162List _item = itemsMenuList.get(i);

        viewHolder.title.setText(_item.getStr());

        viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
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

    public static class Menu162List {

        public interface CallBack {
            void call(Menu162List menu162List);
        }

        private String title;
        private int imageButton;
        private CallBack callBack;

        public Menu162List(String title, int imageButton, CallBack callBack) {
            this.title = title;
            this.imageButton = imageButton;
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
        private final ImageView imageButton;
        private final RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.rl_cell_menu_1_6_2_title);
            imageButton = itemView.findViewById(R.id.rl_cell_menu_1_6_2_img_arrow);
            relativeLayout = itemView.findViewById(R.id.rl_cell_menu_1_6_2);
        }
    }
}