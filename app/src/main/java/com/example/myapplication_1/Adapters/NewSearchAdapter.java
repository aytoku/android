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
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

import java.util.List;

import ru.osety.amironlibrary.DrawableUtils;

public class NewSearchAdapter extends RecyclerView.Adapter<NewSearchAdapter.ViewHolder>  {

    private List<NewSearchItems> newSearchAdapterList;
    private Context context;
    private LayoutInflater layoutInflater;

    public NewSearchAdapter(List<NewSearchAdapter.NewSearchItems> newSearchAdapterList, Context context){
        this.newSearchAdapterList = newSearchAdapterList;
        this.context = context;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_search_new, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i){
        final NewSearchItems newSearchItems = newSearchAdapterList.get(i);
        float _dens = context.getResources().getDisplayMetrics().density;
        int _size = Math.round(_dens * 15);
        Drawable _drawable = context.getResources().getDrawable(newSearchItems.getImg());
        Bitmap bitmap = DrawableUtils.convertToBitmap(_drawable, _size, _size);
        viewHolder.img.setScaleType(ImageView.ScaleType.CENTER);
        viewHolder.img.setImageBitmap(bitmap);
        viewHolder.title.setText(newSearchItems.getTitle());
        viewHolder.desc.setText(newSearchItems.getDesc());
    }

    @Override
    public int getItemCount() {
        return newSearchAdapterList.size();
    }

    public static class NewSearchItems{
        private int img;
        private String title;
        private String desc;
        public NewSearchItems(int img, String title, String desc){
            this.img = img;
            this.title = title;
            this.desc = desc;
        }

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
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            img = itemView.findViewById(R.id.ll_cell_search_new_img);
            title = itemView.findViewById(R.id.ll_cell_search_new_title);
            desc = itemView.findViewById(R.id.ll_cell_search_new_desc);
        }
    }
}