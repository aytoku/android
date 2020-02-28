package com.example.myapplication_1.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

import ru.osety.amironlibrary.DrawableUtils;

public class AssistantNotificationAdapter extends RecyclerView.Adapter<AssistantNotificationAdapter.ViewHolder> {

    private final AssistantNotificationAdapter.AssistantNotificationItems[] assistantNotificationItems;
    private final LayoutInflater layoutInflater;
    private final Context context;

    public AssistantNotificationAdapter(AssistantNotificationAdapter.AssistantNotificationItems[] assistantNotificationItems, Context context) {
        this.assistantNotificationItems = assistantNotificationItems;
        this.context = context;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public AssistantNotificationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ViewGroup v = (ViewGroup) layoutInflater.inflate(R.layout.cell_assistant_notification, viewGroup, false);
        return new AssistantNotificationAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AssistantNotificationAdapter.ViewHolder viewHolder, int i) {
        final AssistantNotificationAdapter.AssistantNotificationItems _item = assistantNotificationItems[i];
        float _dens = context.getResources().getDisplayMetrics().density;
        try{
            AssistantNotificationTextAdapter assistantNotificationTextAdapter = new AssistantNotificationTextAdapter(_item.str_text, context);
            viewHolder.rv_text.setAdapter(assistantNotificationTextAdapter);
            viewHolder.rv_text.setLayoutManager(
                    new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
            viewHolder.rv_text.setItemAnimator(new DefaultItemAnimator());
        }catch (NullPointerException e){
            e.printStackTrace();
        }

        try{
            AssistantNotificationButtonAdapter assistantNotificationButtonAdapter = new AssistantNotificationButtonAdapter(_item.str_button, context);
            viewHolder.rv_button.setAdapter(assistantNotificationButtonAdapter);
            viewHolder.rv_button.setLayoutManager(
                    new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
            viewHolder.rv_button.setItemAnimator(new DefaultItemAnimator());
        }catch (NullPointerException e){
            e.printStackTrace();
        }

        try{
            AssistantNotificationNewsAdapter assistantNotificationNewsAdapter = new AssistantNotificationNewsAdapter(_item.str_news, context);
            viewHolder.rv_news.setAdapter(assistantNotificationNewsAdapter);
            viewHolder.rv_news.setLayoutManager(
                    new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
            viewHolder.rv_news.setItemAnimator(new DefaultItemAnimator());
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return assistantNotificationItems.length;
    }

    public static class AssistantNotificationItems {

        private String[] str_text;
        private String[] str_button;
        private String[] str_news;

        public AssistantNotificationItems(String[] str_text, String[] str_button, String[] str_news) {
            this.str_text = str_text;
            this.str_button = str_button;
            this.str_news = str_news;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final RecyclerView rv_text;
        private final RecyclerView rv_button;
        private final RecyclerView rv_news;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rv_text = itemView.findViewById(R.id.rl_cell_assistant_notification_text_rv);
            rv_button = itemView.findViewById(R.id.rl_cell_assistant_notification_button_rv);
            rv_news = itemView.findViewById(R.id.rl_cell_assistant_notification_news_rv);
        }
    }
}
