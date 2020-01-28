package com.example.myapplication_1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

public class SettingsAdapter extends RecyclerView.Adapter<SettingsAdapter.ViewHolder> {

    private final SettingsItems[] settingsItems;
    private final LayoutInflater layoutInflater;
    private final Context context;

    public SettingsAdapter(SettingsAdapter.SettingsItems[] settingsItems, Context context) {
        this.settingsItems = settingsItems;
        this.context = context;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ViewGroup v = (ViewGroup) layoutInflater.inflate(R.layout.cell_settings, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final SettingsItems _item = settingsItems[i];
        viewHolder.title.setText( _item.getStr() );
    }

    @Override
    public int getItemCount() {
        return settingsItems.length;
    }

    public static class SettingsItems {

        private String title;
        public SettingsItems(String title) {
            this.title = title;
        }
        public String getStr() {
            return title;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.ll_settings_rl_settings_title);
        }
    }
}