package com.example.myapplication_1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

    public class ChatWithDriverAdapter extends RecyclerView.Adapter<ChatWithDriverAdapter.ViewHolder> {

        private final ItemsMenu[] itemsMenu;
        private final LayoutInflater layoutInflater;
        private final Context context;
        private int selectItem = -1;

        public ChatWithDriverAdapter(ChatWithDriverAdapter.ItemsMenu[] itemsMenu, Context context) {
            this.itemsMenu = itemsMenu;
            this.context = context;

            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            ViewGroup v = (ViewGroup) layoutInflater.inflate(R.layout.cell_empty_chat_driver, viewGroup, false);
            return new ViewHolder(v);

        }

        @Override
        public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

            final ItemsMenu _item = itemsMenu[i];

            viewHolder.title.setText( _item.getTitle() );

        }

        @Override
        public int getItemCount() {
            return itemsMenu.length;
        }

        public static class ItemsMenu {

            public interface CallBack {
                void call(ItemsMenu itemsMenu);
            }

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
            private final CardView cv_item;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                cv_item = itemView.findViewById(R.id.cv_cell__empty_chat_with_driver);
                title = itemView.findViewById(R.id.cv_cell__empty_chat_with_driver_title);
            }
        }
    }