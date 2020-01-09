package com.example.myapplication_1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

public class PartnersAdapter extends RecyclerView.Adapter<PartnersAdapter.ViewHolder> {

    private final PartnersItems[] itemsMenu;
    private final LayoutInflater layoutInflater;
    private final Context context;

    public PartnersAdapter(PartnersAdapter.PartnersItems[] itemsMenu, Context context) {
        this.itemsMenu = itemsMenu;
        this.context = context;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        ViewGroup v = (ViewGroup) layoutInflater.inflate(R.layout.cell_partners, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        final PartnersItems _item = itemsMenu[i];

        viewHolder.desc.setText( _item.getStr() );

        viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    _item.getCallBack().call(_item);
                }catch (NullPointerException e){
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemsMenu.length;
    }

    public static class PartnersItems {

        public interface CallBack {
            void call(PartnersItems itemsMenu);

        }

        private int imgResId;
        private String desc;
        private CallBack callBack;

        public PartnersItems(int imgResId,String desc, CallBack callBack) {
            this.imgResId = imgResId;
            this.desc = desc;
            this.callBack = callBack;
        }

        public int getImgResId() {
            return imgResId;
        }

        public String getStr() {
            return desc;
        }

        public CallBack getCallBack() {
            return callBack;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView desc;
        private final RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.ll_cell_partners_rl_cell_partners_img);
            desc = itemView.findViewById(R.id.ll_cell_partners_rl_cell_partners_title);
            relativeLayout = itemView.findViewById(R.id.ll_cell_partners_rl_cell_partners);

        }
    }
}