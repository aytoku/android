package com.example.myapplication_1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

import java.util.List;

public class CalculationCostAdapter extends RecyclerView.Adapter<CalculationCostAdapter.ViewHolder> {

    private final Context context;
    private List<CalculationCostItems> createOrderItems;

    public CalculationCostAdapter(List<CalculationCostAdapter.CalculationCostItems> createOrderItems, Context context) {
        this.createOrderItems = createOrderItems;
        this.context = context;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_calculation_cost, viewGroup, false);
        ViewHolder itemViewHolder = new ViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        final CalculationCostItems _item = createOrderItems.get(i);
        viewHolder.title.setText(_item.getTitle());
        viewHolder.desc.setText(_item.getDesc());
    }

    @Override
    public int getItemCount() {
        return createOrderItems.size();
    }

    public static class CalculationCostItems {
        private String title;
        private String desc;

        public CalculationCostItems(String title, String desc) {
            this.title = title;
            this.desc = desc;
        }
        public String getTitle() {
            return title;
        }
        public String getDesc() {
            return desc;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.rl_cell_calculation_cost_title);
            desc = itemView.findViewById(R.id.rl_cell_calculation_cost_title_desc);
        }
    }
}
