package com.example.myapplication_1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

import java.util.List;

public class DiagnosticsAdapter extends RecyclerView.Adapter<DiagnosticsAdapter.ViewHolder>  {

    private List<DiagnosticsItems> diagnosticsItemsList;
    private Context context;
    private LayoutInflater layoutInflater;

    public DiagnosticsAdapter(List<DiagnosticsAdapter.DiagnosticsItems> diagnosticsItemsList, Context context){
        this.diagnosticsItemsList = diagnosticsItemsList;
        this.context = context;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_diagnostics, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i){
        final DiagnosticsItems diagnosticsItems = diagnosticsItemsList.get(i);

        viewHolder.title.setText(diagnosticsItems.getTitle());
        viewHolder.desc.setText(diagnosticsItems.getDesc());
    }

    @Override
    public int getItemCount() {
        return diagnosticsItemsList.size();
    }

    public static class DiagnosticsItems{
        private int close_button_img;
        private String title;
        private String desc;
        private int img;
        public DiagnosticsItems(int close_button_img, String title, String desc, int img){
            this.close_button_img = close_button_img;
            this.title = title;
            this.desc = desc;
            this.img = img;
        }

        public int getClose_button_img(){return close_button_img;}

        public int getImg() {
            return img;
        }

        public String getTitle() {
            return title;
        }

        public String getDesc() {
            return desc;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView img;
        private final TextView title;
        private final TextView desc;
        private final ImageView close_button_img;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            img = itemView.findViewById(R.id.rl_cell_diagnostics_img);
            title = itemView.findViewById(R.id.rl_cell_diagnostics_title);
            desc = itemView.findViewById(R.id.rl_cell_diagnostics_desc);
            close_button_img = itemView.findViewById(R.id.rl_cell_diagnostics_close_button_img);
        }
    }
}
