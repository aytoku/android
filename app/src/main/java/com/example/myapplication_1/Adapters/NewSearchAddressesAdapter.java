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

public class NewSearchAddressesAdapter extends RecyclerView.Adapter<NewSearchAddressesAdapter.ViewHolder>  {

    private List<NewSearchAddressesItems> newSearchAddressesItemsList;
    private Context context;
    private LayoutInflater layoutInflater;

    public NewSearchAddressesAdapter(List<NewSearchAddressesAdapter.NewSearchAddressesItems> newSearchAddressesItemsList, Context context){
        this.newSearchAddressesItemsList = newSearchAddressesItemsList;
        this.context = context;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_new_search_addresses, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i){
        final NewSearchAddressesItems newSearchAddressesItems = newSearchAddressesItemsList.get(i);
        viewHolder.title.setText(newSearchAddressesItems.getTitle());
        viewHolder.desc.setText(newSearchAddressesItems.getDesc());
    }

    @Override
    public int getItemCount() {
        return newSearchAddressesItemsList.size();
    }

    public static class NewSearchAddressesItems{
        private String title;
        private String desc;
        public NewSearchAddressesItems(String title, String desc){
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

    class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView title;
        private final TextView desc;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.ll_cell_new_search_addresses_title);
            desc = itemView.findViewById(R.id.ll_cell_new_search_addresses_desc);
        }
    }
}