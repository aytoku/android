package com.example.myapplication_1.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

public class AssistantNotificationNewsAdapter extends RecyclerView.Adapter<AssistantNotificationNewsAdapter.ViewHolder>{

    private final String[] array;
    private final LayoutInflater layoutInflater;
    private final Context context;

    AssistantNotificationNewsAdapter(String[] array, Context context) {
        this.array = array;
        this.context = context;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public AssistantNotificationNewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ViewGroup v = (ViewGroup) layoutInflater.inflate(R.layout.cell_assistant_notification_news, viewGroup, false);
        return new AssistantNotificationNewsAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AssistantNotificationNewsAdapter.ViewHolder viewHolder, int i) {

        viewHolder.title.setText(array[i]);

        if(i == 0){
            viewHolder.title.setTypeface(viewHolder.title.getTypeface(), Typeface.BOLD);
            viewHolder.title.setTextSize(15);
        }
        if(i == 1){
            viewHolder.title.setTextColor(Color.parseColor("#515151"));
            viewHolder.title.setTextSize(14);
        }
        if(i == 2){
            viewHolder.title.setTextColor(Color.parseColor("#C3C3C3"));
            viewHolder.title.setTextSize(13);
        }
    }

    @Override
    public int getItemCount() {
        return array.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.rl_cell_assistant_notification_news_title);
        }
    }
}
