package com.example.myapplication_1.Adapters;


import android.content.Context;
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

    public class AssistantAdapter extends RecyclerView.Adapter<AssistantAdapter.ViewHolder> {

        private final LayoutInflater layoutInflater;
        private Context context;
        private Drawable card;
        private Drawable card_gradient;
        private List<AssistantItems> assistantItemsList;

        public AssistantAdapter(List<AssistantItems> assistantItemsList, Context context) {
            this.assistantItemsList = assistantItemsList;
            this.context = context;

            card = context.getResources().getDrawable(R.drawable.ic_card_gradient);
            card_gradient = context.getResources().getDrawable(R.drawable.card_gradient_1);
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_assistant, viewGroup, false);
            ViewHolder itemViewHolder = new ViewHolder(view);
            return itemViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

            final AssistantItems _item = assistantItemsList.get(i);
            viewHolder.title.setText(_item.getTitle());

            if(i == 0){
                viewHolder.relativeLayout.setBackground(card);
            }else{
                viewHolder.relativeLayout.setBackground(card_gradient);
                viewHolder.imageView.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) viewHolder.relativeLayout.getLayoutParams();
                params.weight = 160;
                params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                viewHolder.relativeLayout.setLayoutParams(params);
            }
        }

        @Override
        public int getItemCount() {
            return assistantItemsList.size();
        }

        public static class AssistantItems {

            private String title;
            public AssistantItems(String title) {
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

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                title = itemView.findViewById(R.id.rl_cell_assistant_title);
                relativeLayout = itemView.findViewById(R.id.rl_cell_assistant);
                imageView  = itemView.findViewById(R.id.rl_cell_assistant_button);
            }
        }
    }