package com.example.myapplication_1.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

import java.util.List;

public class DriverTipsAdapter extends RecyclerView.Adapter<DriverTipsAdapter.ViewHolder> {

    private final LayoutInflater layoutInflater;
    private final Context context;
    private int selectItem = -1;

    private List<DriverTipsItems> driverTipsItemsList;

    public DriverTipsAdapter(List<DriverTipsAdapter.DriverTipsItems> driverTipsItemsList, Context context) {
        this.driverTipsItemsList = driverTipsItemsList;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_driver_tips, viewGroup, false);
        ViewHolder itemViewHolder = new ViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

        final DriverTipsItems _item = driverTipsItemsList.get(i);

        viewHolder.title.setText(_item.getStr());

        if(selectItem == i){
            viewHolder.cardView.setCardBackgroundColor(Color.parseColor("#FD6F6D"));
            viewHolder.title.setTextColor(Color.WHITE);

        }else{
            viewHolder.cardView.setCardBackgroundColor(Color.WHITE);
            viewHolder.title.setTextColor(Color.BLACK);
        }

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                notifyItemChanged(selectItem);
                selectItem = i;
                notifyItemChanged(i);
                _item.callBack.call(_item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return driverTipsItemsList.size();
    }

    public static class DriverTipsItems {

        public interface CallBack {
            void call(DriverTipsItems itemsMenu);

        }

        private String title;
        private CallBack callBack;

        public DriverTipsItems(String title, CallBack callBack) {
            this.title = title;
            this.callBack = callBack;
        }

        public String getStr() {
            return title;
        }

        public CallBack getCallBack() {
            return callBack;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.cv_rating_price);
            cardView = itemView.findViewById(R.id.ll_cv);
        }
    }
}