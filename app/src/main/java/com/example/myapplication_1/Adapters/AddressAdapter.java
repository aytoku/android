package com.example.myapplication_1.Adapters;


import android.content.Context;
import android.graphics.Bitmap;
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

import java.util.List;

import ru.osety.amironlibrary.DrawableUtils;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.ViewHolder> {

    private final LayoutInflater layoutInflater;
    private final Context context;
    private List<AddressItems> addressItemsList;

    public AddressAdapter(List<AddressAdapter.AddressItems> addressItemsList, Context context) {
        this.addressItemsList = addressItemsList;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_addresses, viewGroup, false);
        ViewHolder itemViewHolder = new ViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

        final AddressItems _item = addressItemsList.get(i);

        Drawable ic_background_xml = context.getResources().getDrawable(R.mipmap.icon_car);
        float _dens = context.getResources().getDisplayMetrics().density;

        Drawable ic_rout_color = DrawableUtils.setTintDrawable(ic_background_xml, _item.getColorBackground());

        int _size = Math.round(_dens * 20);
        Drawable _def_draw = context.getResources().getDrawable(_item.getImg());
        Bitmap _bitmap = DrawableUtils.convertToBitmap(_def_draw, _size, _size);
        viewHolder.title.setText(_item.getStr());
        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
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
        return addressItemsList.size();
    }

    public static class AddressItems {

        public interface CallBack {
            void call(AddressItems itemsMenu);
        }

        int colorBackgroundInt;
        private int img;
        private String title;
        CallBack callBack;

        public AddressItems(int colorBackgroundRes, int img, String title, CallBack callBack) {
            this.colorBackgroundInt = colorBackgroundRes;
            this.img = img;
            this.title = title;
            this.callBack = callBack;
        }

        public int getImg() {
            return img;
        }

        public String getStr() {
            return title;
        }

        public int getColorBackground() {
            return colorBackgroundInt;
        }

        public CallBack getCallBack() {
            return (CallBack) callBack;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView title;
        private final LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.ll_cell_address_button_plus1);
            title = itemView.findViewById(R.id.ll_cell_address_add_address_home);
            linearLayout = itemView.findViewById(R.id.ll_cell_address);
        }
    }
}