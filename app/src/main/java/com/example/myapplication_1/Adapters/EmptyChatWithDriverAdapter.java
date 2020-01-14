package com.example.myapplication_1.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

import java.util.List;

public class EmptyChatWithDriverAdapter extends RecyclerView.Adapter<EmptyChatWithDriverAdapter.ViewHolder> {

        private List<ItemsMenu> itemsMenuList1;
        private final LayoutInflater layoutInflater;
        private final Context context;
        private Drawable card_draw;
        private Drawable card;
        private int selectItem = -1;

        public EmptyChatWithDriverAdapter(List<EmptyChatWithDriverAdapter.ItemsMenu> itemsMenuList1, Context context) {
            this.itemsMenuList1 = itemsMenuList1;
            this.context = context;

            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            ViewGroup v = (ViewGroup) layoutInflater.inflate(R.layout.cell_empty_chat_driver, viewGroup, false);
            ViewHolder itemViewHolder = new ViewHolder(v);
            return itemViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

            final ItemsMenu _item = itemsMenuList1.get(i);

            viewHolder.title.setText( _item.getTitle() );

            if(selectItem == i) {

                viewHolder.cv_item.setCardBackgroundColor(Color.parseColor("#FC5B58"));
                viewHolder.title.setTextColor(Color.WHITE);
            }else{

                viewHolder.cv_item.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                viewHolder.title.setTextColor(Color.BLACK);
            }

            viewHolder.cv_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    notifyItemChanged(selectItem);
                    selectItem = i;
                    notifyItemChanged(i);
                    _item.callBack.call(_item);
                }
            });
        }

        @Override
        public int getItemCount() {
            return itemsMenuList1.size();
        }

        public static class ItemsMenu {

            public interface CallBack {
                void call(ItemsMenu itemsMenu);
            }

            private String title;
            private CallBack callBack;

            public ItemsMenu(String title, CallBack callBack) {
                this.title = title;
                this.callBack = callBack;
            }

            public String getTitle() {
                return title;
            }
        }

        static class ViewHolder extends RecyclerView.ViewHolder {

            private final TextView title;
            private final CardView cv_item;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                cv_item = itemView.findViewById(R.id.cv_cell__empty_chat_with_driver);
                title = itemView.findViewById(R.id.cv_cell__empty_chat_with_driver_title);
            }
        }
    }