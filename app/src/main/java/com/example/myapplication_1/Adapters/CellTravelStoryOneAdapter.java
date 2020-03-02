package com.example.myapplication_1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

    public class CellTravelStoryOneAdapter extends RecyclerView.Adapter<CellTravelStoryOneAdapter.ViewHolder> {

        private final PaymentDesc[] paymentDesc;
        private final LayoutInflater layoutInflater;
        private final Context context;

        public CellTravelStoryOneAdapter(CellTravelStoryOneAdapter.PaymentDesc[] paymentDesc, Context context) {
            this.paymentDesc = paymentDesc;
            this.context = context;

            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            ViewGroup v = (ViewGroup) layoutInflater.inflate(R.layout.cell_travel_story_1, viewGroup, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            final PaymentDesc _item = paymentDesc[i];
            viewHolder.title.setText( _item.getTitle() );
            viewHolder.desc.setText( _item.getDesc() );
            viewHolder.cost.setText( _item.getCost() );
        }

        @Override
        public int getItemCount() {
            return paymentDesc.length;
        }

        public static class PaymentDesc {
            public interface CallBack {
                void call(PaymentDesc itemsMenu);
            }

            private String title;
            private String desc;
            private String cost;

            public PaymentDesc(String title,String desc, String cost) {
                this.title = title;
                this.desc = desc;
                this.cost = cost;
            }

            public String getTitle() {
                return title;
            }
            public String getDesc() {
                return desc;
            }
            public String getCost() {
                return cost;
            }
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            private final TextView title;
            private final TextView desc;
            private final TextView cost;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                title = itemView.findViewById(R.id.ll_travel_story_1_expectation);
                desc = itemView.findViewById(R.id.ll_travel_story_1_expectation_desc);
                cost = itemView.findViewById(R.id.ll_travel_story_1_expectation_cost);
            }
        }
    }