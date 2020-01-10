package com.example.myapplication_1.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.R;

import java.util.List;

import ru.osety.amironlibrary.DrawableUtils;

public class PaymentMethodAdapter extends RecyclerView.Adapter<PaymentMethodAdapter.ViewHolder> {

    private final LayoutInflater layoutInflater;
    private final Context context;
    private List<PaymentMethodItems> itemsMenuList;
    private Drawable imgToggleGrey;
    private Drawable imgToggleRed;
    private int selectItem = -1;

    public PaymentMethodAdapter(List<PaymentMethodAdapter.PaymentMethodItems> itemsMenuList, Context context) {
        this.itemsMenuList = itemsMenuList;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        imgToggleGrey = context.getResources().getDrawable(R.drawable.togle_uncheked);
        imgToggleRed = context.getResources().getDrawable(R.drawable.toggle_checked);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_payment_method, viewGroup, false);
        ViewHolder itemViewHolder = new ViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

        final PaymentMethodItems _item = itemsMenuList.get(i);

        float _dens = context.getResources().getDisplayMetrics().density;
        int _size = Math.round(_dens * 40);
        Drawable _def_draw = context.getResources().getDrawable(_item.getCardImg());
        Bitmap _bitmap = DrawableUtils.convertToBitmap(_def_draw, _size, _size);

        viewHolder.card_img.setScaleType(ImageView.ScaleType.CENTER);
        viewHolder.card_img.setImageBitmap( _bitmap );
        viewHolder.title.setText( _item.getCardNumber() );
        if(selectItem == i){
            viewHolder.toggle_img.setImageDrawable(imgToggleRed);
        }else{
            viewHolder.toggle_img.setImageDrawable(imgToggleGrey);
        }
        viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notifyItemChanged(selectItem);
                selectItem = i;
                notifyItemChanged(i);
                _item.callBack.call(_item);
            }
        });
//        viewHolder.card_img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                itemsMenuList.add(i, _item);
//                notifyItemRemoved(i);
//                notifyItemRangeChanged(i, 1);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return itemsMenuList.size();
    }

    public static class PaymentMethodItems {

        public interface CallBack {
            void call(PaymentMethodItems itemsMenu);
        }

        private int card_img;
        private String card_number;
        private String date;
        private String cvv;
        private int toggle_img;
        private CallBack callBack;

        public PaymentMethodItems(int card_img, String card_number, String date, String cvv, int toggle_img, CallBack callBack) {
            this.card_img = card_img;
            this.card_number = card_number;
            this.date = date;
            this.cvv = cvv;
            this.toggle_img = toggle_img;
            this.callBack = callBack;
        }

        public String getCardNumber() {
            return card_number;
        }

        public String getDate() {
            return date;
        }

        public String getCvv() {
            return cvv;
        }

        public int getCardImg() {
            return card_img;
        }

        public CallBack getCallBack() {
            return callBack;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final ImageView card_img;
        private final ImageView toggle_img;
        private final RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            card_img = itemView.findViewById(R.id.rl_payment_method_card_img);
            title = itemView.findViewById(R.id.rl_payment_method_title);
            toggle_img = itemView.findViewById(R.id.rl_payment_method_toggle);
            relativeLayout = itemView.findViewById(R.id.rl_payment_method);
        }
    }
}