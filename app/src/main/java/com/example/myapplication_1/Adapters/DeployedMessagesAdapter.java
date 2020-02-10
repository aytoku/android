package com.example.myapplication_1.Adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Fragments.MessageDialog;
import com.example.myapplication_1.R;

import java.util.Collections;
import java.util.List;

public class DeployedMessagesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final LayoutInflater layoutInflater;
    private Context context;
    private Drawable card_draw;
    private Drawable card;
    private List<String> list;
    private List<MessageDialog> messageDialogs;
    private List<MessageDialog> data = Collections.emptyList();
    private List<DeployedMessagesAdapter.DeployedMessagesItems> deployedMessagesItemsList;

    public DeployedMessagesAdapter(List<DeployedMessagesAdapter.DeployedMessagesItems> deployedMessagesItemsList, Context context) {
        this.deployedMessagesItemsList = deployedMessagesItemsList;
        this.context = context;

        card_draw = context.getResources().getDrawable(R.drawable.ic_card_grey_rect);
        card = context.getResources().getDrawable(R.drawable.ic_card);

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

//    @Override
//    public int getItemViewType(int position) {
//        if(position == deployedMessagesItemsList.size()-1){
//            return 2;
//        } else if (position >= 0 && position != 2) {
//            return 0;
//        } else if(position == 2){
//            return 1;
//        }
//        return position;
//    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int typeInt) {

        RecyclerView.ViewHolder itemViewHolder;

        //if (typeInt == 0) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_deployed_messages, viewGroup, false);
            itemViewHolder = new ViewHolder(view);
//        } else if(typeInt == 1){
//            View view1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_deployed_messages_2, viewGroup, false);
//            itemViewHolder = new ViewHolder1(view1);
//        } else{
//            View view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_deployed_messages3, viewGroup, false);
//            itemViewHolder = new ViewHolder2(view2);
//        }
        return (RecyclerView.ViewHolder) itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {

        //final DeployedMessagesItems _item = deployedMessagesItemsList.get(i);
        ((ViewHolder)viewHolder).title.setText(list.get(i));
        list.get(i);
        MessageDialog messageDialog = data.get(i);
        ((ViewHolder)viewHolder).title.setText(messageDialog.message);
        LinearLayout.LayoutParams params;
        if(i > 0){
            ((ViewHolder)viewHolder).relativeLayout.setBackground(card_draw);
            params = (LinearLayout.LayoutParams)((ViewHolder) viewHolder).relativeLayout.getLayoutParams();
            params.height = 240;
            params.width = 905;
        }
//        if(i == deployedMessagesItemsList.size()-1){
//            if(viewHolder instanceof ViewHolder2)
//                viewHolder = (ViewHolder2)viewHolder;
//            if(i==0){
//                ((ViewHolder2)viewHolder).linearLayout.setVisibility(View.GONE);
//            }
//        } else if (i >=0 && i!=2) {
//            if (i == 0) {
//                viewHolder = (ViewHolder) viewHolder;
//                ((ViewHolder) viewHolder).relativeLayout.setBackground(card);
//                ((ViewHolder) viewHolder).title.setText(_item.getTitle());
//            } else {
//                ((ViewHolder) viewHolder).relativeLayout.setBackground(card_draw);
//                params = (LinearLayout.LayoutParams)((ViewHolder) viewHolder).relativeLayout.getLayoutParams();
//                params.height = 240;
//                params.width = 905;
//                ((ViewHolder) viewHolder).relativeLayout.setLayoutParams(params);
//            }
//        }
//        else if(i == 2){
//            if (viewHolder instanceof ViewHolder1)
//                viewHolder = (ViewHolder1) viewHolder;
//                params = (LinearLayout.LayoutParams)((ViewHolder1) viewHolder).linearLayout.getLayoutParams();
//                params.height = 240;
//                params.width = 905;
//                ((ViewHolder1) viewHolder).linearLayout.setLayoutParams(params);
//                params = (LinearLayout.LayoutParams)((ViewHolder1)viewHolder).linearLayout1.getLayoutParams();
//                params.width = 905;
//                ((ViewHolder1)viewHolder).linearLayout1.setLayoutParams(params);
//        }
    }

    @Override
    public int getItemCount() {
        return messageDialogs.size();
    }

    public static class DeployedMessagesItems {

        private String title;

        public DeployedMessagesItems(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final RelativeLayout relativeLayout;
        private final ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.rl_cell_deployed_messages_title);
            relativeLayout = itemView.findViewById(R.id.rl_cell_deployed_messages);
            imageView = itemView.findViewById(R.id.rl_cell_deployed_messages_button);
        }
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final ImageView imageView;
        private final TextView textView1;
        private final TextView textView2;
        private final TextView textView3;
        private final LinearLayout linearLayout;
        private final LinearLayout linearLayout1;

        ViewHolder1(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.ll_cell_deployed_messages_2_title1);
            imageView = itemView.findViewById(R.id.ll_cell_deployed_messages_2_img);
            textView1 = itemView.findViewById(R.id.ll_cell_deployed_messages_2_title2);
            textView2 = itemView.findViewById(R.id.rl_cell_deployed_messages2_title);
            textView3 = itemView.findViewById(R.id.rl_cell_deployed_messages2_desc);
            linearLayout = itemView.findViewById(R.id.ll_cell_deployed_messages_2);
            linearLayout1 = itemView.findViewById(R.id.ll_cell_deployed_messages_2_1);
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {
        private final ImageView img;
        private final TextView txtView;
        private final LinearLayout linearLayout;

        ViewHolder2(@NonNull View itemView) {
            super(itemView);
            txtView = itemView.findViewById(R.id.ll_cell_deployed_messages3_title);
            img = itemView.findViewById(R.id.ll_cell_deployed_messages3_img);
            linearLayout = itemView.findViewById(R.id.ll_cell_deployed_messages3);
        }
    }
}