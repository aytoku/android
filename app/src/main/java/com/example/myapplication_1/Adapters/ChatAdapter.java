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

    public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

        private final ChatItems[] chatItems;
        private final LayoutInflater layoutInflater;
        private final Context context;

        public ChatAdapter(ChatAdapter.ChatItems[] chatItems, Context context) {
            this.chatItems = chatItems;
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
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

            final ChatItems _item = chatItems[i];

            viewHolder.cv_item.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    try {
                        _item.getCallBack().call(_item);

                    } catch ( NullPointerException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return chatItems.length;
        }

        public static class ChatItems {

            public interface CallBack {
                void call(ChatItems itemsMenu);
            }

            private CallBack callBack;
            private String title;

            public ChatItems(CallBack callBack,String title) {
                this.callBack = callBack;
                this.title = title;
            }

            public CallBack getCallBack() {
                return callBack;
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