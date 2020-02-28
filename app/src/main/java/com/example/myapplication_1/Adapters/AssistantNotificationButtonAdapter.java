package com.example.myapplication_1.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

public class AssistantNotificationButtonAdapter  extends RecyclerView.Adapter<AssistantNotificationButtonAdapter.ViewHolder>{

    private final String[] array;
    private final LayoutInflater layoutInflater;
    private final Context context;
    private int selectItem = -1;
    private Drawable gray_back;
    private Drawable red_back;
    private Drawable finger_gray;
    private Drawable finger_red;

    AssistantNotificationButtonAdapter(String[] array, Context context) {
        this.array = array;
        this.context = context;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        gray_back = context.getResources().getDrawable(R.drawable.ic_helper_notion_normal);
        red_back = context.getResources().getDrawable(R.drawable.ic_assistant_notification_back_red);
        finger_gray = context.getResources().getDrawable(R.drawable.ic_helper_notion_finger);
        finger_red = context.getResources().getDrawable(R.drawable.assistant_finger_back);
    }

    @NonNull
    @Override
    public AssistantNotificationButtonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ViewGroup v = (ViewGroup) layoutInflater.inflate(R.layout.cell_assistant_notification_button, viewGroup, false);
        return new AssistantNotificationButtonAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final AssistantNotificationButtonAdapter.ViewHolder viewHolder, final int i) {

        viewHolder.title.setText(array[i]);

        if(selectItem == i && selectItem != 1){
            viewHolder.title.setBackground(red_back);
            viewHolder.title.setTextColor(Color.parseColor("#FFFFFF"));
        }else{
            viewHolder.title.setBackground(gray_back);
            viewHolder.title.setTextColor(Color.parseColor("#FC5B58"));
        }
        if(selectItem == 1){
            viewHolder.title.setBackground(finger_gray);
        }

        viewHolder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notifyItemChanged(selectItem);
                selectItem = i;
                notifyItemChanged(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return array.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.ll_cell_assistant_notification_button_title);
        }
    }
}