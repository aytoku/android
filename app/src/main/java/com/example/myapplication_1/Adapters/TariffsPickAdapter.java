package com.example.myapplication_1.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

import java.util.List;

import ru.osety.amironlibrary.DrawableUtils;

public class TariffsPickAdapter extends RecyclerView.Adapter<TariffsPickAdapter.ViewHolder> {

    private final LayoutInflater layoutInflater;
    private final Context context;
    LinearLayout.LayoutParams params;
    private Drawable unChecked;
    private Drawable checked;
    private boolean f = true;

    private List<ItemsMenu> itemsMenuList;

    public TariffsPickAdapter(List<TariffsPickAdapter.ItemsMenu> itemsMenuList, Context context) {
        this.itemsMenuList = itemsMenuList;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        unChecked = context.getResources().getDrawable(R.drawable.ic_empty_switch);
        checked = context.getResources().getDrawable(R.drawable.ic_checked_switch);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_tarrifs_pick, viewGroup, false);
        ViewHolder itemViewHolder = new ViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

        final ItemsMenu _item = itemsMenuList.get(i);

        float _dens = context.getResources().getDisplayMetrics().density;

        int _size = Math.round(_dens * 18);
        Drawable _def_draw = context.getResources().getDrawable(_item.getImgResId());
        Bitmap _bitmap = DrawableUtils.convertToBitmap(_def_draw, _size, _size);

        viewHolder.imageView.setScaleType(ImageView.ScaleType.CENTER);
        viewHolder.imageView.setImageBitmap( _bitmap );
        viewHolder.title.setText(_item.getStr());


        viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  if (f =!f) {
                      viewHolder.imageView.setImageDrawable(checked);
                  }else {
                      viewHolder.imageView.setImageDrawable(unChecked);
                  }
              }
          });
    }

    @Override
    public int getItemCount() {
        return itemsMenuList.size();
    }

    public static class ItemsMenu {

        public interface CallBack {
            void call(ItemsMenu itemsMenu);

        }

        private @ColorInt
        int colorBackgroundInt;
        private String title;
        private CallBack callBack;
        private int img;

        public ItemsMenu(int colorBackgroundRes, String title, CallBack callBack, int img) {
            this.colorBackgroundInt = colorBackgroundRes;
            this.title = title;
            this.callBack = callBack;
            this.img = img;
        }

        public int getImgResId() {
            return img;
        }

        public String getStr() {
            return title;
        }

        public int getColorBackground() {
            return colorBackgroundInt;
        }

        public CallBack getCallBack() {
            return callBack;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final RelativeLayout relativeLayout;
        private final ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.rl_cell_tariffs_pick_title);
            imageView = itemView.findViewById(R.id.rl_cell_tariffs_pick_img);
            relativeLayout = itemView.findViewById(R.id.rl_cell_tariffs_pick);
        }
    }
}